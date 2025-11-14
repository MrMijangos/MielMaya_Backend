package com.mieleria.service;

import com.mieleria.models.User;
import com.mieleria.repository.UserRepository;
import com.mieleria.utils.TokenUtil;
import java.util.List;
import java.util.UUID;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public void createUser(User user) {
        userRepository.create(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }

    public void deleteUser(int id) {
        userRepository.delete(id);
    }

    public String login(String correo, String contraseña) {
        User user = userRepository.findByEmail(correo);
        if (user != null && user.getContraseña().equals(contraseña)) {
            // Generar token único
            String token =TokenUtil.generateToken(correo);
            userRepository.updateToken(correo, token);
            return token;
        }
        return null;
    }
}
