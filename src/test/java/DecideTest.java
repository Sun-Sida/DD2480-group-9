
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
            int num_points = 4;
            int[][] points = new int[2][num_points];
            points[0][0] = 6;
            points[0][1] = 2;
            points[0][2] = 4;
            points[0][3] = 5;
            Parameters parameters = new Parameters(0.0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            var dec = new Decide(parameters, num_points, points);
            assertTrue(dec.LIC5());
        }
        @Test
        void LIC5FalseTest(){
            int num_points = 4;
            int[][] points = new int[2][num_points];
            points[0][0] = 1;
            points[0][1] = 2;
            points[0][2] = 4;
            points[0][3] = 5;
            Parameters parameters = new Parameters(0.0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            var dec = new Decide(parameters, num_points, points);
            assertFalse(dec.LIC5());
        }
    @Test
    void LIC6FalseTest_ToLargeDist(){
        //Will test the euclidean distance. All y:s are zero
        int num_points = 4;
        int[][] points = new int[2][num_points];
        points[0][0] = 1;
        points[0][1] = 2;
        points[0][2] = 4;
        points[0][3] = 5;
        Parameters parameters = new Parameters(0.0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        var dec = new Decide(parameters, 4, points);
        assertFalse(dec.LIC6());
    }
    @Test
    void LIC6TrueTest_SmallerDist(){
        //Will test the euclidean distance. ALl y:s are zero
        int num_points = 8;
        int[][] points = new int[2][num_points];
        points[0][0] = 1;
        points[0][1] = 4;
        points[0][2] = 7;
        points[0][3] = 11;
        points[0][4] = 14;
        points[0][4] = 1;
        points[0][4] = 1;
        points[0][4] = 1;
        Parameters parameters = new Parameters(0.0, 0, 0, 0, 0, 0, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        var dec = new Decide(parameters, num_points, points);
        assertTrue(dec.LIC6());
    }
    @Test
    void LIC6TrueTest_Line(){
        //Will test the euclidean distance. ALl y:s are zero
        int num_points = 5;
        int[][] points = new int[2][num_points];
        points[0][0] = 2;
        points[0][1] = 1;
        points[0][2] = 4;
        points[0][3] = 7;
        points[0][4] = 11;
        points[1][0] = 1;
        points[1][1] = 1;
        points[1][2] = 1;
        points[1][3] = 2;
        points[1][4] = 2;
        Parameters parameters = new Parameters(0.0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        var dec = new Decide(parameters, num_points, points);
        assertTrue(dec.LIC6());
    }
}