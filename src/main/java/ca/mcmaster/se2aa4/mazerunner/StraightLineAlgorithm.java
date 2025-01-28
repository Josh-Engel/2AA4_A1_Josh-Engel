package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StraightLineAlgorithm implements PathAlgorithm {
    private int[][] maze;

    private static final Logger logger = LogManager.getLogger();

    public StraightLineAlgorithm (int[][] maze) {
        this.maze = maze;
    }

    //finds a straight line path through a maze
    public String findPath () {
        try {
            logger.trace("**** Attempting to find path");
            int length = 0;
            StringBuffer path = new StringBuffer();
            int[] entrances = this.findEntrances();
            for (int i = 0; i < maze[0].length; i++) {
                if (maze[entrances[0]][i] == 0) {
                    length++;
                } else {
                    throw new IllegalStateException("/!\\ Path could not be computed /!\\");
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