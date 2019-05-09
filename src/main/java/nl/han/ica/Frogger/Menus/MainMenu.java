package nl.han.ica.Frogger.Menus;

import nl.han.ica.OOPD_Engine.Dashboard.Dashboard;

public class MainMenu extends Dashboard {

    private long startTime = 0;
    private long stopTime = 0;
    private long resultTimeInSeconds = 0;

    public MainMenu( float worldWidth, float worldHeight )
    {
        super(0, 0, worldWidth, worldHeight);
    }

    public void start()
    {
        this.startTime = System.currentTimeMillis();
    }

    public void stop()
    {
        this.stopTime = System.currentTimeMillis();
        resultTimeInSeconds = ((stopTime - startTime) / 1000);
    }
}
