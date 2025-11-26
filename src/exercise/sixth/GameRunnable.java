package exercise.sixth;

import java.util.Scanner;

public class GameRunnable implements Runnable {

    // У каждого "запуска" игры будет своя сессия и свой сканер
    private GameSessionExtended game;
    private Scanner scanner;

    public GameRunnable() {
        this.game = new GameSessionExtended();
        // В серверной версии здесь был бы поток ввода от клиента, а не System.in
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Добро пожаловать в игру Монти-Холла (Расширенная версия)!");

        boolean playAgain = true;
        int roundNumber = 1;

        while (playAgain) {
            // 1. Старт
            game.startGame();

            // 2. Выбор игрока
            int choice = getUserChoice(); // Вынесли в отдельный приватный метод для чистоты
            game.playerChooses(choice);

            // 3. Ведущий открывает дверь (используем переопределенный метод из GameSessionExtended)
            game.hostOpensDoor();

            // 4. ПРОВЕРКА: Не открыл ли ведущий приз случайно?
            // (Логика специфичная для расширенной версии)
            if (game.didHostHitPrize()) {
                handleHostWin(roundNumber);
                // Спрашиваем про новую игру
                playAgain = Utils.askPlayAgain();
                if (playAgain) {
                    roundNumber++;
                    System.out.println("\nНачинаем новый раунд!\n");
                }
                continue; // Переход к следующему циклу
            }

            // 5. Решение игрока (менять дверь или нет)
            boolean switchChoice = getSwitchDecision();
            game.playerFinalDecision(switchChoice);

            // 6. Итоги
            printRoundResult(roundNumber);

            // 7. Играем еще?
            playAgain = Utils.askPlayAgain();
            if (playAgain) {
                roundNumber++;
                System.out.println("\nНачинаем новый раунд!\n");
            } else {
                System.out.println("Спасибо за игру!");
            }
        }
        // Важно: закрываем ресурсы
        scanner.close();
    }

    // --- Вспомогательные методы, чтобы разгрузить метод run() ---

    private int getUserChoice() {
        int choice = 0;
        while (true) {
            System.out.print("\nВыберите дверь (1-3): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) return choice;
            } else {
                scanner.next();
            }
            System.out.println("Ошибка! Введите число от 1 до 3.");
        }
    }

    private boolean getSwitchDecision() {
        while (true) {
            System.out.print("Хотите поменять выбор на другую дверь? (y/n): ");
            String switchInput = scanner.next();
            if (switchInput.equalsIgnoreCase("y")) return true;
            if (switchInput.equalsIgnoreCase("n")) return false;
            System.out.println("Введите y или n.");
        }
    }

    private void handleHostWin(int roundNumber) {
        System.out.println("\nВедущий случайно открыл дверь с призом!");
        System.out.println("Ведущий победил, игра завершена.");
        System.out.println("\n=== Результат раунда " + roundNumber + " ===");
        game.currentSessionInfo();
    }

    private void printRoundResult(int roundNumber) {
        System.out.println("\n=== Результат раунда " + roundNumber + " ===");
        game.currentSessionInfo();
        if (game.isPlayerWin()) {
            System.out.println("Поздравляем! Вы выиграли приз!");
        } else {
            System.out.println("К сожалению, вы проиграли.");
        }
    }
}