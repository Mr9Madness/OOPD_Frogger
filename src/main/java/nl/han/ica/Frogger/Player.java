package nl.han.ica.Frogger;

import nl.han.ica.Frogger.Menus.GameMenu;
import nl.han.ica.Frogger.Menus.MenuManager;
import nl.han.ica.Frogger.Objects.Ball;
import nl.han.ica.Frogger.Objects.RiverObjects.Tree;
import nl.han.ica.Frogger.Objects.RoadObjects.RoadObjects;
import nl.han.ica.Frogger.Tiles.FinishTile;
import nl.han.ica.Frogger.Tiles.SafeFinishTile;
import nl.han.ica.Frogger.Tiles.WaterTile;
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
    private boolean isHit = false;
    private Sound froggerJump,froggerSplash,froggerCarScreech,froggerBallSploing;

    private int lives = 5;
    private int countFrogsOnFinish = 0;
    private int neededFrogsOnFinish = 1;
    private long startTime = System.currentTimeMillis();

    /**
     * Constructor waar de kikker afbeelding wordt meegegeven
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

    /**
     * Deze functie regelt dat als de kikker iets raakt er een kikker wordt afgetrokken en de huidige kikker weer beneden in het scherm komt te staan
     */
    private void onHit() {
        if (!isOnSafeObject) {
            gameMenu.RemoveLive(lives);
            lives--;
            System.out.println("you have " + lives + " frogs now!");
            if (lives != 0) setY(100000);
            isHit = false;
        }
    }

    /**
     * Player score wordt hier opgevraagd
     * @return playerscore wordt hier teruggegeven
     */
    public int GetPlayerScore() { return currentScore; }

    /**
     * Deze methode zorgt ervoor dat de
     */
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
        if (getCurrentFrameIndex()==0) //The frog is getting too wide with all the frames
            setCurrentFrameIndex(1);
        else
            setCurrentFrameIndex(0);
    }

    /**
     * Als er op de plijtjestoetsen wordt gedrukt, zal deze methode ervoor zorgen dat de kikker een andere positie krijgt toegewezen
     * @param keyCode Vraagt de toetscode op
     * @param key vraagt de toets op
     */
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

    /**
     * Zorgt ervoor dat als de kikker een object geraakt wordt er een object er een actie wordt gedaan.
     * Een actie is op de boom meedrijven
     * Of zorgen dat de kikker "af" is.
     * @param collidedGameObjects Een collectie van objecten waarmee wordt gebotst
     */
    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject ct : collidedGameObjects) {
            if (ct instanceof Ball)
            {
                isOnSafeObject = false;

                froggerBallSploing.rewind();
                froggerBallSploing.play();
                onHit();
            }
            else if (ct instanceof RoadObjects)
            {
                isOnSafeObject = false;

                froggerCarScreech.rewind();
                froggerCarScreech.play();
                onHit();
            }
            else if (ct instanceof Tree) {
                isOnSafeObject = true;
                setCurrentFrameIndex(0);

                if ((getX()>=0) && (ct.getDirection()==270.0)) //left
                {
                    if (ct.getX() <= getX() + getWidth() / 2 && ct.getX() + ct.getWidth() >= getX() + getWidth() / 2)
                        setX(getX()+ct.getxSpeed());
                    else isOnSafeObject = false;
                }
                else if (getX()<=0 && getDirection()==270.0) {
                    setY(getY()+50);
                    isOnSafeObject=false;
                }
                else if ((getX()<=750) && (ct.getDirection()==90.0)) //right
                {
                    if (ct.getX() <= getX() + getWidth() / 2 && ct.getX() + ct.getWidth() >= getX() + getWidth() / 2)
                        setX(getX()+ct.getxSpeed());
                    else isOnSafeObject = false;
                }
                else if ((getX()>=750) && (ct.getDirection()==90.0)) //right
                {
                    setY(getY()+50);
                    isOnSafeObject=false;
                }
            }
            else //alle andere objecten
            {
                isOnSafeObject = false;
                onHit();
            }
        }
    }

    /**
     * Draagt zorg voor de bosting van de Tiles, waar dan ook weer acties ontstaan zoals
     * alleen in een inham bij de finish kan de kikker komem
     * bij de watertile isn de kikker af.
     * @param collidedTiles Dit zijn alle Tiles die botsen met de kikker
     */
    @Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles)  {

        for (CollidedTile ct : collidedTiles)
        {
            if (ct.theTile instanceof FinishTile)
            {
                setY(Y+50);
            }
            else if (ct.theTile instanceof SafeFinishTile)
            {
                countFrogsOnFinish++;
                setY(10000);
                // Actuele X en Y positie van de kikker pakken wanneer hij in de SafeFinishTile is, en in de huidige SafefinishTile een kikker neerzetten
                // Vervolgens de positie van de huidige kikker weer terugzetten naar 0
            }
            else if( ct.theTile instanceof WaterTile && !isOnSafeObject)
            {
                froggerSplash.rewind();
                froggerSplash.play();
                onHit();
            }
        }
    }

}
