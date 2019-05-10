package nl.han.ica.Frogger.sections;

import nl.han.ica.Frogger.Vector;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import processing.core.PVector;

/**
 * Section is the base class for section and contains the needed data for all sections
 */
public abstract class Section {
    protected PVector pos;
    protected PVector size;

    protected GameEngine engine;

    /**
     * Dit is de save Tile die tussen 2 secties in zit. Deze kan niet zichtbaar worden met de loadSafeline
     */
    protected int[][] tileSection = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };
    protected boolean loadSafeLine;

    /**
     * Zorgt voor de sectie wordt toegevoegd aan de tilemap en gespeeld kan worden
     * @param engine is de Gameengine van de Frogger, wordt gebruikt om de tilemap te veranderen
     * @param loadSafeLine Als deze true is voegt hij een extra safeline toe aan het begin van de section
     */
    public Section(GameEngine engine, boolean loadSafeLine)
    {
        this.engine = engine;
        this.loadSafeLine = loadSafeLine;

        if( loadSafeLine ) engine.getTileMap().setTileMap(appendTileMap(tileSection));
    }

    /**
     * Zorgt voor de sectie wordt toegevoegd aan de tilemap en gespeeld kan worden, met default een safeline
     * @param engine is de Gameengine van de Frogger, wordt gebruikt om de tilemap te veranderen
     */
    public Section(GameEngine engine)
    {
        this(engine, true);
    }

    int[][] appendTileMap( int[][] appendingSection )
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

    /**
     * Zorgt ervoor dat alle benodigde obstakels voor die section gespawnd worden
     */
    public abstract void spawnEntity();

    /**
     * Pakt de grootte van de section
     */
    public PVector getSize() {
        return size;
    }

    public abstract void setSize();

    /**
     * Veranderd de size en wordt meegegeven
     * @param size geeft de size terug
     */
    public void setSize( PVector size) { this.size = size;}

    /**
     * Gets the position of the section
     * @return the position of the section
     */
    public PVector getPos() {
        return pos;
    }

    /**
     * Sets the position to the specified one
     * @param pos the position it needs to be changed to
     */
    public void setPos( PVector pos ) { this.pos = pos;}


    /**
     * Get the bounds of the Section based on the position and size
     * @return the bounds of the current section
     */
    public Vector<PVector> getBounds()
    {
        return new Vector<>( new PVector(pos.x - size.x, pos.x + size.x), new PVector(pos.y - size.y, pos.y + size.y) );
    }
}
