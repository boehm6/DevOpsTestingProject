package project.devOps.DevOpsTesting.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "borrows")
@Getter
@Setter
public class Borrow {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long borrowID;

  @Column(nullable = false)
  private LocalDate startDate;

  @Column(nullable = false)
  private LocalDate endDate;

  @ManyToOne private User borrower;
  @ManyToOne private Book book;

  public Long getBookId() {
    return book.getBookID();
  }

  /**
   * Diese Methode gibt einen String aus den Daten aus.
   *
   * @return String des Start und Endes der Ausleihe.
   */
  public String getDate() {
    return startDate.format(DateTimeFormatter.ISO_DATE)
        + " "
        + endDate.format(DateTimeFormatter.ISO_DATE);
  }
}
