package nl.han.ica.Frogger.sections;

import nl.han.ica.Frogger.Vector;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import processing.core.PVector;

public abstract class Section {
    protected PVector pos;
    protected PVector size;

    protected GameEngine engine;

    protected int[][] tileSection = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };


    public Section(GameEngine engine, boolean loadSafeLine)
    {
        this.engine = engine;

        if( loadSafeLine ) engine.getTileMap().setTileMap(appendTileMap(tileSection));
        else engine.getTileMap().setTileMap(appendTileMap(tileSection));
    }

    public Section(GameEngine engine)
    {
        this(engine, true);
    }

    protected int[][] appendTileMap( int[][] appendingSection )
    {
        int[][] tilemap = engine.getTileMap().getTileMap();

        int[][] newTileMap = new int[ tilemap.length + appendingSection.length ][engine.getView().getWorldWidth() / 50];
        for(int i = 0; i <= newTileMap.length; i++)
        {
            if( i < appendingSection.length ) newTileMap[i] = appendingSection[i];
            else if( i - appendingSection.length < tilemap.length ) newTileMap[i] = tilemap[i - appendingSection.length];
        }
        return newTileMap;
    }
    public abstract void spawnEntity();

    public PVector getSize() {
        return size;
    }

    public abstract void setSize();
    public void setSize( PVector size) { this.size = size;}

    public PVector getPos() {
        return pos;
    }
    public void setPos( PVector pos ) { this.pos = pos;}

    public Vector<PVector> getBounds()
    {
        return new Vector<>( new PVector(pos.x - size.x, pos.x + size.x), new PVector(pos.y - size.y, pos.y + size.y) );
    }
}
