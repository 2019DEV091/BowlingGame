package kata.bowling.frames;

import kata.bowling.roll.Roll;

public class NormalFrame extends Frame {

	public NormalFrame() {
		super();
	}

	@Override
	public int score() {
		return frameRolls.stream().mapToInt(Roll::getScore).sum();
		
	}
	
	

}
