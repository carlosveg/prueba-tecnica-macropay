package com.example.pruebatecnica.Services;

import com.example.pruebatecnica.Models.User;
import com.example.pruebatecnica.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) return user.get();

        return null;
    }

    @Override
    public User createUser(@Valid User user) {
        User response = null;

        try {
            response = userRepository.save(user);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return response;
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        }

        return false;
    }

    // TODO
    @Override
    public User editUser(Long id, User user) {
        return null;
    }
}
