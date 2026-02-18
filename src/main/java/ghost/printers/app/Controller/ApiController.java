package ghost.printers.app.Controller;

import ghost.printers.app.Entity.Printer; 
import ghost.printers.app.Entity.Toner;
import ghost.printers.app.Services.PrinterService;
import ghost.printers.app.Services.TonerService;
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

    @Autowired
    private final TonerService tonerService;

    public ApiController(PrinterService printerService, TonerService tonerService) {
        this.printerService = printerService;
        this.tonerService = tonerService;
    }
    
    @GetMapping("/printers")
    public List<Printer> getPrinters() {
        return printerService.getAllPrinters();
    }

    @GetMapping("/toners")
    public List<Toner> getToners() {
        return tonerService.getAllToners();
    }
}
