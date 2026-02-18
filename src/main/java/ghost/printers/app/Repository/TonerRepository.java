package ghost.printers.app.Repository;

import ghost.printers.app.Entity.Toner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TonerRepository extends JpaRepository<Toner, Integer> {}

