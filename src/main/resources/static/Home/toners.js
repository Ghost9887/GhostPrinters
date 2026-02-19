export async function getToners() {
  try {
    const response = await fetch("../api/toners");
    const events = await response.json();
    const tonersTable = document.getElementById("tonersTable");

    tonersTable.innerHTML = `
      <tr>
        <th>Id</th>
        <th>Brand</th>
        <th>Model</th>
        <th>Type</th>
        <th>Size</th>
        <th>In Stock</th>
        <th>Actions</th>
      </tr>
      `

    if (!events || events.length == 0) {
      return;
    }

    events.sort((a, b) => a.id - b.id);
    
    events.forEach(event => {
      tonersTable.innerHTML += `
          <tr>
            <td>${event.id}</td>
            <td>${event.brand}</td>
            <td>${event.model}</td>
            <td>${event.type}</td>
            <td>${event.size}</td>
            <td>${event.stock}</td>
            <td>
              <button
                type="button"
                class="btn btn-warning"
                onclick="subTonerCount(${event.id})">
                -
              </button>
              <button
                type="button"
                class="btn btn-warning"
                onclick="addTonerCount(${event.id})">
                +
              </button>
              <button 
                type="button" 
                class="btn btn-danger" 
                onclick="deleteToner(${event.id})">
                Delete
              </button>
            </td>
          </tr>
          
      `
    });

  }catch (err) {
    console.error("Error: " , err);
  }
}

const tonerForm = document.getElementById("addTonerForm");

tonerForm.addEventListener("submit", (event) => {
  event.preventDefault();
  addToner();
});

async function addToner() {
  const formData = new FormData(addTonerForm);
  const toner = Object.fromEntries(formData.entries());
  try {
    const response = await fetch("../api/toners/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(toner)
    });
    const modalEl = document.getElementById("addTonerModal");
    const modal = bootstrap.Modal.getInstance(modalEl) 
                 || new bootstrap.Modal(modalEl);
    modal.hide();
    await getToners();
  } catch (err) {
    console.error("Error: ", err);
  }
}

async function deleteToner(id) {
  try {
    const response = await fetch(`../api/toners/delete/${id}`, {
      method: "DELETE",
    });
    await getToners();
  } catch (err) {
    console.error("Error: ", err);
  }
}
window.deleteToner = deleteToner;

async function addTonerCount(id) { 
  try{
    const response = await fetch(`../api/toners/increase/${id}`, {
      method: "PUT",
    });
    await getToners();
  }catch (err) {
    console.error("Error: ", err);
  }
}
window.addTonerCount = addTonerCount;

async function subTonerCount(id) {
  try {
    const response = await fetch(`../api/toners/decrease/${id}`, {
      method: "PUT",
    });
    await getToners();
  }catch (err) {
    console.error("Error: ", err);
  }
}
window.subTonerCount = subTonerCount;
