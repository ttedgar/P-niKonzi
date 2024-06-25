package org.example.user;

import org.example.Position;
import org.example.ponies.Pony;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class User {
    private String userName;
    private LocalDate registrationDate;
    private Set<Pony> ponies;

    public User(String userName, LocalDate registrationDate) {
        this.registrationDate = registrationDate;
        this.ponies = new HashSet<>();
        this.userName = userName;
    }

    public User(String userName, LocalDate registrationDate, Set<Pony> ponies) {
        this.registrationDate = registrationDate;
        this.ponies = ponies;
        this.userName = userName;
    }

    public void addPony(Pony pony) {
        ponies.add(pony);
    }

    public int getXpLevelOfMostExperiencedPony() {
        return ponies.stream()
                .mapToInt(Pony::getXpLevel)
                .max()
                .orElse(0);
    }

    public Stream<Pony> getPoniesOnPosition(Position position) {
        return ponies.stream()
                .filter(pony -> pony.isOnPosition(position));
    }

    public String getUserName() {
        return userName;
    }
}
