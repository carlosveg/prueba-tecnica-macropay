package com.example.pruebatecnica.Repositories;

import com.example.pruebatecnica.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
