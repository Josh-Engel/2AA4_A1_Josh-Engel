package ca.mcmaster.se2aa4.mazerunner.algorithms;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.commands.*;
import ca.mcmaster.se2aa4.mazerunner.observers.*;
import ca.mcmaster.se2aa4.mazerunner.status.Coordinates;
import ca.mcmaster.se2aa4.mazerunner.status.Direction;

public class StraightLineAlgorithm implements PathAlgorithm {
    private Maze maze;
    private final List<Observer> observers;
    private CommandList commandList;

    private static final Logger logger = LogManager.getLogger();

    public StraightLineAlgorithm (Maze my_maze, List<Observer> observers, CommandList commandList) {
        maze = my_maze;
        this.observers = observers;
        this.commandList = commandList;
    }

    //finds a straight line path through a maze
    public String findPath () {
        try {
            logger.trace("**** Attempting to find path");
            int length = 0;
            StringBuffer path = new StringBuffer();
            int[] entrances = maze.findEntrances();
            Integer[] integer_entrance = new Integer[2];
            integer_entrance[0] = 0;
            integer_entrance[1] = entrances[0];
            commandList.getCommand("setCoordinates").execute(integer_entrance, ' ');
            
            int[] position = new int[2];
            while (((Coordinates) commandList.getCommand("getCoordinates").execute(null,' ')).getCoords()[0] < maze.getWidth() -1) {
                position[0] = ((Coordinates) commandList.getCommand("getCoordinates").execute(null, ' ')).getCoords()[0];
                position[1] = ((Coordinates) commandList.getCommand("getCoordinates").execute(null, ' ')).getCoords()[1];
                if (maze.getCoordInstance(position[0], position[1]) == 0) {
                    length++;
                    
                } else {
                    throw new IllegalStateException("/!\\ Path could not be computed /!\\");
                }
                commandList.getCommand("setPreviousMove").execute(null, 'F');
                char previous_move = (Character) commandList.getCommand("getPreviousMove").execute(null, ' ');
                for(Observer observer: observers) {
                    observer.updateStatus((Direction) commandList.getCommand("getDirection").execute(null, ' '),
                        (Coordinates) commandList.getCommand("getCoordinates").execute(null, ' '), previous_move);
                }
            }
            for (int j = 1; j < length; j++) {
                path.append("F");
            }
            return path.toString();
        } catch(IllegalStateException e) {
            logger.error(e);
            throw e;
        }
    }
}