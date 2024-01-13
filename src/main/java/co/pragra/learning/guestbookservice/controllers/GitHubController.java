package co.pragra.learning.guestbookservice.controllers;


import co.pragra.learning.guestbookservice.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/github")
public class GitHubController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/user/{name}")
    public User getUserDetails(@PathVariable("name") String name){
        return restTemplate.getForObject("https://api.github.com/users/"+name, User.class);
    }
}
