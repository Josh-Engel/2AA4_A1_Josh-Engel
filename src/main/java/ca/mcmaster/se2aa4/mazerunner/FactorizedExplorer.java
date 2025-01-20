package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FactorizedExplorer extends Explorer {
    private String path;
    private int[][] maze;

    private static final Logger logger = LogManager.getLogger();

    public FactorizedExplorer (String path, int[][] maze) {
        this.path = path;
        this.maze = maze;
    }

    public int[] findEntrances () {
        System.out.println("hi");
        int[] entrances = new int[2];
        System.out.println("hi");
        for (int i = 0; i < maze.length; i++) {
            System.out.println(i);
            if (maze[i][0] == 0) {
                entrances[0] = i;
            } else if (maze[i][maze[0].length-1] == 0) {
                entrances[1] = i;
            }
        }
        return entrances;
    }

    public boolean explore () {
        return true;
    }
}