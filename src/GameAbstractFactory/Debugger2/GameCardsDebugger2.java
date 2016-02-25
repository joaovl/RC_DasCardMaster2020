package GameAbstractFactory.Debugger2;

import GameAbstractFactory.ICards;
import GameAbstractFactory.IRules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Joao on 08/02/2016.
 */
public class GameCardsDebugger2 implements ICards {

    public String getGameCards() {
        return "Cards for Debugger2 game";
    }

    public List<Integer> getShuffledCards(){
        return shuffleDebugger();
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


    private static List<Integer> shuffleDebugger() {
        List<Integer> cardList = new ArrayList<>(MAX_CARDS);
        for (int i = 1; i <= MAX_CARDS; i++){
            cardList.add(i);
        }
        Collections.shuffle(cardList);
        return cardList;
    }
}