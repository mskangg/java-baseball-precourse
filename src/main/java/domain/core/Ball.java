package domain.core;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int number;

    public Ball(int index, int number) {
        this.position = index;
        this.number = number;
    }

    public BallStatus match(Ball targetBall) {
        if (this.equals(targetBall)) {
            return BallStatus.STRIKE;
        }
        if (this.isBall(targetBall.number)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isBall(int number) {
        return this.number == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }

}
