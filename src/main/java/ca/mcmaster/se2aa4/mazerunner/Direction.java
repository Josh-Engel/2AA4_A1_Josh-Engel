package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Direction {
    private char direction;

    private static final Logger logger = LogManager.getLogger();

    public Direction (char direction) {
        this.direction = direction;
    }
    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void turnLeft () {
        if (direction == 'N') {
            direction = 'W';
        } else if (direction == 'E') {
            direction = 'N';
        } else if (direction == 'S') {
            direction = 'E';
        } else {
            direction = 'S';
        }
    }

    public void turnRight () {
        if (direction == 'N') {
            direction = 'E';
        } else if (direction == 'E') {
            direction = 'S';
        } else if (direction == 'S') {
            direction = 'W';
        } else {
            direction = 'N';
        }
    }

    public char getDirection () {
        return direction;
    }

    public int[] getDirVector () {
        int[] dir_vector = new int[2];
        if (direction == 'N') {
            dir_vector[0] = 0;
            dir_vector[1] = -1;
        } else if (direction == 'E') {
            dir_vector[0] = 1;
            dir_vector[1] = 0;
        } else if (direction == 'S') {
            dir_vector[0] = 0;
            dir_vector[1] = 1;
        } else {
            dir_vector[0] = -1;
            dir_vector[1] = 0;
        }
        return dir_vector;
    }
}