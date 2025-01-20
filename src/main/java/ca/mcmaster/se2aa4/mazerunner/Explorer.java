package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Explorer {
    private String path;
    private int[][] maze;

    private static final Logger logger = LogManager.getLogger();

    public abstract int[] findEntrances();

    public abstract boolean explore();
}