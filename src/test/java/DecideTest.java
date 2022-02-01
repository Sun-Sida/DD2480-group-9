
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
class DecideTest {

    @Test
    void LIC0ExampleTest(){
        var dec = new Decide();
        assertTrue(dec.LIC0(dec.X, dec.Y, dec.NUMPOINTS,dec.LENGTH1));
        //assertFalse(dec.LIC0(dec.X, dec.Y, dec.NUMPOINTS,dec.LENGTH1));

    }
    @Test
    void LIC5TrueTest(){
        int[][] points = new int[4][2];
        points[0][0] = 6;
        points[1][0] = 2;
        points[2][0] = 4;
        points[3][0] = 5;
        Parameters parameters = new Parameters(0.0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        var dec = new Decide(parameters, 2, points);
        assertTrue(dec.LIC5());
    }
    @Test
    void LIC5FalseTest(){
        int[][] points = new int[4][2];
        points[0][0] = 1;
        points[1][0] = 2;
        points[2][0] = 4;
        points[3][0] = 5;
        Parameters parameters = new Parameters(0.0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        var dec = new Decide(parameters, 2, points);
        assertFalse(dec.LIC5());
    }

}