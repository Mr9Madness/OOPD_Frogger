package nl.han.ica.Frogger;

import nl.han.ica.Frogger.tiles.FinishTile;
import nl.han.ica.Frogger.tiles.WaterTile;
import nl.han.ica.OOPD_Engine.Collision.CollidedTile;
import nl.han.ica.OOPD_Engine.Collision.ICollidableWithTiles;
import nl.han.ica.OOPD_Engine.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import processing.core.PVector;

import java.util.List;

/**
 * @author Ralph Niels
 * De spelerklasse (het paarse visje)
 */
public class Player extends AnimatedSpriteObject implements ICollidableWithTiles
{

    private final int size = 50;
    private final Frogger frog;

    private int lives = 5;

    /**
     * Constructor
     * @param _frog Referentie naar de wereld
     */
    public Player(Frogger _frog)
    {
        super(new Sprite("src/main/assets/sprites/Frogger.png"), 1);
        this.frog = _frog;
        setCurrentFrameIndex(0);
        setFriction(.5f);
    }

    @Override
    public void update()
    {
        if (getX() <= 0) {
            setxSpeed(0);
            setX(0);
        }
        if (getY() <= 0) {
            setySpeed(0);
            setY(0);
        }
        if (getX() >= frog.getWidth() - size) {
            setxSpeed(0);
            setX(frog.getWidth() - size);
        }
        if (getY() >= frog.getView().getWorldHeight() - size) {
            setySpeed(0);
            setY(frog.getView().getWorldHeight() - size);
        }
    }

    @Override
    public void keyPressed(int keyCode, char key) {
        final int speed = 50;
        if (keyCode == frog.LEFT)
        {
            setDirectionSpeed(270, speed);
            setCurrentFrameIndex(0);
        }
        else if (keyCode == frog.UP)
        {
            setDirectionSpeed(0, speed);
        }
        else if (keyCode == frog.RIGHT)
        {
            setDirectionSpeed(90, speed);
            setCurrentFrameIndex(0);
        }
        else if (keyCode == frog.DOWN)
        {
            setDirectionSpeed(180, speed);
        }
    }

    @Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles)  {

        for (CollidedTile ct : collidedTiles)
        {
            // Kijkt alleen naar een finish tile en als die in (inside) de tile is word de finish method uitgevoerd
            if (ct.theTile instanceof FinishTile)
            {
                ((FinishTile) ct.theTile).Finish();
            }
            else if( ct.theTile instanceof WaterTile)
            {
                lives--;
                System.out.println("GET OUT, WATER!!!. you have" + lives + " frogs now!");
                setY(100000);
            }
        }
    }
}
