package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class MazeTest {
    private Maze maze = new Maze("examples\\tiny.maz.txt");

    @Test
    public void testFindEntrances() {
        assertEquals(5, maze.findEntrances()[0]);
        assertEquals(1, maze.findEntrances()[1]);
    }

    @Test
    public void testGetCoordInstance() {
        assertEquals(2,maze.getCoordInstance(-1,-1));
    }

    @Test
    public void testGetWidth() {
        assertEquals(7,maze.getWidth());
    }
}
