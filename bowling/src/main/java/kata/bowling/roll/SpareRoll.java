package kata.bowling.roll;

public class SpareRoll extends Roll {
	
	private Roll previousRoll;
	private Roll nextRoll;
	
	public Roll getPreviousRoll() {
		return previousRoll;
	}
	public void setPreviousRoll(Roll previousRoll) {
		this.previousRoll = previousRoll;
	}
	public Roll getNextRoll() {
		return nextRoll;
	}
	public void setFollowingRoll(Roll nextRoll) {
		this.nextRoll = nextRoll;
	}
	@Override
	public int getPins() {
		
		return 10-previousRoll.getPins();
	}
	
	@Override
	public int getScore() {
		return this.getPins()+getNextRoll().getPins();
	}
	
	
	

}
