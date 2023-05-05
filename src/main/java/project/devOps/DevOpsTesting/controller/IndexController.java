package project.devOps.DevOpsTesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.devOps.DevOpsTesting.model.Book;
import project.devOps.DevOpsTesting.model.Borrow;
import project.devOps.DevOpsTesting.model.User;
import project.devOps.DevOpsTesting.service.impl.BookServiceImpl;
import project.devOps.DevOpsTesting.service.impl.UserServiceImpl;

import java.util.List;

@Controller
public class IndexController {

  private final UserServiceImpl userService;

  private final BookServiceImpl bookService;

  public IndexController(BookServiceImpl bookService, UserServiceImpl userService) {
    this.bookService = bookService;
    this.userService = userService;
  }

  @GetMapping("/")
  public String home(Model model) {
    List<Book> books = bookService.getAllBooks();
    model.addAttribute("books", books);
    return "home";
  }

  @GetMapping("/register")
  public String showRegistrationForm(Model model) {
    model.addAttribute("user", new User());
    return "registration";
  }

  @PostMapping("/register")
  public String registerUser(@ModelAttribute("user") User user, Model model) {
    userService.createUser(user);
    return "redirect:/";
  }

  @GetMapping("/borrow")
  public String showBorrowForm(Model model) {
    List<Book> books = bookService.getAllBooks();
    List<User> users = userService.getAllUsers();
    model.addAttribute("user", users);
    model.addAttribute("books", books);
    model.addAttribute("borrow", new Borrow());
    return "borrow";
  }

  @PostMapping("/borrow")
  public String borrowBook(@RequestParam("bookId") Long bookid, @ModelAttribute("borrow") Borrow borrow, Model model) {
    model.addAttribute("borrow", borrow);
    Book book = bookService.getBookById(bookid);
    if (book != null) {
      borrow.setBook(book); // set the Book object in borrow
      bookService.borrowBook(borrow); // pass the borrow object to the bookService method
    }
    return "redirect:/";
  }

}
