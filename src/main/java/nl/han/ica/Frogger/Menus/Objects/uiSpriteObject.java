package nl.han.ica.Frogger.Menus.Objects;

import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Objects.SpriteObject;

/**
 * A generic class that draws a sprite
 */
public class uiSpriteObject extends SpriteObject {
    /**
     * Constructs a ui object with a sprite
     * @param sprite
     */
    public uiSpriteObject( Sprite sprite)
    {
        super(sprite);
    }

    /**
     * Update loop activated by gameobject
     */
    @Override
    public void update() {

    }
}
