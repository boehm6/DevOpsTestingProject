package project.devOps.DevOpsTesting.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long UserID;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private String email;
    private UserRole roles;
    @OneToMany(mappedBy = "borrower")
    private List<Borrow> borrows;
}
