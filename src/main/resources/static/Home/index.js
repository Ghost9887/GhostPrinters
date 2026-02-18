import { getPrinters } from "./printers.js";
import { getToners } from "./toners.js";

window.addEventListener("DOMContentLoaded", async () => {
  await getPrinters();
  await getToners();
});
