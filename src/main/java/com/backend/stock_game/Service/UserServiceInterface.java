package com.backend.stock_game.Service;

import com.backend.stock_game.Entity.Avatar;
import com.backend.stock_game.Entity.UserMaster;
import com.backend.stock_game.Modal.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserServiceInterface {

    UserMaster createUser(User user);

    Avatar saveAvatar(MultipartFile avatar);
}
