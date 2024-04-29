package com.example.pruebatecnica.Controllers;

import com.example.pruebatecnica.Models.User;
import com.example.pruebatecnica.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/health")
    public String checkHealth() {
        return "OK";
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping()
    public User saveUser(@Valid @RequestBody User userReceived) {
        return userService.createUser(userReceived);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        boolean status = userService.deleteUser(id);

        return status ?
                new ResponseEntity<>("Usuario eliminado con éxito", HttpStatus.ACCEPTED)
                :
                new ResponseEntity<>("Ocurrió un error al eliminar el usuario", HttpStatus.BAD_REQUEST);
    }
}
