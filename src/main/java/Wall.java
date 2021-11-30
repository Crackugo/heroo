public class Wall {
    private Position position = new Position(0,0);
    public Wall(int c, int i) {
        position.setX(c);
        position.setY(i);
    }
    public Position getPos(){
        return position;
    }
}
