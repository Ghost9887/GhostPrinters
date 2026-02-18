package ghost.printers.app.Controller;

import ghost.printers.app.Entity.Printer; 
import ghost.printers.app.Repository.PrinterRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("api/")
public class ApiController {

    @Autowired
    private final PrinterRepository printerRepo;

    public ApiController(PrinterRepository printerRepo) {
        this.printerRepo = printerRepo;
    }
    
    @GetMapping("/printers")
    public List<Printer> getPrinters() {
        return printerRepo.findAll();
    }
}
