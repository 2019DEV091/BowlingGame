package kata.bowling.frames.builder;

import java.util.ArrayList;
import java.util.List;

import kata.bowling.BowlingGame;
import kata.bowling.frames.FinalFrame;
import kata.bowling.frames.Frame;
import kata.bowling.frames.NormalFrame;
import kata.bowling.frames.SpareFrame;
import kata.bowling.frames.StrikeFrame;
import kata.bowling.roll.Roll;

public class FrameBuilder {

	private int rollTracker = 0;
	private BowlingGame bowlingGame;

	public FrameBuilder(BowlingGame bowlingGame) {
		super();
		this.bowlingGame = bowlingGame;
	}

	public Frame build(String rollsPerFrame) {
		List<Roll> rolls = new ArrayList<Roll>();

		if (rollsPerFrame.contains("X")) {
			addNextRollsToList(rolls, 1);
			return new StrikeFrame(rolls, bowlingGame);

		} else if (rollsPerFrame.contains("/")) {
			addNextRollsToList(rolls, 2);

			return new SpareFrame(rolls, bowlingGame);
		}
		addNextRollsToList(rolls, 2);
		return new NormalFrame(rolls, bowlingGame);
	}

	private void addNextRollsToList(List<Roll> rolls, int numberOfRollsToAdd) {
		for (int i = 0; i < numberOfRollsToAdd; i++) {
			addNextRollToList(rolls);
		}
	}

	private void addNextRollToList(List<Roll> rolls) {
		rolls.add(bowlingGame.getRollAt(rollTracker));
		rollTracker++;
	}

	public Frame buildFinalFrame() {
		List<Roll> rolls = new ArrayList<Roll>();

		/*
		 * This was to see if there were too many rolls added to the last frame. The
		 * Kata explicitly says that no checks were needed on validity, so I commented
		 * it out int rollsSize = bowlingGame.getRollSize() - rollTracker < 3 ?
		 * 
		 * bowlingGame.getRollSize() : rollTracker + 3;
		 * 
		 */

		int rollsSize = bowlingGame.getRollsSize();

		for (int i = rollTracker; i < rollsSize; i++) {
			addNextRollToList(rolls);
		}
		return new FinalFrame(rolls, bowlingGame);
	}
}
