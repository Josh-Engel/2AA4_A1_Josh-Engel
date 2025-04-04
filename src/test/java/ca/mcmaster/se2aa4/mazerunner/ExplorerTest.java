package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.se2aa4.mazerunner.observers.*;
import ca.mcmaster.se2aa4.mazerunner.commands.*;
import ca.mcmaster.se2aa4.mazerunner.status.*;

public class ExplorerTest {
    private final List<Observer> observers = new ArrayList<>();
    private Maze maze = new Maze("examples\\straight.maz.txt");
    private Coordinates coords =new Coordinates(new int[] {0,0});
    private Direction dir = new Direction('E');
    private PreviousMove previous = new PreviousMove();
    private CommandList commandList = new CommandList(dir, coords, previous);
    private String path_string = "FFFF";
    private Explorer explorer;

    @BeforeEach
    public void setUp() {
        observers.add(new CoordinateObserver());
        observers.add(new DirectionObserver());
        commandList.defaultList();
        explorer = new Explorer(path_string, maze, observers, commandList);
    }

    @Test
    public void testExplore() {
        assertTrue(explorer.explore());
    }
}
