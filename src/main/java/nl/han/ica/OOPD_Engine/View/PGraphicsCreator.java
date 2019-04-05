package nl.han.ica.OOPD_Engine.View;

import nl.han.ica.OOPD_Engine.Engine.GameEngine;
import processing.core.PGraphics;

/**
 * This object can make new PGraphics (canvas) objects, this is a layer used to switch between different canvasses.
 */
public class PGraphicsCreator {
	
	/**
	 * Creates a new PGraphics object.
	 * @param worldWidth
	 * @param worldHeight
	 * @return PGraphics
	 */
	public PGraphics createPGraphics(int worldWidth, int worldHeight) {
		
		return GameEngine.createPGraphics(worldWidth, worldHeight);
	}
}
