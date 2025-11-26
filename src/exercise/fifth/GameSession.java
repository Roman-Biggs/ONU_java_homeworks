package exercise.fifth;

import java.util.Random;

public class GameSession {
    // МЕНЯЕМ private на protected, чтобы наследник видел эти поля
    protected Door[] doors;
    protected int playerInitialChoice;
    protected int hostOpenedDoor;
    protected int playerFinalChoice;
    protected Random random;

    protected static final int DOOR_COUNT = 3;

    public GameSession() {
        this.random = new Random();
        this.doors = new Door[DOOR_COUNT];
        for (int i = 0; i < DOOR_COUNT; i++) {
            doors[i] = new Door();
        }
    }

    public void resetAllBeforeGame(){
        this.playerInitialChoice = -1;
        this.hostOpenedDoor = -1;
        this.playerFinalChoice = -1;
        for  (int i = 0; i < DOOR_COUNT; i++) {
            doors[i].reset();
        }
    }

    public void startGame() {
        resetAllBeforeGame();
        int prizeDoor = random.nextInt(3);
        doors[prizeDoor].setHasPrize(true);
    }

    public void playerChooses(int doorIndex) {
        this.playerInitialChoice = doorIndex - 1;
        doors[doorIndex - 1].setIsChosenByPlayer(true);
    }

    // Этот метод мы будем ПЕРЕОПРЕДЕЛЯТЬ в наследнике
    public void hostOpensDoor() {
        for (int i = 0; i < DOOR_COUNT; i++) {
            if (i != playerInitialChoice && !doors[i].hasPrize()) {
                hostOpenedDoor = i;
                doors[i].setIsChosenByHost(true);
                return;
            }
        }
    }

    public void playerFinalDecision(boolean switchChoice) {
        if (!switchChoice) {
            playerFinalChoice = playerInitialChoice;
        } else {
            for (int i = 0; i < DOOR_COUNT; i++) {
                // ВАЖНО: проверяем, чтобы не выбрать начальный выбор и открытую дверь
                if (i != playerInitialChoice && i != hostOpenedDoor) {
                    playerFinalChoice = i;
                    break;
                }
            }
        }
    }

    public boolean isPlayerWin() {
        // Если ведущий случайно открыл приз (в расширенной версии), игрок технически не выиграл в классическом смысле,
        // но этот метод проверяет финальный выбор.
        // Доп. проверку на победу ведущего лучше делать отдельно или внутри логики игры.
        if (playerFinalChoice == -1) return false; // Защита
        return doors[playerFinalChoice].hasPrize();
    }

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