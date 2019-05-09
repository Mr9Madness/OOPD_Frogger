package nl.han.ica.Frogger;

import nl.han.ica.Frogger.Menus.MenuManager;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import nl.han.ica.OOPD_Engine.View.CenterFollowingViewport;
import nl.han.ica.OOPD_Engine.View.View;
import nl.han.ica.OOPD_Engine.Sound.Sound;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Frogger extends GameEngine
{
    private Player frog;
    private Map map;
    private MenuManager menuManager;
    private Sound backgroundSound,frogWinSound,frogSplashSound,frogHopSound,gameOverSound,froggerFlatSound;

    private int worldWidth = 900;
    private int worldHeight = 1200;

    public static void main(String[] args) {
        PApplet.main(new String[]{"nl.han.ica.Frogger.Frogger"});
    }

    /**
     * Initialiseert geluid
     */
    private void initializeSound() {
        backgroundSound = new Sound(this, "src/main/assets/music/Background.mp3");
        backgroundSound.loop(-1);
        frogWinSound = new Sound(this, "src/main/assets/music/yehaw.mp3");
        frogSplashSound = new Sound(this, "src/main/assets/music/frogger-splash.wav");
        frogHopSound = new Sound(this, "src/main/assets/music/frogger-hop.wav");
        froggerFlatSound = new Sound(this, "src/main/assets/music/carscreechstop.wav");
        gameOverSound = new Sound(this, "src/main/assets/music/gameover.mp3");
    }

    /**
     * In deze methode worden de voor het spel noodzakelijke zaken geïnitialiseerd
     */
    @Override
    public void setupGame()
    {
        int screenWidth = 800;
        int screenHeight = 1200;

        initializeSound();

        menuManager = new MenuManager(this, screenWidth, screenHeight, true); // TODO: Verander ingame naar false zodra het main menu menu bestaat
        createObjects(screenWidth, screenHeight);

        initView(screenWidth, screenHeight, worldWidth, worldHeight);

        map = new Map(this);
    }

    public void RestartGame()
    {
        menuManager.StartGame();
        createObjects(worldWidth, worldHeight);
    }

    void EndGame()
    {
        menuManager.ShowGameOver(frog);
        deleteGameObject(frog);
        frog = null;
    }

    /**
     * Creeërt de view zonder viewport
     * @param worldWidth Breedte van het scherm
     * @param worldHeight Hoogte van het scherm
     */
    private void initView( int screenWidth, int screenHeight, int worldWidth, int worldHeight)
    {
        CenterFollowingViewport viewPort = new CenterFollowingViewport(frog, screenWidth, screenHeight,0,0);
        viewPort.setTolerance(50, 50, 50, 50);
        View view = new View(viewPort, worldWidth, worldHeight);
        view.setBackground(0,0,0);
        setView(view);
        size(screenWidth, screenHeight);
    }

    /** Maakt de spelobjecten aan */
    private void createObjects(int worldWidth, int worldHeight)
    {
        frog = new Player(this, menuManager);
        addGameObject(frog, worldWidth / 2, worldHeight);
    }

    @Override
    public void update() {
    }
}
