package exercise.fourth;

import java.util.Scanner;

public class EolympSolution4817 {

    public static void solution(){
        Scanner console = new Scanner(System.in);

        while(console.hasNextInt()) {

            //Sides of rectangle
            int a = console.nextInt();
            int b = console.nextInt();

            //Printing out his perimeter and area
            int perimeter = 2 * (a + b);
            int area = a * b;

            System.out.println(perimeter + " " + area);
        }

    }

}