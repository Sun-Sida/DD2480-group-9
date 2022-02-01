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
        var dec = new Decide();
        double[] LIC12X = {2.0, 2.0, 5.0, 7.0, 8.0, 11.0};
        double[] LIC12Y = {2.0, 5.0, 6.0, 4.0, 8.0, 4.0};
        double LIC12Length1 = 4.0;
        double LIC12Length2 = 7.0;
        int LIC12K_pts = 2;
        int LIC12Numpoints = 6;
        assertTrue(dec.LIC12(LIC12X, LIC12Y,LIC12Numpoints,  LIC12Length1, LIC12Length2, LIC12K_pts));
    }
    @Test
    void LIC12FalseTest(){
        var dec = new Decide();
        double[] LIC12X = {2.0, 2.0, 5.0, 7.0, 8.0, 11.0};
        double[] LIC12Y = {2.0, 5.0, 6.0, 4.0, 8.0, 4.0};
        double LIC12Length1 = 40.0;
        double LIC12Length2 = 7.0;
        int LIC12K_pts = 0;
        int LIC12Numpoints = 6;
        assertFalse(dec.LIC12(LIC12X, LIC12Y,LIC12Numpoints,  LIC12Length1, LIC12Length2, LIC12K_pts));
    }


}