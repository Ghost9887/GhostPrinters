window.addEventListener("DOMContentLoaded", async () => {
  await getPrinters();
  await getToners();
});

async function getPrinters() {
  try {
    const response = await fetch("../api/printers");
    if (!response.ok) {
      console.log("Error loading printers");
      return;
    }
    const events = await response.json();
    const printerList = document.getElementById("printers");
    printerList.innerHTML = "";

    if (!events || events.length == 0) {
      printerList.innerHTML = "<p>No printers</p>";
    }

    events.forEach(event => {
      printerList.innerHTML += `<li>${event.id}<strong>${event.name}</strong></li>`
    });

  }catch (err) {
    console.error("Error: " , err);
  }
}

async function getToners() {
  try {
    const response = await fetch("../api/toners");
    if (!response.ok) {
      console.log("Error loading toners");
      return;
    }
    const events = await response.json();
    const printerList = document.getElementById("toners");
    printerList.innerHTML = "";

    if (!events || events.length == 0) {
      printerList.innerHTML = "<p>No toners</p>";
    }

    events.forEach(event => {
      printerList.innerHTML += `<li>${event.id}<strong>${event.name}</strong>${event.size}</li>`
    });

  }catch (err) {
    console.error("Error: " , err);
  }
}
