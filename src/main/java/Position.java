public class Position {
    private int y;
    private int x;

    public Position(int xx, int yy) {
        x = xx;
        y = yy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return x == p.getX() && y == p.getY();
    }

    public void setX(int xx) {
        x = xx;
    }

    public void setY(int yy) {
        y = yy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    




    
}

