package com.backend.stock_game.Service;

import com.backend.stock_game.Config.Exception.ExceptionResolver;
import com.backend.stock_game.Entity.Avatar;
import com.backend.stock_game.Entity.UserMaster;
import com.backend.stock_game.Modal.User;
import com.backend.stock_game.Repository.AvatarRepository;
import com.backend.stock_game.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private AvatarRepository avatarRepository;

    @Override
    public UserMaster createUser(User user){

        UserMaster newUser = new UserMaster();
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
        newUser.setPoints(user.getPoints());

        Avatar avatar = avatarRepository.findById(Integer.parseInt(user.getAvatarId()))
                        .orElseThrow(()-> new ExceptionResolver("Not Found Avatar"));

        newUser.setAvatar(avatar);

        userRepository.findByEmail(newUser.getEmail()).ifPresent((userVal) ->{
            throw new ExceptionResolver("User Email Already Registered!");
        });

        return userRepository.save(newUser);
    }

    @Override
    public Avatar saveAvatar(MultipartFile avatar) {

        Avatar newAvatar = new Avatar();
        try{
            newAvatar.setImageData(avatar.getBytes());
            newAvatar.setFileName(UUID.randomUUID()+avatar.getName());
            System.out.println("Setting File with name "+newAvatar.getFileName());
            newAvatar.setContentType("Image");
            return avatarRepository.save(newAvatar);

        }catch (IOException ioException){
            throw new ExceptionResolver("Error saving avatar..");
        }

    }

}
