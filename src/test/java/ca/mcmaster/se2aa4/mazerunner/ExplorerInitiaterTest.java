package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.initiaters.ExplorerInitiater;

class ExplorerInitiaterTest {
    
    private ExplorerInitiater explorerInitiater = new ExplorerInitiater();
    private Maze maze = new Maze("examples\\straight.maz.txt");
    private String path_string = "FFF";

    @Test
    public void testInitiate() {
        explorerInitiater.initiate(path_string, maze);
        assertNotNull(explorerInitiater.getExplorer());
    }
}
