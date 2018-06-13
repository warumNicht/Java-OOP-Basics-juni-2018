import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _11_CatLady {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Cat> cats=new ArrayList<>();

        String input=reader.readLine();

        while ("End".equals(input)==false){

            String[] tokens=input.split("\\s+");

            String breed=tokens[0];
            String name=tokens[1];
            double param=Double.parseDouble(tokens[2]);

            Cat curCat=new Cat(name,breed);

            if(breed.equals("StreetExtraordinaire")){
                curCat.setDecibelsOfMeows(param);
            }else if(breed.equals("Siamese")){
                curCat.setEarSize(param);
            }else {
                curCat.setFurLenght(param);
            }
            cats.add(curCat);

            input=reader.readLine();
        }
        String wantedCat=reader.readLine();

        cats.stream()
                .filter(c->c.getName().equals(wantedCat))
                .limit(1)
                .forEach(k->{
                    k.printCat();
                });




    }
}
class Cat{
    private String name;
    private String breed;
    private double earSize;
    private double furLenght;
    private double decibelsOfMeows;

    public Cat(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public void printCat(){
        double param=0;
        if(this.furLenght!=0){
            param=this.furLenght;
        }else if(this.earSize!=0){
            param=this.earSize;
        }else {
            param=this.decibelsOfMeows;
        }
        System.out.printf("%s %s %.2f%n",this.breed,this.name,param);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEarSize() {
        return earSize;
    }

    public void setEarSize(double earSize) {
        this.earSize = earSize;
    }

    public double getFurLenght() {
        return furLenght;
    }

    public void setFurLenght(double furLenght) {
        this.furLenght = furLenght;
    }

    public double getDecibelsOfMeows() {
        return decibelsOfMeows;
    }

    public void setDecibelsOfMeows(double decibelsOfMeows) {
        this.decibelsOfMeows = decibelsOfMeows;
    }
}
