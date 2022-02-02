
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
	void LIC11FalseInputTest(){
		int[][] points = new int[2][5];
		points[0][0] = -2;
		points[1][0] = 3;
		points[0][1] = -1;
		points[1][1] = 2;
		Parameters parameters = new Parameters(0.0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0);
		var dec = new Decide(parameters, 2, points);
		assertFalse(dec.LIC11());
	}
	@Test
	void LIC11FalseTest(){
		int[][] points = new int[2][5];
		points[0][0] = 1;
		points[1][0] = 3;
		points[0][1] = 2;
		points[1][1] = 3;
		points[0][2] = 3;
		points[1][2] = 3;
		points[0][3] = 4;
		points[1][3] = 3;
		points[0][4] = 5;
		points[1][4] = 3;
		Parameters parameters = new Parameters(0.0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0);
		var dec = new Decide(parameters, 5, points);
		assertFalse(dec.LIC11());
	}
	@Test
	void LIC11TrueTest(){
		int[][] points = new int[2][7];
		points[0][0] = 30;
		points[1][0] = 3;
		points[0][1] = 2;
		points[1][1] = 3;
		points[0][2] = 3;
		points[1][2] = 3;
		points[0][3] = 4;
		points[1][3] = 3;
		points[0][4] = 5;
		points[1][4] = 3;
		points[0][5] = 6;
		points[1][5] = 3;
		points[0][6] = 7;
		points[1][6] = 3;
		Parameters parameters = new Parameters(0.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0);
		var dec = new Decide(parameters, 7, points);
		assertTrue(dec.LIC11());
	}

}