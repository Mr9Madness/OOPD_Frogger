package nl.han.ica.Frogger.sections;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.Frogger.Objects.RoadObjects.Car;
import nl.han.ica.Frogger.Objects.RoadObjects.FireCar;
import nl.han.ica.Frogger.Objects.RoadObjects.Truck;

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
        System.out.println("Direction " + pos + " / " + size);
        engine.addGameObject(new Car(engine,270,1),60,800); //LEFT
        engine.addGameObject(new Car(engine,270,1),200,800); //LEFT
        engine.addGameObject(new Car(engine,270,1),534,800); //LEFT
        engine.addGameObject(new Car(engine,270,1),720,800); //LEFT

        engine.addGameObject(new FireCar(engine,90,2),260,735); //RIGHT
        engine.addGameObject(new FireCar(engine,90,2),90,735); //RIGHT
        engine.addGameObject(new FireCar(engine,90,2),560,735); //RIGHT

        engine.addGameObject(new Truck(engine,270,1),0,690); //LEFT
        engine.addGameObject(new Truck(engine,270,1),334,690); //LEFT
        engine.addGameObject(new Truck(engine,270,1),720,690); //LEFT
//
//        engine.addGameObject(new Car(engine,90,1),0,pos.y + 50 - 60000); //RIGHT
//        engine.addGameObject(new Truck(engine,90,1),500,pos.y); //RIGHT
//        engine.addGameObject(new FireCar(engine,90,1),260,pos.y + 100); //RIGHT
//
//        engine.addGameObject(new Car(engine,270,1),engine.width,pos.y); //LEFT
////        engine.addGameObject(new Car(engine,180,20),20,engine.height+20);
//        engine.addGameObject(new Car(engine,270,10),70, engine.height);
//        System.out.println("object spawned at " + engine.height+60 );
//1
        //    engine.addGameObject(new Car(engine,270,10),50,engine.height+10);

      //  engine.addGameObject(new Car(engine,180,180),30,engine.height);
    }
}
