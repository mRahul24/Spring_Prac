package co.pragra.learning.guestbookservice.repositories;

import co.pragra.learning.guestbookservice.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepo extends JpaRepository<Guest,Integer> {
    Optional<Guest> findGuestByFirstName(String firstName);
}
