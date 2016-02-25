package GameAbstractFactory;

import GameAbstractFactory.Debugger.GameFactoryDebugger;
import GameAbstractFactory.Debugger2.GameFactoryDebugger2;
import GameAbstractFactory.gateways.Player;
import GameAbstractFactory.gateways.PlayerGateway;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Joao on 06/02/2016.
 */
public class app {
    static PlayerGateway personDB = new PlayerGateway();
    //This is not an elegat solution. It is here only because it is an academic work (for industrial
    //code redesigning should be consider. Player should be passed by reference.
    //PROBLEMS - This can cause the object to be lost in memory
    public static Player user;

    private static void login() {
        System.out.println("Login");

        String user_name;
        String pass_word;
        do {
            Scanner user_input = new Scanner(System.in);
            System.out.println("Insert your name");
            user_name = user_input.next();

            System.out.println("Insert your password");
            pass_word = user_input.next();

            user = personDB.find(user_name);

            if (user == null || !user.getPassword().equals(pass_word)) {
                System.out.println("Login invalido");
            }
        } while (user == null || !user.getPassword().equals(pass_word));
    }

    private static void register() {
        System.out.println("Register");

        int id;
        String user_name;
        String pass_word;

        Scanner user_input = new Scanner(System.in);
        System.out.println("Insert your id");
        id = Integer.parseInt(user_input.next());

        System.out.println("Insert your name");
        user_name = user_input.next();

        System.out.println("Insert your password");
        pass_word = user_input.next();

        personDB.insert(id, user_name, pass_word);
    }

    private static void menu() {
        int option = 0;

        do {
            Scanner user_input = new Scanner(System.in);
            System.out.println("1 - Login, 2 - Register");
            option = Integer.parseInt(user_input.next());

            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
            }
        } while (option != 1);
    }

    public static void main(String[] args) {

        menu();

        String whatToMake = "Debugger2";


        AbstractGameFactory factory = null;

        if (whatToMake.equals("Debugger")) {
            factory = new GameFactoryDebugger();
        } else {
            factory = new GameFactoryDebugger2();
        }

        ICards objCards = factory.createCards();
        IRules objRules = factory.createRules();
        IAI objAI = factory.createAI();

        int numPlayers = objRules.getMaxNumberOfPlayers();
        System.out.println("Number of valid Players is: " + numPlayers);

        //ask for players
        //TODO - This is hard coded to check that the function is working.
        String test = objRules.checkNumberOfPlayers(4);
        System.out.println(test);

        List<List<Integer>> numberOfPlayer = new GameAbstractFactory.Player().PlayerCreator(objRules, objCards);

        //AI plays accordingly HUMAN or AUTOMATION
        List<Integer> gamePlay = objAI.playGame(objRules, numberOfPlayer);

        //returns winner
        String printResults = objRules.checkWhoWinnes(gamePlay);

        System.out.println(printResults);

    }
}
