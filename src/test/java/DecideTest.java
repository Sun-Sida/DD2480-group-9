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


}