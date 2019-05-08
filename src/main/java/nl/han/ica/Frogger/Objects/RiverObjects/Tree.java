package nl.han.ica.Frogger.Objects.RiverObjects;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.OOPD_Engine.Objects.Sprite;

public class Tree extends RiverObjects {
    private final Frogger engine;
    private final int size = 50;

    /**
     * Tree method
     *
     * @param engine The engine used, needed to determine the worldsize
     * @param direction The direction the object is traveling
     * @param speed The speed the object is traveling
     **/
    public Tree(Frogger engine, TreeSize treeSize, float direction, float speed) {

        super(engine, new Sprite(treeSize.getSpritePath()), direction, speed);
        this.engine = engine;
    }
}
