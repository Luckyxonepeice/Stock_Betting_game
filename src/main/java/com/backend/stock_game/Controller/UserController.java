package com.backend.stock_game.Controller;

import com.backend.stock_game.Entity.Avatar;
import com.backend.stock_game.Entity.UserMaster;
import com.backend.stock_game.Modal.User;
import com.backend.stock_game.Service.UserServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceInterface userService;

    @GetMapping()
    public String getUser(){
        return "Sending User !";
    }

    @PostMapping("/create-user")
    public ResponseEntity<UserMaster> createUser(@Valid @RequestBody User body){

        UserMaster createdUser = userService.createUser(body);
        return new ResponseEntity<>(createdUser , HttpStatus.OK);

    }

    @PostMapping("/set-avatar")
    public ResponseEntity<Avatar> addAvatar(@RequestParam("file") MultipartFile file){

        Avatar avatar = userService.saveAvatar(file);
        return new ResponseEntity<>(avatar,HttpStatus.OK);
    }
}
