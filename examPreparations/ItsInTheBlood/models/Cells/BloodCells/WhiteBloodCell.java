package ItsInTheBlood.models.Cells.BloodCells;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder(super.toString());
        res.append(System.lineSeparator())
                .append(String.format("--------Health: %d | Size: %d | Energy: %d%n",
                        super.getHealth(),this.size,calculateEnergy()));
        return res.toString();
    }
    @Override
    public int calculateEnergy(){
        return (super.getHealth()+size)*2;
    }
}
