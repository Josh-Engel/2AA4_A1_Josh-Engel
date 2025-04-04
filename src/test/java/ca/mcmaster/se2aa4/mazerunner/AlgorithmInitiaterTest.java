package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.initiaters.AlgorithmInitiater;

public class AlgorithmInitiaterTest {
    
    private AlgorithmInitiater algorithmInitiater = new AlgorithmInitiater();
    private Maze maze = new Maze("examples\\straight.maz.txt");

    @Test
    public void testInitiate() {
        algorithmInitiater.initiate(null, maze);
        assertNotNull(algorithmInitiater.getAlgorithm());
    }
}
