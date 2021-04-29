package domain.core;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    private final List<Ball> answer;

    public BaseBall(List<Integer> answer) {
        this.answer = mapBalls(answer);
    }

    private List<Ball> mapBalls(List<Integer> answer) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answer.get(i)));
        }
        return balls;
    }

    public BallStatus play(Ball userBall) {
        return answer.stream()
                .map(ball -> ball.match(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
