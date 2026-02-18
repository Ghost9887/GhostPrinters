package ghost.printers.app.Repository;

import ghost.printers.app.Entity.Printer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrinterRepository extends JpaRepository<Printer, Integer> {}

