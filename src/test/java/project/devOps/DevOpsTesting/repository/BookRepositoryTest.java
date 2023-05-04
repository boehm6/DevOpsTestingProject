package project.devOps.DevOpsTesting.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.devOps.DevOpsTesting.model.Book;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSaveBook() {
        Book book = createBook(1L);
        Book savedBook = bookRepository.save(book);
        assertNotNull(savedBook.getBookID());
        assertEquals(book.getTitle(), savedBook.getTitle());
    }

    @Test
    public void testFindById() {
        Book book = createBook(2L);
        Book savedBook = bookRepository.save(book);
        Optional<Book> result = bookRepository.findById(savedBook.getBookID());
        assertTrue(result.isPresent());
        assertEquals(book.getAuthor(), result.get().getAuthor());
    }

    @Test
    public void testDeleteBook() {
        Book book = createBook(1L);
        Book savedBook = bookRepository.save(book);
        bookRepository.delete(savedBook);
        Optional<Book> result = bookRepository.findById(savedBook.getBookID());
        assertFalse(result.isPresent());
    }

    private Book createBook(long bookId) {
        Book book = new Book();
        book.setBookID(bookId);
        book.setTitle("Test");
        book.setIsbn("978-456-321");
        book.setAvailable(true);
        book.setAuthor("Max Mustermann");
        return book;
    }
}
