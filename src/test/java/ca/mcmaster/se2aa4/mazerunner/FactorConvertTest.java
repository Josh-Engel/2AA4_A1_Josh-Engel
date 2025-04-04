package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FactorConvertTest {
    
    private FactorConvert factorconvert = new FactorConvert();

    @Test
    public void testToCanon() {
        assertEquals("FFRRF", factorconvert.toCanon("2F2RF"));
    }

    @Test
    public void testToFactor() {
        assertEquals("2F2RF", factorconvert.toFactor("FFRRF"));
    }
}
