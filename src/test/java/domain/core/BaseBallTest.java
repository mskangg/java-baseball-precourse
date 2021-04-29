package domain.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BaseBallTest {
    private BaseBall baseBall;

    @BeforeEach
    void setUp() {
        this.baseBall = new BaseBall(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("3개 숫자 중에 해당 공이 스트라이크`인지")
    void answer_1strike() {
        Ball userBall = new Ball(1, 1);
        BallStatus result = baseBall.play(userBall);
        Assertions.assertEquals(result, BallStatus.STRIKE);
    }

    @Test
    @DisplayName("3개 숫자 중에 해당 콩이 볼인지")
    void answer_1ball() {
        Ball userBall = new Ball(1, 2);
        BallStatus result = baseBall.play(userBall);
        Assertions.assertEquals(result, BallStatus.BALL);
    }

    @Test
    @DisplayName("3개 숫자 중에 해당 볼이 낫싱인지")
    void answer_nothing() {
        Ball userBall = new Ball(1, 4);
        BallStatus result = baseBall.play(userBall);
        Assertions.assertEquals(result, BallStatus.NOTHING);
    }
}
