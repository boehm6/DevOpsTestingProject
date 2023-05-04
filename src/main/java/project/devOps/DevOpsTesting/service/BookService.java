package project.devOps.DevOpsTesting.service;

import project.devOps.DevOpsTesting.model.Book;
import project.devOps.DevOpsTesting.model.Borrow;

import java.util.List;

public interface BookService {
  List<Book> getAllBooks();

  void borrowBook(Borrow borrow);

  Book getBookById(Long bookId);
}
