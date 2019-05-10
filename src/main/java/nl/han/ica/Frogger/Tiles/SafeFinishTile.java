package nl.han.ica.Frogger.Tiles;

import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Tile.Tile;

/**
 * Safe finish tile which is used to show the ending tile and check if player is on the exit
 */
public class SafeFinishTile extends Tile
{
    /**
     * Constructs a safe finish tile with the safe finish sprite
     * @param sprite the safe finish sprite
     */
    public SafeFinishTile(Sprite sprite) {
        super(sprite);
    }
}
