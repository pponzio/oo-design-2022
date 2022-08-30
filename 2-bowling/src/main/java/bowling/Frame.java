package bowling;

public class Frame {
	
	private int first;
	private int second;
	private int numRolls;
	Frame next;

	public void registerRoll(int pins) {
		if (invalidNumberOfPins(pins))
			throw new IllegalArgumentException();
		if (invalidResultingScore(pins))
			throw new IllegalArgumentException();
		
		registerCurrentRoll(pins);
	}

	private void registerCurrentRoll(int pins) {
		switch (numRolls) {
		case 0:
			first = pins;
			break;
		case 1:
			second = pins;
			break;
		default:
			throw new IllegalStateException(); 
		}
		numRolls++;
	}

	private boolean invalidResultingScore(int pins) {
		return first + second + pins > 10;
	}

	private boolean invalidNumberOfPins(int pins) {
		return pins < 0 || pins > 10;
	}

	public int score() {
		int partialScore = first + second;
		if (first == 10)
			return partialScore + next.first + next.second;
		
		if (partialScore == 10) 
			return partialScore + next.first;
		
		return partialScore;
	}

	public void setNext(Frame next) {
		this.next = next;
	}

}
