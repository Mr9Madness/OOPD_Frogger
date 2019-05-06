package nl.han.ica.Frogger;

import nl.han.ica.Frogger.Menus.GameMenu;
import nl.han.ica.Frogger.Menus.MenuManager;
import nl.han.ica.Frogger.tiles.FinishTile;
import nl.han.ica.Frogger.tiles.SafeFinishTile;
import nl.han.ica.Frogger.tiles.WaterTile;
import nl.han.ica.OOPD_Engine.Collision.CollidedTile;

import nl.han.ica.OOPD_Engine.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPD_Engine.Collision.ICollidableWithTiles;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import nl.han.ica.OOPD_Engine.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPD_Engine.Objects.GameObject;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import processing.core.PVector;

import java.util.List;

/**
 * Player class
 */
public class Player extends AnimatedSpriteObject implements ICollidableWithTiles, ICollidableWithGameObjects
{

    private final int size = 50;
    private final Frogger engine;
    private final GameMenu gameMenu;
    private int currentScore = 0;

    private int lives = 5;

    /**
     * Constructor
     * @param engine Referentie naar de wereld
     */
    public Player(Frogger engine, MenuManager menuManager)
    {
        super(new Sprite("src/main/assets/sprites/Frogger.png"), 1);
        this.engine = engine;
        this.gameMenu = ((GameMenu)menuManager.GetCurrentMenu());
        setCurrentFrameIndex(0);
        setFriction(.5f);
    }
    private void onHit() {
        gameMenu.RemoveLive(lives);

        lives--;
        System.out.println("you have " + lives + " frogs now!");
        if( lives != 0 ) setY(100000);
    }

    public int GetPlayerScore() { return currentScore; }

    @Override
    public void update()
    {
        if (getX() <= 0)
        {
            setxSpeed(0);
            setX(0);
        }
        if (getY() <= 0)
        {
            setySpeed(0);
            setY(0);
        }
        if (getX() >= engine.getWidth() - size)
        {
            setxSpeed(0);
            setX(engine.getWidth() - size);
        }
        if (getY() >= engine.getView().getWorldHeight() - size)
        {
            setySpeed(0);
            setY(engine.getView().getWorldHeight() - size);
        }

        if( lives <= 0 ) engine.EndGame();
        gameMenu.UpdateScore( currentScore );
    }

    @Override
    public void keyPressed(int keyCode, char key) {
        final int speed = 50;
        if (keyCode == engine.LEFT)
        {
            setDirectionSpeed(270, speed);
            setCurrentFrameIndex(0);
        }
        else if (keyCode == engine.UP)
        {
            setDirectionSpeed(0, speed);
        }
        else if (keyCode == engine.RIGHT)
        {
            setDirectionSpeed(90, speed);
            setCurrentFrameIndex(0);
        }
        else if (keyCode == engine.DOWN)
        {
            setDirectionSpeed(180, speed);
        }
    }

    @Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles)  {

        for (CollidedTile ct : collidedTiles)
        {
            // Kijkt alleen naar een finish tile en als die in (inside) de tile is wordt de finish method uitgevoerd
            if (ct.theTile instanceof FinishTile)
            {
                //((FinishTile) ct.theTile).Finish();
                setY(Y+50);
            }
            else if (ct.theTile instanceof SafeFinishTile)
            {
                ((SafeFinishTile) ct.theTile).Finish();
            }
            else if( ct.theTile instanceof WaterTile)
            {
                onHit();
            }
        }
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        onHit();
    }
}
