package exercise.sixth;

import exercise.fifth.GameSession;

// Наследуемся от базовой сессии
public class GameSessionExtended extends GameSession {

    public GameSessionExtended() {
        super(); // Вызов конструктора родителя (создание дверей, рандома и т.д.)
    }

    /**
     * Переопределяем метод: Ведущий открывает дверь наугад.
     * Он не знает, где приз, поэтому исключает только выбор игрока.
     */
    @Override
    public void hostOpensDoor() {
        // Собираем кандидатов (двери, кроме той, что выбрал игрок)
        int[] candidates = new int[DOOR_COUNT - 1];
        int idx = 0;
        for (int i = 0; i < DOOR_COUNT; i++) {
            if (i != playerInitialChoice) {
                candidates[idx++] = i;
            }
        }

        // Случайно выбираем одну из них
        int randIndex = random.nextInt(candidates.length);
        hostOpenedDoor = candidates[randIndex];

        // Открываем её
        doors[hostOpenedDoor].setIsChosenByHost(true);
    }

    /**
     * Уникальный метод для этой версии игры:
     * Проверка, не открыл ли ведущий случайно приз.
     */
    public boolean didHostHitPrize() {
        // hostOpenedDoor у нас доступен, так как он protected в родителе
        if (hostOpenedDoor == -1) return false;
        return doors[hostOpenedDoor].hasPrize();
    }
}