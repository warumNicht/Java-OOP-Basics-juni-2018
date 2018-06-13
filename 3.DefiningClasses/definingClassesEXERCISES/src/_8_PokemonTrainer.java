import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _8_PokemonTrainer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Trainer> trainers=new ArrayList<>();

        String input=reader.readLine();

        while ("Tournament".equals(input)==false){

            String[]tokens=input.split("\\s+");

            String curTrainName=tokens[0];
            String curPokName=tokens[1];
            String curPokElem=tokens[2];
            int curPokHealt=Integer.parseInt(tokens[3]);
            Pokemon curPok=new Pokemon(curPokName,curPokElem,curPokHealt);

            if(trainers.stream()
                    .anyMatch(x->x.getName().equals(curTrainName))==false){
                Trainer curTr=new Trainer(curTrainName);
                curTr.getPokemons().add(curPok);
                trainers.add(curTr);

            }else {
                trainers.stream().filter(x->x.getName().equals(curTrainName))
                        .forEach(t->t.getPokemons().add(curPok));
            }
            input=reader.readLine();
        }
        input=reader.readLine();

        while ("End".equals(input)==false){

            String curEl=input;

                for (Trainer trainer : trainers) {

                    boolean hasMatch=trainer.getPokemons().stream()
                            .anyMatch(x->x.element.equals(curEl)&&x.healt>0);
                    if(hasMatch){
                        trainer.setBadges(trainer.getBadges()+1);
                    }else {
                        trainer.getPokemons().stream()
                                .forEach(p->{
                                    p.setHealt(p.getHealt()-10);
                                });
                    }
                }

            input=reader.readLine();
        }
        trainers.stream()
                .sorted((x,y)->{
                    return Integer.compare(y.getBadges(),x.getBadges());
                })
                .forEach(tr->{
                    tr.print();
                });
    }
}
class Trainer{
    String name;
    int badges;
    List<Pokemon> pokemons;

    public void  print(){
        long livePokemons=this.getPokemons().stream()
                .filter(x->x.getHealt()>0)
                .count();
        System.out.printf("%s %d %d%n",this.name,this.badges,livePokemons);
    }

    public Trainer(String name) {
        this.name = name;
        this.badges=0;
        this.pokemons=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
class Pokemon{

    String name;
    String element;
    int healt;

    public Pokemon(String name, String element, int healt) {
        this.name = name;
        this.element = element;
        this.healt = healt;
    }
    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public int getHealt() {
        return healt;
    }

    public void setHealt(int healt) {
        this.healt = healt;
    }
}
