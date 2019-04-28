package nl.han.ica.Frogger;

import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import nl.han.ica.OOPD_Engine.View.CenterFollowingViewport;
import nl.han.ica.OOPD_Engine.View.View;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Frogger extends GameEngine
{
    private Player frog;
    private Map map;

    public static void main(String[] args) {
        PApplet.main(new String[]{"nl.han.ica.Frogger.Frogger"});
    }

    /**
     * In deze methode worden de voor het spel noodzakelijke zaken geïnitialiseerd
     */
    @Override
    public void setupGame()
    {
        int worldWidth = 800;
        int worldHeight = 600;

        createObjects(worldWidth, worldHeight);
        initView(worldWidth, worldHeight);

        map = new Map(this);
    }

    /**
     * Creeërt de view zonder viewport
     * @param screenWidth Breedte van het scherm
     * @param screenHeight Hoogte van het scherm
     */
    private void initView(int screenWidth, int screenHeight)
    {
        CenterFollowingViewport viewPort = new CenterFollowingViewport(frog, screenWidth, screenHeight,0,0);
        viewPort.setTolerance(50, 50, 50, 50);
        View view = new View(viewPort, 950, 750);
        view.setBackground(0,0,0);
        setView(view);
        size(screenWidth, screenHeight);
    }

    /** Maakt de spelobjecten aan */
    private void createObjects(int dashboardWidth,int dashboardHeight)
    {
        frog = new Player(this);
        addGameObject(frog, dashboardWidth/2, dashboardHeight);
    }

    @Override
    public void update() {
    }
}
