package GameAbstractFactory.Debugger2;

import GameAbstractFactory.AbstractGameFactory;
import GameAbstractFactory.IAI;
import GameAbstractFactory.ICards;
import GameAbstractFactory.IRules;

/**
 * Created by Joao on 08/02/2016.
 */
public class GameFactoryDebugger2 extends AbstractGameFactory {

    public ICards createCards(){
        return new GameCardsDebugger2();
    }

    public IRules createRules(){
        return new GameRulesDebugger2();
    }

    public IAI createAI(){
        return new GameAIDebugger2();
    }
}