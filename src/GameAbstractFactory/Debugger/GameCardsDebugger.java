package GameAbstractFactory.Debugger;

import GameAbstractFactory.ICards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Joao on 06/02/2016.
 */
public class GameCardsDebugger implements ICards {

    public String getGameCards() {
        return "Cards for Sueca game created this is CGameCardsBody";
    }

    public List<Integer> getShuffledCards(){
        return shuffle();
    }

    private static final int POINTS_CLUBS       = 0;
    private static final int POINTS_DIAMONDS    = 0;
    private static final int POINTS_SPADES      = 0;
    private static final int POINTS_HEARTS      = 0;
    private static final int POINTS_SPECIAL     = 0;
    private static final int MAX_CARDS     = 40;

    public enum Rank
    { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

    public enum Suit
    { CLUBS, DIAMONDS, SPADES, HEARTS }


    private static List<Integer> shuffle() {
        List<Integer> array = new ArrayList<>(MAX_CARDS);
        for (int i = 1; i <= MAX_CARDS; i++){
            array.add(i);
        }
        Collections.shuffle(array);
        return array;
    }
}

// CarBody implements Body
// String getBodyParts