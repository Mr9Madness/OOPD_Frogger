package nl.han.ica.Frogger.Sections;

import nl.han.ica.OOPD_Engine.Engine.GameEngine;

public class BallSection extends Section {
    private int[][] tileSection = {
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
    };

    public BallSection(GameEngine engine)
    {
        super(engine);

        engine.getTileMap().setTileMap( super.appendTileMap(tileSection) );
    }

}
