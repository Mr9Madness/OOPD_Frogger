package nl.han.ica.OOPD_Engine.Exceptions;

/**
 * Used by the TileType object.
 */
public class TileNotFoundException extends RuntimeException {

    public TileNotFoundException(String message) {
        super(message);
    }
}
