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

    private final int size = 50;
    private final Frogger frog;

    /**
     * Constructor
     * @param _frog Referentie naar de wereld
     */
    public Player(Frogger _frog) {
        super(new Sprite("src/main/assets/sprites/frogger.png"), 1);
        this.frog =_frog;
        setCurrentFrameIndex(0);
        setFriction(.5f);
    }

    @Override
    public void update() {
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
        if (keyCode == frog.LEFT) {
            setDirectionSpeed(270, speed);
            setCurrentFrameIndex(0);
        }
        if (keyCode == frog.UP) {
            setDirectionSpeed(0, speed);
        }
        if (keyCode == frog.RIGHT) {
            setDirectionSpeed(90, speed);
            setCurrentFrameIndex(0);
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
                if (ct.collisionSide == CollidedTile.TOP) {
                    try {
                        vector = frog.getTileMap().getTilePixelLocation(ct.theTile);
                        setY(vector.y - getHeight());
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (ct.collisionSide == CollidedTile.RIGHT) {
                    try {
                        vector = frog.getTileMap().getTilePixelLocation(ct.theTile);
                        setX(vector.x + getWidth());
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (ct.collisionSide == CollidedTile.LEFT) {
                    try {
                        vector = frog.getTileMap().getTilePixelLocation(ct.theTile);
                        setX(vector.x - getWidth());
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (ct.collisionSide == CollidedTile.BOTTOM) {
                    try {
                        vector = frog.getTileMap().getTilePixelLocation(ct.theTile);
                        setY(vector.y + getHeight());
                    } catch (TileNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
