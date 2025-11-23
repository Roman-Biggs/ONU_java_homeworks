package exercise.fifth;

import java.util.Random;

public class GameSession {
    private Door[] doors; //массив из трёх дверей
    //Храним как числа для массива (т.е. от 0 до 2)
    private int playerInitialChoice;
    private int hostOpenedDoor;
    private int playerFinalChoice;
    private Random random;

    private static final int DOOR_COUNT = 3; // константа для числа дверей

    //Конструктор - задаём рандомное число и создаём изначальный массив из 3-ёх дверей
    public GameSession() {
        this.random = new Random();
        this.doors = new Door[DOOR_COUNT];
        for (int i = 0; i < DOOR_COUNT; i++) {
            doors[i] = new Door();
        }
    }

    //Сброс всей информации перед началом игры
    public void resetAllBeforeGame(){

        //Сброс полей выборов игрока и ведущего старой сессии
        this.playerInitialChoice = -1;
        this.hostOpenedDoor = -1;
        this.playerFinalChoice = -1;

        //Сброс информации каждой двери старой сессии
        for  (int i = 0; i < DOOR_COUNT; i++) {
            doors[i].reset();
        }
    }

    // 1. Старт игры: чистим старую инфу и размещаем новый приз
    public void startGame() {
        resetAllBeforeGame();

        // случайно размещаем приз
        int prizeDoor = random.nextInt(3); //генерирует случайное число от 0 до 3 (невключительно)
        doors[prizeDoor].setHasPrize(true);
    }

    // 2. Игрок делает выбор
    public void playerChooses(int doorIndex) {
        this.playerInitialChoice = doorIndex - 1; //Приводим от натурального числа к числу для массива
        doors[doorIndex - 1].setIsChosenByPlayer(true);
    }

    // 3. Ведущий открывает дверь без приза, которую игрок не выбрал
    public void hostOpensDoor() {
        for (int i = 0; i < DOOR_COUNT; i++) {
            if (i != playerInitialChoice
                    && !doors[i].hasPrize()) {

                hostOpenedDoor = i;
                doors[i].setIsChosenByHost(true);
                return;
            }
        }
    }

    // 4. Игрок принимает финальное решение (менять или нет)
    public void playerFinalDecision(boolean switchChoice) {
        if (!switchChoice) {
            // остаёмся при прежнем выборе
            playerFinalChoice = playerInitialChoice;
        } else {
            // ищем дверь, которую:
            //  - не выбрал игрок изначально
            //  - не открыл ведущий
            for (int i = 0; i < DOOR_COUNT; i++) {
                if (i != playerInitialChoice && i != hostOpenedDoor) {
                    playerFinalChoice = i;
                    break;
                }
            }
        }
    }

    // 5. Проверка выигрыша
    public boolean isPlayerWin() {
        return doors[playerFinalChoice].hasPrize();
    }

    // Отладочный вывод состояния дверей
    public void currentSessionInfo() {
        System.out.println("Current game session information:");
        System.out.println("Player initial choice: " + (playerInitialChoice + 1));
        System.out.println("Host opened door: " + (hostOpenedDoor + 1));
        System.out.println("Player final choice: " + (playerFinalChoice + 1));
        System.out.println("Doors information:");
        for (int i = 0; i < DOOR_COUNT; i++) {
            System.out.println(doors[i].getDoorInfo(i));
        }
    }
}
