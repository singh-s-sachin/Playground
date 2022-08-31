package lld.snakeladder;

import java.util.Random;

public class Snake extends Jump {

    public Snake(int cellPos) {
        createJump(cellPos);
    }

    @Override
    void createJump(int cellPos) {
        Random random = new Random();
        fromIndex = cellPos;
        toIndex = random.nextInt(fromIndex);
    }
}
