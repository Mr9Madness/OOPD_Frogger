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
     * @param totalFrames The number of frames the object has
     * @param direction The direction the object is traveling
     * @param speed The speed the object is traveling
     **/
    public RiverObjects(Frogger engine, Sprite sprite, int totalFrames, float direction, float speed) {
        super(engine, sprite, totalFrames, direction, speed);
        this.engine = engine;
    }
}
