package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.algorithms.*;
import ca.mcmaster.se2aa4.mazerunner.observers.*;
import ca.mcmaster.se2aa4.mazerunner.commands.*;
import ca.mcmaster.se2aa4.mazerunner.status.*;

public class StraightLineAlgorithmTest {

    private final List<Observer> observers = new ArrayList<>();
    private Maze maze = new Maze("examples\\straight.maz.txt");
    private Coordinates coords =new Coordinates(new int[] {0,0});
    private Direction dir = new Direction('E');
    private PreviousMove previous = new PreviousMove();
    private CommandList commandList = new CommandList(dir, coords, previous);
    private StraightLineAlgorithm straightLineAlgorithm;

    @BeforeEach
    public void setUp() {
        observers.add(new CoordinateObserver());
        observers.add(new DirectionObserver());
        commandList.defaultList();
        straightLineAlgorithm = new StraightLineAlgorithm(maze, observers, commandList);
    }

    @Test
    public void testFindPath() {
        assertEquals("FFFF",straightLineAlgorithm.findPath());
    }

    
}
