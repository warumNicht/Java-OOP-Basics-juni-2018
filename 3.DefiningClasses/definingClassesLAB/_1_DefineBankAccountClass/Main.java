import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashMap<Integer,BankAccount> accounts=new HashMap<>();

        String command=scanner.nextLine();

        while ("End".equals(command)==false){

            String[] tokens=command.split("\\s+");

            switch (tokens[0]){
                case "Create":{
                    int curId=Integer.valueOf(tokens[1]);
                    if(accounts.containsKey(curId)){
                        System.out.println("Account already exists");
                    }else {
                        BankAccount currAcc=new BankAccount();
                        currAcc.setId(curId);
                        accounts.put(curId,currAcc);
                    }
                }break;
                case "Deposit":{
                    int wantedId=Integer.valueOf(tokens[1]);
                    int amount=Integer.valueOf(tokens[2]);
                    if(accounts.containsKey(wantedId)){
                        accounts.get(wantedId).deposit(amount);
                    }else {
                        System.out.println("Account does not exist");
                    }
                }break;
                case "Withdraw":{
                    int wantedId=Integer.valueOf(tokens[1]);
                    int amount=Integer.valueOf(tokens[2]);
                    if(accounts.containsKey(wantedId)){
                        accounts.get(wantedId).withdraw(amount);
                    }else {
                        System.out.println("Account does not exist");
                    }
                }break;
                case "Print":{
                    int wantedId=Integer.valueOf(tokens[1]);
                    if(accounts.containsKey(wantedId)){
                        System.out.println(accounts.get(wantedId).toString());
                    }else {
                        System.out.println("Account does not exist");
                    }
                }break;

            }


            command=scanner.nextLine();
        }

    }
}
