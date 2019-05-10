package nl.han.ica.Frogger.Menus;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.Frogger.Menus.Objects.uiButton;
import nl.han.ica.Frogger.Menus.Objects.uiObject;
import nl.han.ica.Frogger.Menus.Objects.uiSpriteObject;
import nl.han.ica.OOPD_Engine.Dashboard.Dashboard;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import nl.han.ica.OOPD_Engine.Objects.GameObject;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Objects.TextObject;

import java.util.HashMap;
import java.util.Map;

/**
 * The gameover menu that displays when the game is lost
 */
public class GameOverMenu extends Dashboard {
    private Map<String, GameObject> menuObjects = new HashMap<>();
    private GameEngine engine;

    /**
     * Constructs the gameover menu and adds the needed ui objects
     * @param engine Engine reference to add objects
     * @param worldWidth with of the entire world
     * @param worldHeight height of the entire world
     */
    GameOverMenu(GameEngine engine, float worldWidth, float worldHeight)
    {
        super(0, 0, worldWidth, worldHeight);
        this.engine = engine;

        AddGameObject( "Background", new uiObject( 200, 150, 400, 350,255,69,57,255), 200, 150);

        AddGameObject( "GameOverTitle", new TextObject( "Game over", 20 ), 250, 175 );

        AddGameObject( "GaveOverImage", new uiSpriteObject( new Sprite("src/main/assets/sprites/GameOver216.jpg")), 275, 225 );

        AddGameObject( "GaveOverButton", new uiButton( 250, 450, 115, 35, "Restart", 70,5,3,255, (Frogger)engine));
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
