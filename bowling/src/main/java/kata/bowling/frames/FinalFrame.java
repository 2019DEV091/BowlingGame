package kata.bowling.frames;

import java.util.List;

import kata.bowling.BowlingGame;
import kata.bowling.roll.Roll;

public class FinalFrame extends Frame {

	public FinalFrame(List<Roll> rolls,BowlingGame bowlingGame) {
		super(rolls,bowlingGame);
	}

	@Override
	public int score() {
		// optellen van alle rolls scores
		return frameRolls.stream().mapToInt(Roll::getPins).sum();
	}

}
