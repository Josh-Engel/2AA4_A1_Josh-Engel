package ca.mcmaster.se2aa4.mazerunner.observers;

import ca.mcmaster.se2aa4.mazerunner.status.*;

//updates direction
public class DirectionObserver implements Observer {
    
    public void updateStatus(Direction direction, Coordinates coords, char previousMove) {
        if (previousMove == 'R') {
            direction.turnRight();
        } else if (previousMove == 'L') {
            direction.turnLeft();
        } else if (previousMove == 'U') {
            direction.uTurn();
        }
    }
}
