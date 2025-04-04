package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.commands.*;
import ca.mcmaster.se2aa4.mazerunner.status.*;

public class CommandListTest {
    private Coordinates coords =new Coordinates(new int[] {0,0});
    private Direction dir = new Direction('E');
    private PreviousMove previous = new PreviousMove();
    private CommandList commandList = new CommandList(dir, coords, previous);

    @Test
    public void testAddCommand() {
        commandList.addCommand("getDirection", new GetDirectionCommand(dir));
        assertNotNull(commandList.getCommand("getDirection"));
    }

    @Test
    public void testComGetmand() {
        commandList.addCommand("getDirection", new GetDirectionCommand(dir));
        assertNotNull(commandList.getCommand("getDirection"));
    }
}
