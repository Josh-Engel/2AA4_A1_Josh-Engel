package ca.mcmaster.se2aa4.mazerunner.commands;

import ca.mcmaster.se2aa4.mazerunner.status.Coordinates;

public class SetCoordinatesCommand implements Command<Integer> {
    private Coordinates coordinates;
    
    public SetCoordinatesCommand(Coordinates coords) {
        this.coordinates = coords;
    }

    @Override
    public Integer execute(Integer[] coords, char update) {
        int[] new_coords = new int[2];
        new_coords[0] = coords[0];
        new_coords[1] = coords[1];
        coordinates.setCoordinates(new_coords);
        return null;
    }
}
