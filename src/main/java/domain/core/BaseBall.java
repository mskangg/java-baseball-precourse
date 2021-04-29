package domain.core;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    private final List<Ball> balls;

    public BaseBall(List<Integer> inputInteger) {
        this.balls = mapBalls(inputInteger);
    }

    private List<Ball> mapBalls(List<Integer> inputInteger) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, inputInteger.get(i)));
        }
        return balls;
    }

    public BallStatus judge(Ball userBall) {
        return balls.stream()
                .map(ball -> ball.match(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(List<Integer> inputInteger) {
        BaseBall baseBall = new BaseBall(inputInteger);
        PlayResult playResult = new PlayResult();
        for (Ball ball : balls) {
            playResult.report(baseBall.judge(ball));
        }
        return playResult;
    }

}
