window.addEventListener("DOMContentLoaded", async () => {
  await getPrinters();
  await getToners();
});

async function getPrinters() {
  try {
    const response = await fetch("../api/printers");
    const events = await response.json();
    const printerList = document.getElementById("printers");
    printerList.innerHTML = "";

    if (!events || events.length == 0) {
      printerList.innerHTML = "<p>No printers</p>";
      return;
    }

    events.forEach(event => {
      printerList.innerHTML += ` 
        <span>
          <li>${event.id}<strong>${event.name}</strong></li>
          <button>Delete</button> 
        </span>
      `
    });

  }catch (err) {
    console.error("Error: " , err);
  }
}

async function getToners() {
  try {
    const response = await fetch("../api/toners");
    const events = await response.json();
    const printerList = document.getElementById("toners");
    printerList.innerHTML = "";

    if (!events || events.length == 0) {
      printerList.innerHTML = "<p>No toners</p>";
      return;
    }

    events.forEach(event => {
      printerList.innerHTML += `
        <span>
          <li>${event.id}<strong>${event.name}</strong>${event.size}</li>
          <button>Delete</button>
        </span>
      `
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
    window.location.reload();
  } catch (err) {
    console.error("Error: ", err);
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
