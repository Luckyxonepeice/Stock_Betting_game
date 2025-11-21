package com.backend.stock_game.Repository;

import com.backend.stock_game.Entity.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserMaster,Integer> {

    Optional<UserMaster> findByEmail(String email);
}
