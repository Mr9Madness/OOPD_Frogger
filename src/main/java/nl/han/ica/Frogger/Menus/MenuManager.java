package nl.han.ica.Frogger.Menus;

import nl.han.ica.Frogger.Player;
import nl.han.ica.OOPD_Engine.Dashboard.Dashboard;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;

public class MenuManager
{
    private boolean isGamePlaying;
    private boolean isMainMenuShowing;

    private Dashboard currentMenu;
    private GameEngine engine;

    public MenuManager( GameEngine engine, int screenWidth, int screenHeight)
    {
        isGamePlaying = false;
        isMainMenuShowing = true;
        this.engine = engine;

        currentMenu = new MainMenu( screenWidth, screenHeight );
        engine.addDashboard(currentMenu);
    }
    public MenuManager(GameEngine engine, int screenWidth, int screenHeight, boolean inGame )
    {
        isGamePlaying = inGame;
        isMainMenuShowing = !inGame;
        this.engine = engine;

        if( inGame ) currentMenu = new GameMenu(screenWidth, screenHeight);
        else currentMenu = new MainMenu(screenWidth, screenHeight);
        engine.addDashboard(currentMenu);
    }
    public Dashboard GetCurrentMenu() { return currentMenu; }

    public void StartGame()
    {
        this.isGamePlaying = true;
        engine.deleteDashboard( currentMenu );

        currentMenu = new GameMenu( currentMenu.getWidth(), currentMenu.getHeight() );

        engine.addDashboard( currentMenu );

    }
    public void ShowGameWon( Player player)
    {
        this.isGamePlaying = false;
        engine.deleteDashboard( currentMenu );

        currentMenu = new GameWonMenu( engine, currentMenu.getWidth(), currentMenu.getHeight(), player );

        engine.addDashboard( currentMenu );

    }

    public void ShowGameOver( Player player)
    {
        this.isGamePlaying = false;
        engine.deleteDashboard( currentMenu );

        currentMenu = new GameOverMenu( engine, currentMenu.getWidth(), currentMenu.getHeight(), player );

        engine.addDashboard( currentMenu );

    }
}
