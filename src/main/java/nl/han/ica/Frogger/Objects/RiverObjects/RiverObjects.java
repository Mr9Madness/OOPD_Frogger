package nl.han.ica.Frogger.Objects.RiverObjects;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.Frogger.Objects.Objects;
import nl.han.ica.OOPD_Engine.Objects.Sprite;

public class RiverObjects extends Objects {

    private final Frogger engine;
    private final int size = 50;

    /**
     * RiverObjects
     *
     * @param engine The engine used, needed to determine the worldsize
     * @param sprite The sprite that is used for the object
     * @param direction The direction the object is traveling
     * @param speed The speed the object is traveling
     **/
    public RiverObjects(Frogger engine, Sprite sprite, float direction, float speed) {
        super(engine, sprite, direction, speed);
        this.engine = engine;
    }
}
