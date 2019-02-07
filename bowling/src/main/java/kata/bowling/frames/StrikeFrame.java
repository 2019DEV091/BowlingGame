package kata.bowling.frames;

import java.util.List;

import kata.bowling.BowlingGame;
import kata.bowling.roll.Roll;

public class StrikeFrame extends Frame{

	
	public StrikeFrame(List<Roll> rolls,BowlingGame bowlingGame) {
		super(rolls, bowlingGame);
	}

	@Override
	public int score() {
		//een strikeframe krijgt sowieso 10 punten + de waarde van de volgende 2 rollen
		return 10+getPointsOfNextTwoRolls();
	}

	private int getPointsOfNextTwoRolls() {
		int rollIndex = frameRolls.get(0).getRollNumber();
		return bowlingGame.getScoreOfRoll(rollIndex+1)+bowlingGame.getScoreOfRoll(rollIndex+2);
	}

}
