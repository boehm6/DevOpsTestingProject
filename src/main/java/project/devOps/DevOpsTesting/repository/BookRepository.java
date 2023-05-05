package project.devOps.DevOpsTesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.devOps.DevOpsTesting.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
