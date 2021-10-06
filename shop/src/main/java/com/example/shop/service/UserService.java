package com.example.shop.service;

import com.example.shop.dao.Product;
import com.example.shop.dao.User;
import com.example.shop.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user){return userRepository.save(user);}

    public Optional<User> findUser(Integer id){return userRepository.findById(id);}

    public List<User> getAllUsers(){return userRepository.findAll();}

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
