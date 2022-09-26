package lld.tictaktoe;

import java.util.Deque;
import java.util.LinkedList;

public class Player {
    String name;
    Deque<Ball> balls;

    public Player(String playerName, BallType ballType) {
        this.name = playerName;
        balls = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            balls.add(new Ball(ballType));
        }
    }

    public String getName() {
        return this.name;
    }

    public Ball getBall() throws TicTakToeException {
        if (balls.size() <= 0) {
            throw new TicTakToeException(this.name.concat("have no balls remaining."));
        }
        return balls.removeFirst();
    }
}
