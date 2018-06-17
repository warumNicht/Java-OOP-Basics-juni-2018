package _5_RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomList extends ArrayList {

    private Random rnd;

    public Object getRandomElement(){
        int index=rnd.nextInt(super.size());
        Object toMove=super.get(super.size()-1);
        Object toRemove=super.get(index);
        toRemove=toMove;
        return super.remove(super.size()-1);
    }
}
