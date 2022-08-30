package bowling;

public class LastFrame implements Frame {
	
	private int first;
	private int second;
	private int third;
	private int numRolls;

	@Override
	public void registerRoll(int pins) {

	}
	
	@Override
	public boolean isClosed() {
		return false;
	}

	@Override
	public int score() {
		return 0;
	}

	@Override
	public int getFirstBonus() {
		return 0;
	}

	@Override
	public int getSecondBonus() {
		return 0;
	}

	@Override
	public void setNext(Frame next) {
		throw new UnsupportedOperationException();
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
	public int getFirstRoll() {
		return first;
	}

	@Override
	public int getSecondRoll() {
		return second;
	}

}
