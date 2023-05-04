package project.devOps.DevOpsTesting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.devOps.DevOpsTesting.model.Book;
import project.devOps.DevOpsTesting.model.Borrow;
import project.devOps.DevOpsTesting.repository.BookRepository;
import project.devOps.DevOpsTesting.repository.BorrowRepository;
import project.devOps.DevOpsTesting.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

  @Autowired private BookRepository bookRepository;

  @Autowired private BorrowRepository borrowRepository;

  @Override
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  public void borrowBook(Borrow borrow) {
    borrowRepository.save(borrow);
    Book book =
        bookRepository
            .findById(borrow.getBookId())
            .orElseThrow(() -> new RuntimeException("Book not found"));
    book.setAvailable(false);
    bookRepository.save(book);
  }

  @Override
  public Book getBookById(Long bookId) {
    // Schleife über alle Bücher in der Liste
    List<Book> bookList = getAllBooks();
    for (Book book : bookList) {
      // Wenn die ID des Buchs mit der gesuchten ID übereinstimmt, gibt das Buch zurück
      if (book.getBookID().equals(bookId)) {
        return book;
      }
    }
    // Wenn kein passendes Buch gefunden wurde, gib null zurück
    return null;
  }
}
