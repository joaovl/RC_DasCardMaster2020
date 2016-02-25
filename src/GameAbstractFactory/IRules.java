package GameAbstractFactory;

import java.util.List;

/**
 * Created by Joao on 06/02/2016.
 */
public interface IRules {

    public String checkWhoWinnes(List<Integer> resultOfPlay);
    public String checkNumberOfPlayers(Integer numberOfPLayers);
    public boolean soloGame();
    public List<Integer> validPlay(List<Integer> playerCards);

    public abstract int getCardsInHand();
    public abstract int getGamePlayingOrder();
    public abstract int getMaxNumberCardsGame();
    public abstract int getMaxNumberCardsPlayer();
    public abstract int getMaxNumberOfPlayers();
    public abstract int getMaxScore();
    public abstract int getMinNumberOfPlayers();
    public abstract int getNumberOfCardsPassed();
    public abstract int getValidGamesPerSession();



}