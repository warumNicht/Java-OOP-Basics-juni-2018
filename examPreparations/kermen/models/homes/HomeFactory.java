package kermen.models.homes;

import kermen.models.Child;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class HomeFactory {
    public HomeFactory() {
    }

    public Home createHome (String[] args){
        switch (args[0]){
            case "AloneOld":
                return new AloneOldHome(Double.parseDouble(args[1]));
            case "AloneYoung":
                return new AloneYoungHome(Double.parseDouble(args[1]),Double.parseDouble(args[2]));
            case "OldCouple":{
                String[]pensions=args[1].split(", ");
                return new OldCoupleHome(Double.parseDouble(pensions[0]),Double.parseDouble(pensions[1]),Double.parseDouble(args[2]),
                        Double.parseDouble(args[3]),Double.parseDouble(args[4]));
            }

            case "YoungCouple":{
                String[]salaries=args[1].split(", ");
                return new YoungCouple(Double.parseDouble(salaries[0]),Double.parseDouble(salaries[1]),Double.parseDouble(args[2]),
                        Double.parseDouble(args[3]),Double.parseDouble(args[4]));
            }

            case "YoungCoupleWithChildren":{
                String[]salaries=args[1].split(", ");

                Home home= new YoungCoupleWithChildrenHome(Double.parseDouble(salaries[0]),Double.parseDouble(salaries[1]),Double.parseDouble(args[2]),
                        Double.parseDouble(args[3]),Double.parseDouble(args[4]));
                if(args.length>5){
                    for(int i=5; i<args.length; i++){
                        List<Double> dep= Arrays.stream(args[i].split(", "))
                                .map(x->Double.parseDouble(x))
                                .collect(Collectors.toList());
                        Child curr=new Child(dep);
                        ((YoungCoupleWithChildrenHome) home).getChildren().add(curr);
                    }
                }
                return home;
            }



                default:return null;
        }
    }
}
