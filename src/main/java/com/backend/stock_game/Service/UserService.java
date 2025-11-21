package com.backend.stock_game.Service;

import com.backend.stock_game.Config.Exception.ExceptionResolver;
import com.backend.stock_game.Entity.Avatar;
import com.backend.stock_game.Entity.UserMaster;
import com.backend.stock_game.Modal.User;
import com.backend.stock_game.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private  UserRepository userRepository;

    @Override
    public UserMaster createUser(User user){

        UserMaster newUser = new UserMaster();
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
        newUser.setPoints(user.getPoints());

        userRepository.findByEmail(newUser.getEmail()).ifPresent((userVal) ->{
            throw new ExceptionResolver("User Email Already Registered!");
        });

        return userRepository.save(newUser);
    }

    @Override
    public Avatar saveAvatar(MultipartFile avatar) {
        return null;
    }

}
