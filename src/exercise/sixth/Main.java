package exercise.sixth;

public class Main {

    public static void main(String[] args) {
        // Создаем экземпляр нашей игры
        GameRunnable gameSession = new GameRunnable();

        // Запускаем её.
        // Так как это implements Runnable, мы можем запустить это в отдельном потоке,
        // если захотим (для сервера это критично).
        // Для консоли пока достаточно просто вызвать run().

        gameSession.run();

        // Если бы мы писали многопоточный сервер, это выглядело бы так:
        // Thread gameThread = new Thread(new GameRunnable());
        // gameThread.start();
    }
}