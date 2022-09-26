package lld.tictaktoe;

public class Cell {
    private Ball ball;

    public Cell() {
        ball = null;
    }

    public void addBall(Ball ball) throws TicTakToeException {
        if (this.ball == null) {
            this.ball = ball;
        } else {
            throw new TicTakToeException("NOT ALLOWED ::::: Cell is already occupied with ".concat(ball.getBallType().toString()));
        }
    }

    public boolean hasBall() {
        return ball != null;
    }

    public BallType getBallType() {
        return this.ball.getBallType();
    }
}
