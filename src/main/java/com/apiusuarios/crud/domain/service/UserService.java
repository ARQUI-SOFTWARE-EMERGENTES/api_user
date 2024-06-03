package com.apiusuarios.crud.domain.service;

import com.apiusuarios.crud.domain.model.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findById(int id);
    User update(User user, int id);
    void delete(int id);
    User findByEmailAndPassword(String email, String password);

}
