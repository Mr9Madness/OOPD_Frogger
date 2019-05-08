package nl.han.ica.Frogger.Objects.RoadObjects;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.Frogger.Objects.Objects;
import nl.han.ica.OOPD_Engine.Objects.Sprite;

public class RoadObjects extends Objects {

    private Frogger engine;
    private final int size = 50;

    /**
     * RoadObjects
     *
     * @param engine The engine used, needed to determine the worldsize
     * @param totalFrames The number of frames the object has
     * @param direction The direction the object is traveling
     * @param speed The speed the object is traveling
     **/
    public RoadObjects(Frogger engine, Sprite sprite, float direction, float speed) {
        super(engine, sprite, direction, speed);
        this.engine = engine;
    }
}
