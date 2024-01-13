package co.pragra.learning.guestbookservice.controllers;

import co.pragra.learning.guestbookservice.entities.Guest;
import co.pragra.learning.guestbookservice.repositories.GuestRepo;
import co.pragra.learning.guestbookservice.services.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    GuestRepo repo;

    @Autowired
    GuestBookService service;

    @GetMapping("/info/{id}")
    public String info(@RequestParam("name") String name, @PathVariable("id") Integer id){
        return "Hi " +  name + " : " + id + "  , I am Guest Book Service";
    }
    @PostMapping("/add")
    public Guest addGuest(@RequestBody Guest guest){
        return service.addOrUpdateGuest(guest);
    }

    @GetMapping("/all/")
    public List<Guest> getAll( ){

        return service.getAllGuest();
    }

    @GetMapping("/all/{id}")
    public Optional<Guest> getById(@PathVariable("id")Integer id ){
        return service.getGuestById(id);
    }

    @GetMapping("/allByName/{firstName}")
    public Optional<Guest> getByFirstName(@PathVariable("firstName")String firstName ){
        return service.getGuestByFirstName(firstName);
    }

    @DeleteMapping("/deleteById/{id}")
    public Optional<Guest> deleteById(@PathVariable("id") Integer id){
        return service.deleteGuestById(id);
    }

    @PostMapping("/update")
    public ResponseEntity<Guest> updateGuest(@RequestBody Guest guest){
        ResponseEntity<Guest> guestResponseEntity;
        Optional<Guest> optionalGuest = service.updateGuest(guest);
        if(optionalGuest.isPresent()) {
            guestResponseEntity = ResponseEntity.ok(guest);
        }else {
            guestResponseEntity = ResponseEntity.noContent().header("error message", "Guest did not found for id: "+ guest.getGuestId()).build();
        }
        return guestResponseEntity;

    }



}
