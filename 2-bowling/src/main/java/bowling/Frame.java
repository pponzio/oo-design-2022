package bowling;

public interface Frame {

	void registerRoll(int pins);

	boolean isClosed();

	int score();

	int getFirstBonus();

	int getSecondBonus();

	void setNext(Frame next);
	
	boolean isStrike();
	
	boolean isSpare();
	
	int getFirstRoll();

	int getSecondRoll();

}