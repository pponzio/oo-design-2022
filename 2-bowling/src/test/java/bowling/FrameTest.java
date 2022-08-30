package bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class FrameTest {

	@Test
	void testRegisterSingleFive() {
		Frame f = new RegularFrame();
		f.registerRoll(5);
		assertEquals(5, f.score());
	}
	
	@Test
	void testRegisterSingleOne() {
		Frame f = new RegularFrame();
		f.registerRoll(1);
		assertEquals(1, f.score());
	}
	
	@Test
	void testRegisterNegativeNumber() {
		Frame f = new RegularFrame();
		assertThrows(IllegalArgumentException.class,
				() -> f.registerRoll(-1));
	}
	
	@Test
	void testRegisterTwoScores() {
		Frame f = new RegularFrame();
		f.registerRoll(5);
		f.registerRoll(4);
		assertEquals(9, f.score());
	}
	
	@Test
	void testRegisterScoresSumGreaterThan10() {
		Frame f = new RegularFrame();
		f.registerRoll(5);
		assertThrows(IllegalArgumentException.class,
				() -> f.registerRoll(6));
	}
	
	@Test
	void testRegisterThreeRolls() {
		Frame f = new RegularFrame();
		f.registerRoll(3);
		f.registerRoll(3);
		assertThrows(IllegalStateException.class,
				() -> f.registerRoll(3));
	}
	
	@Test
	void testRegisterSpare() {
		Frame f1 = new RegularFrame();
		RegularFrame f2 = new RegularFrame();
		f1.setNext(f2);

		f1.registerRoll(5);
		f1.registerRoll(5);
		assertEquals(10, f1.score());

		f2.registerRoll(5);
		assertEquals(5, f2.score());
		assertEquals(15, f1.score());
	}
	
	
	@Test
	void testRegisterStrike() {
		Frame f1 = new RegularFrame();
		RegularFrame f2 = new RegularFrame();
		f1.setNext(f2);

		f1.registerRoll(10);
		assertEquals(10, f1.score());

		f2.registerRoll(4);
		f2.registerRoll(3);
		assertEquals(7, f2.score());
		assertEquals(17, f1.score());
	}
	
	@Test
	void testRegisterStrikeAndZero() {
		Frame f = new RegularFrame();
		f.registerRoll(10);
		assertThrows(IllegalStateException.class,
				() -> f.registerRoll(0));
	}

	@Test
	void testSkippingAFrame() {
		Frame f1 = new RegularFrame();
		Frame f2 = new RegularFrame();
		Frame f3 = new RegularFrame();
		f1.setNext(f2);
		f2.setNext(f3);

		f1.registerRoll(10);
		assertEquals(10, f1.score());

		assertEquals(0, f2.score());

		f3.registerRoll(3);
		assertEquals(10, f1.score());
		assertEquals(3, f3.score());
	}

	
	
}
