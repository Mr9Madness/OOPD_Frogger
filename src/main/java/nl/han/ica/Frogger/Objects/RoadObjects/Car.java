package nl.han.ica.Frogger.Objects.RoadObjects;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.OOPD_Engine.Objects.Sprite;

public class Car extends RoadObjects {
    private final Frogger engine;

    /**
     * Constructor
     *
     * @param engine The engine used, needed to determine the worldsize
     * @param direction The direction the object is traveling
     * @param speed The speed the object is traveling
     **/
    public Car(Frogger engine, float direction, float speed) {
        super(engine, new Sprite("src/main/assets/obstacles/Car.png"), direction, speed);
        this.engine = engine;
    }
}
