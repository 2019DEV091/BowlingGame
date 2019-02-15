package kata.bowling;

import java.util.List;

import kata.bowling.frames.Scoreable;
import kata.bowling.frames.builder.FrameFactory;
import kata.bowling.roll.Roll;
import kata.bowling.roll.RollFactory;

/**
 * Starting point for the bowling game kata As is stated in the kata the
 * following will not be checked, so there are no safeties built in for these:
 * 
 * We will not check for valid rolls. We will not check for correct number of
 * rolls and frames. We will not provide scores for intermediate frames.
 * 
 * 
 *
 */
public class BowlingGame {

	private List<Roll> rolls;
	private List<Scoreable> frames;

	public BowlingGame(String line) {
		String[] individualRolls = line.replaceAll("[^0-9X/-]", "").split("");
		RollFactory rollFactory = new RollFactory(individualRolls);
		List<Roll> rolls = rollFactory.createRollList();
		FrameFactory frameFactory = new FrameFactory();
		frames = frameFactory.createFrames(rolls);
	}

	public int getScore() {
		return frames.stream().mapToInt(Scoreable::score).sum();
	}

	public Roll getRollAt(int rollTracker) {
		return rolls.get(rollTracker);
	}

	public int getRollsSize() {
		return rolls.size();
	}

}
