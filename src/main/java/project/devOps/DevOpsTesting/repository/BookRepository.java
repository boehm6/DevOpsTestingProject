package project.devOps.DevOpsTesting.repository;

import org.springframework.data.repository.CrudRepository;
import project.devOps.DevOpsTesting.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
