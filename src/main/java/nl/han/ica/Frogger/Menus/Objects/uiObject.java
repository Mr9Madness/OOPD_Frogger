package nl.han.ica.Frogger.Menus.Objects;

import nl.han.ica.OOPD_Engine.Objects.GameObject;
import processing.core.PGraphics;

/**
 * Use this class to draw a background.
 */
public class uiObject extends GameObject {

    private int r, g, b, alpha = 255;
    private float x1, y1, x2, y2 = 0;

    /**
     * Create a new generic UI Object with a background.
     */
    public uiObject(float x1, float y1, float x2, float y2, int r, int g, int b, int alpha)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        this.r = r;
        this.g = g;
        this.b = b;
        this.alpha = alpha;
    }

    /**
     * Override or implement this method to handle updates inside this object.
     */
    @Override
    public void update() {

    }

    /**
     * Draws a background on the PGraphics object, this is fired by the GameEngine.
     */
    @Override
    public void draw(PGraphics g)
    {
        g.background(0, 0, 0, 155);

        g.fill(this.r, this.g, this.b);
        g.rect(x1, y1, x2, y2);
    }

    /**
     * Sets the background color.
     * @param r The min and max value are 0-255.
     * @param g The min and max value are 0-255.
     * @param b The min and max value are 0-255.
     * @param alpha The min and max value are 0-255.
     */
    public void setBackgroundColor(int r, int g, int b, int alpha)
    {
        this.r = r;
        this.g = g;
        this.b = b;

        this.alpha = alpha;
    }

    /**
     * Gets the red value. (0-225)
     * @return int
     */
    public int getRedValue() {

        return r;
    }

    /**
     * Gets the green value. (0-225)
     * @return int
     */
    public int getGreenValue() {

        return g;
    }

    /**
     * Gets the blue value. (0-225)
     * @return int
     */
    public int getBlueValue() {

        return b;
    }

    /**
     * Gets the alpha value. (0-225)
     * @return int
     */
    public int getAlphaValue() {

        return alpha;
    }
}
