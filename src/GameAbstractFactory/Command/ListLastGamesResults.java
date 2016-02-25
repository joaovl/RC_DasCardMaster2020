package GameAbstractFactory.Command;

/**
 * Created by Joao on 16/02/2016.
 */
public class ListLastGamesResults implements Command {

    private SaveLoadData dataAccess;

    public ListLastGamesResults(SaveLoadData dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void execute() {
        dataAccess.getListLastGamesResults();
        System.out.println("Print getListLastGamesResults");

    }

}