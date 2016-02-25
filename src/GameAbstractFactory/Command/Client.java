package GameAbstractFactory.Command;

/**
 * Created by Joao on 16/02/2016.
 */
public class Client {

    public static void main(String[] args) {

        //todo Create a Game and their save and load commands
        SaveLoadData saveData = new SaveLoadData();
        Command listActualResults = new ListActualGameResults(saveData);
        Command ListGameResults = new ListLastGamesResults(saveData);
        Command saveDataCommand = new SaveGameResults(saveData);

        //todo Create a login

        GameEmulator objGameEmulator = new GameEmulator();
        objGameEmulator.setCommands(listActualResults, ListGameResults, saveDataCommand);

        //Just confirm that this is a valid implementation
        System.out.println("Do What is expected, List games and save ");
        objGameEmulator.listGamesResultsCommand();
        objGameEmulator.listPlaysCommand();
        objGameEmulator.setSaveGameResults();

        System.out.println("Debug option");

    }

}