package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        Options options = new Options();
        options.addOption("i", true, "Input file for the maze");
        options.addOption("p", true, "Input string for a path");

        CommandLineParser parser = new DefaultParser();

        FactorConvert converter = new FactorConvert();

        logger.info("** Starting Maze Runner");
        try {
            CommandLine cmd = parser.parse(options, args);
            String maze_file = cmd.getOptionValue("i");
            String path_string = cmd.getOptionValue("p");

            logger.info("**** Reading the maze from file " + maze_file);
            Maze maze = new Maze(maze_file);
            int[][] my_maze = maze.getMaze();
            boolean canon = true;
            if (path_string != null) {
                logger.trace("**** Checking type of path input");
                for(int i = 0; i < path_string.length(); i++) {
                    if(path_string.charAt(i) != 'F' && path_string.charAt(i) != 'L' && path_string.charAt(i) != 'R') {
                        canon = false;
                        break;
                    }
                }
                logger.info("**** Checking if path is valid");
                if (canon != true) {
                    path_string = converter.toCanon(path_string);  
                }
                Explorer path_checker = new Explorer(path_string,my_maze);
                if (path_checker.explore() == true) {
                    System.out.println("Valid path");
                } else {
                    System.out.println("Not a valid path");
                }
            }
            maze.printMaze();
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.warn("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
