package GameAbstractFactory.Debugger2;

import GameAbstractFactory.AbstractGameRules;
import GameAbstractFactory.app;
import GameAbstractFactory.gateways.ResultsGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Joao on 08/02/2016.
 */
public class GameRulesDebugger2 extends AbstractGameRules {

    public boolean SOLO_GAME = false;
    public static final int MAX_NUMBER_CARDS_GAME = 40;
    public static final int MAX_NUMBER_CARDS_PLAYER = 10;
    public static final int VALID_GAMES_PER_SESSION = 10;
    public static final int MIN_NUMBER_OF_PLAYERS = 4;
    public static final int MAX_NUMBER_OF_PLAYERS = 4;

    //Is it valid to stop the game and let the other player continue playing?
    public static final boolean STOP_PLAYING_DURING_SESSION_VALID = false;

    //This is called 'trunfo'
    public static final boolean SPECIAL_CARDS_ALLOWED = false;

    // TODO - I need to identify the cards' value here.
    //Enum? array?

    public static final int GAME_PLAYING_ORDER = 1;
    //TODO - I need to clarify this implementation detail later
    //1 - Left to Right
    //2 - RIght to Left
    //3 - Other

    public static final int NUMBER_OF_TRICKS = 10;
    public static final int NUMBER_OF_CARDS_PASSED = 3;
    public static final int MAX_SCORE = 100;
    public static final int CARDS_IN_HAND = 10;

    static ResultsGateway resultsDB = new ResultsGateway();


    public String getGameRules() {
        return "Rules for Debugger2";
    }

    public boolean soloGame() { return SOLO_GAME; }

    public String checkNumberOfPlayers(Integer numberOfPLayers){

        if ((MAX_NUMBER_OF_PLAYERS == MIN_NUMBER_OF_PLAYERS) && (MIN_NUMBER_OF_PLAYERS != numberOfPLayers)){
            return "Not a valid Number of players, Select " + MAX_NUMBER_OF_PLAYERS + " players";

        }else if (numberOfPLayers <= MAX_NUMBER_OF_PLAYERS && numberOfPLayers >= MIN_NUMBER_OF_PLAYERS){
            return "Number of players is valid";
        }else{
            return "Not a valid Number of players. Select between"
                    + MIN_NUMBER_OF_PLAYERS + "and" + MAX_NUMBER_OF_PLAYERS + " players";
        }
    }


    public List<Integer> validPlay(List<Integer> player){
        Scanner user_input = new Scanner( System.in );
        List<Integer> rulesResult = new ArrayList<Integer>();
        int cardSelectedByHuman = 0;

        //Ask user to pick a card
        System.out.println("Which card would you like to play? (select Position 0 - 9 )");
        //List cards
        System.out.println(player);
        cardSelectedByHuman = Integer.parseInt(user_input.next());

        while ((cardSelectedByHuman < 0) || (cardSelectedByHuman > 9)) {
            System.out.println("You cannot select an invalid position \n" +
                    " (select Position 0 - 9 )");
            System.out.println(player);
            cardSelectedByHuman = Integer.parseInt(user_input.next());
        }

        int tempHumanValue = player.get(cardSelectedByHuman);

        while (tempHumanValue == 0) {
            System.out.println("You selected an invalid card");
            System.out.println(player);
            cardSelectedByHuman = Integer.parseInt(user_input.next());
            tempHumanValue = player.get(cardSelectedByHuman);
        }
        rulesResult.add(0,tempHumanValue);
        rulesResult.add(1,cardSelectedByHuman);

        System.out.println("card Selected is : " + tempHumanValue);
        return rulesResult;
    }

    public String checkWhoWinnes(List<Integer> resultOfPlay){
        //TODO - Last value to be saved in the database is supposed to be the game name.
        //Each game will save data in a differente way. Team games will save team results and,
        //single player games will save results from single players.
        //TODO - consider an elegant solution to save results for a considerably big number of players.
        // available solution only save only two results (which is the max number in the database.
        resultsDB.insert(app.user.getId(), resultOfPlay.get(0), resultOfPlay.get(1), "1");

        if(resultOfPlay.get(0) > resultOfPlay.get(1)) {
            return "Your and PLayer 3 team is the winner with : " + resultOfPlay.get(0).toString() + " points";
        }
        else if (resultOfPlay.get(0) < resultOfPlay.get(1)) {
            return "Player 2 and PLayer 4 team is the winner with : " + resultOfPlay.get(1).toString() + " points";
        }
        else {
            return "Team A and B draw with : " + resultOfPlay.get(1).toString() + " points";
        }
    }


    //Each card has a different card value.
    // It need to be confirmed in Game Rules.
    public int cardsValue() {
        return 0;
    }

    // TODO - Where does the game starts

    // Which order of playing is used in the game (one is left to right, the other is right to left
    // TODO - Consider if there are more options for different games

    public int gameOrder() {
        return GAME_PLAYING_ORDER;
    }

    // During the game it is required to check the number of points

    public int showTotalPoints(){
        return 0;
    }

    public int getCardsInHand(){
        return CARDS_IN_HAND;
    }

    public int getGamePlayingOrder(){
        return GAME_PLAYING_ORDER;
    }

    public int getMaxNumberCardsGame() {
        return MAX_NUMBER_CARDS_GAME;
    }

    public int getMaxNumberCardsPlayer(){
        return MAX_NUMBER_CARDS_PLAYER;
    }

    public int getMaxNumberOfPlayers() {
        return MAX_NUMBER_OF_PLAYERS;
    }

    public int getMaxScore() {
        return MAX_SCORE;
    }

    public int getMinNumberOfPlayers() {
        return MIN_NUMBER_OF_PLAYERS;
    }

    public int getNumberOfCardsPassed() {
        return NUMBER_OF_CARDS_PASSED;
    }

    public int getValidGamesPerSession() {
        return VALID_GAMES_PER_SESSION;
    }

    public int getNumberOfTricks() {
        return NUMBER_OF_TRICKS;
    }

}
