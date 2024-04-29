package com.example.pruebatecnica.Services;

import com.example.pruebatecnica.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserService {
    // Solo para verificar que sí se insertan los registros
    List<User> getAllUsers();

    // Obtener usuario por id
    User getUserById(Long id);

    // Registrar usuario
    User createUser(User user);

    // Eliminar usuario
    boolean deleteUser(Long id);

    // Editar usuario
    User editUser(Long id, User user);
}
