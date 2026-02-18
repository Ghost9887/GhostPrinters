package ghost.printers.app.Services;

import ghost.printers.app.Repository.TonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ghost.printers.app.Entity.Toner;
import java.util.List;

@Service
public class TonerServiceImpl implements TonerService {
    
    @Autowired
    private final TonerRepository tonerRepo;

    public TonerServiceImpl(TonerRepository tonerRepo) {
        this.tonerRepo = tonerRepo;
    }

    @Override
    public List<Toner> getAllToners() {
        return tonerRepo.findAll();
    }
}
