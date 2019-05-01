package nl.han.ica.Frogger;

import nl.han.ica.Frogger.sections.*;
import nl.han.ica.Frogger.tiles.*;
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
                new TileType<>(SafeTile.class, new Sprite( "src/main/assets/sprites/Safezone.png" )),
                new TileType<>(RoadTile.class, new Sprite( "src/main/assets/sprites/RoadWithStripes.png" )),
                new TileType<>(RoadTile.class, new Sprite( "src/main/assets/sprites/Road.png" )),
                new TileType<>(WaterTile.class, new Sprite( "src/main/assets/sprites/Water.png" )),
                new TileType<>(BallTile.class, new Sprite( "src/main/assets/sprites/Air.png" )),
                new TileType<>(FinishTile.class, new Sprite( "src/main/assets/sprites/SafeFinisch.png" )),
                new TileType<>(FinishTile.class, new Sprite( "src/main/assets/sprites/Finisch.png" ))
        };

        int tileSize = 50;
        int[][] tileMapData = {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };
        return new TileMap(tileSize, tileType, tileMapData);
    }

}
