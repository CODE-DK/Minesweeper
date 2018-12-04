package Sweeper;

public class Game {

    private BombLayout bomb;
    private FlagLayout flag;

    public Game(int cols, int rows, int initBombs) {
        Ranges.getRanges().setSize(new Coord(cols, rows));
        bomb = new BombLayout(initBombs);
        flag = new FlagLayout();
    }

    public Box getBox (Coord coord){

        if (flag.get(coord) == Box.OPENED){
            return bomb.get(coord);
        }
        else
            return flag.get(coord);
    }

    public void start() {
        bomb.start();
        flag.start();
    }

    public void pressLeftButton(Coord coord) {

        flag.setOpenedToBox (coord);
    }

    public void pressRightButton(Coord coord) {

        flag.toggleFlagedToBox (coord);
    }
}
