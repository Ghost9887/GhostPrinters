package ghost.printers.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "toners")
public class Toner {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")   
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private int size;

    public Toner() {}
    public Toner(int id, String name, int size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ID: " + id + " ; Name: " + name + " ; Size: " + size;
    }
}
