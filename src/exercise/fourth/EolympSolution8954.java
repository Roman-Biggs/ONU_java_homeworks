package exercise.fourth;

import java.util.Scanner;
import java.util.List;

public class EolympSolution8954 {

    public static void Solution8954(){
        Scanner console = new Scanner(System.in);

        int n = console.nextInt();

        int[] list =  new int[n];

        for (int i=0; i<n ;i++){
            list[i] = console.nextInt();
        }

        //without space at the end
        for (int i=n-1; i>0; i--){
            System.out.print(list[i] + " ");
        }
        System.out.print(list[0]);

    }

}
