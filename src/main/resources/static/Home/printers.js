export async function getPrinters() {
  try {
    const response = await fetch("../api/printers");
    const events = await response.json();
    const printerTable = document.getElementById("printersTable");
    
    printerTable.innerHTML = `
      <tr>
        <th>Id</th>
        <th>Brand</th>
        <th>Model</th>
        <th>Type</th>
        <th>In Stock</th>
        <th>Actions</th>
      </tr>
    `

    if (!events || events.length == 0) {
      return;
    }
    events.sort((a, b) => a.id - b.id);
    
    events.forEach(event => {
      printerTable.innerHTML += `
        <tr>
          <td>${event.id}</td>
          <td>${event.brand}</td>
          <td>${event.model}</td>
          <td>${event.type}</td>
          <td>${event.stock}</td>
          <td>
            <button
              type="button"
              class="btn btn-warning"
              onclick="editPrinter("${event.id})">
              Edit
            </button>
            <button 
              type="button" 
              class="btn btn-danger" 
              onclick="deletePrinter(${event.id})">
              Delete
            </button>
          </td>
        </tr>
      `;
    });

  }catch (err) {
    console.error("Error: " , err);
  }
}

const printerForm = document.getElementById("addPrinterForm");

printerForm.addEventListener("submit", (event) => {
  event.preventDefault();
  addPrinter();
});

async function addPrinter() {
  const formData = new FormData(addPrinterForm);
  const printer = Object.fromEntries(formData.entries());

  try {
    const response = await fetch("../api/printers/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(printer)
    });

    const modalEl = document.getElementById("addPrinterModal");
    const modal = bootstrap.Modal.getInstance(modalEl) 
                 || new bootstrap.Modal(modalEl);

    modal.hide();
    await getPrinters();
  } catch (err) {
    console.error("Error: ", err);
  }
}

async function deletePrinter(id) {
  console.log("deleting...", id);
  try {
    const response = await fetch(`../api/printers/delete/${id}`, {
      method: "DELETE",
    });
    await getPrinters();
  } catch (err) {
    console.error("Error: ", err);
  }
}
window.deletePrinter = deletePrinter;

async function editPrinter(id) {}
window.editPrinter = editPrinter;
