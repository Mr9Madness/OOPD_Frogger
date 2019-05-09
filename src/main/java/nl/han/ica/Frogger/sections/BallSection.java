package nl.han.ica.Frogger.sections;

import nl.han.ica.Frogger.Objects.Ball;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import processing.core.PVector;

public class BallSection extends Section {
    private int[][] tileSection = {
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}
    };

    public BallSection(GameEngine engine)
    {
        super(engine, true);

        engine.getTileMap().setTileMap( super.appendTileMap(tileSection) );
    }

    @Override
    public void spawnEntity() {
        float[] bounds = new float[2];
        bounds[0] = 150 - size.y + 100;
        bounds[1] = 150;
        engine.addGameObject(new Ball(engine,240,2, bounds), engine.getView().getWorldWidth(),150);
        engine.addGameObject(new Ball(engine,300,6, bounds), engine.getView().getWorldWidth(),100);
        engine.addGameObject(new Ball(engine,300,4, bounds), engine.getView().getWorldWidth(),50);
    }

    @Override
    public void setSize() { this.size = new PVector(tileSection[0].length * 50, (tileSection.length + 1) * 50 );}
}
