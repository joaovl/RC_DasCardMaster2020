package GameAbstractFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Joao on 12/02/2016.
 */
public class Player {

    private int AskNumberOfHumanPLayers(){
        String humanStringUsers;
        int humanUsers = 0;

        Scanner user_input = new Scanner(System.in);

        //THIS requires to be more generic, it is used just one Human player.
        System.out.println("Number of Human Users");
        humanStringUsers = user_input.next();
        humanUsers = Integer.parseInt(humanStringUsers);
        return humanUsers;

    }


    // TODO - Transform this into a BUILDER
    // I Want to create a user
    public List<List<Integer>> PlayerCreator(IRules objRule, ICards objCard) {

        boolean soloGames = objRule.soloGame();
        int numberHumanPlayers = AskNumberOfHumanPLayers();
        int maxNumberOfPlayers = objRule.getMaxNumberOfPlayers();
        int numberCardsPerPlayer = objRule.getCardsInHand();
        List<Integer> listOfCards = objCard.getShuffledCards();

        //TODO - This list should be dinamic.
        //Later on a for cycle will create all required users (Human and AI)
        List<Integer> player1 = null,player2 = null,player3 = null,player4 = null;
        if (soloGames == true ) {
            // TODO - Only one player is created
            // This will be valid for games such as Blackjack

        }else {
            //Checks many Human players exist and how many are required.

            //System creates the remaining AI users
            //Number of Human players is equal to max of players
            if (numberHumanPlayers == maxNumberOfPlayers ) {
                //No AI is required.
                //It will be asked to each user what to do
            }
            //TODO - terrible coding, consider changing this later
            else {
                //This will create human and AI users
                player1 = new ArrayList<>(listOfCards.subList(0,numberCardsPerPlayer));
                player2 = new ArrayList<>(listOfCards.subList(numberCardsPerPlayer,(numberCardsPerPlayer*2)));
                player3 = new ArrayList<>(listOfCards.subList((numberCardsPerPlayer*2),(numberCardsPerPlayer*3)));
                player4 = new ArrayList<>(listOfCards.subList((numberCardsPerPlayer*3),(numberCardsPerPlayer*4)));
            }

                System.out.println("\n" + numberHumanPlayers + " Human and " +
                        (maxNumberOfPlayers-numberHumanPlayers) + " AI users were created.");
        }
        List<List<Integer>> usersList = new ArrayList<>();
        usersList.add(player1);
        usersList.add(player2);
        usersList.add(player3);
        usersList.add(player4);
        return usersList;
    }

}
