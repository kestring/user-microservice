package com.ms.usermicroservice.services;

import com.ms.usermicroservice.models.User;
import com.ms.usermicroservice.producers.UserProducer;
import com.ms.usermicroservice.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducer userProducer;

    @Transactional
    public User save(User user){

        user = this.userRepository.save(user);
        userProducer.publishMessageEmail(user);

        return user;
    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

}
