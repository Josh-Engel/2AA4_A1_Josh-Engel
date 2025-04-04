package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ca.mcmaster.se2aa4.mazerunner.commands.CommandList;
import ca.mcmaster.se2aa4.mazerunner.status.Coordinates;
import ca.mcmaster.se2aa4.mazerunner.status.Direction;
import ca.mcmaster.se2aa4.mazerunner.observers.*;

public class Explorer {
    private String path;
    private Maze maze;
    private final List<Observer> observers;
    private CommandList commandList;

    private static final Logger logger = LogManager.getLogger();

    //constructor
    public Explorer (String path, Maze my_maze, List<Observer> observers, CommandList commandList) {
        this.path = path;
        maze = my_maze;
        this.observers = observers;
        this.commandList = commandList;
    }

    //checks for validity of path
    public boolean explore () {
        try {
            int error = 0;
            int[] entrances = maze.findEntrances();
            Integer[] integer_entrance = new Integer[2];
            integer_entrance[0] = 0;
            integer_entrance[1] = entrances[0];
            commandList.getCommand("setCoordinates").execute(integer_entrance, ' ');

            int exit_height = entrances[1];
            int exit_width = maze.getWidth()-1;
            logger.trace("**** Moving through the maze");
            for (int j = 0; j <2 ; j++) {
                if (j == 1) {
                    commandList.getCommand("setDirection").execute(null, 'W');
                    integer_entrance[1] = entrances[1];
                    integer_entrance[0] = maze.getWidth()-1;
                    commandList.getCommand("setCoordinates").execute(integer_entrance, ' ');
                    exit_height = entrances[0];
                    exit_width = 0;
                }
                for (int i = 0; i < path.length(); i++) {
                    char instruction = path.charAt(i);
                    if (instruction == 'L') {
                        commandList.getCommand("setPreviousMove").execute(null,'L');
                    } else if (instruction == 'R') {
                        commandList.getCommand("setPreviousMove").execute(null,'R');
                    } else {
                        commandList.getCommand("setPreviousMove").execute(null,'F');
                    }

                    char previous_move = (Character) commandList.getCommand("getPreviousMove").execute(null, ' ');
                    for(Observer observer: observers) {
                        observer.updateStatus((Direction) commandList.getCommand("getDirection").execute(null, ' '),
                            (Coordinates) commandList.getCommand("getCoordinates").execute(null, ' '), previous_move);
                    }
                    int[] current_coords = new int[2];
                    current_coords[0] = ((Coordinates) commandList.getCommand("getCoordinates").execute(null,' ')).getCoords()[0];
                    current_coords[1] = ((Coordinates) commandList.getCommand("getCoordinates").execute(null,' ')).getCoords()[1];
                    
                    if (maze.getCoordInstance(current_coords[0],current_coords[1]) == 1) {
                        break;
                    }
                }
                if (((Coordinates) commandList.getCommand("getCoordinates").execute(null,' ')).getCoords()[1] != exit_height 
                    || ((Coordinates) commandList.getCommand("getCoordinates").execute(null,' ')).getCoords()[0] != exit_width) {
                        error++;
                }
            }
            if (error > 1) {
                return false;
            } else {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //under assumption that even if a path hits no walls if it ends up out of bounds or goes out of bounds at any point its not valid
            return false;
        }
    }
}