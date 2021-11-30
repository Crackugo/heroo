import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;



public class Hero {
    private Position position=new Position(10,10);
    public Hero(int xx, int yy) {
        position.setX(xx);
        position.setY(yy);
    }


    public Position getPos(){
        return position;
    }

    public void setPosition(Position pos) {
        position = pos;
    }


    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }

    public Position moveRight() {
        return new Position(position.getX()+1, position.getY());
    }

    public Position moveLeft() {
        return new Position(position.getX()-1, position.getY());
    }



}
