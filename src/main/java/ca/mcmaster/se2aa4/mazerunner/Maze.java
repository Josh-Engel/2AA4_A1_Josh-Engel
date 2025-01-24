package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {
    private int[][] maze;
    private int width;
    private int height;

    private static final Logger logger = LogManager.getLogger();

    //constructor
    public Maze (String maze_file) {
        try {
            logger.trace("**** Creating maze array");
            BufferedReader index = new BufferedReader(new FileReader(maze_file));
            String line;
            this.width = 0;
            this.height = 0;
            int line_idx = 0;

            while ((line = index.readLine()) != null) {
                height++;
                width = line.length();
            }

            this.maze = new int[height][width];

            index.close();
            BufferedReader reader = new BufferedReader(new FileReader(maze_file));
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        this.maze[line_idx][idx] = 1;
                    } else if (line.charAt(idx) == ' ') {
                        this.maze[line_idx][idx] = 0;
                    }
                }
                line_idx++;
            }
        } catch(Exception e) {
            logger.error("/!\\ Maze could not be created /!\\");
        }
    }
     //returns the maze
    public int[][] getMaze() {
        return this.maze;
    }

    //prints out the maze
    public void printMaze() {
        for (int i = 0; i < height; i++) {
            System.out.print("\n");
            for (int j = 0; j < width; j++) {
                if (maze[i][j] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
        }
        System.out.print("\n");
    }
}