package lld.snakeladder;

import java.util.Random;

public class Dice {
    private int currentValue = 1;

    int roll() {
        Random random = new Random();
        this.currentValue = random.nextInt(1, 7);
        return this.currentValue;
    }
}
