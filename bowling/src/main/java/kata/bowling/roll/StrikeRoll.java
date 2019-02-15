package kata.bowling.roll;

import java.util.ArrayList;
import java.util.List;

public class StrikeRoll extends Roll {

	private List<Roll> followingRolls;

	public StrikeRoll() {
		this.followingRolls = new ArrayList<Roll>();
	}

	public List<Roll> getFollowingRolls() {
		return followingRolls;
	}

	@Override
	public int getPins() {
		return 10;
	}

	@Override
	public int getScore() {
		return this.getPins() + followingRolls.stream().mapToInt(Roll::getPins).sum();
	}

}
