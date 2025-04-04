package ca.mcmaster.se2aa4.mazerunner.algorithms;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.status.*;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.commands.CommandList;
import ca.mcmaster.se2aa4.mazerunner.observers.*;

public class RightHandAlgorithm implements PathAlgorithm {
    private Maze maze;
    private final List<Observer> observers;
    private CommandList commandList;

    private static final Logger logger = LogManager.getLogger();

    public RightHandAlgorithm (Maze my_maze, List<Observer> observers, CommandList commandList) {
        maze = my_maze;
        this.observers = observers;
        this.commandList = commandList;
    }

    //finds a path through a maze by following the right wall
    public String findPath () {
        try {
            logger.trace("**** Attempting to find path");
            StringBuffer path = new StringBuffer();
            int[] entrances = maze.findEntrances();
            Integer[] integer_entrance = new Integer[2];
            integer_entrance[0] = 0;
            integer_entrance[1] = entrances[0];
            commandList.getCommand("setCoordinates").execute(integer_entrance, ' ');
            
            int exit_height = entrances[1];
            int exit_width = maze.getWidth() -1;

            logger.trace("**** Looking for open path");
            
            while (((Coordinates) commandList.getCommand("getCoordinates").execute(null,' ')).getCoords()[1] != exit_height 
                || ((Coordinates) commandList.getCommand("getCoordinates").execute(null,' ')).getCoords()[0] != exit_width) {

                    int[] current_coords = new int[2];
                    current_coords[0] = ((Coordinates) commandList.getCommand("getCoordinates").execute(null,' ')).getCoords()[0];
                    current_coords[1] = ((Coordinates) commandList.getCommand("getCoordinates").execute(null,' ')).getCoords()[1];
                    char current_dir = ((Direction) commandList.getCommand("getDirection").execute(null,' ')).getDirection();
                    if((Character) commandList.getCommand("getPreviousMove").execute(null, ' ') == 'F') {
                        switch(current_dir) {
                            case 'N':
                                if(maze.getCoordInstance(current_coords[0] +1, current_coords[1]) == 0) {
                                    path.append("R");
                                    commandList.getCommand("setPreviousMove").execute(null,'R');
                                } else if(maze.getCoordInstance(current_coords[0], current_coords[1] -1) == 0) {
                                    path.append("F");
                                    commandList.getCommand("setPreviousMove").execute(null,'F');
                                } else if(maze.getCoordInstance(current_coords[0]-1, current_coords[1]) == 0) {
                                    path.append("L");
                                    commandList.getCommand("setPreviousMove").execute(null,'L');
                                } else {
                                    path.append("LL");
                                    commandList.getCommand("setPreviousMove").execute(null,'U');
                                }
                                break;
                            case 'E':
                                if(maze.getCoordInstance(current_coords[0], current_coords[1]+1) == 0) {
                                    path.append("R");
                                    commandList.getCommand("setPreviousMove").execute(null,'R');
                                } else if(maze.getCoordInstance(current_coords[0]+1, current_coords[1]) == 0) {
                                    path.append("F");
                                    commandList.getCommand("setPreviousMove").execute(null,'F');
                                } else if(maze.getCoordInstance(current_coords[0], current_coords[1]-1) == 0) {
                                    path.append("L");
                                    commandList.getCommand("setPreviousMove").execute(null,'L');
                                } else {
                                    path.append("LL");
                                    commandList.getCommand("setPreviousMove").execute(null,'U');
                                }
                                break;
                            case 'S':
                                if(maze.getCoordInstance(current_coords[0]-1, current_coords[1]) == 0) {
                                    path.append("R");
                                    commandList.getCommand("setPreviousMove").execute(null,'R');
                                } else if(maze.getCoordInstance(current_coords[0], current_coords[1]+1) == 0) {
                                    path.append("F");
                                    commandList.getCommand("setPreviousMove").execute(null,'F');
                                } else if(maze.getCoordInstance(current_coords[0]+1, current_coords[1]) == 0) {
                                    path.append("L");
                                    commandList.getCommand("setPreviousMove").execute(null,'L');
                                } else {
                                    path.append("LL");
                                    commandList.getCommand("setPreviousMove").execute(null,'U');
                                }
                                break;
                            case 'W':
                                if(maze.getCoordInstance(current_coords[0], current_coords[1]-1) == 0) {
                                    path.append("R");
                                    commandList.getCommand("setPreviousMove").execute(null,'R');
                                } else if(maze.getCoordInstance(current_coords[0]-1, current_coords[1]) == 0) {
                                    path.append("F");
                                    commandList.getCommand("setPreviousMove").execute(null,'F');
                                } else if(maze.getCoordInstance(current_coords[0], current_coords[1]+1) == 0) {
                                    path.append("L");
                                    commandList.getCommand("setPreviousMove").execute(null,'L');
                                } else {
                                    path.append("LL");
                                    commandList.getCommand("setPreviousMove").execute(null,'U'); 
                                }
                                break;
                        }
                    } else {
                        path.append("F");
                        commandList.getCommand("setPreviousMove").execute(null,'F');
                    }
                    char previous_move = (Character) commandList.getCommand("getPreviousMove").execute(null, ' ');
                    for(Observer observer: observers) {
                        observer.updateStatus((Direction) commandList.getCommand("getDirection").execute(null, ' '),
                            (Coordinates) commandList.getCommand("getCoordinates").execute(null, ' '), previous_move);
                    }
            }
            return path.toString();
        } catch(Exception e) {
            logger.error("/!\\ Path couldn't be computed /!\\");
            throw e;
        }
    }
}