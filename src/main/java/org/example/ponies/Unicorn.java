package org.example.ponies;

public class Unicorn extends Pony implements Magic {
    public Unicorn(String name) {
        super(name);
    }

    @Override
    public void magic() {
        this.xpLevel++;
        this.name += '*';
    }
}
