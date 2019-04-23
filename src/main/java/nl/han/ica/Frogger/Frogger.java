package nl.han.ica.Frogger;

import nl.han.ica.OOPD_Engine.Dashboard.Dashboard;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Persistence.FilePersistence;
import nl.han.ica.OOPD_Engine.Persistence.IPersistence;
import nl.han.ica.OOPD_Engine.Sound.Sound;
import nl.han.ica.OOPD_Engine.Tile.TileMap;
import nl.han.ica.OOPD_Engine.Tile.TileType;
import nl.han.ica.OOPD_Engine.View.View;
import nl.han.ica.Frogger.tiles.RoadTile;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Frogger extends GameEngine
{
    private Player frog;
    private Map map = new Map(this);


    public static void main(String[] args) {
        PApplet.main(new String[]{"nl.han.ica.Frogger.Frogger"});
    }

    /**
     * In deze methode worden de voor het spel
     * noodzakelijke zaken geïnitialiseerd
     */
    @Override
    public void setupGame() {

        int worldWidth=900;
        int worldHeight=650;

        initializeTileMap();
        createObjects(worldWidth, worldHeight);
        createViewWithoutViewport(worldWidth, worldHeight);

    }

    /**
     * Creeërt de view zonder viewport
     * @param screenWidth Breedte van het scherm
     * @param screenHeight Hoogte van het scherm
     */
    private void createViewWithoutViewport(int screenWidth, int screenHeight) {
        View view = new View(screenWidth,screenHeight);
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

    /**
     * Initialiseert de tilemap
     */
    private void initializeTileMap() {
        /* TILES */
        TileType[] tileType = new TileType[]{
                new TileType<>(RoadTile.class, new Sprite( "src/main/assets/sprites/safezone.png" )),
                new TileType<>(RoadTile.class, new Sprite( "src/main/assets/sprites/roadWithStripes.png" )),
                new TileType<>(RoadTile.class, new Sprite( "src/main/assets/sprites/road.png" )),
                new TileType<>(RoadTile.class, new Sprite( "src/main/assets/sprites/water.png" )),
                new TileType<>(RoadTile.class, new Sprite( "src/main/assets/sprites/road.png" ))
        };

        int tileSize=50;
        int[][] tileMapData = {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
                {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
                {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        };
        tileMap = new TileMap(tileSize, tileType, tileMapData);
    }

    @Override
    public void update() {
    }
}
