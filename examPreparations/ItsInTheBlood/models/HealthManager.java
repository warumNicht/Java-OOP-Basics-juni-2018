package ItsInTheBlood.models;

import ItsInTheBlood.models.Cells.BloodCells.RedBloodCell;
import ItsInTheBlood.models.Cells.BloodCells.WhiteBloodCell;
import ItsInTheBlood.models.Cells.Cell;
import ItsInTheBlood.models.Cells.Microbes.Bacteria;
import ItsInTheBlood.models.Cells.Microbes.Fungi;
import ItsInTheBlood.models.Cells.Microbes.Virus;

import java.util.HashMap;

public class HealthManager {
    private HashMap<String,Organism> organisms;

    public HealthManager() {
        this.organisms = new HashMap<>();
    }

    public String checkCondition(String organismName){
        if(organisms.containsKey(organismName)){
            return organisms.get(organismName).toString();
        }
    return null;
    }
    public String createOrganism(String name){
        if(organisms.containsKey(name)){
            return String.format("Organism %s already exists%n",name);
        }
        Organism curr=new Organism(name);
        organisms.put(name,curr);
        return String.format("Created organism %s%n",name);
    }
    public String addCluster(String organismName, String id, int rows, int cols){
        if(organisms.containsKey(organismName)){
            if(organisms.get(organismName).getHashClusters().containsKey(id)==false){

                Cluster curCluster=new Cluster(id,rows,cols);
                organisms.get(organismName).getHashClusters().put(id,curCluster);
                organisms.get(organismName).getClusters().offer(curCluster);
                return String.format("Organism %s: Created cluster %s%n",organismName,id);
            }
        }
        return null;
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        if(organisms.containsKey(organismName)){
            if(organisms.get(organismName).getHashClusters().containsKey(clusterId)){
                Cluster toAddCell=organisms.get(organismName).getHashClusters().get(clusterId);
                if(positionRow<toAddCell.getRows()
                        &&additionalProperty>0
                        &&positionCol>=0&&positionCol<toAddCell.getCols()){
                    Cell currCell=null;
                    switch (cellType){
                        case "RedBloodCell":{
                                currCell=new RedBloodCell(cellId,health,positionRow,positionCol,additionalProperty);
                        }break;
                        case "WhiteBloodCell":{
                            currCell=new WhiteBloodCell(cellId,health,positionRow,positionCol,additionalProperty);

                        }break;
                        case "Bacteria":{
                            currCell=new Bacteria(cellId,health,positionRow,positionCol,additionalProperty);
                        }break;
                        case "Fungi":{
                            currCell=new Fungi(cellId,health,positionRow,positionCol,additionalProperty);
                        }break;
                        case "Virus":{
                            currCell=new Virus(cellId,health,positionRow,positionCol,additionalProperty);
                        }break;
                    }

                    toAddCell.getCells().add(currCell);

                    return String.format("Organism %s: Created cell %s in cluster %s%n",
                            organismName,cellId,clusterId);
                }
            }
        }
        return null;
    }
    public String activateCluster(String organismName){

        if(organisms.containsKey(organismName)){
            Organism curOrg=organisms.get(organismName);
            if(curOrg.getClusters().isEmpty()){
                return null;
            }else {
                Cluster currCluster=curOrg.getClusters().poll();
                curOrg.getClusters().offer(currCluster);

                currCluster.activate();
                int size=currCluster.getCells().size();
                return String.format("Organism %s: Activated cluster %s. Cells left: %d%n",
                        organismName,currCluster.getId(),size);
            }
        }
        return null;
    }
}
