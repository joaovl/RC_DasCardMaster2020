package GameAbstractFactory.Command;

/**
 * Created by Joao on 16/02/2016.
 */
public class SaveGameResults implements Command {

    private SaveLoadData dataAccess;

    public SaveGameResults(SaveLoadData dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void execute() {
        dataAccess.saveData();
        System.out.println("Save Data in DATABASE");

    }

}

