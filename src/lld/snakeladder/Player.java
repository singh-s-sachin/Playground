package lld.snakeladder;

public class Player {
    private int currentPosition;
    private final String name;

    public Player(String name) {
        this.name = name;
        this.currentPosition = 1;
    }

    public String getName() {
        return this.name;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    int changePosition(int nextPosition) {
        if (nextPosition <= Game.BOARD_SIZE) {
            this.currentPosition = nextPosition;
        }
        return this.currentPosition;
    }
}
