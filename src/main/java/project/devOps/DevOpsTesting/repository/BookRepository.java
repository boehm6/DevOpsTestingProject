package project.devOps.DevOpsTesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.devOps.DevOpsTesting.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAvailableTrue();
}
