package Sweeper;

class FlagLayout {
    private Matrix flagMatrix;

    void start(){
        flagMatrix = new Matrix(Box.CLOSED);
    }

    Box get (Coord coord){
        return flagMatrix.getMatrix(coord);
    }

    void setOpenedToBox(Coord coord) {

        flagMatrix.setMatrix(coord, Box.OPENED);
    }


    void toggleFlagedToBox(Coord coord) {

        switch (flagMatrix.getMatrix(coord)){

            case FLAGED: setClosedToBox(coord);
                break;
            case CLOSED: setFlagedToBox(coord);
                break;
        }
    }

    private void setFlagedToBox(Coord coord) {

        flagMatrix.setMatrix(coord, Box.FLAGED);

    }

    private void setClosedToBox(Coord coord) {

        flagMatrix.setMatrix(coord, Box.CLOSED);
    }
}
