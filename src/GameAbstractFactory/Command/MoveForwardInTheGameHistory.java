package GameAbstractFactory.Command;

/**
 * Created by joao on 17/02/16.
 */
public class MoveForwardInTheGameHistory implements Command{
    private SaveLoadData data;
    private int movements;

    public MoveForwardInTheGameHistory(SaveLoadData saveLoadData, int moves) {
        data = saveLoadData;
        movements = moves;
    }

    @Override
    public void execute() {
        data.moveForward(movements);
    }
}
