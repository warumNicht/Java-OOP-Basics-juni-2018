package ItsInTheBlood.models;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Organism {
    private String name;
    private ArrayDeque<Cluster> clusters;
    private HashMap<String,Cluster> hashClusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayDeque<>();
        this.hashClusters=new HashMap<>();
    }
    private int countCells(){
        int count=0;

        for (Cluster cluster : this.clusters) {
            count+=cluster.getCellsCount();
        }
        return count;
    }

    public HashMap<String, Cluster> getHashClusters() {
        return hashClusters;
    }

    public ArrayDeque<Cluster> getClusters() {
        return clusters;
    }
    private int countOrgCells(){
        int count=0;
        for (Cluster cluster : clusters) {
            count+=cluster.getCellsCount();
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        res.append(String.format("Organism - %s%n",this.name))
                .append(String.format("--Clusters: %d%n",this.clusters.size()))
                .append(String.format("--Cells: %d%n",countCells()));

        for (Cluster cluster : clusters) {
            res.append(String.format("----Cluster %s%n",cluster.getId()));
            res.append(cluster.toString());
        }
        return res.toString();
    }
}
