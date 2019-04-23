package nl.han.ica.Frogger.Sections;

import nl.han.ica.Frogger.Vector;
import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import processing.core.PVector;

public class Section {
    protected PVector pos;
    protected PVector size;

    protected GameEngine engine;

    Section( GameEngine engine)
    {
        this.engine = engine;
    }
    Section(GameEngine engine, PVector pos, PVector size)
    {
        this.engine = engine;
        this.pos = pos;
        this.size = size;
    }

    public PVector getSize() {
        return size;
    }

    public PVector getPos() {
        return pos;
    }

    public Vector<PVector> getBounds()
    {
        return new Vector<>( new PVector(pos.x - size.x, pos.x + size.x), new PVector(pos.y - size.y, pos.y + size.y) );
    }
}
