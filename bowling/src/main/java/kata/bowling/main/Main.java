package kata.bowling.main;

import kata.bowling.BowlingGame;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
       BowlingGame game = new BowlingGame(args[0]);
       
       System.out.printf("Your score is: %d",game.getScore());
    }
}
