package com.backend.stock_game.Entity;

import jakarta.persistence.*;

import lombok.*;
import jakarta.validation.constraints.NotNull;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Avatar avatar;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false,unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private int points;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }




}
