package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Explorer {
    private String path;
    private int[][] maze;

    private static final Logger logger = LogManager.getLogger();

    //constructor
    public Explorer (String path, int[][] maze) {
        this.path = path;
        this.maze = maze;
    }

    //finds the entrances to the maze
    public int[] findEntrances () {
        logger.trace("**** Finding valid entrances");
        int[] entrances = new int[2];
        for (int i = 0; i < maze.length; i++) {
            if (maze[i][0] == 0) {
                entrances[0] = i;
            } 
            if (maze[i][maze[0].length-1] == 0) {
                entrances[1] = i;
            }
        }
        return entrances;
    }

    //checks for validity of path
    public boolean explore () {
        try {
            int error = 0;
            int height_idx = 0;
            int width_idx = 0;
            int exit_height = 0;
            int exit_width = 0;
            int[] entrances = findEntrances();
            height_idx = entrances[0];
            exit_height = entrances[1];
            exit_width = maze[0].length-1;
            Direction direction = new Direction('E');
            logger.trace("**** Moving through the maze");
            for (int j = 0; j <2 ; j++) {
                if (j == 1) {
                    direction.setDirection('W');
                    height_idx = entrances[1];
                    width_idx = maze[0].length-1;
                    exit_height = entrances[0];
                    exit_width = 0;
                }
                for (int i = 0; i < path.length(); i++) {
                    char instruction = path.charAt(i);
                    if (instruction == 'L') {
                        direction.turnLeft();
                    } else if (instruction == 'R') {
                        direction.turnRight();
                    } else {
                        if (direction.getDirection() == 'N') {
                            height_idx--;
                        } else if (direction.getDirection() == 'E') {
                            width_idx++;
                        } else if (direction.getDirection() == 'S') {
                            height_idx++;
                        } else {
                            width_idx--;
                        }
                    }
                    if (maze[height_idx][width_idx] == 1) {
                        break;
                    }
                }
                if (height_idx != exit_height || width_idx != exit_width) {
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