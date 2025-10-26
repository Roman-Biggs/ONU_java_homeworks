package exercise.fourth;

import java.util.Scanner;

public class EolympSolution8520 {

    public static void solution(){
        Scanner console = new Scanner(System.in);
        int x =  console.nextInt();

        if (x < 5){
            System.out.println((x*x)-(3*x)+4);
        }
        else {
            System.out.println(x+7);
        }

    }

}