package co.pragra.learning.guestbookservice.services;

import co.pragra.learning.guestbookservice.dto.User;
import co.pragra.learning.guestbookservice.entities.Guest;
import co.pragra.learning.guestbookservice.repositories.AddressRepo;
import co.pragra.learning.guestbookservice.repositories.GuestRepo;
import co.pragra.learning.guestbookservice.repositories.ReviewRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Data
@Service //@Component and @Service does the exact same thing
public class GuestBookService {

    private final GuestRepo repo;
    private final AddressRepo addressRepo;
    private final ReviewRepo reviewRepo;
    @Autowired
    private RestTemplate restTemplate;
    public Guest addOrUpdateGuest(Guest guest){

        User user = restTemplate.getForObject("http://localhost:8081/github/user/"+guest.getUsername(), User.class);
        guest.setAvatarUrl(user.getAvatar_url());
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
