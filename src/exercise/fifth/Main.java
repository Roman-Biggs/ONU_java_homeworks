package exercise.fifth;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameSession game = new GameSession();

        System.out.println("Добро пожаловать в игру Монти-Холла!");
        //Для входа в игровую сессию
        boolean playAgain = true;
        int roundNumber = 1;

        //Точка входа в игровую сессию
        while (playAgain) {
            // 1. Старт игры
            game.startGame();

            // 2. Игрок выбирает дверь
            int choice = 0;
            while (true) {
                System.out.print("Выберите дверь (1-3): ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice >= 1 && choice <= 3) break;
                } else {
                    scanner.next(); // пропускаем неправильный ввод
                }
                System.out.println("Ошибка! Введите число от 1 до 3.");
            }
            game.playerChooses(choice);

            // 3. Ведущий открывает одну дверь без приза
            game.hostOpensDoor();

            // 4. Игрок решает менять выбор
            String switchInput = "";
            boolean switchChoice = false;
            while (true) {
                System.out.print("Хотите поменять выбор на другую дверь? (y/n): ");
                switchInput = scanner.next();
                if (switchInput.equalsIgnoreCase("y")) {
                    switchChoice = true;
                    break;
                } else if (switchInput.equalsIgnoreCase("n")) {
                    switchChoice = false;
                    break;
                }
                System.out.println("Введите y или n.");
            }
            game.playerFinalDecision(switchChoice);

            // 5. Результат
            System.out.println("\n=== Результат раунда " + roundNumber + " ===");
            game.currentSessionInfo();
            if (game.isPlayerWin()) {
                System.out.println("Поздравляем! Вы выиграли приз!");
            } else {
                System.out.println("К сожалению, вы проиграли.");
            }

            // 6. Спрашиваем, играть ли снова
            String againInput = "";
            while (true) {
                System.out.print("\nХотите сыграть ещё раз? (y/n): ");
                againInput = scanner.next();
                if (againInput.equalsIgnoreCase("y")) {
                    playAgain = true;
                    roundNumber++;
                    System.out.println("\nНачинаем новый раунд!\n");
                    break;
                } else if (againInput.equalsIgnoreCase("n")) {
                    playAgain = false;
                    System.out.println("Спасибо за игру!");
                    break;
                }
                System.out.println("Введите y или n.");
            }
        }

        scanner.close();
    }
}
