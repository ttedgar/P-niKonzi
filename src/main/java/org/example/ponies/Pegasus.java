package org.example.ponies;

import org.example.Position;

public class Pegasus extends Pony implements Fly {
    public Pegasus(String name) {
        super(name);
    }

    @Override
    public void fly(Position position) {
        this.position = position;
    }
}
