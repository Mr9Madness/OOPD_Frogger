package nl.han.ica.Frogger;

import nl.han.ica.Frogger.Sections.BallSection;
import nl.han.ica.Frogger.Sections.RiverSection;
import nl.han.ica.Frogger.Sections.RoadSection;
import nl.han.ica.Frogger.Sections.Section;
import nl.han.ica.Frogger.tiles.RoadTile;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Tile.TileMap;
import nl.han.ica.OOPD_Engine.Tile.TileType;
import processing.core.PVector;

import java.util.ArrayList;

public class Map {
    public ArrayList<Section> SectionList;

    public Map(GameEngine engine)
    {
        engine.setTileMap( initTileMap() );

        SectionList = new ArrayList<>();
        SectionList.add(new RoadSection(engine));
        SectionList.add(new Section(engine, new PVector(2, 4), new PVector(0,0)));
        SectionList.add(new RiverSection(engine));
        SectionList.add(new Section(engine, new PVector(2, 4), new PVector(0,0)));
        SectionList.add(new RoadSection(engine));
        SectionList.add(new Section(engine, new PVector(2, 4), new PVector(0,0)));
        SectionList.add(new BallSection(engine));

        engine.getView().setWorldSize(engine.getWidth(), engine.getTileMap().getMapHeight());
    }

    /**
     * Initialiseert de tilemap
     */
    private TileMap initTileMap() {
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
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };
        return new TileMap(tileSize, tileType, tileMapData);
    }

}
