package com.apiusuarios.crud.api;

import com.apiusuarios.crud.domain.model.entity.User;
import com.apiusuarios.crud.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User create(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("email/{email}/password/{password}")
    public User login(@PathVariable String email, @PathVariable String password){
        return userService.findByEmailAndPassword(email, password);
    }
    @GetMapping("/{id}")
    public User findById(@PathVariable int id){
        return userService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public  User update(@RequestBody User user, @PathVariable int id){
        return userService.update(user, id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }
}
