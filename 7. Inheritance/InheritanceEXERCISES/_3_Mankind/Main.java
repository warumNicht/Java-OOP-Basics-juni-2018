package _3_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[]studTokens=reader.readLine().split("\\s+");
        String[]workerTokens=reader.readLine().split("\\s+");

        try {
            Student student=new Student(studTokens[0],studTokens[1],studTokens[2]);
            Worker worker=new Worker(workerTokens[0],workerTokens[1],Double.parseDouble(workerTokens[2]),Double.parseDouble(workerTokens[3]));

            System.out.println(student.toString());
            System.out.println(worker.toString());


        }catch (IllegalArgumentException error){
            System.out.println(error.getMessage());
        }

    }
}
