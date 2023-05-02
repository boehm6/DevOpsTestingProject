package project.devOps.DevOpsTesting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int adressID;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private long plz;
    private String phone;
}
