package net.java.main.models;

import net.java.main.interfaces.Position;

public class PositionImpl implements Position {
    private int x;
    private int y;

    public PositionImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)",this.x,this.y);
    }
}
