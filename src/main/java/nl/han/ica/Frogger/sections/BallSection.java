package nl.han.ica.Frogger.sections;

import nl.han.ica.OOPD_Engine.Engine.GameEngine;

public class BallSection extends Section {
    private int[][] tileSection = {
            {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
            {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
            {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4}
    };

    public BallSection(GameEngine engine)
    {
        super(engine, true);

        engine.getTileMap().setTileMap( super.appendTileMap(tileSection) );
    }
}
