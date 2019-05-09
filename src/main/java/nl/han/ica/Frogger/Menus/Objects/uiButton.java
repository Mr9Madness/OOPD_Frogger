package nl.han.ica.Frogger.Menus.Objects;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.OOPD_Engine.Objects.GameObject;
import processing.core.PGraphics;

public class uiButton extends GameObject {

    private int r, g, b, alpha = 255;
    private float x, y, width, height;
    private String text;

    private Frogger callback;

    /**
     * Create a new generic UI Button.
     */
    public uiButton(float x, float y, float width, float height, String text, Frogger callback)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.callback = callback;
    }

    /**
     * Create a new generic UI Button with color.
     */
    public uiButton(float x, float y, float width, float height, String text, int r, int g, int b, int alpha, Frogger callback)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;

        this.r = r;
        this.g = g;
        this.b = b;
        this.alpha = alpha;
        this.callback = callback;
    }

    private boolean isOver( float mX, float mY )
    {
        return mX > this.x && mX < this.x + this.width && mY > this.y && mY < this.y + this.height;
    }

    /**
     * Checks if the mouse on over this button and if clicked is true executes given function
     * @param x Vertical position of the mouse
     * @param y Horizontal position of the mouse
     * @param clicked True if mouse is pressed
     */
    public void mouseUpdate(float x, float y, boolean clicked)
    {
        if( isOver( x, y ) && clicked )
        {
            callback.RestartGame();
        }
    }

    /**
     * Update loop activated by gameobject
     */
    @Override
    public void update() { }

    /**
     * Draws a background on the PGraphics object, this is fired by the GameEngine.
     */
    @Override
    public void draw(PGraphics g)
    {
        g.fill(this.r, this.g, this.b);
        g.rect(x, y, width, height);

        g.fill(255, 255, 255, 255);
        g.textAlign( CENTER, CENTER );
        g.text( text, x + (width / 2), y + (height / 2));
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