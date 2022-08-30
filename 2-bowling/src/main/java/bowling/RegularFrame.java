package bowling;

public class RegularFrame implements Frame {
	
	private int first;
	private int second;
	private int numRolls;
	private Frame next;

	@Override
	public void registerRoll(int pins) {
		if (invalidNumberOfPins(pins))
			throw new IllegalArgumentException();
		if (invalidResultingScore(pins))
			throw new IllegalArgumentException();
		if (isClosed()) 
			throw new IllegalStateException();
		
		registerCurrentRoll(pins);
	}

	@Override
	public boolean isClosed() {
		return isStrike() || numRolls == 2;
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

	@Override
	public int score() {
		int partialScore = first + second;

		if (isSpare()) 
			partialScore += getFirstBonus();
			
		if (isStrike()) { 
			partialScore += getFirstBonus();
			partialScore += getSecondBonus();
		}
		
		return partialScore;
	}

	@Override
	public boolean isStrike() {
		return first == 10;
	}

	@Override
	public boolean isSpare() {
		return !isStrike() &&
				first + second == 10;
	}
	
	@Override
	public int getFirstBonus() {
		if (!isStrike() && !isSpare())
			throw new IllegalStateException();

		return next.getFirstRoll();
	}
	
	@Override
	public int getSecondBonus() {
		if (!isStrike())
			throw new IllegalStateException();

		if (next.isStrike())
			return next.getFirstBonus();
			
		return next.getSecondRoll();
	}

	@Override
	public void setNext(Frame next) {
		this.next = next;
	}

	@Override
	public int getFirstRoll() {
		return first;
	}

	@Override
	public int getSecondRoll() {
		return second;
	}

}