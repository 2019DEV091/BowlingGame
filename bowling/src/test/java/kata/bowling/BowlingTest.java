package kata.bowling;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;


/**
 * Testcases for the bowling game points calculator
 *
 */
public class BowlingTest 
{
	@BeforeEach
	void setup(TestInfo testInfo) {
		System.out.printf("Test: %s started%n",testInfo.getDisplayName());
	}

	@Test
	@DisplayName("Game with perfect score")
    void perfectScore()
    {
		BowlingGame game = new BowlingGame("X X X X X X X X X X X X");
        
        Assertions.assertEquals(300, game.getScore(), "Score should be 300");
    }
	
	@Test
	@DisplayName("Game with each frame a 9 and a miss")
    void nineAndMiss()
    {
		BowlingGame game = new BowlingGame("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-");
        
        Assertions.assertEquals(90, game.getScore(), "Score should be 90");
    }
	
	@Test
	@DisplayName("Game with each frame a 5 and a spare and a final 5")
	void fiveAndSpareAndFinalFive() {
		BowlingGame game = new BowlingGame("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5");

		Assertions.assertEquals(150, game.getScore(), "Score should be 150");
	}
	
	@Test
	@DisplayName("Game with a strike and spares and some normal scores")
	void gameWithSpareStrikeAndNormals() {
		BowlingGame game = new BowlingGame("35 17 32 7/ X 11 36 72 45 5/5");

		Assertions.assertEquals(97, game.getScore(), "Score should be 97");
	}
	
	
	@Test
	@DisplayName("Game with strikes and spares and some normal scores")
	void gameWithSparesStrikesAndNormals() {
		BowlingGame game = new BowlingGame("X 8/ 5/ X X X 90 30 11 26");

		Assertions.assertEquals(155, game.getScore(), "Score should be 155");
	}
	
	@Test
	@DisplayName("Game with junk in the scoring")
    void junkScore()
    {
		BowlingGame game = new BowlingGame("XqqsdqdXqsdqzazfhX$$$$ X X X X X X3 2 X X");
        
        Assertions.assertEquals(253, game.getScore(), "Score should be 253");
    }
	
	@Test
	@DisplayName("Game with only numbers in the scoring")
    void onlyNumbersScore()
    {
		BowlingGame game = new BowlingGame("41352462368190246310");
        
        Assertions.assertEquals(70, game.getScore(), "Score should be 70");
    }
	

	@AfterEach
	void tearDown(TestInfo testInfo) {
		System.out.printf("Test: %s stopped%n",testInfo.getDisplayName());
	}
}
