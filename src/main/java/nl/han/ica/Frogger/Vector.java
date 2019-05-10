package nl.han.ica.Frogger;

/**
 * A vector that holds two items x and y based of the given type
 * @param <T> Given type that needs to be stored
 */
public class Vector<T> {
    public T X;
    public T Y;

    /**
     * Creates a instance with the given values
     * @param x X value of the instance
     * @param y Y value of the instance
     */
    public Vector(T x, T y )
    {
        this.X = x;
        this.Y = y;
    }
}
