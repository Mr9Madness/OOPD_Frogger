package nl.han.ica.Frogger.Menus;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.Frogger.Menus.Objects.uiButton;
import nl.han.ica.Frogger.Menus.Objects.uiObject;
import nl.han.ica.Frogger.Menus.Objects.uiSpriteObject;
import nl.han.ica.Frogger.Player;
import nl.han.ica.OOPD_Engine.Dashboard.Dashboard;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import nl.han.ica.OOPD_Engine.Objects.GameObject;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Objects.TextObject;

import java.util.HashMap;
import java.util.Map;

/**
 * The gamewon menu that displays when the game is won
 */
public class GameWonMenu extends Dashboard {
    private Map<String, GameObject> menuObjects = new HashMap<>();
    private GameEngine engine;

    /**
     * Constructs the gamewon menu and adds the needed ui objects
     * @param engine Engine reference to add objects
     * @param worldWidth with of the entire world
     * @param worldHeight height of the entire world
     */
    public GameWonMenu(GameEngine engine, float worldWidth, float worldHeight, Player player)
    {
        super(0, 0, worldWidth, worldHeight);
        this.engine = engine;

        AddGameObject( "Background", new uiObject( 200, 150, 400, 350,30,255,123,255), 200, 150);

        AddGameObject( "GameOverTitle", new TextObject( "Gewonnen", 20 ), 250, 175 );

        AddGameObject( "FinalPlayerScore", new TextObject( "Score: " + player.GetPlayerScore(), 20 ), 250, 210 );

        AddGameObject( "GameOverImage", new uiSpriteObject( new Sprite("src/main/assets/sprites/Gewonnen216.jpg")), 275, 225 );

        AddGameObject( "GameOverButton", new uiButton( 250, 450, 115, 35, " Restart", 5,67,31,255, (Frogger)engine));
    }

    /**
     * Add an gameobject to the object hashmap with the specified string key
     * @param key String key that makes getting the object easier
     * @param object the object needed to be displayed on the menu
     */
    private void AddGameObject(String key, GameObject object )
    {
        menuObjects.put( key, object );
        addGameObject( object );
    }

    /**
     * Add an gameobject to the object hashmap with the specified string key and spawn it with the specified coordinates
     * @param key String key that makes getting the object easier
     * @param object the object needed to be displayed on the menu
     * @param x x position of the menu object
     * @param y y position of the menu object
     */
    private void AddGameObject(String key, GameObject object, int x, int y )
    {
        menuObjects.put( key, object );
        addGameObject( object, x, y );
    }

    /**
     * Get the mouse coordinates and clicked state and gives to the buttons
     */
    @Override
    public void update() {
        for (Map.Entry<String, GameObject> object: menuObjects.entrySet()) {
            if( object.getValue() instanceof uiButton )
                ((uiButton)object.getValue()).mouseUpdate(engine.mouseX, engine.mouseY, engine.mousePressed);
        }
    }

}
