package project.devOps.DevOpsTesting.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BorrowTest {

    @Test
    public void testBorrowConstructor() {
        Borrow borrow = new Borrow();
        Assertions.assertNotNull(borrow);
    }

    @Test
    public void testBorrowProperties() {
        Borrow borrow = new Borrow();
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(7);

        borrow.setStartDate(startDate);
        borrow.setEndDate(endDate);

        Assertions.assertEquals(startDate, borrow.getStartDate());
        Assertions.assertEquals(endDate, borrow.getEndDate());
    }

    @Test
    public void testBorrowBookId() {
        Book book = new Book();
        book.setBookID(1L);

        Borrow borrow = new Borrow();
        borrow.setBook(book);

        Assertions.assertEquals(1L, borrow.getBookId());
    }

    @Test
    public void testBorrowDate() {
        Borrow borrow = new Borrow();
        LocalDate startDate = LocalDate.of(2023, 5, 1);
        LocalDate endDate = LocalDate.of(2023, 5, 8);

        borrow.setStartDate(startDate);
        borrow.setEndDate(endDate);

        Assertions.assertEquals("01.05.2023 bis 08.05.2023", borrow.getDate());
    }
}
