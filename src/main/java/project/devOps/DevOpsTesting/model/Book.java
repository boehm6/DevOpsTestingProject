package project.devOps.DevOpsTesting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
    @Id
    private String barcode;
    private String name;
    private String author;
    private double price;
    private int quantity;

    public Book(String barcode, String name, String author, double price, int quantity) {
        this.barcode = barcode;
        this.name = name;
        this.author = author;
        this.setPrice(price);
        this.quantity = quantity;
    }
}
