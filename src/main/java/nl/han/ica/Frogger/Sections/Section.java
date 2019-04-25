package nl.han.ica.Frogger.Sections;

import nl.han.ica.Frogger.Vector;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import processing.core.PVector;

public class Section {
    protected PVector pos;
    protected PVector size;

    protected GameEngine engine;

    protected int[][] tileSection = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };

    protected Section(GameEngine engine)
    {
        this.engine = engine;
    }
    public Section(GameEngine engine, PVector pos, PVector size)
    {
        this.engine = engine;
        this.pos = pos;
        this.size = size;

        engine.getTileMap().setTileMap( appendTileMap( tileSection ) );
    }

    protected int[][] appendTileMap( int[][] appendingSection )
    {
        int[][] tilemap = engine.getTileMap().getTileMap();
        int[][] newTileMap = new int[ tilemap.length + appendingSection.length ][24];
        for(int i = 0; i <= newTileMap.length; i++)
        {
            if( i < appendingSection.length ) newTileMap[i] = appendingSection[i];
            else if( i - appendingSection.length < tilemap.length ) newTileMap[i] = tilemap[i - appendingSection.length];
        }
        return newTileMap;
    }

    public PVector getSize() {
        return size;
    }

    public PVector getPos() {
        return pos;
    }

    public Vector<PVector> getBounds()
    {
        return new Vector<>( new PVector(pos.x - size.x, pos.x + size.x), new PVector(pos.y - size.y, pos.y + size.y) );
    }
}
