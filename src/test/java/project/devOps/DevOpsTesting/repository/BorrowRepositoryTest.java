package project.devOps.DevOpsTesting.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.devOps.DevOpsTesting.model.Borrow;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BorrowRepositoryTest {

    @Autowired
    private BorrowRepository borrowRepository;

    @Test
    public void testSaveBorrow() {
        Borrow borrow = createBorrow(3L);
        Borrow savedBorrow = borrowRepository.save(borrow);
        assertNotNull(savedBorrow.getBorrowID());
        assertEquals(borrow.getStartDate(), savedBorrow.getStartDate());
    }

    @Test
    public void testFindById() {
        Borrow borrow = createBorrow(3L);
        Borrow savedBorrow = borrowRepository.save(borrow);
        Optional<Borrow> result = borrowRepository.findById(savedBorrow.getBorrowID());
        assertTrue(result.isPresent());
        assertEquals(borrow.getEndDate(), result.get().getEndDate());
    }

    @Test
    public void testDeleteBorrow() {
        Borrow borrow = createBorrow(3L);
        Borrow savedBorrow = borrowRepository.save(borrow);
        borrowRepository.delete(savedBorrow);
        Optional<Borrow> result = borrowRepository.findById(savedBorrow.getBorrowID());
        assertFalse(result.isPresent());
    }

    public Borrow createBorrow(long borrowID) {
        Borrow borrow = new Borrow();
        borrow.setBorrowID(borrowID);
        borrow.setStartDate(LocalDate.now());
        borrow.setEndDate(LocalDate.now().plusDays(8));
        return borrow;
    }
}
