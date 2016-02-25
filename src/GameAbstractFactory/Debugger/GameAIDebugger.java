package GameAbstractFactory.Debugger;

import GameAbstractFactory.AbstractGameRules;
import GameAbstractFactory.IAI;
import GameAbstractFactory.IRules;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Joao on 07/02/2016.
 */
public class GameAIDebugger implements IAI<AbstractGameRules> {

    private static final int MAX_TEAMS     = 2;

    public String getGameAI() {
        return "AI for Sueca game";
    }

    public List<Integer> playGame(AbstractGameRules objRules, List<List<Integer>> cardsShuffled){
        Scanner user_input = new Scanner( System.in );

        //TODO - This is completly wrong here.
        //It is required to implement this in PLayer Class
        List<Integer> player1 = cardsShuffled.get(0);
        List<Integer> player2 = cardsShuffled.get(1);
        List<Integer> player3 = cardsShuffled.get(2);
        List<Integer> player4 = cardsShuffled.get(3);
        //Start playing
        int teamA = 0, teamB = 0;

        for( int i = 0; i < 10; i++) {
            if ((player1.get(i) + player3.get(i)) < (player2.get(i) + player4.get(i))) {
                teamB = teamB + 2;
            }

            else if ((player1.get(i) + player3.get(i)) > (player2.get(i) + player4.get(i))) {
                teamA = teamA + 2;
            }

            else {
                teamA = teamA++;
                teamB = teamB++;
            }
        }
        List<Integer> results = new ArrayList<>(MAX_TEAMS + 1);

        results.add(teamA);
        results.add(teamB);

        return results;
    }

}
