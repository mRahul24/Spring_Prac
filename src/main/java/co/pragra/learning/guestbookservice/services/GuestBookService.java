package co.pragra.learning.guestbookservice.services;

import co.pragra.learning.guestbookservice.entities.Address;
import co.pragra.learning.guestbookservice.entities.Guest;
import co.pragra.learning.guestbookservice.entities.Review;
import co.pragra.learning.guestbookservice.repositories.AddressRepo;
import co.pragra.learning.guestbookservice.repositories.GuestRepo;
import co.pragra.learning.guestbookservice.repositories.ReviewRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service //@Component and @Service does the exact same thing
public class GuestBookService {

    private final GuestRepo repo;
    private final AddressRepo addressRepo;
    private final ReviewRepo reviewRepo;
    public Guest addOrUpdateGuest(Guest guest){
//        Address address = addressRepo.save(guest.getAddress());
//        guest.setAddress(address);
        return repo.save(guest);
    }

    public List<Guest> getAllGuest(){
        return repo.findAll();
    }

    public Optional<Guest> getGuestById(Integer id) {
        return repo.findById(id);

    }
    public Optional<Guest> getGuestByFirstName(String firstName){
        return repo.findGuestByFirstName(firstName);
    }

    public Optional<Guest> deleteGuestById(Integer id){
       Optional<Guest> guestById = getGuestById(id);
        if(guestById.isPresent()){
            repo.deleteById(id);
            return guestById;
        }
        return Optional.empty();
    }

    public Optional<Guest> updateGuest(Guest guest){
        Optional<Guest> guestById = getGuestById(guest.getGuestId());
        if(guestById.isPresent()){
            return Optional.of(addOrUpdateGuest(guest));
        }
        return Optional.empty();
    }
}
