package kata.bowling.frames;

import java.util.List;

import kata.bowling.BowlingGame;
import kata.bowling.roll.Roll;

public class NormalFrame extends Frame {

	public NormalFrame(List<Roll> rolls,BowlingGame bowlingGame) {
		super(rolls,bowlingGame);
	}

	@Override
	public int score() {
		return frameRolls.stream().mapToInt(Roll::getPins).sum();
	}

}
