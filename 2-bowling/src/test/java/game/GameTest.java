package game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import bowling.Frame;
import bowling.LastFrame;
import bowling.RegularFrame;

public class GameTest {

	@Test
	void testRegisterTwoScores() {
		
		Frame [] frames = new Frame[10];
		for (int i = 0; i < 9; i++)
			frames[i] = new RegularFrame();
		frames[9] = new LastFrame();
		for (int i = 0; i < 9; i++)
			frames[i].setNext(frames[i+1]);
		
		// cargar los resultados de los 10 frames
		
		int score = 0;
		for (int i = 0; i < 10; i++)
			score += frames[i].score();

	}
}
