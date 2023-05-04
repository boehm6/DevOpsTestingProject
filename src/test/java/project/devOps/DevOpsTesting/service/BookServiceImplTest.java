package project.devOps.DevOpsTesting.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import project.devOps.DevOpsTesting.model.Book;
import project.devOps.DevOpsTesting.model.Borrow;
import project.devOps.DevOpsTesting.repository.BookRepository;
import project.devOps.DevOpsTesting.repository.BorrowRepository;
import project.devOps.DevOpsTesting.service.impl.BookServiceImpl;

public class BookServiceImplTest {

    private BookServiceImpl bookService;

    BookRepository bookRepository = mock(BookRepository.class);

    BorrowRepository borrowRepository = mock(BorrowRepository.class);

    @Before
    public void setUp() {
        bookService = new BookServiceImpl(bookRepository, borrowRepository);
    }

    @Test
    public void testGetAllBooks() {
        // Setup
        Book book = createBook(1L);
        Book book2 = createBook(2L);
        List<Book> expectedBooks = List.of(book, book2);
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Execution
        List<Book> actualBooks = bookService.getAllBooks();

        // Verification
        assertEquals(expectedBooks.size(), actualBooks.size());
    }

    private Book createBook(long bookId) {
        Book book = new Book();
        book.setBookID(bookId);
        book.setTitle("Test");
        book.setIsbn("978-456-321");
        return book;
    }

    @Test
    public void testBorrowBook() {
        // Setup
        Borrow borrow = new Borrow();
        Book book = createBook(1L);
        borrow.setBook(book);
        when(bookRepository.findById(1L)).thenReturn(java.util.Optional.of(book));

        // Execution
        bookService.borrowBook(borrow);

        // Verification
        Mockito.verify(borrowRepository).save(borrow);
        assertFalse(book.isAvailable());
        Mockito.verify(bookRepository).save(book);
    }

    @Test
    public void testGetBookByIdFound() {
        // Setup
        Book expectedBook = createBook(1L);
        when(bookRepository.findAll()).thenReturn(List.of(expectedBook));

        // Execution
        Book actualBook = bookService.getBookById(1L);

        // Verification
        assertNotNull(actualBook);
        assertEquals(expectedBook, actualBook);
    }

    @Test
    public void testGetBookByIdNotFound() {
        // Setup
        when(bookRepository.findAll()).thenReturn(List.of(createBook(1L)));

        // Execution
        Book actualBook = bookService.getBookById(2L);

        // Verification
        assertNull(actualBook);
    }
}
