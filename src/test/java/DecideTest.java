
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
	@Test
	void LIC12TrueTest(){
		        /*
    		Input: Parameters: Length1=1, K_PTS=2, length2 = 7, Number of inputs:6. X-coordinates:2,2,5,7,8,11 Y-coords:2,5,6,4,8,4.
    		Output: True
    	*/
		Parameters parameters = new Parameters(4.0, 0, 0, 0, 0, 0,
				0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 7,0, 0);
		int[][] points = {{2, 2, 5, 7, 8, 11}, {2, 5, 6, 4, 8, 4}};
		var dec = new Decide(parameters, 6, points);
		assertTrue(dec.LIC12());
	}
	@Test
	void LIC12FalseTest(){
				        /*
    		Input: Parameters: Length1=40, K_PTS=2, length2 = 7, Number of inputs:6. X-coordinates:2,2,5,7,8,11 Y-coords:2,5,6,4,8,4.
    		Output: False
    	*/
		Parameters parameters = new Parameters(40.0, 0, 0, 0, 0, 0,
				0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 7,0, 0);
		int[][] points = {{2, 2, 5, 7, 8, 11}, {2, 5, 6, 4, 8, 4}};

		var dec = new Decide(parameters, 6, points);
		assertFalse(dec.LIC12());
	}

}
