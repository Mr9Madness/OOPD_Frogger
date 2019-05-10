package nl.han.ica.Frogger.Tiles;

import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Tile.Tile;

/**
 * Safe tile are the Tiles between Sections which the player can rest and think on
 */
public class SafeTile extends Tile
{
    /**
     * Constructs a Safe tile with the safe tile sprite
     * @param sprite the safe tile sprite
     */
    public SafeTile(Sprite sprite) { super(sprite); }
}
