import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero = new Hero(5,5);
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) +
                    1, random.nextInt(height - 2) + 1));
        return coins;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Arena(int w, int h) {
        width = w;
        height = h;
        this.walls = createWalls();
        this.coins = createCoins();
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
    public void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp) {
            moveHero(hero.moveUp());
        }
        if (key.getKeyType() == KeyType.ArrowDown) {
            moveHero(hero.moveDown());
        }
        if (key.getKeyType() == KeyType.ArrowRight) {
            moveHero(hero.moveRight());
        }
        if (key.getKeyType() == KeyType.ArrowLeft) {
            moveHero(hero.moveLeft());
        }
    }
    private void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
        }
    }

    private boolean canHeroMove(Position position){
        for (Wall wall : walls) {
            if (wall.getPos().equals(position)) {
                return false;
            }
        }
        return true;
    }



    public void draw(@org.jetbrains.annotations.NotNull Screen screen) {
        screen.setCharacter(hero.getPos().getX(), hero.getPos().getY(), TextCharacter.fromCharacter('X')[0]);
        for (Wall wall : walls) {
            screen.setCharacter(wall.getPos().getX(), wall.getPos().getY(), TextCharacter.fromCharacter('O')[0]);
        }
        for (Coin wall : coins) {
            screen.setCharacter(wall.getPos().getX(), wall.getPos().getY(), TextCharacter.fromCharacter('C')[0]);
        }
    }



}
