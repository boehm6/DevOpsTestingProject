package project.devOps.DevOpsTesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.devOps.DevOpsTesting.model.Book;
import project.devOps.DevOpsTesting.model.Borrow;
import project.devOps.DevOpsTesting.model.User;
import project.devOps.DevOpsTesting.service.impl.BookServiceImpl;
import project.devOps.DevOpsTesting.service.impl.UserServiceImpl;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BookServiceImpl bookService;

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
        model.addAttribute("books", books);
        model.addAttribute("borrow", new Borrow());
        return "borrow";
    }

    @PostMapping("/borrow")
    public String borrowBook(@ModelAttribute("borrow") Borrow borrow, Model model) {
        bookService.borrowBook(borrow);
        return "redirect:/";
    }
}
