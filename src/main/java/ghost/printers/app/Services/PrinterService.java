package ghost.printers.app.Services;

import ghost.printers.app.Entity.Printer;
import java.util.List;

public interface PrinterService {
    
    public List<Printer> getAllPrinters();

    public Printer getPrinterById(int id);

    public void addPrinter(Printer printer);
}
