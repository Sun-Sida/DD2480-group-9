
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
            var dec = new Decide(parameters, 4, points);
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
            var dec = new Decide(parameters, 4, points);
            assertFalse(dec.LIC5());
        }
    @Test
    void LIC6FalseTest_ToLargeDist(){
        //Will test the euclidean distance. All y:s are zero
        int[][] points = new int[4][2];
        points[0][0] = 1;
        points[1][0] = 2;
        points[2][0] = 3;
        points[3][0] = 4;
        Parameters parameters = new Parameters(0.0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        var dec = new Decide(parameters, 4, points);
        assertFalse(dec.LIC6());
    }
    @Test
    void LIC6TrueTest_SmallerDist(){
        //Will test the euclidean distance. ALl y:s are zero
        int[][] points = new int[5][2];
        int NUMPOINTS = 5;
        points[0][0] = 0;
        points[1][0] = 1;
        points[2][0] = 1;
        points[3][0] = 1;
        points[4][0] = 3;
        Parameters parameters = new Parameters(0.0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        var dec = new Decide(parameters, NUMPOINTS, points);
        assertTrue(dec.LIC6());
    }

}