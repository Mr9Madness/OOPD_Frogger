package nl.han.ica.Frogger.sections;

import nl.han.ica.OOPD_Engine.Engine.GameEngine;

public class RiverSection extends Section {
    private int[][] tileSection = {
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
    };

    public RiverSection(GameEngine engine)
    {
        super(engine, true);

        engine.getTileMap().setTileMap( super.appendTileMap(tileSection) );
    }
}
