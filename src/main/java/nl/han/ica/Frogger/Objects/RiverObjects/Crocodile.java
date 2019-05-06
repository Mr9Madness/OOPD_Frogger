package nl.han.ica.Frogger.Objects.RiverObjects;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.OOPD_Engine.Objects.Sprite;

public class Crocodile extends RiverObjects {
    private final Frogger engine;
    private final int size = 50;

    /**
     * Crocodile object
     *
     * @param engine The engine used, needed to determine the worldsize
     * @param direction The direction the object is traveling
     * @param speed The speed the object is traveling
     **/
    public Crocodile(Frogger engine, float direction, float speed) {
        super(engine, new Sprite("src/main/assets/sprites/Crocodile.png"), 4, direction, speed);
        this.engine = engine;
    }
}
