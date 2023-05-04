package project.devOps.DevOpsTesting.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookTest {

    @Test
    public void testBookConstructor() {
        Book book = new Book();
        Assertions.assertNotNull(book);
    }

    @Test
    public void testBookProperties() {
        Book book = new Book();
        book.setIsbn("1234567890");
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setAvailable(true);

        Assertions.assertEquals("1234567890", book.getIsbn());
        Assertions.assertEquals("Test Book", book.getTitle());
        Assertions.assertEquals("Test Author", book.getAuthor());
        Assertions.assertTrue(book.isAvailable());
    }

    @Test
    public void testBookBorrows() {
        Book book = new Book();
        List<Borrow> borrows = new ArrayList<>();

        Borrow borrow1 = new Borrow();
        borrow1.setBorrowID(1L);
        borrow1.setStartDate(LocalDate.now());
        borrow1.setEndDate(LocalDate.now().plusDays(8));
        borrow1.setBook(book);
        borrows.add(borrow1);

        Borrow borrow2 = new Borrow();
        borrow2.setBorrowID(2L);
        borrow2.setStartDate(LocalDate.now());
        borrow2.setEndDate(LocalDate.now().plusDays(9));
        borrow2.setBook(book);
        borrows.add(borrow2);

        book.setBorrows(borrows);

        Assertions.assertEquals(2, book.getBorrows().size());
        Assertions.assertEquals(LocalDate.now(), book.getBorrows().get(0).getStartDate());
        Assertions.assertEquals(LocalDate.now().plusDays(9), book.getBorrows().get(1).getEndDate());
    }
}
