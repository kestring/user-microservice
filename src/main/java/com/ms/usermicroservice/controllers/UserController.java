package com.ms.usermicroservice.controllers;

import com.ms.usermicroservice.dtos.UserRecordDTO;
import com.ms.usermicroservice.models.User;
import com.ms.usermicroservice.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.logging.Logger;

@Controller("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(UserController.class.getName());

    @PostMapping("/inserir")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRecordDTO userDTO){
        logger.info("Iniciou saveUser");
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);

        user = this.userService.save(user);

        logger.info("Finalizou saveUser");
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping()
    public ResponseEntity<List<User>> findAll(){
        logger.info("Iniciou findAll");

        List<User> users = this.userService.findAll();

        logger.info("Finalizou findAll");
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }

}
