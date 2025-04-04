package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.initiaters.AlgorithmInitiater;
import ca.mcmaster.se2aa4.mazerunner.initiaters.ExplorerInitiater;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    //runs the mazerunner program
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

            if (path_string != null) {
                ExplorerInitiater explorerInitiater = new ExplorerInitiater();
                explorerInitiater.initiate(path_string, maze);
                if (explorerInitiater.getExplorer().explore() == true) {
                    System.out.println("Valid path");
                } else {
                    System.out.println("Not a valid path");
                }
            } else {
                AlgorithmInitiater algorithmInitiater = new AlgorithmInitiater();
                algorithmInitiater.initiate(path_string, maze);
                String computed_path = algorithmInitiater.getAlgorithm().findPath();
                System.out.println("Canon path: " + computed_path);
                System.out.println("Factorized path: " + converter.toFactor(computed_path));
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("** End of MazeRunner");
    }
}
