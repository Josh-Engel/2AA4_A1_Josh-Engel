package ca.mcmaster.se2aa4.mazerunner.observers;

import ca.mcmaster.se2aa4.mazerunner.status.*;

//updates coordinates
public class CoordinateObserver implements Observer {
    
    public void updateStatus(Direction direction, Coordinates coords, char previousMove) {
        if (previousMove == 'F') {
            switch(direction.getDirection()) {
                case 'N':
                    coords.adjustY(-1);
                    break;
                case 'E':
                    coords.adjustX(1);
                    break;
                case 'S':
                    coords.adjustY(1);
                    break;
                case 'W':
                    coords.adjustX(-1);
                    break;
            }
        }
    }
}
