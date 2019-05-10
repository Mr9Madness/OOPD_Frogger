package nl.han.ica.Frogger.Menus;

import nl.han.ica.Frogger.Player;
import nl.han.ica.OOPD_Engine.Dashboard.Dashboard;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;
/**
 * The MenuManager that manager every menu (gamemenu/gameovermenu/etc..) and show or hides then when the game stage changes
 */

public class MenuManager
{
    private boolean isGamePlaying;
    private boolean isMainMenuShowing;

    private Dashboard currentMenu;
    private GameEngine engine;

    /**
     * Constructs the MenuManager menu and adds the mainmenu as default menu
     * @param engine Engine reference to add objects and dashboards
     * @param screenWidth with of the entire screen
     * @param screenHeight height of the entire screen
     */
    public MenuManager( GameEngine engine, int screenWidth, int screenHeight)
    {
        isGamePlaying = false;
        isMainMenuShowing = true;
        this.engine = engine;

        currentMenu = new MainMenu( screenWidth, screenHeight );
        engine.addDashboard(currentMenu);
    }
    /**
     * Constructs the MenuManager menu and adds a mainmenu or gamemenu as default menu
     * @param engine Engine reference to add objects and dashboards
     * @param screenWidth with of the entire screen
     * @param screenHeight height of the entire screen
     * @param inGame specifies if the game or main menu should be the default menu
     */
    public MenuManager(GameEngine engine, int screenWidth, int screenHeight, boolean inGame )
    {
        isGamePlaying = inGame;
        isMainMenuShowing = !inGame;
        this.engine = engine;

        if( inGame ) currentMenu = new GameMenu(screenWidth, screenHeight);
        else currentMenu = new MainMenu(screenWidth, screenHeight);
        engine.addDashboard(currentMenu);
    }

    /**
     * Get the currently used menu
     * @return The menu that is currently being used
     */
    public Dashboard GetCurrentMenu() { return currentMenu; }

    /**
     * Show the game menu manually
     */
    public void StartGame()
    {
        this.isGamePlaying = true;
        engine.deleteDashboard( currentMenu );

        currentMenu = new GameMenu( currentMenu.getWidth(), currentMenu.getHeight() );

        engine.addDashboard( currentMenu );
    }

    /**
     * Show the game won menu manually
     */
    public void ShowGameWon( Player player)
    {
        this.isGamePlaying = false;
        engine.deleteDashboard( currentMenu );

        currentMenu = new GameWonMenu( engine, currentMenu.getWidth(), currentMenu.getHeight(), player );

        engine.addDashboard( currentMenu );

    }
    /**
     * Show the game over manually
     */
    public void ShowGameOver()
    {
        this.isGamePlaying = false;
        engine.deleteDashboard( currentMenu );

        currentMenu = new GameOverMenu( engine, currentMenu.getWidth(), currentMenu.getHeight() );

        engine.addDashboard( currentMenu );
    }
}
