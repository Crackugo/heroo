public class Coin {
    private Position position = new Position(0,0);
    public Coin(int c, int i) {
        position.setX(c);
        position.setY(i);
    }
    public Position getPos(){
        return position;
    }
}
