package exercise.sixth;

import java.util.Scanner;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Спрашивает пользователя, хочет ли он играть дальше.
     * @return true, если пользователь хочет продолжить; false иначе
     */
    public static boolean askPlayAgain() {
        while (true) {
            System.out.print("\nХотите сыграть ещё раз? (y/n): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("y")) {
                return true;
            } else if (input.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Введите y или n.");
            }
        }
    }
}
