package project.devOps.DevOpsTesting.repository;

import org.springframework.data.repository.CrudRepository;
import project.devOps.DevOpsTesting.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
