package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CanonicalPath extends Path {
    private String path;
    private int[][] maze;

    private static final Logger logger = LogManager.getLogger();

    public CanonicalPath (int[][] maze) {
        this.path = "";
        this.maze = maze;
    }
}