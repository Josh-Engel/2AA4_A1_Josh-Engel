package ca.mcmaster.se2aa4.mazerunner.observers;

import ca.mcmaster.se2aa4.mazerunner.status.*;

public interface Observer {
    void updateStatus(Direction direction, Coordinates coords, char previousMove);
}
