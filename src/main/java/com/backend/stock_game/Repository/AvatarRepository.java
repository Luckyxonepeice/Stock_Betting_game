package com.backend.stock_game.Repository;

import com.backend.stock_game.Entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar,Integer> {
}
