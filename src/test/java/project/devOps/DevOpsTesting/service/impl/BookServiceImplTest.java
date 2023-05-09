package project.devOps.DevOpsTesting.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.devOps.DevOpsTesting.model.Book;
import project.devOps.DevOpsTesting.model.Borrow;
import project.devOps.DevOpsTesting.repository.BookRepository;
import project.devOps.DevOpsTesting.repository.BorrowRepository;

public class BookServiceImplTest {

  private BookServiceImpl bookService;

  BookRepository bookRepository = mock(BookRepository.class);

  BorrowRepository borrowRepository = mock(BorrowRepository.class);

  @BeforeEach
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

  @Test
  void testCreateBook() {
    Book book = createBook(1L);
    bookService.createBook(book);
    verify(bookRepository).save(book);
  }

  private Book createBook(long bookId) {
    Book book = new Book();
    book.setBookID(bookId);
    book.setTitle("Test");
    book.setIsbn("978-456-321");
    book.setAvailable(false);
    return book;
  }
}
