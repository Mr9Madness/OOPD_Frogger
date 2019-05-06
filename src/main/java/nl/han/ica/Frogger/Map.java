package nl.han.ica.Frogger;

import nl.han.ica.Frogger.sections.*;
import nl.han.ica.Frogger.tiles.*;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Tile.TileMap;
import nl.han.ica.OOPD_Engine.Tile.TileType;
import processing.core.PVector;

import java.util.ArrayList;

public class Map {
    private ArrayList<Section> sectionList = new ArrayList<>();

    public Map(Frogger engine)
    {
        engine.setTileMap( initTileMap() );

        AddSection(new RoadSection(engine ));
        //AddSection(new RoadSection(engine));
        AddSection(new RiverSection(engine));
        AddSection(new RoadSection(engine));
        AddSection(new BallSection(engine));
        AddSection(new FinishSection(engine));

        for (int i = 0; i < sectionList.size(); i++) {
            if( i == 0 ) sectionList.get(i).setPos(new PVector(0,100));
            else sectionList.get(i).setPos(new PVector(
                sectionList.get(i - 1).getPos().x + sectionList.get(i - 1).getSize().x,
                sectionList.get(i - 1).getPos().y + sectionList.get(i - 1).getSize().y
            ));
            sectionList.get(i).setSize();
            sectionList.get(i).spawnEntity();
        }

        engine.getView().setWorldSize(engine.getWidth(), engine.getTileMap().getMapHeight());
    }

    public void AddSection( Section section )
    {
        sectionList.add( section );
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
                new TileType<>(SafeFinishTile.class, new Sprite( "src/main/assets/sprites/SafeFinish.png" )),
                new TileType<>(FinishTile.class, new Sprite( "src/main/assets/sprites/Finish.png" ))
        };

        int tileSize = 50;
        int[][] tileMapData = {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };
        return new TileMap(tileSize, tileType, tileMapData);
    }

}
