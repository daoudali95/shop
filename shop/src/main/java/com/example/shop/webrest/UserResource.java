package com.example.shop.webrest;

import com.example.shop.dao.Product;
import com.example.shop.dao.User;
import com.example.shop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity<User> creatMember(@RequestBody User user){
        User userRes = userService.create(user);
        return ResponseEntity.ok().body(userRes);
    }

    @GetMapping("AllUsers")
    public ResponseEntity<List<User>>AllUsers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/user/{id}")
    public Optional<User> findProduct(@PathVariable int id){
        return userService.findUser(id);
    }

    @DeleteMapping("/delUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.ok().body("User deleted id : "+ id);
    }
}
