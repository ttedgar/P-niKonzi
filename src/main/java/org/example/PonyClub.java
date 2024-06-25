package org.example;

import org.example.ponies.Pony;
import org.example.ponies.SuperPony;
import org.example.user.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PonyClub {
    private Set<User> users;

    public PonyClub() {
        users = new HashSet<>();
    }

    public void addUser(String userName) {
        LocalDate today = LocalDate.now();
        HashSet<Pony> promotionSet = new HashSet<>();
        promotionSet.add(new SuperPony("PromotionPony"));
        if (today.getMonth() == Month.AUGUST) {
            User newUser = new User(userName, today, promotionSet);
            users.add(newUser);
        } else {
            User newUser = new User(userName, today);
            users.add(newUser);
        }
    }

    public void addPonyToUser(String userName, Pony pony) {
        users.stream()
                .filter(user -> user.getUserName().equals(userName))
                .findFirst()
                .orElseThrow()
                .addPony(pony);
    }

    public User getUserWithBestPony() {
        return users.stream()
                .max(Comparator.comparingInt(User::getXpLevelOfMostExperiencedPony))
                .orElseThrow();
    }

    public Set<Pony> getAllPoniesOnPosition(Position position) {
        return users.stream()
                .flatMap(user -> user.getPoniesOnPosition(position))
                .collect(Collectors.toSet());
    }


}
