package ghost.printers.app.Services;

import ghost.printers.app.Repository.TonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ghost.printers.app.Entity.Toner;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Toner getTonerById(int id) {
        Optional<Toner> toner = tonerRepo.findById(id);
        if (toner.isPresent()) {
            return toner.get();
        }
        return null;
    }

    @Override
    public void addToner(Toner toner) {
        tonerRepo.save(toner);
    }

    @Override
    public void deleteTonerById(int id) {
        Optional<Toner> toner = tonerRepo.findById(id);
        if(toner.isPresent()) {
            tonerRepo.deleteById(id);
        }
    }

    @Override
    public void increaseTonerCount(int id) {
        Optional<Toner> toner = tonerRepo.findById(id);
        if (toner.isPresent()) {
            Toner originalToner = toner.get();
            int stock = originalToner.getStock();
            stock++;
            if (stock >= 0) { 
                originalToner.setStock(stock--);
                tonerRepo.save(originalToner);
            }
        }
    }

    @Override
    public void decreaseTonerCount(int id) {
        Optional<Toner> toner = tonerRepo.findById(id);
        if (toner.isPresent()) {
            Toner originalToner = toner.get();
            int stock = originalToner.getStock();
            stock--;
            if (stock >= 0) {
                originalToner.setStock(stock);
                tonerRepo.save(originalToner);
            }
        }
    }
}
