package ca.mcmaster.se2aa4.mazerunner.commands;

import ca.mcmaster.se2aa4.mazerunner.status.Coordinates;

public class GetCoordinatesCommand implements Command<Coordinates> {
    private Coordinates coordinates;
    
    public GetCoordinatesCommand(Coordinates coords) {
        this.coordinates = coords;
    }

    @Override
    public Coordinates execute(Integer[] coords, char update) {
        return coordinates;
    }
}
