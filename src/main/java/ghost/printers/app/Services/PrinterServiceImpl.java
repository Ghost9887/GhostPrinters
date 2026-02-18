package ghost.printers.app.Services;

import ghost.printers.app.Repository.PrinterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ghost.printers.app.Entity.Printer;
import java.util.List;

@Service
public class PrinterServiceImpl implements PrinterService {
    
    @Autowired
    private final PrinterRepository printerRepo;

    public PrinterServiceImpl(PrinterRepository printerRepo) {
        this.printerRepo = printerRepo;
    }

    @Override
    public List<Printer> getAllPrinters() {
        return printerRepo.findAll();
    }
}
