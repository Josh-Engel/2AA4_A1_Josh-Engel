package ca.mcmaster.se2aa4.mazerunner.status;

public class PreviousMove {
    private char last_move = ' ';

    public char getPreviousMove() {
        char last_move_copy = last_move;
        return last_move_copy;
    }

    public void updatePreviousMove(char update) {
        last_move = update;
    }
}
