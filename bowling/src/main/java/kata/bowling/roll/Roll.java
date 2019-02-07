package kata.bowling.roll;

import kata.bowling.BowlingGame;

public class Roll {
	
	private int pins;
	private int rollNumber;
	private String score;
	private BowlingGame bowlingGame;
	
	
	public Roll(String score, int rollNumber, BowlingGame bowlingGame) {
		super();
		this.bowlingGame = bowlingGame;
		this.score = score;
		this.rollNumber = rollNumber;
		this.pins = getPinsFromScore();
		
	}


	public int getPinsFromScore() {
		switch (score) {
		case "X":
			return 10;

		case "/":
			return 10- getScorePreviousRoll();
			
		case "-":
			return 0;
		default:
			return Integer.parseInt(score);
		}
	}


	private int getScorePreviousRoll() {
		
		return bowlingGame.getScoreOfRoll(this.rollNumber-1);
	}


	public int getPins() {
		return pins;
	}
	
	public int getRollNumber() {
		return rollNumber;
	}


}
