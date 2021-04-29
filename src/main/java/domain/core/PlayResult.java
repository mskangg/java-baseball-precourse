package domain.core;

public class PlayResult {
    private int strike;
    private int ball;

    public PlayResult() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void report(BallStatus play) {
        if (play.isBall()) {
            this.ball++;
        }
        if (play.isStrike()) {
            this.strike++;
        }
    }
}
