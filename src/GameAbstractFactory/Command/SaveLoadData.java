package GameAbstractFactory.Command;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Joao on 16/02/2016.
 */

public class SaveLoadData {

    public static final int LIST_LAST_GAMES_RESULTS = 10;
    public static final int LIST_ACTUAL_GAME_RESULTS = 10;

    private List<GamePlay> gamePlayList;
    private int pos;

    public SaveLoadData() {
        gamePlayList = new LinkedList<GamePlay>();
        pos = 0;
    }

    public String getListLastGamesResults() {
        return "list of games played";
    }

    public String setListActualGameResults() {
        return "List valid plays during actual game";
    }

    public String saveData() {
        return "Data was saved in database";
    }

    public void addGamePlay(GamePlay play) {
        if (gamePlayList.size() == 10) {
            gamePlayList.remove(0);
        }
        gamePlayList.add(play);
    }

    public void moveBack(int p) {
        if (p < 10) {
            pos -= p;
        }
    }

    public void moveForward(int p) {
        if (p < 10) {
            pos += p;
        }
    }
}