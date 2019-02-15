package kata.bowling.frames;

import java.util.ArrayList;
import java.util.List;

import kata.bowling.roll.Roll;

public abstract class Frame implements Scoreable{
	
	protected List<Roll> frameRolls;

	public Frame() {
		this.frameRolls =new ArrayList<Roll>();
	}

	public List<Roll> getFrameRolls() {
		return frameRolls;
	}
	
	
	
}
