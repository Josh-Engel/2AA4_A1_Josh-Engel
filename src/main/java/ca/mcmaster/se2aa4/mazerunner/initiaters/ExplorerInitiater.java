package ca.mcmaster.se2aa4.mazerunner.initiaters;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.Explorer;
import ca.mcmaster.se2aa4.mazerunner.FactorConvert;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.observers.*;
import ca.mcmaster.se2aa4.mazerunner.commands.*;
import ca.mcmaster.se2aa4.mazerunner.status.*;

//Initiates in case of need of an explorer
public class ExplorerInitiater implements Initiater {
    private final List<Observer> observers = new ArrayList<>();
    private Direction direction = new Direction('E');
    private int[] initial_coords = new int[] {0,0};
    private Coordinates coords = new Coordinates(initial_coords);
    private PreviousMove previous = new PreviousMove();
    private CommandList commandList = new CommandList(direction, coords, previous);

    private Explorer explorer;
    private static final Logger logger = LogManager.getLogger();
    private FactorConvert converter = new FactorConvert();
    
    public void initiate(String path_string, Maze maze) {
        boolean canon = true;
        observers.add(new CoordinateObserver());
        observers.add(new DirectionObserver());
        commandList.defaultList();

        logger.trace("**** Checking type of path input");
                for(int i = 0; i < path_string.length(); i++) {
                    if(path_string.charAt(i) != 'F' && path_string.charAt(i) != 'L' && path_string.charAt(i) != 'R') {
                        canon = false;
                        break;
                    }
                }
                logger.info("**** Checking if path is valid");
                if (canon != true) {
                    path_string = converter.toCanon(path_string);  
                }
                explorer = new Explorer(path_string, maze, observers, commandList);
    }

    public Explorer getExplorer() {
        return explorer;
    }
}
