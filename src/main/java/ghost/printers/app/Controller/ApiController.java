package ghost.printers.app.Controller;

import ghost.printers.app.Entity.Printer; 
import ghost.printers.app.Entity.Toner;
import ghost.printers.app.Services.PrinterService;
import ghost.printers.app.Services.TonerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping("/printers/{id}")
    public Printer getPrinterById(@PathVariable int id) {
        return printerService.getPrinterById(id);
    }

    @PostMapping("/printers/add")
    public void addPrinters(@RequestBody Printer printer) {
        printerService.addPrinter(printer);
    }

    @DeleteMapping("/printers/delete/{id}")
    public void deletePrinterById(@PathVariable int id) {
        printerService.deletePrinterById(id);
    }

    @GetMapping("/toners")
    public List<Toner> getToners() {
        return tonerService.getAllToners();
    }

    @GetMapping("/toners/{id}")
    public Toner getTonerById(@PathVariable int id) {
        return tonerService.getTonerById(id);
    }

    @PostMapping("/toners/add")
    public void addToners(@RequestBody Toner toner) {
        tonerService.addToner(toner);
    }

    @DeleteMapping("/toners/delete/{id}")
    public void deleteTonerById(@PathVariable int id) {
        tonerService.deleteTonerById(id);
    }

    @PutMapping("/toners/increase/{id}")
    public void increaseTonerCount(@PathVariable int id) {
        tonerService.increaseTonerCount(id);
    }

    @PutMapping("/toners/decrease/{id}")
    public void decreaseTonerCount(@PathVariable int id) {
        tonerService.decreaseTonerCount(id);
    }

}
