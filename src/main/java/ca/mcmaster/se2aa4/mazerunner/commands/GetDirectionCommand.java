package ca.mcmaster.se2aa4.mazerunner.commands;

import ca.mcmaster.se2aa4.mazerunner.status.Direction;

public class GetDirectionCommand implements Command<Direction> {
    private Direction direction;
    
    public GetDirectionCommand(Direction dir) {
        this.direction = dir;
    }

    @Override
    public Direction execute(Integer[] coords, char update) {
        return direction;
    }
}
