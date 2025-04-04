package ca.mcmaster.se2aa4.mazerunner.commands;

import ca.mcmaster.se2aa4.mazerunner.status.PreviousMove;

public class GetPreviousMoveCommand implements Command<Character> {
    PreviousMove previous;
    
    public GetPreviousMoveCommand(PreviousMove prev) {
        previous = prev;
    }

    @Override
    public Character execute(Integer[] coords, char update) {
        return previous.getPreviousMove();
    }
}
