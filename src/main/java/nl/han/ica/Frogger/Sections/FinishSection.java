package nl.han.ica.Frogger.Sections;

import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import processing.core.PVector;

/**
 * Finish section is the last section where the player needs to go to to finish the game
 */
public class FinishSection extends Section {
    private int[][] tileSection = {
            {5,5,5,5,5,5,5,5,5,4,5,5,5,5,5,5,5,5,5,4,5,5,5,5},
    };

    /**
     * Create a Finish section and append it to the tilemap
     * @param engine Engine reference to update the tilemap
     */
    public FinishSection(GameEngine engine)
    {
        super(engine, false);

        engine.getTileMap().setTileMap( super.appendTileMap(tileSection) );
    }

    /**
     * Needed implementation that isn't used as section doesn't spawn entities
     */
    @Override
    public void spawnEntity() {
    }

    /**
     * Automatically sets this Sections own size
     */
    @Override
    public void setSize() { this.size = new PVector(tileSection[0].length * 50, tileSection.length * 50);}
}
