package nl.han.ica.Frogger.Objects;

import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Objects.SpriteObject;

public class Objects extends SpriteObject {

    private final GameEngine engine;
    /**
     * The main object method, this also handles the updating of the objects
     *
     * @param engine The engine used, needed to determine the worldsize
     * @param sprite The sprite that is used for the object
     * @param direction The direction the object is traveling
     * @param speed The speed the object is traveling
     **/
    public Objects(GameEngine engine, Sprite sprite, float direction, float speed) {
        super(sprite);
        this.engine = engine;
        setDirectionSpeed(direction, speed);
    }

    /**
     * Deze Methode zorgt ervoor dat de objecten wanneer ze uit het scherm gaan weer aan de andere kant worden getoond.
     */
    @Override
    public void update() {
        if (getDirection() == 90 && (getX() + getWidth()) >= engine.width+getWidth()) // RIGHT
            setX(0-getWidth());
        if (getDirection() == 270 && (getX() + getWidth()) <= 0-getWidth()) // LEFT
            setX(engine.width);
    }

    @Override
    public void move() {
        super.move();
    }
}
