package nl.han.ica.Frogger;

import nl.han.ica.Frogger.sections.*;
import nl.han.ica.Frogger.tiles.FinishTile;
import nl.han.ica.Frogger.tiles.RoadTile;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Tile.TileMap;
import nl.han.ica.OOPD_Engine.Tile.TileType;

import java.util.ArrayList;

public class Map {
    public ArrayList<Section> SectionList;

    public Map(GameEngine engine)
    {
        engine.setTileMap( initTileMap() );

        SectionList = new ArrayList<>();
        AddSection(new RoadSection(engine));
        AddSection(new RiverSection(engine));
        AddSection(new RoadSection(engine));
        AddSection(new BallSection(engine));


        AddSection(new FinishSection(engine));

        engine.getView().setWorldSize(engine.getWidth(), engine.getTileMap().getMapHeight());
    }

    public void AddSection( Section section )
    {
        SectionList.add( section );
    }

    /** Initialiseert de tilemap */
    private TileMap initTileMap()
    {
        TileType[] tileType = {
                new TileType<>(RoadTile.class, new Sprite( "src/main/assets/sprites/safezone.png" )),
                new TileType<>(RoadTile.class, new Sprite( "src/main/assets/sprites/roadWithStripes.png" )),
                new TileType<>(RoadTile.class, new Sprite( "src/main/assets/sprites/road.png" )),
                new TileType<>(RoadTile.class, new Sprite( "src/main/assets/sprites/water.png" )),
                new TileType<>(RoadTile.class, new Sprite( "src/main/assets/sprites/road.png" )),
                new TileType<>(FinishTile.class, new Sprite( "src/main/assets/sprites/safezone.png" ))
        };

        int tileSize = 50;
        int[][] tileMapData = {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };
        return new TileMap(tileSize, tileType, tileMapData);
    }

}
