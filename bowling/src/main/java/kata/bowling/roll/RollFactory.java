package kata.bowling.roll;

import java.util.ArrayList;
import java.util.List;

public class RollFactory {
	
	private String[]rolls;

	public RollFactory(String[] rolls) {
		this.rolls = rolls;
	}

	// eerst gewoon alle rolls aanmaken op basis van de String die binnenkomt
	public List<Roll> createRollList() {

		List<Roll> createdRolls = new ArrayList<Roll>();

		for (int i = 0; i < rolls.length; i++) {
			createdRolls.add(createRoll(rolls[i]));
		}

		addInformationAboutOtherRolls(createdRolls);
		return createdRolls;

	}

	private Roll createRoll(String rollType) {

		switch (rollType) {
		case "X":
			return new StrikeRoll();

		case "/":
			return new SpareRoll();
		default:
			return new NormalRoll(rollType);
		}

	}

	// Dan rolls aanvullen met roll info van andere rolls
	// opletten bij laatste rolls -> arrayindex out of bounds exception
	private void addInformationAboutOtherRolls(List<Roll> rolls) {
		for (Roll roll : rolls) {
			int rollsSize = rolls.size();
			int index = rolls.indexOf(roll);

			if (roll instanceof SpareRoll) {

				
				((SpareRoll) roll).setPreviousRoll(rolls.get(index - 1));
				
				if(isNextRollPresent(index + 1, rollsSize)) {
					((SpareRoll) roll).setFollowingRoll(rolls.get(index+1));
				}

			} else if (roll instanceof StrikeRoll) {
				
				if(isNextRollPresent(index + 1, rollsSize)) {
					((StrikeRoll) roll).getFollowingRolls().add(rolls.get(index + 1));
				}
				if(isNextRollPresent(index + 2, rollsSize)) {
					((StrikeRoll) roll).getFollowingRolls().add(rolls.get(index + 2));
				}
			}
		}
	}
	
	private boolean isNextRollPresent(int index, int sizeOfList) {
		if(index < sizeOfList) {
			return true;
		}
		return false;
	}

}
