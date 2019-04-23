package nl.han.ica.Frogger;

import nl.han.ica.Frogger.tiles.BoardsTile;
import nl.han.ica.OOPD_Engine.Collision.CollidedTile;
import nl.han.ica.OOPD_Engine.Collision.ICollidableWithTiles;
import nl.han.ica.OOPD_Engine.Exceptions.TileNotFoundException;
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

    final int size=50;
    private final Frogger frog;

    /**
     * Constructor
     * @param _frog Referentie naar de wereld
     */
    public Player(Frogger _frog) {
        super(new Sprite("src/main/java/nl/han/ica/Frogger/assets/sprites/littleFrogger.png"),2);
        this.frog =_frog;
        setCurrentFrameIndex(1);
        setFriction(0.25f);
    }

    @Override
    public void update() {
        if (getX()<=0) {
            setxSpeed(0);
            setX(0);
        }
        if (getY()<=0) {
            setySpeed(0);
            setY(0);
        }
        if (getX()>= frog.getWidth()-size) {
            setxSpeed(0);
            setX(frog.getWidth() - size);
        }
        if (getY()>= frog.getHeight()-size) {
            setySpeed(0);
            setY(frog.getHeight() - size);
        }

    }
    @Override
    public void keyPressed(int keyCode, char key) {
        final int speed = 5;
        if (keyCode == frog.LEFT) {
            setDirectionSpeed(270, speed);
            setCurrentFrameIndex(0);
        }
        if (keyCode == frog.UP) {
            setDirectionSpeed(0, speed);
        }
        if (keyCode == frog.RIGHT) {
            setDirectionSpeed(90, speed);
            setCurrentFrameIndex(1);
        }
        if (keyCode == frog.DOWN) {
            setDirectionSpeed(180, speed);
        }
    }


    @Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles)  {
        PVector vector;

        for (CollidedTile ct : collidedTiles) {
            if (ct.theTile instanceof BoardsTile) {
                if (ct.collisionSide == ct.TOP) {
                    try {
                        vector = frog.getTileMap().getTilePixelLocation(ct.theTile);
                        setY(vector.y - getHeight());
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (ct.collisionSide == ct.RIGHT) {
                    try {
                        vector = frog.getTileMap().getTilePixelLocation(ct.theTile);
                        frog.getTileMap().setTile((int) vector.x / 50, (int) vector.y / 50, -1);
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
