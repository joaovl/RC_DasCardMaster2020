package GameAbstractFactory.Debugger;

import GameAbstractFactory.AbstractGameRules;
import GameAbstractFactory.IRules;

import java.util.List;

/**
 * Created by Joao on 06/02/2016.
 */

public class GameRulesDebugger extends AbstractGameRules {

    public static final int NUMBER_OF_CARDS = 40;
    public static final int NUMBER_OF_TRICKS = 10;
    public static final int NUMBER_OF_PLAYERS = 4;
    public static final int NUMBER_OF_CARDS_PASSED = 3;
    public static final int MAX_SCORE = 100;
    public static final int CARDS_IN_HAND = 10;

    public String getGameRules() {
        return "Rules for Debugger game created this is CGameRulesBody";
    }


    public String checkWhoWinnes(List<Integer> resultOfPlay){

        if(resultOfPlay.get(0) > resultOfPlay.get(1)) {
            return "Team A is the winner with : " + resultOfPlay.get(0).toString() + " points";
        }
        else if (resultOfPlay.get(0) < resultOfPlay.get(1)) {
            return "Team B is the winner with : " + resultOfPlay.get(1).toString() + " points";
        }
        else {
            return "Team A and B draw with : " + resultOfPlay.get(1).toString() + " points";
        }
    }

    @Override
    public String checkNumberOfPlayers(Integer numberOfPLayers) {
        return null;
    }

    @Override
    public boolean soloGame() {
        return false;
    }

    @Override
    public List<Integer> validPlay(List<Integer> playerCards) {
        return null;
    }


    @Override
    public int getCardsInHand() {
        return 10;
    }

    @Override
    public int getGamePlayingOrder() {
        return 0;
    }

    @Override
    public int getMaxNumberCardsGame() {
        return 0;
    }

    @Override
    public int getMaxNumberCardsPlayer() {
        return 10;
    }

    @Override
    public int getMaxNumberOfPlayers() {
        return 4;
    }

    @Override
    public int getMaxScore() {
        return 0;
    }

    @Override
    public int getMinNumberOfPlayers() {
        return 4;
    }

    @Override
    public int getNumberOfCardsPassed() {
        return 0;
    }

    @Override
    public int getValidGamesPerSession() {
        return 0;
    }
}
