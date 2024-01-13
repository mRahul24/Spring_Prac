package co.pragra.learning.guestbookservice.repositories;

import co.pragra.learning.guestbookservice.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
}
