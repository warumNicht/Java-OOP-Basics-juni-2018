package ItsInTheBlood.models.Cells.Microbes;

import ItsInTheBlood.models.Cells.Cell;

public abstract class Microbe extends Cell {
    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    protected int getVirulence() {
        return virulence;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder(super.toString());
        return res.toString();
    }
}
