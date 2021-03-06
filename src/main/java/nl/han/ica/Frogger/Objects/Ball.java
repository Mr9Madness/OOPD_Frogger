package nl.han.ica.Frogger.Objects;

import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import nl.han.ica.OOPD_Engine.Objects.Sprite;

public class Ball extends Objects {
    private final GameEngine engine;
    private float[] bounds;

    /**
     * The Ball Object
     *
     * @param engine The engine used, needed to determine the worldsize
     * @param direction The direction the object is traveling
     * @param speed The speed the object is traveling
     */
    public Ball(GameEngine engine, float direction, float speed, float[] bounds) {
        super(engine, new Sprite("src/main/assets/obstacles/Ball.png"), direction, speed);
        //super(new Sprite("src/main/assets/sprites/Ball.png"), 2);
        this.engine = engine;
        this.bounds = bounds;
        setDirectionSpeed(direction, speed);
    }

    /**
     * Update loop that checks if the object in out of the top and bottom bound
     */
    @Override
    public void update()
    {
        super.update();

        if (getY() <= bounds[0] ) { //left
            setDirection( 240 );
        } else if( getY() >= bounds[1] )
            setDirection( 300 );
    }
}