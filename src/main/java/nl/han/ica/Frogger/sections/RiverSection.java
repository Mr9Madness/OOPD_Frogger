package nl.han.ica.Frogger.sections;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.Frogger.Objects.RiverObjects.Tree;
import nl.han.ica.Frogger.Objects.RiverObjects.TreeSize;
import processing.core.PVector;

/**
 * River section is the section where river obstacles spawn and move in
 */
public class RiverSection extends Section {
    private final Frogger engine;
    private int[][] tileSection = {
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
    };

    /**
     * Create a River section and append it to the tilemap
     * @param engine Engine reference to update the tilemap
     */
    public RiverSection(Frogger engine)
    {
        super(engine, true);
        this.engine = engine;
        engine.getTileMap().setTileMap( super.appendTileMap(tileSection) );
    }

    /**
     * Implementation of spawnEntity that spawn obstacles when needed
     */
    @Override
    public void spawnEntity() {
        System.out.println("River Direction " + pos + " / " + size + " / engine:" + engine.height + " / view:" + engine.getView().getWorldHeight());

        engine.addGameObject(new Tree(engine, TreeSize.Big,270, 1), 60, 350); //LEFT
        engine.addGameObject(new Tree(engine, TreeSize.Big, 270, 1), 600, 350); //LEFT
        engine.addGameObject(new Tree(engine, TreeSize.Big, 270, 1), 900, 350); //LEFT

        engine.addGameObject(new Tree(engine, TreeSize.Medium, 90, 1), 60, 300); //LEFT
        engine.addGameObject(new Tree(engine, TreeSize.Medium, 90, 1), 600, 300); //LEFT
        engine.addGameObject(new Tree(engine, TreeSize.Medium, 90, 1), 900, 300); //LEFT

        engine.addGameObject(new Tree(engine, TreeSize.Small, 270, 1), 60, 250); //LEFT
        engine.addGameObject(new Tree(engine, TreeSize.Small, 270, 1), 600, 250); //LEFT
        engine.addGameObject(new Tree(engine, TreeSize.Small, 270, 1), 900, 250); //LEFT
    }

    /**
     * Automatically sets this sections own size
     */
    @Override
    public void setSize() { this.size = new PVector(tileSection[0].length * 50, (tileSection.length + 1) * 50);}
}
