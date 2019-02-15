package kata.bowling.roll;

public class NormalRoll extends Roll {

	private String rollType;
	public NormalRoll(String rollType) {
		this.rollType = rollType;
	}
	
	@Override
	public int getPins() {
		switch (rollType) {
		case "-":
			return 0;

		default:
			return Integer.parseInt(rollType);
		}
	}

	@Override
	public int getScore() {
		return this.getPins();
	}

}
