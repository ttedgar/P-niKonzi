package org.example.ponies;

import org.example.Direction;
import org.example.Position;

public class Pony {
    private static final int INITIAL_XP_LEVEL = 0;
    private static final Position INITIAL_POSITION = new Position(0, 0);

    protected String name;
    protected int xpLevel;
    protected Position position;

    public Pony(String name) {
        this.name = name;
        this.xpLevel = INITIAL_XP_LEVEL;
        this.position = INITIAL_POSITION;
    }

    public void walk(Direction direction) {
        position = new Position(position.getX() + direction.getX(), position.getY() + direction.getY());
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXpLevel() {
        return xpLevel;
    }

    public boolean isOnPosition(Position position) {
        return this.position.equals(position);
    }
}
