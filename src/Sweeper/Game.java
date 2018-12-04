package Sweeper;

public class Game {

    private BombLayout bomb;

    public Game(int cols, int rows, int initBombs) {
        Ranges.getRanges().setSize(new Coord(cols, rows));
        bomb = new BombLayout(initBombs);
    }

    public Box getBox (Coord coord){
        return bomb.get(coord);
    }

    public void start() {
        bomb.start();
    }
}
