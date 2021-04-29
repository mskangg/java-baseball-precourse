package domain.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BallTest {
    private Ball answerBall;

    @BeforeEach
    void setUp() {
        answerBall = new Ball(1, 1);
    }

    @Test
    @DisplayName("스트라이크 인지?")
    void is_strike() {
        Ball userBall = new Ball(1, 1);
        BallStatus ballStatus = answerBall.match(userBall);
        assertEquals(ballStatus, BallStatus.STRIKE);
    }

    @Test
    @DisplayName("볼 인지?")
    void is_ball() {
        Ball userBall = new Ball(2, 1);
        BallStatus ballStatus = answerBall.match(userBall);
        assertEquals(ballStatus, BallStatus.BALL);
    }

    @Test
    @DisplayName("낫싱인지?")
    void is_nothing() {
        Ball userBall = new Ball(2, 2);
        BallStatus ballStatus = answerBall.match(userBall);
        assertEquals(ballStatus, BallStatus.NOTHING);
    }
}
