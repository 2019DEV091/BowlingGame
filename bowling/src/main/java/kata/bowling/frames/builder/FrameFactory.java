package kata.bowling.frames.builder;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import kata.bowling.frames.FinalFrame;
import kata.bowling.frames.Frame;
import kata.bowling.frames.NormalFrame;
import kata.bowling.frames.Scoreable;
import kata.bowling.roll.NormalRoll;
import kata.bowling.roll.Roll;

public class FrameFactory {
	
	private int rollcounter = 0;
	
	public List<Scoreable> createFrames(List<Roll> rolls){
		List<Scoreable> frames = new ArrayList<>();
		
		for (int i = 0; i < 9; i++) {
			Frame frame = new NormalFrame();
			Roll roll = rolls.get(rollcounter);
			rollcounter++;
			frame.getFrameRolls().add(roll);
			
			if(isNormalRoll(roll)) {
				Roll secondRoll = rolls.get(rollcounter);
				rollcounter++;
				frame.getFrameRolls().add(secondRoll);
			}
			
			frames.add(frame);
		}
		FinalFrame finalFrame = new FinalFrame();
		finalFrame.getFrameRolls().addAll(getFinalRolls(rolls));
		frames.add(finalFrame);
		return frames;
		
	}
	
	private Collection<? extends Roll> getFinalRolls(List<Roll> rolls) {
		List<Roll> finalRolls = new ArrayList<Roll>();
		
		//als tweede roll een spare of strike is -> derde roll
		
		for (int i = 0; i < 2; i++) {
			finalRolls.add(rolls.get(rollcounter));
			rollcounter++;
		}
		
		if(!isNormalRoll(rolls.get(rollcounter-1))) {
			finalRolls.add(rolls.get(rollcounter));
			rollcounter++;
		}
		return finalRolls;
	}

	private boolean isNormalRoll(Roll roll) {
		if(roll instanceof NormalRoll) {
			return true;
		}
		return false;
	}

}
