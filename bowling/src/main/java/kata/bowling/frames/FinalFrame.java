package kata.bowling.frames;

import kata.bowling.roll.Roll;

public class FinalFrame extends Frame {

	public FinalFrame() {
		super();
	}

	@Override
	public int score() {
		// optellen van alle rolls scores
		return frameRolls.stream().mapToInt(Roll::getPins).sum();
	}

}
