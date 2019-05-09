package nl.han.ica.Frogger.sections;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.Frogger.Objects.RoadObjects.Car;
import nl.han.ica.Frogger.Objects.RoadObjects.FireCar;
import nl.han.ica.Frogger.Objects.RoadObjects.Truck;
import processing.core.PVector;

public class RoadSection extends Section {
    private final Frogger engine;
    private int[][] tileSection = {
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    };

    public RoadSection(Frogger engine)
    {
        super(engine, true);
        this.engine = engine;
        engine.getTileMap().setTileMap( super.appendTileMap(tileSection) );
    }

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

    @Override
    public void setSize() { this.size = new PVector(tileSection[0].length * 50, (tileSection.length + 1) * 50);}
}
