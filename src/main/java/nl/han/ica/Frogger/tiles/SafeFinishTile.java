package nl.han.ica.Frogger.tiles;

import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Tile.Tile;

public class SafeFinishTile extends Tile
{
    public SafeFinishTile(Sprite sprite) {
        super(sprite);
    }

    public void Finish()
    {
        // Scherm laten zien dat speler heeft gewonnen als er 3 frogs op hun plek staan!
    }
}