package GameAbstractFactory.Command;

/**
 * Created by Joao on 16/02/2016.
 */
public class GameEmulator {

    private Command listPlaysCommand, listGamesResultsCommand, saveGameResults;

    public void setCommands(Command listPlaysCommand, Command listGamesResultsCommand, Command saveGameResults) {
        this.listPlaysCommand = listPlaysCommand;
        this.listGamesResultsCommand = listGamesResultsCommand;
        this.saveGameResults = saveGameResults;
    }

    public void listPlaysCommand() {
        listPlaysCommand.execute();
    }

    public void listGamesResultsCommand() {
        listGamesResultsCommand.execute();
    }

    public void setSaveGameResults(){
        saveGameResults.execute();
    }

}