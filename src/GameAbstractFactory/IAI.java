package GameAbstractFactory;

import java.util.List;

/**
 * Created by Joao on 07/02/2016.
 */
public interface IAI <Rules extends IRules> {

//    public String getGameAI();
    public List<Integer> playGame(Rules objRules, List<List<Integer>> test);

    //TODO - Implement AI only for Automated users,
    // Human players need to be implemented in proper place



}
