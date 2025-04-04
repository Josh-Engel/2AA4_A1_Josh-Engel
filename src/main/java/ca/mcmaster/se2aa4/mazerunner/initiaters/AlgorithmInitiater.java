package ca.mcmaster.se2aa4.mazerunner.initiaters;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.algorithms.PathAlgorithm;
import ca.mcmaster.se2aa4.mazerunner.algorithms.RightHandAlgorithm;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.observers.*;
import ca.mcmaster.se2aa4.mazerunner.commands.*;
import ca.mcmaster.se2aa4.mazerunner.status.*;

//initiates in case of need of an algorithm
public class AlgorithmInitiater implements Initiater {
    private final List<Observer> observers = new ArrayList<>();
    private Direction direction = new Direction('E');
    private int[] initial_coords = new int[] {0,0};
    private Coordinates coords = new Coordinates(initial_coords);
    private PreviousMove previous = new PreviousMove();
    private CommandList commandList = new CommandList(direction, coords, previous);

    private PathAlgorithm algorithm;
    private static final Logger logger = LogManager.getLogger();
    
    public void initiate(String pathString, Maze maze) {
        observers.add(new CoordinateObserver());
        observers.add(new DirectionObserver());
        commandList.defaultList();

        logger.info("**** Computing path");
        //PathAlgorithm straight_line_algorithm = new StraightLineAlgorithm(my_maze);
        //String computed_path = straight_line_algorithm.findPath();
        algorithm = new RightHandAlgorithm(maze, observers, commandList);
    }

    public PathAlgorithm getAlgorithm() {
        return algorithm;
    }
}
