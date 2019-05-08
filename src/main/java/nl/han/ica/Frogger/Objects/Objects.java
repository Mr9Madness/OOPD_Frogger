package nl.han.ica.Frogger.Objects;

import nl.han.ica.Frogger.Frogger;
import nl.han.ica.OOPD_Engine.Objects.AnimatedSpriteObject;
import nl.han.ica.OOPD_Engine.Objects.Sprite;
import nl.han.ica.OOPD_Engine.Objects.GameObject;
import nl.han.ica.OOPD_Engine.Objects.SpriteObject;

public class Objects extends SpriteObject {

    private final Frogger engine;
    /**
     * The main object method, this also handles the updating of the objects
     *
     * @param engine The engine used, needed to determine the worldsize
     * @param sprite The sprite that is used for the object
     * @param direction The direction the object is traveling
     * @param speed The speed the object is traveling
     **/
    public Objects(Frogger engine,Sprite sprite, float direction, float speed) {
        super(sprite);
        this.engine = engine;
        setDirectionSpeed(direction, speed);
    }

    public boolean test(){
        System.out.println(this.engine.getGameObjectItems().size()+" / test Direction "+this.getDirection()+ " / X: "+this.getX()+"/"+engine.width+" / Y:"+y+"/"+engine.getView().getWorldHeight());
        for (int i=0; (i < this.engine.getGameObjectItems().size()); i++){
            GameObject goTest = this.engine.getGameObjectItems().elementAt(i);
            System.out.println("Check["+i+"]: "+goTest.getX()+"/"+getX()+" en "+goTest.getY()+"/"+getY()+" / Direction: "+goTest.getDirection());
            if (goTest.getX()==x && goTest.getY()==y) {
                    System.out.println("Dubbel met "+i+" op X:"+x+" / Y:"+y);
                    //engine.deleteGameObject();
            }
        }

        return true;
    }

    @Override
    public void update() {
        //engine.pauseGame();



      //  System.out.println("Direction "+getDirection()+ " / X: "+getX()+"/"+engine.width+" / Y:"+y+"/"+engine.getView().getWorldHeight());

        //System.out.println("section "+getPrevX());
        if (getDirection() == 0 && (getY() + getHeight()) >= engine.height) // UP
            setY(0-getHeight());
        if (getDirection() == 90 && (getX() + getWidth()) >= engine.width+getWidth()) // RIGHT
            setX(0-getWidth());
        if (getDirection() == 180 && (getY() + getHeight()) >= engine.height) // DOWN
            setY(engine.width+getHeight());
        if (getDirection() == 270 && (getX() + getWidth()) <= 0-getWidth()) // LEFT
            setX(engine.width);
    }

    @Override
    public void move() {
        super.move();
    }
}
