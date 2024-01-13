package co.pragra.learning.guestbookservice.repositories;

import co.pragra.learning.guestbookservice.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
}
