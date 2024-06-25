package org.example;

import org.example.ponies.Pony;
import org.example.user.User;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PonyClubTest {
    private PonyClub ponyClub;

    @BeforeEach
    void setUp() {
        ponyClub = new PonyClub();
    }

    @org.junit.jupiter.api.Test
    void testGetAllPoniesOnPositionWithOnePonyOnPositionOneOff() {
        Pony pony1 = new Pony("Pony 1");
        pony1.walk(Direction.WEST);
        pony1.walk(Direction.NORTH);
        Pony pony2 = new Pony("Pony 2");
        ponyClub.addUser("user1");
        ponyClub.addUser("user2");
        ponyClub.addPonyToUser("user1", pony1);
        ponyClub.addPonyToUser("user2", pony2);

        assertEquals(Set.of(pony1), ponyClub.getAllPoniesOnPosition(new Position(1, 1)));
    }
}