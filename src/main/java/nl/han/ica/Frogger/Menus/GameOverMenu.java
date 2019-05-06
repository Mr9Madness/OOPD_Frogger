package nl.han.ica.Frogger.Menus;

import nl.han.ica.Frogger.Menus.Objects.uiButton;
import nl.han.ica.Frogger.Menus.Objects.uiObject;
import nl.han.ica.Frogger.Menus.Objects.uiSpriteObject;
import nl.han.ica.Frogger.Player;
import nl.han.ica.OOPD_Engine.Dashboard.Dashboard;
import nl.han.ica.OOPD_Engine.Objects.GameObject;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Objects.TextObject;

import java.util.HashMap;
import java.util.Map;

public class GameOverMenu extends Dashboard {
    private Map<String, GameObject> menuObjects = new HashMap<>();

    public GameOverMenu(float worldWidth, float worldHeight, Player player)
    {
        super(0, 0, worldWidth, worldHeight);

        AddGameObject( "Background", new uiObject( 200, 150, 400, 350,0,0,0, 125), 200, 150);

        AddGameObject( "GameOverTitle", new TextObject( "Game over", 20 ), 250, 175 );

        AddGameObject( "FinalPlayerScore", new TextObject( "Score: " + player.GetPlayerScore(), 20 ), 250, 210 );

        AddGameObject( "GaveOverImage", new uiSpriteObject( new Sprite("src/main/assets/sprites/GameOver216.jpg")), 275, 225 );

        AddGameObject( "GaveOverButton", new uiButton( 250, 450, 115, 35, "Terug", 0,0,0,125 ));
    }
    private void AddGameObject(String key, GameObject object )
    {
        menuObjects.put( key, object );
        addGameObject( object );
    }

    private void AddGameObject(String key, GameObject object, int x, int y )
    {
        menuObjects.put( key, object );
        addGameObject( object, x, y );
    }
}
