package ca.mcmaster.se2aa4.mazerunner.commands;

import ca.mcmaster.se2aa4.mazerunner.status.Direction;

public class SetDirectionCommand implements Command<Integer> {
    private Direction direction;
    
    public SetDirectionCommand(Direction dir) {
        this.direction = dir;
    }

    @Override
    public Integer execute(Integer[] coords, char update) {
        direction.setDirection(update);
        return null;
    }
}
