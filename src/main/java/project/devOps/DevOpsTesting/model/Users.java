package project.devOps.DevOpsTesting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int UserID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private Long phone;
    private String emailId;
    private List<UserRole> roles;
}
