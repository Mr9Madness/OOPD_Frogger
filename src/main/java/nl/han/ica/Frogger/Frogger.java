package nl.han.ica.Frogger;

import nl.han.ica.OOPD_Engine.Dashboard.Dashboard;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Persistence.FilePersistence;
import nl.han.ica.OOPD_Engine.Persistence.IPersistence;
import nl.han.ica.OOPD_Engine.Sound.Sound;
import nl.han.ica.OOPD_Engine.Tile.TileMap;
import nl.han.ica.OOPD_Engine.Tile.TileType;
import nl.han.ica.OOPD_Engine.View.EdgeFollowingViewport;
import nl.han.ica.OOPD_Engine.View.View;
import nl.han.ica.Frogger.tiles.RoadTile;
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
     * In deze methode worden de voor het spel
     * noodzakelijke zaken geïnitialiseerd
     */
    @Override
    public void setupGame() {

        int worldWidth=800;
        int worldHeight=600;

        createObjects(worldWidth, worldHeight);
        initView(worldWidth, worldHeight);

        map = new Map(this);
    }

    /**
     * Creeërt de view zonder viewport
     * @param screenWidth Breedte van het scherm
     * @param screenHeight Hoogte van het scherm
     */
    private void initView(int screenWidth, int screenHeight) {

        EdgeFollowingViewport viewPort = new EdgeFollowingViewport(frog, (int)Math.ceil(screenWidth / 1f),(int)Math.ceil(screenHeight / 1f),0,0);
        viewPort.setTolerance(50, 50, 50, 50);
        View view = new View(viewPort, 950, 650);
        view.setBackground(0,0,0);
        setView(view);
        size(screenWidth, screenHeight);
    }

    /**
     * Maakt de spelobjecten aan
     */
    private void createObjects(int dashboardWidth,int dashboardHeight) {
        frog = new Player(this);
        addGameObject(frog, dashboardWidth/2, dashboardHeight);
    }

    @Override
    public void update() {
    }
}
