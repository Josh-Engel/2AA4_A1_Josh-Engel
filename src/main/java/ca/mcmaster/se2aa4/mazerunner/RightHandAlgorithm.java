package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandAlgorithm implements PathAlgorithm {
    private int[][] maze;

    private static final Logger logger = LogManager.getLogger();

    public RightHandAlgorithm (int[][] maze) {
        this.maze = maze;
    }

    //finds a path through a maze by following the right wall
    public String findPath () {
        try {
            logger.trace("**** Attempting to find path");
            int length = 0;
            StringBuffer path = new StringBuffer();
            int[] entrances = this.findEntrances();
            
            int height_idx = entrances[0];
            int width_idx = 0;
            int exit_height = entrances[1];
            int exit_width = maze[0].length - 1;
            Direction direction = new Direction('E');
            int[] dir_vector = new int[2];

            while (height_idx != exit_height || width_idx != exit_width) {
                direction.turnRight();
                dir_vector = direction.getDirVector();
                if(maze[height_idx + dir_vector[1]][ width_idx + dir_vector[0]] == 1) {
                    direction.turnLeft();
                    dir_vector = direction.getDirVector();
                    if (maze[height_idx + dir_vector[1]][ width_idx + dir_vector[0]] == 1) {
                        direction.turnLeft();
                        dir_vector = direction.getDirVector();
                        if (maze[height_idx + dir_vector[1]][ width_idx + dir_vector[0]] == 1) {
                            direction.turnLeft();
                            dir_vector = direction.getDirVector();
                            path.append("LLF");
                        } else {
                            path.append("LF");
                        }
                    } else {
                        path.append("F");
                    }
                } else {
                    path.append("RF");
                }
                height_idx += dir_vector[1];
                width_idx += dir_vector[0];
            }
            return path.toString();
        } catch(Exception e) {
            logger.error("/!\\ Path couldn't be computed /!\\");
            throw e;
        }
    }

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
}