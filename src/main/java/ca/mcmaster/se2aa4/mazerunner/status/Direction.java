package ca.mcmaster.se2aa4.mazerunner.status;

public class Direction {
    private char direction;

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

    public void uTurn () {
        if (direction == 'N') {
            direction = 'S';
        } else if (direction == 'E') {
            direction = 'W';
        } else if (direction == 'S') {
            direction = 'N';
        } else {
            direction = 'E';
        }
    }

    public char getDirection () {
        return direction;
    }
}