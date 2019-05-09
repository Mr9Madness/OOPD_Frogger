package nl.han.ica.Frogger.sections;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.Frogger.Objects.RiverObjects.Tree;
import nl.han.ica.Frogger.Objects.RiverObjects.TreeSize;
import processing.core.PVector;

public class RiverSection extends Section {
    private final Frogger engine;
    private int[][] tileSection = {
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
    };

    public RiverSection(Frogger engine)
    {
        super(engine, true);
        this.engine = engine;
        engine.getTileMap().setTileMap( super.appendTileMap(tileSection) );
    }

    @Override
    public void spawnEntity() {
        System.out.println("Direction " + pos + " / " + size + " / engine:" + engine.height + " / view:" + engine.getView().getWorldHeight());


        engine.addGameObject(new Tree(engine, TreeSize.Big,270, 1), 60, size.y - 800); //LEFT
        engine.addGameObject(new Tree(engine, TreeSize.Big, 270, 1), 600, size.y - 800); //LEFT
        engine.addGameObject(new Tree(engine, TreeSize.Big, 270, 1), 900, size.y - 800); //LEFT

        engine.addGameObject(new Tree(engine, TreeSize.Medium, 90, 1), 60, size.y - 850); //LEFT
        engine.addGameObject(new Tree(engine, TreeSize.Medium, 90, 1), 600, size.y - 850); //LEFT
        engine.addGameObject(new Tree(engine, TreeSize.Medium, 90, 1), 900, size.y - 850); //LEFT


        engine.addGameObject(new Tree(engine, TreeSize.Small, 270, 1), 60, size.y - 900); //LEFT
        engine.addGameObject(new Tree(engine, TreeSize.Small, 270, 1), 600, size.y - 900); //LEFT
        engine.addGameObject(new Tree(engine, TreeSize.Small, 270, 1), 900, size.y - 900); //LEFT

    }

    @Override
    public void setSize() { this.size = new PVector(tileSection[0].length * 50, tileSection.length * 50);}
}
