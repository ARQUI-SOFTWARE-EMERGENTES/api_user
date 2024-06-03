package com.apiusuarios.crud.service;

import com.apiusuarios.crud.domain.model.entity.User;
import com.apiusuarios.crud.domain.persistence.UserRepository;
import com.apiusuarios.crud.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    public static final String USER_NOT_FOUND = "User not found";

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, USER_NOT_FOUND));
    }

    @Override
    public User update(User user, int id) {
        userRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, USER_NOT_FOUND));
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, USER_NOT_FOUND));
        userRepository.deleteById(id);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
