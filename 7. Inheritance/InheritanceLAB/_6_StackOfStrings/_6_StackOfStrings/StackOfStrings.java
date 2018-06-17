package _6_StackOfStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StackOfStrings extends ArrayList {

    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item){
        data.add(item);
    }

    public String pop(){
        if(data.isEmpty()==false){
            return data.remove(data.size()-1);
        }
        return null;
    }

    public String peek(){
        if(data.isEmpty()==false){
            return data.get(data.size()-1);
        }
        return null;
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }


}
