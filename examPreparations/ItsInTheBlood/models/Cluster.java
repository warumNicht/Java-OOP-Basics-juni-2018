package ItsInTheBlood.models;
import ItsInTheBlood.models.Cells.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getCellsCount() {
        return cells.size();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public List<Cell> getCells() {
        return cells;
    }


    public void activate(){

        List<Cell> sorted=this.cells.stream()
                .sorted((x,y)->{
                    int firstComp=Integer.compare(x.getPositionRow(),y.getPositionRow());
                    if(firstComp==0){
                        return Integer.compare(x.getPositionCol(),y.getPositionCol());
                    }
                    return firstComp;
                })
                .collect(Collectors.toList());
        if(sorted.isEmpty()){
            return;
        }


        for (int i = 1; i < sorted.size(); i++) {
            String curCelType=sorted.get(0).getClass().getSimpleName();
            if (curCelType.equals("RedBloodCell")||curCelType.equals("WhiteBloodCell")) {
                sorted.get(0).addHealth(sorted.get(i).getHealth());
                sorted.get(0).setPositionRow(sorted.get(i).getPositionRow());
                sorted.get(0).setPositionCol(sorted.get(i).getPositionCol());
            } else {
                while (true) {
                    sorted.get(i).addHealth( - sorted.get(0).calculateEnergy());
                    if (sorted.get(i).getHealth() <= 0) {
                        sorted.get(0).setPositionRow(sorted.get(i).getPositionRow());
                        sorted.get(0).setPositionCol(sorted.get(i).getPositionCol());
                        break;
                    }
                    sorted.get(0).addHealth( - sorted.get(i).calculateEnergy());
                    if (sorted.get(0).getHealth() <= 0) {
                        sorted.set(0, sorted.get(i));
                        break;
                    }
                }
            }
        }
        this.cells.clear();
        this.cells.add(sorted.get(0));

    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        this.cells.stream()
                .sorted((x,y)->{
                    int firstComp=Integer.compare(x.getPositionRow(),y.getPositionRow());
                    if(firstComp==0){
                        return Integer.compare(x.getPositionCol(),y.getPositionCol());
                    }
                    return firstComp;
                })
                .forEach(cell->res.append(cell.toString()));
        return res.toString();
    }
}
