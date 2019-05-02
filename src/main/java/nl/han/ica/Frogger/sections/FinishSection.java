package nl.han.ica.Frogger.sections;

import nl.han.ica.OOPD_Engine.Engine.GameEngine;

public class FinishSection extends Section {
    private int[][] tileSection = {
            {6,6,5,6,6,6,6,6,6,5,6,6,6,6,6,6,6,6,6,5,6,6,6,6},
    };

    public FinishSection(GameEngine engine)
    {
        super(engine, false);

        engine.getTileMap().setTileMap( super.appendTileMap(tileSection) );
    }

//    @Override
//    public Section(GameEngine engine)
//    {
//        this.engine = engine;
//    }
}
