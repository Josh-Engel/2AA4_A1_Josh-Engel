package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Path {
    private String path;
    private int[][] maze;

    private static final Logger logger = LogManager.getLogger();

    public int[] findEntrances () {
        int[] entrances = new int[2];
        for (int i = 0; i < maze.length; i++) {
            if (maze[i][0] == 0) {
                entrances[0] = i;
            } else if (maze[i][maze[0].length-1] == 0) {
                entrances[1] = i;
            }
        }
        return entrances;
    }

}