package ItsInTheBlood.models.Cells.BloodCells;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder(super.toString());
        res.append(System.lineSeparator())
                .append(String.format("--------Health: %d | Velocity: %d | Energy: %d%n",
                        super.getHealth(),this.velocity,calculateEnergy()));
        return res.toString();
    }
    @Override
    public int calculateEnergy(){
        return super.getHealth()+velocity;
    }
}
