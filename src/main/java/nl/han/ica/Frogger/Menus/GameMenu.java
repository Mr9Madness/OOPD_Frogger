package nl.han.ica.Frogger.Menus;

import nl.han.ica.Frogger.Menus.Objects.uiSpriteObject;
import nl.han.ica.OOPD_Engine.Dashboard.Dashboard;
import nl.han.ica.OOPD_Engine.Objects.GameObject;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Objects.TextObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Deze class zorgt voor het weergeven van de user interface
 * Het betreft hier de score en de kikkers.
 */
public class GameMenu extends Dashboard {
    private Map<String, GameObject> menuObjects = new HashMap<>();

    /**
     * Constructs a dashboard with ui object for a running game
     * @param worldWidth Width of the game world
     * @param worldHeight Height of the game world
     */
    GameMenu( float worldWidth, float worldHeight )
    {
        super(0, 0, worldWidth, worldHeight);

        AddLives( 5 );
        TextObject scoreText = new TextObject("Score: 0", 15);
        scoreText.setForeColor(255,255,255,95);
        AddGameObject( "Score", scoreText, 25, 50 );
    }

    /**
     * Add an gameobject to the object hashmap with the specified string key and spawn it with the specified coordinates
     * @param key String key that makes getting the object easier
     * @param object the object needed to be displayed on the menu
     * @param x x position of the menu object
     * @param y y position of the menu object
     */
    private void AddGameObject( String key, GameObject object, int x, int y )
    {
        menuObjects.put( key, object );
        addGameObject( object, x, y );
    }

    /**
     * Add an amount of lives to the game menu
     * @param amount Amount to be added
     */
    private void AddLives(int amount)
    {
        for (int i = 1; i <= amount; i++)
            AddGameObject( "PlayerLife" + i, new uiSpriteObject( new Sprite( "src/main/assets/sprites/LittleFrogger.png" ) ), (25 * i - 1) + (5 * i - 1), 10 );
    }

    /**
     * Public access method to update the score on the game screen
     * @param score The score needed to be displayed
     */
    public void UpdateScore( int score )
    {
        ( ( TextObject )menuObjects.get( "Score" ) ).setText("Score: " + score);
    }

    /**
     * Public access method to update amount of lives being displayed on the game screen
     * @param index Index of the live needing to be removed
     */
    public void RemoveLive( int index)
    {
        deleteGameObject(menuObjects.get( "PlayerLife" + index ));
        menuObjects.remove("PlayerLife" + index);
    }
}
