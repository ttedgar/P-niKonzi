package org.example.ponies;

import org.example.Position;

public class SuperPony extends Pony implements Fly, Magic{
    public SuperPony(String name) {
        super(name);
    }

    @Override
    public void fly(Position position) {
        this.position = position;
    }

    @Override
    public void magic() {
        this.xpLevel++;
        this.name += '*';
    }
}
