package nl.han.ica.Frogger.Menus.Objects;

import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Objects.SpriteObject;
import processing.core.PVector;

public class uiSpriteObject extends SpriteObject {

    public uiSpriteObject( Sprite sprite)
    {
        super(sprite);
    }

    public uiSpriteObject(PVector pos, Sprite sprite)
    {
        this(sprite);
        this.setX(pos.x);
        this.setY(pos.y);
    }

    @Override
    public void update() {

    }
}
