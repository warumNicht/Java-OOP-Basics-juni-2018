package ItsInTheBlood.models.Cells.Microbes;

public class Virus extends Microbe {
    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder(super.toString());
        res.append(System.lineSeparator())
                .append(String.format("--------Health: %d | Virulence: %d | Energy: %d%n",
                        super.getHealth(),super.getVirulence(),this.calculateEnergy()));
        return res.toString();
    }
    @Override
    public int calculateEnergy(){
        return super.getHealth()+super.getVirulence();
    }
}
