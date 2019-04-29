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
     * @param worldWidth Breedte van het scherm
     * @param worldHeight Hoogte van het scherm
     */
    private void initView(int worldWidth, int worldHeight)
    {
        CenterFollowingViewport viewPort = new CenterFollowingViewport(frog, worldWidth, worldHeight,0,0);
        viewPort.setTolerance(50, 50, 50, 50);
        View view = new View(viewPort, 950, 750);
        view.setBackground(0,0,0);
        setView(view);
        size(worldWidth, worldHeight);
    }

    /** Maakt de spelobjecten aan */
    private void createObjects(int worldWidth, int worldHeight)
    {
        frog = new Player(this);
        addGameObject(frog, worldWidth/2, worldHeight*100000);
    }

    @Override
    public void update() {
    }
}
