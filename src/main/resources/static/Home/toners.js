export async function getToners() {
  try {
    const response = await fetch("../api/toners");
    const events = await response.json();
    const tonersTable = document.getElementById("tonersTable");

    if (!events || events.length == 0) {
      return;
    }

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
    window.location.reload();
  } catch (err) {
    console.error("Error: ", err);
  }
}

async function deleteToner(id) {
  try {
    const response = await fetch(`../api/toners/delete/${id}`, {
      method: "DELETE",
    });
    window.location.reload();
  } catch (err) {
    console.error("Error: ", err);
  }
}
window.deleteToner = deleteToner;
