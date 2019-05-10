package nl.han.ica.Frogger.Tiles;

import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Tile.Tile;

/**
 * Water tile is used to check if the player is in water and show the water
 */
public class WaterTile extends Tile {

    /**
     * Constructs a water tile with the water sprite
     * @param sprite the water sprite
     */
    public WaterTile(Sprite sprite) {
        super(sprite);
    }
}
