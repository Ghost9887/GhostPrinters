package ghost.printers.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "printers")
public class Printer {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private int amount;

    public Printer() {}

    public Printer(String brand, String model, String type, int amount) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.amount = amount;
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

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "ID: " + id
        + "Brand: " + brand
        + "Model: " + model
        + "Type: " + type
        + "Stock: " + amount;
    }
}
