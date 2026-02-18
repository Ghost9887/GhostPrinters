package ghost.printers.app.Services;

import ghost.printers.app.Entity.Toner;
import java.util.List;

public interface TonerService {
    
    public List<Toner> getAllToners();

    public Toner getTonerById(int id);

    public void addToner(Toner toner);

    public void deleteTonerById(int id);
}
