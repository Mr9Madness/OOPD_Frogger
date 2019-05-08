package nl.han.ica.Frogger.Objects;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.Frogger.Objects.Objects;
import nl.han.ica.OOPD_Engine.Objects.Sprite;

public class Ball extends Objects {
    private final Frogger engine;

    /**
     * The Ball Object
     *
     * @param engine The engine used, needed to determine the worldsize
     * @param direction The direction the object is traveling
     * @param speed The speed the object is traveling
     */
    public Ball(Frogger engine, float direction, float speed) {
        super(engine, new Sprite("src/main/assets/sprites/Ball.png"), direction, speed);
        //super(new Sprite("src/main/assets/sprites/Ball.png"), 2);
        this.engine = engine;
        setDirectionSpeed(direction, speed);
    }

    @Override
    public void update() {
        if (getDirection() == 270 && (getX() + getWidth() <= 0)) { //left
            setX(engine.width); //restart on the right
        }
    }
}