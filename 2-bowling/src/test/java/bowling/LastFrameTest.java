package bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LastFrameTest {

	@Test
	void testRegisterSingleFive() {
		Frame f = new LastFrame();
		f.registerRoll(5);
		assertEquals(5, f.score());
	}
	
	@Test
	void testRegisterSingleOne() {
		Frame f = new LastFrame();
		f.registerRoll(1);
		assertEquals(1, f.score());
	}
	
	@Test
	void testRegisterNegativeNumber() {
		Frame f = new LastFrame();
		assertThrows(IllegalArgumentException.class,
				() -> f.registerRoll(-1));
	}
	
	@Test
	void testRegisterTwoScores() {
		Frame f = new LastFrame();
		f.registerRoll(5);
		f.registerRoll(4);
		assertEquals(9, f.score());
	}
	
	@Test
	void testRegisterScoresSumGreaterThan10() {
		Frame f = new LastFrame();
		f.registerRoll(5);
		assertThrows(IllegalArgumentException.class,
				() -> f.registerRoll(6));
	}
	
	
	
}
