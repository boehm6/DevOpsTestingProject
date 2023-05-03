package project.devOps.DevOpsTesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.devOps.DevOpsTesting.model.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
}
