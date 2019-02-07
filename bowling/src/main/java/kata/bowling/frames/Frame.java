package kata.bowling.frames;

import java.util.List;

import kata.bowling.BowlingGame;
import kata.bowling.roll.Roll;

public abstract class Frame implements Scoreable{
	
	protected List<Roll> frameRolls;
	protected BowlingGame bowlingGame;

	public Frame(List<Roll> rolls,BowlingGame bowlingGame) {
		this.bowlingGame = bowlingGame;
		this.frameRolls =rolls;
	}
	
}
