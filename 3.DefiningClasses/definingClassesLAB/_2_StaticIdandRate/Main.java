package _2_StaticIdandRate;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, BankAccount> accounts=new HashMap<>();

        String command=scanner.nextLine();
        int curId=0;
        while ("End".equals(command)==false){

            String[] tokens=command.split("\\s+");


            switch (tokens[0]){
                case "Create":{

                        BankAccount currAcc=new BankAccount();
                        curId++;
                        accounts.put(curId,currAcc);
                    System.out.printf("Account %s created%n",currAcc.toString());

                }break;
                case "Deposit":{

                        int wantedId=Integer.valueOf(tokens[1]);
                        double amount=Double.valueOf(tokens[2]);
                        if(accounts.containsKey(wantedId)){
                            accounts.get(wantedId).deposit(amount);
                            String curCount=accounts.get(wantedId).toString();
                            System.out.printf("Deposited %.0f to %s%n",amount,curCount);

                        }else {
                            System.out.println("Account does not exist");
                        }


                }break;
                case "GetInterest":{
                    int wantedId=Integer.valueOf(tokens[1]);
                    int years=Integer.valueOf(tokens[2]);
                    if(accounts.containsKey(wantedId)){
                        System.out.printf("%.2f%n",accounts.get(wantedId).getInterest(years));
                    }else {
                        System.out.println("Account does not exist");
                    }
                }break;
                case "SetInterest":{
                    double newInterest=Double.valueOf(tokens[1]);
                    BankAccount.setInterestRate(newInterest);
                }break;

            }


            command=scanner.nextLine();
        }

    }
}
