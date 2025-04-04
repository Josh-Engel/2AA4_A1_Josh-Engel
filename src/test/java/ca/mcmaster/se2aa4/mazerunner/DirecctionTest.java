package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.status.Direction;

public class DirecctionTest {

    private Direction direction;

    @BeforeEach
    public void setUp() {
        direction = new Direction('N');
    }

    @Test
    public void testTurnRight() {
        direction.turnRight();
        char dir = direction.getDirection();
        assertEquals('E', dir);
    }

    @Test
    public void testTurnLeft() {
        direction.turnLeft();
        char dir = direction.getDirection();
        assertEquals('W', dir);
    }

    @Test
    public void testUTurn() {
        direction.uTurn();
        char dir = direction.getDirection();
        assertEquals('S', dir);
    }

    @Test
    public void testGetDirection() {
        char dir = direction.getDirection();
        assertEquals('N', dir);
    }
}
