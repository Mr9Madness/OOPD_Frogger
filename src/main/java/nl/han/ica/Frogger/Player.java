package nl.han.ica.Frogger;

import nl.han.ica.Frogger.Menus.GameMenu;
import nl.han.ica.Frogger.Menus.MenuManager;
import nl.han.ica.Frogger.Objects.RiverObjects.Tree;
import nl.han.ica.Frogger.tiles.FinishTile;
import nl.han.ica.Frogger.tiles.SafeFinishTile;
import nl.han.ica.Frogger.tiles.WaterTile;
import nl.han.ica.OOPD_Engine.Collision.CollidedTile;

import nl.han.ica.OOPD_Engine.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPD_Engine.Collision.ICollidableWithTiles;
import nl.han.ica.OOPD_Engine.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPD_Engine.Objects.GameObject;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import processing.core.PApplet;

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
    private boolean isOnSafeObject = false;

    private int lives = 5;
    private int countFrogsOnFinish = 0;

    /**
     * Constructor
     * @param engine Referentie naar de wereld
     */
    public Player(Frogger engine, MenuManager menuManager)
    {
        super(new Sprite("src/main/assets/sprites/Frogger.png"), 7);
        this.engine = engine;
        this.gameMenu = ((GameMenu)menuManager.GetCurrentMenu());
        setCurrentFrameIndex(0);
        setZ(25);
        setFriction(.5f);
    }
    private void onHit() {
        if (!isOnSafeObject && false) {
            gameMenu.RemoveLive(lives);
            lives--;
            System.out.println("you have " + lives + " frogs now!");
            if (lives != 0) setY(100000);
        }
    }

    public int GetPlayerScore() { return currentScore; }

    @Override
    public void update()
    {
        isOnSafeObject=false;

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
        System.out.println("Y: "+getY()+" / X:"+getX());
        final int speed = 50;

        if (keyCode == engine.LEFT)
        {
  //          setDirectionSpeed(270, speed);
            setX(getX()-speed);
            nextFrame();
        }
        else if (keyCode == engine.UP)
        {
//            setDirectionSpeed(0, speed);
            //setDirection(0);
            setY(getY()-speed);
            nextFrame();
        }
        else if (keyCode == engine.RIGHT)
        {
            //setDirectionSpeed(90, speed);
            //setDirection(90);
            setX(getX()+speed);
            nextFrame();
        }
        else if (keyCode == engine.DOWN)
        {
            //setDirectionSpeed(180, speed);
            //setDirection(180);
            setY(getY()+speed);

            nextFrame();
        }
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject ct : collidedGameObjects) {
            if (ct instanceof Tree) { //hier komt het volg script}
                isOnSafeObject =true;
                setCurrentFrameIndex(0);
                float direction = ct.getDirection();
                //setX(getX()-50);
                //setX(ct.getCenterX()-(getWidth()/2));
                if ((getX()>=0) && (ct.getDirection()==270.0)) //left
                {
                    System.out.println("boomstam: "+(ct.getX()-ct.getxSpeed())+" / kikkker:"+(getX()-getWidth()));
                    if (ct.getX()-ct.getxSpeed()<=(getX()-getWidth()))
                        setX(getX()+ct.getxSpeed());
                    //System.out.println("Locatie kikker voor: "+getX()+" / getxsp: "+ (getX()-ct.getxSpeed())+ "/ maxlinks:"+(ct.getX()-ct.getxSpeed())+" / getx-50: "+(getX()-50)+" getxspeedboomstam/ "+ct.getxSpeed()+" / direction: "+direction);
                    //setX(getX()+ct.getxSpeed());
                   // System.out.println("Locatie kikker na: "+getX()+" / Boomstam:"+ct.getX()+ct.getWidth()+" / getx-50: "+(getX()-50)+" / direction: "+direction);
                    //System.out.println("lctgetwidth"+ct.getX()+" / ctwidth: "+ct.getWidth()+"/ ctgetx"+ct.getX()+ct.getWidth());

                }
                else if (getX()<=0 && getDirection()==270.0) {
                    System.out.println("resetyctgetwidth"+ct.getX()+" / ctwidth: "+ct.getWidth()+"/ ctgetx"+ct.getX()+ct.getWidth());
                    //setX(0);
                    //setY(getY()+50);
                    isOnSafeObject=false;
                }
            } else {
                isOnSafeObject =false;
                onHit();
            }
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
                countFrogsOnFinish  = countFrogsOnFinish++;
                // Actuele X en Y positie van de kikker pakken wanneer hij in de SafeFinishTile is, en in de huidige SafefinishTile een kikker neerzetten
                // Vervolgens de positie van de huidige kikker weer terugzetten naar 0
            }
            else if( ct.theTile instanceof WaterTile)
            {
                onHit();
            }
        }
    }

}
