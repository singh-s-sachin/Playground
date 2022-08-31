package lld.snakeladder;

import java.util.Random;

public class Ladder extends Jump {

    public Ladder(int cellPos) {
        createJump(cellPos);
    }

    @Override
    void createJump(int cellPos) {
        Random random = new Random();
        toIndex = random.nextInt(cellPos, Game.BOARD_SIZE);
        fromIndex = cellPos;
    }
}
