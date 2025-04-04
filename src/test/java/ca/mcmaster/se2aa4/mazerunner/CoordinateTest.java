package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.status.Coordinates;

public class CoordinateTest {
    private Coordinates coordinate;

    @BeforeEach
    public void setUp() {
        int[] coords = new int[2];
        coords[0] = 0;
        coords[1] = 0;
        coordinate = new Coordinates(coords);
    }

    @Test
    public void testGetCoords() {
        int[] coords = coordinate.getCoords();
        assertEquals(0,coords[0]);
        assertEquals(0,coords[1]);
    }

    @Test
    public void testAdjustX() {
        coordinate.adjustX(1);
        int[] coords = coordinate.getCoords();
        assertEquals(1,coords[0]);
    }

    @Test
    public void testAdjustY() {
        coordinate.adjustY(2);
        int[] coords = coordinate.getCoords();
        assertEquals(2,coords[1]);
    }
}
