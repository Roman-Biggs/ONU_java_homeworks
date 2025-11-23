package exercise.sixth;

import exercise.fifth.Door;

import java.util.Random;

public class GameSessionExtended {
    private exercise.fifth.Door[] doors; //массив из трёх дверей
    //Храним как числа для массива (т.е. от 0 до 2)
    private int playerInitialChoice;
    private int hostOpenedDoor;
    private int playerFinalChoice;
    private Random random;

    private static final int DOOR_COUNT = 3; // константа для числа дверей

    //Конструктор - задаём рандомное число и создаём изначальный массив из 3-ёх дверей
    public GameSessionExtended() {
        this.random = new Random();
        this.doors = new exercise.fifth.Door[DOOR_COUNT];
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

    // 3. Ведущий открывает дверь наугад, не зная где приз, которую игрок не выбрал
    public void hostOpensDoorUnknown() {
        // Генерируем список возможных дверей, которые можно открыть
        int[] candidates = new int[DOOR_COUNT - 1]; // исключаем выбор игрока
        int idx = 0;
        for (int i = 0; i < DOOR_COUNT; i++) {
            if (i != playerInitialChoice) {
                candidates[idx++] = i; //Записываем возможный номер двери по индексу 0, затем увеличиваем индекс до 1
            }
        }

        // Случайно выбираем дверь из кандидатов
        int randIndex = random.nextInt(candidates.length); //Фактически случаное число-индекс 0 или 1 (т.к. список возможных дверей всегда из двух элементов)
        hostOpenedDoor = candidates[randIndex];
        doors[hostOpenedDoor].setIsChosenByHost(true);
    }

    // 4. Проверяем: если ведущий открыл призовую дверь, ведущий побеждает
    public boolean didHostHitPrize() {
        return doors[hostOpenedDoor].hasPrize(); // true → ведущий выиграл
    }

    // 5. Игрок принимает финальное решение (менять или нет)
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

    // 6. Проверка выигрыша
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
            System.out.println(doors[i].getDoorInfo(i + 1));
        }
    }
}