package _5_RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    private Random rnd;

    public Object getRandomElement(){
        int index=rnd.nextInt(super.size());

        super.set(index, super.get(super.size()-1));
        
        return super.remove(super.size()-1);
    }
}
