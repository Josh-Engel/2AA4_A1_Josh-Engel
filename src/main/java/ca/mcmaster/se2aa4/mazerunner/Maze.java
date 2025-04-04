package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
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
            reader.close();
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

    public int getCoordInstance(int xcoord, int ycoord) {
        if(xcoord < 0 || ycoord < 0 || xcoord >= maze[0].length || ycoord >= maze.length) {
            return 2;
        }
        return maze[ycoord][xcoord];
    }

    public int getWidth() {
        return maze[0].length;
    }

    public int getHeight() {
        return maze.length;
    }
}