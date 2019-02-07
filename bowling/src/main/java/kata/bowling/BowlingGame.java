package kata.bowling;

import java.util.ArrayList;
import java.util.List;
import kata.bowling.frames.Frame;
import kata.bowling.frames.Scoreable;
import kata.bowling.frames.builder.FrameBuilder;
import kata.bowling.roll.Roll;

/**
 * Starting point for the bowling game kata
 * As is stated in the kata the following will not be checked, so there are no safeties built in for these:
 * 
 * We will not check for valid rolls.
 * We will not check for correct number of rolls and frames.
 * We will not provide scores for intermediate frames.
 * 
 * 
 *
 */
public class BowlingGame {

	private String[] rollsPerFrame;
	private String[] individualRolls;
	private List<Roll> rolls;
	private List<Scoreable> frames;

	public BowlingGame(String line) {
		this.rollsPerFrame = line.split(" ");
		this.individualRolls = line.replaceAll(" ", "").split("");
		createRolls();
		createFrames();
	}

	private void createRolls() {
		rolls = new ArrayList<Roll>();
		
		for (int i = 0; i < individualRolls.length; i++) {
			Roll roll = new Roll(individualRolls[i],i, this);
			rolls.add(roll);
		}
		
	}
	
	public int getScoreOfRoll(int rollNumber) {
		return rolls.get(rollNumber).getPinsFromScore();
	}

	private void createFrames() {
		frames = new ArrayList<>();
		FrameBuilder builder = new FrameBuilder(this);
		
		//Build the first 9 frames, as they follow the normal rules of scoring
		for (int i = 0; i < 9; i++) {
			Scoreable frame = builder.build(rollsPerFrame[i]);
			frames.add(frame);
		}
		
		//Buid the final frame separately because it has a different scoring method
		Frame finalFrame = builder.buildFinalFrame();
		frames.add(finalFrame);
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
