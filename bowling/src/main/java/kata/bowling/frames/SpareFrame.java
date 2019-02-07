package kata.bowling.frames;

import java.util.List;

import kata.bowling.BowlingGame;
import kata.bowling.roll.Roll;

public class SpareFrame extends Frame {

	public SpareFrame(List<Roll> rolls,BowlingGame bowlingGame) {
		super(rolls,bowlingGame);
	}

	@Override
	public int score() {
		
		return 10+getPointsOfRoll();
	}
	
	private int getPointsOfRoll() {
		int rollIndex = frameRolls.get(0).getRollNumber();
		return bowlingGame.getScoreOfRoll(rollIndex+2);
	}

}
