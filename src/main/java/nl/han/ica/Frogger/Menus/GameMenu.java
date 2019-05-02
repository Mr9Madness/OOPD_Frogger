package nl.han.ica.Frogger.Menus;

import nl.han.ica.Frogger.Menus.Objects.uiSpriteObject;
import nl.han.ica.OOPD_Engine.Dashboard.Dashboard;
import nl.han.ica.OOPD_Engine.Objects.GameObject;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Objects.TextObject;

import java.util.HashMap;
import java.util.Map;

public class GameMenu extends Dashboard {
    private Map<String, GameObject> menuObjects = new HashMap<>();

    public GameMenu( float worldWidth, float worldHeight )
    {
        super(0, 0, worldWidth, worldHeight);

        AddLives( 5 );
        AddGameObject( "Score", new TextObject("Score: 0", 15), 25, 50 );
    }

    private void AddGameObject( String key, GameObject object, int x, int y )
    {
        menuObjects.put( key, object );
        addGameObject( object, x, y );
    }

    private void AddLives(int amount)
    {
        for (int i = 1; i <= amount; i++)
            AddGameObject( "PlayerLife" + i, new uiSpriteObject( new Sprite( "src/main/assets/sprites/LittleFrogger.png" ) ), (25 * i - 1) + (5 * i - 1), 10 );
    }

    public void UpdateScore( int score )
    {
        ( ( TextObject )menuObjects.get( "Score" ) ).setText("Score: " + score);
    }

    public void RemoveLive( int index)
    {
        deleteGameObject(menuObjects.get( "PlayerLife" + index ));
        menuObjects.remove("PlayerLife" + index);
    }
}
