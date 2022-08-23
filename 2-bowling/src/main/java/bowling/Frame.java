package bowling;

public class Frame {
	
	private int score;

	public void registerRoll(int pins) {
		if (pins < 0 || pins > 10)
			throw new IllegalArgumentException();
		if (score + pins > 10)
			throw new IllegalArgumentException();

		score += pins;
	}

	public int score() {
		return score;
	}

}
