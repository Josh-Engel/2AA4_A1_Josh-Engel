package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface PathAlgorithm {

    //finds a path through a given maze
    String findPath();

    //finds the entrances of a given maze
    int[] findEntrances ();
}