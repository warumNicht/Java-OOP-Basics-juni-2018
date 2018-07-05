package TheExpanse.models;

import TheExpanse.models.colonistes.Colonist;

import java.util.ArrayList;
import java.util.List;

public class Family {
    private String id;
    private List<Colonist> colonists;



    public Family(String id) {
        this.id = id;
        this.colonists=new ArrayList<>();
    }

    public String getId() {
        return id;
    }

}
