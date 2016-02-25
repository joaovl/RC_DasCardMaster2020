package GameAbstractFactory.Command;

/**
 * Created by joao on 17/02/16.
 */
public class AddGamePlay implements Command {

    private SaveLoadData data;
    private GamePlay game;

    public AddGamePlay(SaveLoadData saveLoadData, GamePlay play) {
        data = saveLoadData;
        game = play;
    }

    @Override
    public void execute() {
        data.addGamePlay(game);
    }
}
