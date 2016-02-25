package GameAbstractFactory;

/**
 * Created by Joao on 06/02/2016.
 */

public abstract class AbstractGameFactory {
    public abstract ICards createCards();

    public abstract IRules createRules();

    public abstract IAI createAI();

}

//AbstractVehicleFactory
//Body createBody()