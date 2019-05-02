package nl.han.ica.Frogger.Menus;

import nl.han.ica.Frogger.Menus.Objects.uiObject;
import nl.han.ica.Frogger.Player;
import nl.han.ica.OOPD_Engine.Dashboard.Dashboard;
import nl.han.ica.OOPD_Engine.Objects.GameObject;
import nl.han.ica.OOPD_Engine.Objects.TextObject;

import java.util.HashMap;
import java.util.Map;

public class GameOverMenu extends Dashboard {
    private Map<String, GameObject> menuObjects = new HashMap<>();

    public GameOverMenu(float worldWidth, float worldHeight, Player player)
    {
        super(0, 0, worldWidth, worldHeight);

        AddGameObject( "Background", new uiObject( 200, 150, 450, 350,0,0,0, 125), 200, 150);

        AddGameObject( "GameOverTitle", new TextObject( "Game over", 20 ), 250, 175 );

        AddGameObject( "FinalPlayerScore", new TextObject( "Score: " + player.GetPlayerScore(), 20 ), 250, 210 );
    }

    private void AddGameObject(String key, GameObject object, int x, int y )
    {
        menuObjects.put( key, object );
        addGameObject( object, x, y );
    }
}
