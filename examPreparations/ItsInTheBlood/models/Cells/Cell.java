package ItsInTheBlood.models.Cells;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    protected Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public void addHealth(int health) {
        this.health +=health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    protected String getId() {
        return id;
    }

    public int getHealth() {
        return health;
    }

    public int getPositionRow() {
        return positionRow;
    }

    public int getPositionCol() {
        return positionCol;
    }

    public int calculateEnergy(){
        return health;
    }


    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]",this.id,this.positionRow,this.positionCol);
    }
}
