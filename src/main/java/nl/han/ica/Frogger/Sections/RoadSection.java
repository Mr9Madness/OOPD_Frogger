package nl.han.ica.Frogger.Sections;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.Frogger.Objects.RoadObjects.Car;
import nl.han.ica.Frogger.Objects.RoadObjects.FireCar;
import nl.han.ica.Frogger.Objects.RoadObjects.Truck;
import processing.core.PVector;

/**
 * Road section is the section where road obstacles spawn and move in
 */
public class RoadSection extends Section {
    private final Frogger engine;
    private int[][] tileSection = {
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    };
    /**
     * Create a Road section and append it to the tilemap
     * @param engine Engine reference to update the tilemap
     */
    public RoadSection(Frogger engine)
    {
        super(engine, true);
        this.engine = engine;
        engine.getTileMap().setTileMap( super.appendTileMap(tileSection) );
    }

    /**
     * Implementation of spawnEntity that spawn obstacles when needed
     */
    @Override
    public void spawnEntity()
    {
        System.out.println("Direction " + pos + " / " + size+ " / engine:"+engine.height+" / view:"+engine.getView().getWorldHeight());

        engine.addGameObject(new Car(engine,270,1),60,550); //LEFT
        engine.addGameObject(new Car(engine,270,1),200,550); //LEFT
        engine.addGameObject(new Car(engine,270,1),534,550); //LEFT
        engine.addGameObject(new Car(engine,270,1),720,550); //LEFT

        engine.addGameObject(new FireCar(engine,90,2),260,500); //RIGHT
        engine.addGameObject(new FireCar(engine,90,2),90,500); //RIGHT
        engine.addGameObject(new FireCar(engine,90,2),560,500); //RIGHT

        engine.addGameObject(new Truck(engine,270,1),0,450); //LEFT
        engine.addGameObject(new Truck(engine,270,1),334,450); //LEFT
        engine.addGameObject(new Truck(engine,270,1),720,450); //LEFT
    }

    /**
     * Automatically sets this Sections own size
     */
    @Override
    public void setSize() { this.size = new PVector(tileSection[0].length * 50, (tileSection.length + 1) * 50);}
}
