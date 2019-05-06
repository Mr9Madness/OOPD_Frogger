package nl.han.ica.Frogger.Objects.RoadObjects;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.OOPD_Engine.Objects.Sprite;

public class Truck extends RoadObjects {
    private final Frogger engine;
    private final int size = 50;

    /**
     * Constructor
     *
     * @param engine The engine used, needed to determine the worldsize
     * @param direction The direction the object is traveling
     * @param speed The speed the object is traveling
     **/
    public Truck(Frogger engine, float direction, float speed) {
        super(engine, new Sprite("src/main/assets/obstacles/Truck.png"), 2, direction, speed);
        this.engine = engine;
    }
}
