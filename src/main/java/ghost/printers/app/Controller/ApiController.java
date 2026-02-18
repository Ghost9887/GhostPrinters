package ghost.printers.app.Controller;

import ghost.printers.app.Entity.Printer; 
import ghost.printers.app.Services.PrinterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("api/")
public class ApiController {

    @Autowired
    private final PrinterService printerService;

    public ApiController(PrinterService printerService) {
        this.printerService = printerService;
    }
    
    @GetMapping("/printers")
    public List<Printer> getPrinters() {
        return printerService.getAllPrinters();
    }
}
