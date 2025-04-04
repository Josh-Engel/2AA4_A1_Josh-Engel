package ca.mcmaster.se2aa4.mazerunner.commands;

import ca.mcmaster.se2aa4.mazerunner.status.PreviousMove;

public class SetPreviousMoveCommand implements Command<Integer>{
    PreviousMove previous;
    
    public SetPreviousMoveCommand(PreviousMove prev) {
        previous = prev;
    }

    @Override
    public Integer execute(Integer[] coords, char update) {
        previous.updatePreviousMove(update);
        return null;
    }
}
