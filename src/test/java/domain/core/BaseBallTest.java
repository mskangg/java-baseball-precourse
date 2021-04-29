package domain.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseBallTest {
    private BaseBall baseBall;

    @BeforeEach
    void setUp() {
        this.baseBall = new BaseBall(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("3개 숫자 중에 해당 공이 스트라이크인지")
    void answer_1strike() {
        Ball userBall = new Ball(1, 1);
        BallStatus result = baseBall.judge(userBall);
        assertEquals(result, BallStatus.STRIKE);
    }

    @Test
    @DisplayName("3개 숫자 중에 해당 콩이 볼인지")
    void answer_1ball() {
        Ball userBall = new Ball(1, 2);
        BallStatus result = baseBall.judge(userBall);
        assertEquals(result, BallStatus.BALL);
    }

    @Test
    @DisplayName("3개 숫자 중에 해당 볼이 낫싱인지")
    void answer_nothing() {
        Ball userBall = new Ball(1, 4);
        BallStatus result = baseBall.judge(userBall);
        assertEquals(result, BallStatus.NOTHING);
    }

    @Test
    @DisplayName("입력된 숫자 3개가 3스트라이크로 나오는지")
    void play_3strike() {
        PlayResult playResult = baseBall.play(Arrays.asList(1, 2, 3));
        assertEquals(playResult.getStrike(), 3);
        assertEquals(playResult.getBall(), 0);
    }

    @Test
    @DisplayName("입력된 숫자 3개가 3볼로 나오는지")
    void play_3ball() {
        PlayResult playResult = baseBall.play(Arrays.asList(3, 1, 2));
        assertEquals(playResult.getStrike(), 0);
        assertEquals(playResult.getBall(), 3);
    }

    @Test
    @DisplayName("입력된 숫자 3개가 2볼 1스트라이크로 나오는지")
    void play_2ball_1strike() {
        PlayResult playResult = baseBall.play(Arrays.asList(1, 3, 2));
        assertEquals(playResult.getStrike(), 1);
        assertEquals(playResult.getBall(), 2);
    }
}
