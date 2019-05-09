package nl.han.ica.Frogger.sections;

import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import processing.core.PVector;

public class FinishSection extends Section {
    private int[][] tileSection = {
            {5,5,5,5,5,5,5,5,5,4,5,5,5,5,5,5,5,5,5,4,5,5,5,5},
    };

    public FinishSection(GameEngine engine)
    {
        super(engine);

        engine.getTileMap().setTileMap( super.appendTileMap(tileSection) );
    }

    @Override
    public void spawnEntity() {

    }

    @Override
    public void setSize() { this.size = new PVector(tileSection[0].length * 50, tileSection.length * 50);}
}
