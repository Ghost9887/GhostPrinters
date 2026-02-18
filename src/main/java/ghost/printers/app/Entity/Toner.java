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

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "size")
    private int size;

    @Column(name = "type")
    private String type;

    public Toner() {}
    public Toner(String brand,  String model, int size, String type) {
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.type = type;
    }
    
    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ID: " + id
        + "Brand: " + brand
        + "Model: " + model
        + "Size: " + size
        + "Type: " + type;
    }
}
