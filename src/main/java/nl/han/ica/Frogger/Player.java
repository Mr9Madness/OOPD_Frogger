package nl.han.ica.Frogger;

import nl.han.ica.Frogger.Menus.GameMenu;
import nl.han.ica.Frogger.Menus.MenuManager;
import nl.han.ica.Frogger.Objects.Ball;
import nl.han.ica.Frogger.Objects.RiverObjects.Tree;
import nl.han.ica.Frogger.Objects.RoadObjects.RoadObjects;
import nl.han.ica.Frogger.tiles.FinishTile;
import nl.han.ica.Frogger.tiles.SafeFinishTile;
import nl.han.ica.Frogger.tiles.WaterTile;
import nl.han.ica.OOPD_Engine.Collision.CollidedTile;
import nl.han.ica.OOPD_Engine.Collision.ICollidableWithGameObjects;
import nl.han.ica.OOPD_Engine.Collision.ICollidableWithTiles;
import nl.han.ica.OOPD_Engine.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPD_Engine.Objects.GameObject;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Sound.Sound;

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
    private Sound froggerJump,froggerSplash,froggerCarScreech,froggerBallSploing;

    private int lives = 5;
    private int countFrogsOnFinish = 0;
    private int neededFrogsOnFinish = 1;
    private long startTime = System.currentTimeMillis();

    /**
     * Constructor
     * @param engine Referentie naar de wereld
     */
    public Player(Frogger engine, MenuManager menuManager)
    {
        super(new Sprite("src/main/assets/sprites/Frogger.png"), 7);
        this.engine = engine;
        this.gameMenu = ((GameMenu)menuManager.GetCurrentMenu());

        froggerJump = new Sound(engine, "src/main/assets/sounds/frogger-hop.wav");
        froggerSplash = new Sound(engine, "src/main/assets/sounds/frogger-splash.wav");
        froggerCarScreech = new Sound(engine, "src/main/assets/sounds/carsplat.mp3");
        froggerBallSploing= new Sound(engine, "src/main/assets/sounds/frogger-boing.wav");
        setCurrentFrameIndex(0);
        setZ(25);
        setFriction(.5f);
    }
    private void onHit() {
        if (!isOnSafeObject) {
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
        currentScore = (int)(System.currentTimeMillis() - startTime) / 1000;

        if( countFrogsOnFinish >= neededFrogsOnFinish ) engine.FinishGame();
        if( lives <= 0 ) engine.EndGame();
        gameMenu.UpdateScore( currentScore );
    }
    private void jump () {
        froggerJump.rewind();
        froggerJump.play();
        nextFrame();
    }
    @Override
    public void keyPressed(int keyCode, char key) {
        final int speed = 50;

        if (keyCode == engine.LEFT)
        {
            setX(getX()-speed);
            jump();
        }
        else if (keyCode == engine.UP)
        {
            setY(getY()-speed);
            jump();
        }
        else if (keyCode == engine.RIGHT)
        {
            setX(getX()+speed);
            jump();
        }
        else if (keyCode == engine.DOWN)
        {
            setY(getY()+speed);
            jump();
        }
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject ct : collidedGameObjects) {
            if (ct instanceof Tree) { //hier komt het volg script}
                isOnSafeObject =true;
                setCurrentFrameIndex(0);

                if ((getX()>=0) && (ct.getDirection()==270.0)) //left
                {
                    System.out.println("Boomstam: "+(ct.getX()-getWidth())+" kikker: "+getWidth());
                   //if (ct.getX()-getWidth() >= getX())
                        setX(getX()+ct.getxSpeed());
                }
                else if (getX()<=0 && getDirection()==270.0) {
                    System.out.println("resetyctgetwidth"+ct.getX()+" / ctwidth: "+ct.getWidth()+"/ ctgetx"+ct.getX()+ct.getWidth());
                    setY(getY()+50);
                    isOnSafeObject=false;
                }
                else if ((getX()<=750) && (ct.getDirection()==90.0)) //right
                {
                    System.out.println("rechtstyctgetwidth"+ct.getX()+" / ctwidth: "+ct.getWidth()+"/ ctgetx"+ct.getX()+ct.getWidth());
                    //if (ct.getX()-getWidth() >= getX())
                    setX(getX()+ct.getxSpeed());
                }
                else if ((getX()>=750) && (ct.getDirection()==90.0)) //right
                {
                    setY(getY()+50);
                    isOnSafeObject=false;
                }
            } else if (ct instanceof Ball) {
                fr.rewind();
                froggerCarScreech.play();
                onHit();
            } else if (ct instanceof RoadObjects) {
            froggerCarScreech.rewind();
            froggerCarScreech.play();
            onHit();
        }

            else //alle andere objecten
            {
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
                countFrogsOnFinish++;
                setY(10000);
                // Actuele X en Y positie van de kikker pakken wanneer hij in de SafeFinishTile is, en in de huidige SafefinishTile een kikker neerzetten
                // Vervolgens de positie van de huidige kikker weer terugzetten naar 0
            }
            else if( ct.theTile instanceof WaterTile)
            {
                froggerSplash.rewind();
                froggerSplash.play();
                onHit();
            }
        }
    }

}
