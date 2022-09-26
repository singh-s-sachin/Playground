package lld.tictaktoe;

public class Ball {
    BallType ballType;

    public Ball(BallType ballType) {
        this.ballType = ballType;
    }

    public BallType getBallType() {
        return this.ballType;
    }
}
