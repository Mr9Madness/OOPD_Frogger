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

        System.out.println(pos);
        System.out.println(size);
        System.out.println( "X: " + engine.getView().getWorldWidth() + " | Y: " + (engine.getView().getWorldHeight() + pos.y + size.y)  );
        engine.addGameObject(new Ball(engine,270,1), engine.getView().getWorldWidth(),engine.getView().getWorldHeight() + pos.y + size.y);

    }

    @Override
    public void setSize() { this.size = new PVector(tileSection[0].length * 50, tileSection.length * 50);}
}
