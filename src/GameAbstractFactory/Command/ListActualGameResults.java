package GameAbstractFactory.Command;

/**
 * Created by Joao on 16/02/2016.
 */
public class ListActualGameResults implements Command {

    private SaveLoadData dataAccess;

    public ListActualGameResults(SaveLoadData dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void execute() {
        dataAccess.setListActualGameResults();
        System.out.println("Print setListActualGameResults");
    }

}