package ca.mcmaster.se2aa4.mazerunner.status;

public class Coordinates {
    private int coords[];

    public Coordinates(int[] coords) {
        this.coords = new int[2];
        this.coords = coords;
    }

    public void setCoordinates(int[] coords) {
        this.coords[0] = coords[0];
        this.coords[1] = coords[1];
    }

    public int[] getCoords() {
        int returnedCoords[] = coords;
        return returnedCoords;
    }

    public void adjustX(int shift) {
        coords[0] += shift;
    }

    public void adjustY(int shift) {
        coords[1] += shift;
    }
}
