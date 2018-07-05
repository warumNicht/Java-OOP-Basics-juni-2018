package ItsInTheBlood.models.Cells.BloodCells;

import ItsInTheBlood.models.Cells.Cell;

public abstract class BloodCell extends Cell {
    protected BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
