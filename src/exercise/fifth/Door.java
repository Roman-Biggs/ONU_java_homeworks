package exercise.fifth;

public class Door {
    //Поля - содержит ли приз, выбрана ли игроком, выбрана ли ведущим
    private boolean hasPrize;
    private boolean isChosenByPlayer;
    private boolean isChosenByHost;

    // Конструктор по умолчанию (все false)
    public Door() {}

    // Конструктор с параметрами
    public Door(boolean hasPrize) {
        this.hasPrize = hasPrize;
    }

    //Сетеры
    public void setHasPrize(boolean hasPrize) {
        this.hasPrize = hasPrize;
    }
    public void setIsChosenByPlayer(boolean isChosenByPlayer) {
        this.isChosenByPlayer = isChosenByPlayer;
    }
    public void setIsChosenByHost(boolean isChosenByHost) {
        this.isChosenByHost = isChosenByHost;
    }

    //Гетеры
    public boolean hasPrize() {
        return hasPrize;
    }
    public boolean isChosenByPlayer() {
        return isChosenByPlayer;
    }
    public boolean isChosenByHost() {
        return isChosenByHost;
    }

    //Сброс полей двери (перед стартом новой игры)
    public void reset() {
        hasPrize = false;
        isChosenByPlayer = false;
        isChosenByHost = false;
    }

    //Печать информации о текущем состоянии двери
    public String getDoorInfo(int doorNumber) {
        return "Door {" + doorNumber + "} " +
                "hasPrize=" + hasPrize +
                ", chosenByPlayer=" + isChosenByPlayer +
                ", openedByHost=" + isChosenByHost;
    }
}
