package com.lisboa.userdepart.controllers;

import com.lisboa.userdepart.entities.User;
import com.lisboa.userdepart.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll(){
        return repository.findAll();
    }

    @GetMapping (value = "/{id}")
    public User findById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        //verifying user exists by email
        User userEmail = repository.findByUserEmail(user.getEmail());
        if (userEmail != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }else{
            return repository.save(user);
        }
    }

    @PutMapping (value = "/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id){
        User result = repository.findById(id).get();
        result.setName(user.getName());
        result.setEmail(user.getEmail());
        result.setDepartment(user.getDepartment());
        return repository.save(result);
    }

    @DeleteMapping (value = "/{id}")
    public User deleteUser(@PathVariable Long id){
        repository.deleteById(id);
        return null;
    }
}
