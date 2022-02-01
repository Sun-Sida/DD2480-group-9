
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
    void LIC12TrueTest(){
        Parameters parameters = new Parameters(4.0, 0, 0, 0, 0, 0,
                0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 7,0, 0);
        int[][] points = {{2, 2, 5, 7, 8, 11}, {2, 5, 6, 4, 8, 4}};
        var dec = new Decide(parameters, 6, points);
        assertTrue(dec.LIC12());
    }
    @Test
    void LIC12FalseTest(){
        Parameters parameters = new Parameters(40.0, 0, 0, 0, 0, 0,
                0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 7,0, 0);
        int[][] points = {{2, 2, 5, 7, 8, 11}, {2, 5, 6, 4, 8, 4}};

        var dec = new Decide(parameters, 6, points);
        assertFalse(dec.LIC12());
    }


}