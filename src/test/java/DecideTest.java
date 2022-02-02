
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
		void LIC4FalseTest(){
			int[][] points = new int[2][2];
			points[0][0] = 1;
			points[0][1] = 2;
			points[1][0] = 3;
			points[1][1] = 4;
			Parameters parameters = new Parameters(0.0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
			var dec = new Decide(parameters, 2, points);
			assertFalse(dec.LIC4());
		}

        @Test
		void LIC4TrueTest(){
			int[][] points = new int[2][5];
			points[0][0] = -2;
			points[1][0] = 3;
			points[0][1] = -1;
			points[1][1] = 2;
            points[0][2] = 1;
            points[1][2] = 2;
            points[0][3] = 1;
            points[1][3] = -2;
            points[0][4] = -2;
            points[1][4] = -2;
			Parameters parameters = new Parameters(0.0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
			var dec = new Decide(parameters, 5, points);
			assertTrue(dec.LIC4());
		}
		@Test
		void LIC4WrongTest(){
			int[][] points = new int[2][5];
			points[0][0] = -2;
			points[1][0] = 3;
			points[0][1] = -1;
			points[1][1] = 2;
            points[0][2] = 1;
            points[1][2] = 2;
            points[0][3] = 1;
            points[1][3] = -2;
            points[0][4] = -2;
            points[1][4] = -2;
			Parameters parameters = new Parameters(0.0, 0, 0, 0, 3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
			var dec = new Decide(parameters, 5, points);
			assertFalse(dec.LIC4());
		}

	@Test
	void LIC8TrueTest() {
		int[][] points = new int[2][8];
		points[0][0] = 10;
		points[1][0] = 10;

		points[0][1] = 15;
		points[1][1] = 10;
		
		points[0][2] = 9;
		points[1][2] = 14;
		
		points[0][3] = 11;
		points[1][3] = 11;

		points[0][4] = 10;
		points[1][4] = 15;

		points[0][5] = 20;
		points[1][5] = 10;
		
		points[0][6] = 15;
		points[1][6] = 19;

		points[0][7] = 30;
		points[1][7] = 10;

		double rad = 30.0;
		int aPts = 3;
		int bPts = 2;

		Parameters parameters = new Parameters(0, rad, 0, 0, 0, 0, 0, 0, 0, aPts, bPts, 0, 0, 0, 0, 0, 0, 0, 0);
		var dec = new Decide(parameters, 8, points);
		assertFalse(dec.LIC8());
	}

	@Test
	void LIC8FalseTest1() {

		int[][] points = new int[2][8];
		points[0][0] = 10;
		points[1][0] = 10;

		points[0][1] = 15;
		points[1][1] = 10;
		
		points[0][2] = 9;
		points[1][2] = 14;
		
		points[0][3] = 11;
		points[1][3] = 11;

		points[0][4] = 10;
		points[1][4] = 15;

		points[0][5] = 20;
		points[1][5] = 10;
		
		points[0][6] = 15;
		points[1][6] = 19;

		points[0][7] = 30;
		points[1][7] = 10;

		double rad = 40.0;
		int aPts = 3;
		int bPts = 2;

		Parameters parameters = new Parameters(0, rad, 0, 0, 0, 0, 0, 0, 0, aPts, bPts, 0, 0, 0, 0, 0, 0, 0, 0);
		var dec = new Decide(parameters, 8, points);
		assertFalse(dec.LIC8());
	}

	@Test
	void LIC8FalseTest2() {
		// Should fail due to too few points.
		int[][] points = new int[2][7];
		points[0][0] = 10;
		points[1][0] = 10;

		points[0][1] = 15;
		points[1][1] = 10;
		
		points[0][2] = 9;
		points[1][2] = 14;
		
		points[0][3] = 11;
		points[1][3] = 11;

		points[0][4] = 10;
		points[1][4] = 15;

		points[0][5] = 20;
		points[1][5] = 10;
		
		points[0][6] = 15;
		points[1][6] = 19;

		double rad = 35.0;
		int aPts = 3;
		int bPts = 2;

		Parameters parameters = new Parameters(0, rad, 0, 0, 0, 0, 0, 0, 0, aPts, bPts, 0, 0, 0, 0, 0, 0, 0, 0);
		var dec = new Decide(parameters, 7, points);
		assertFalse(dec.LIC8());
	}

	
}