package co.pragra.learning.guestbookservice.controllers;

import co.pragra.learning.guestbookservice.entities.Employee;
import co.pragra.learning.guestbookservice.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepo empRepo;

    @GetMapping("/info/{id}")
    public String info(@RequestParam("name") String name, @PathVariable("id") Integer id){
        return "Hello "+name + " : " + id + ", I am an Employee";
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee emp){
        return empRepo.save(emp);
    }

    @GetMapping("/findById/{id}")
    public Optional<Employee> findById(@PathVariable("id") Integer id){
        return empRepo.findById(id);
    }

//    @GetMapping("/findByName/{fName}")
//    public Optional<Employee> findByName(@PathVariable("fName") String fName){
//        return empRepo.findEmployeeByFName(fName);
//    }

}
