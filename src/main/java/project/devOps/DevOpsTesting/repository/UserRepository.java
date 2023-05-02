package project.devOps.DevOpsTesting.repository;

import org.springframework.data.repository.CrudRepository;
import project.devOps.DevOpsTesting.model.Users;

public interface UserRepository extends CrudRepository<Users, Integer> {
}
