import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertSame;
class DecideTest {

    @Test
    void LIC0TrueTest(){
        int[][] points = new int[2][3];
            points[1][0] = 1;
            points[0][0] = 3;
			points[1][1] = 1;
			points[0][1] = 7;
            points[1][1] = 1;
			points[0][1] = 8;
        Parameters parameters = new Parameters(2.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		var dec = new Decide(parameters, 3, points);
        assertTrue(dec.LIC0());
        //assertFalse(dec.LIC0(dec.X, dec.Y, dec.NUMPOINTS,dec.LENGTH1));

    }


    @Test
    void LIC0FalseTest(){
        int[][] points = new int[2][2];
            points[0][0] = 1;
			points[0][1] = 1;
			points[1][0] = 3;
			points[1][1] = 7;
        Parameters parameters = new Parameters(10.0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		var dec = new Decide(parameters, 2, points);
        assertFalse(dec.LIC0());
        //assertFalse(dec.LIC0(dec.X, dec.Y, dec.NUMPOINTS,dec.LENGTH1));

    }
  
      void LIC1TrueTest(){
        int[][] points = new int[2][3];
            points[1][0] = 1;
            points[0][0] = 3;
			points[1][1] = 1;
			points[0][1] = 5;
            points[1][2] = 1;
			points[0][2] = 7;
        Parameters parameters = new Parameters(2.0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		var dec = new Decide(parameters, 3, points);
        assertTrue(dec.LIC1());
        //assertFalse(dec.LIC0(dec.X, dec.Y, dec.NUMPOINTS,dec.LENGTH1));

    }

    @Test
    void LIC1FalseTest(){
        int[][] points = new int[2][3];
            points[1][0] = 1;
            points[0][0] = 3;
			points[1][1] = 1;
			points[0][1] = 5;
            points[1][1] = 2;
			points[0][1] = 7;
        Parameters parameters = new Parameters(2.0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		var dec = new Decide(parameters, 3, points);
        assertFalse(dec.LIC1());
        //assertFalse(dec.LIC0(dec.X, dec.Y, dec.NUMPOINTS,dec.LENGTH1));

    }

    @Test
    void LIC2TrueTest(){
        int[][] points = new int[2][3];
            points[0][0] = 1;
			points[1][0] = 1;
			points[0][1] = 3;
			points[1][1] = 1;
            points[0][2] = 3;
			points[1][2] = 2;
            Parameters parameters = new Parameters(10.0, 0, 3.14/2, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		    var dec = new Decide(parameters, 3, points);
            assertTrue(dec.LIC2());
    }

    @Test
    void LIC2FalseTest(){
        int[][] points = new int[2][3];
            points[0][0] = 1;
			points[1][0] = 1;
			points[0][1] = 0;
			points[1][1] = 0;
            points[0][2] = -1;
			points[1][2] = 1;
            Parameters parameters = new Parameters(10.0, 0, 3.20/2, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		    var dec = new Decide(parameters, 3, points);
            assertFalse(dec.LIC2());
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
	@Test
	void LIC7TrueTest(){
		//Will test the euclidean distance. ALl y:s are zero
		int num_points = 5;
		int[][] points = new int[2][num_points];
		points[0][0] = 2;
		points[0][1] = 6;
		points[0][2] = 4;
		points[0][3] = 7;
		points[0][4] = 11;
		points[1][0] = 4;
		points[1][1] = 3;
		points[1][2] = 5;
		points[1][3] = 11;
		points[1][4] = 2;
		Parameters parameters = new Parameters(1.0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		var dec = new Decide(parameters, num_points, points);
		assertTrue(dec.LIC7());
	}
	@Test
	void LIC7FalseTest(){
		//Will test the euclidean distance. ALl y:s are zero
		int num_points = 5;
		int[][] points = new int[2][num_points];
		points[0][0] = 2;
		points[0][1] = 6;
		points[0][2] = 4;
		points[0][3] = 7;
		points[0][4] = 11;
		points[1][0] = 4;
		points[1][1] = 3;
		points[1][2] = 5;
		points[1][3] = 11;
		points[1][4] = 2;
		Parameters parameters = new Parameters(100.0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		var dec = new Decide(parameters, num_points, points);
		assertFalse(dec.LIC7());
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
	@Test
	void LIC13TrueTest(){
		Parameters parameters = new Parameters(40.0, -100, 0, 0, 0, 0,
				0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0,100, 0);
		int[][] points = {{3, 4, 5, 6, 6, 8, 8}, {2, 4, 2, 3, 5, 3, 5}};

		var dec = new Decide(parameters, 7, points);
		assertTrue(dec.LIC13());
	}
	@Test
	void LIC13FalseTest(){
		Parameters parameters = new Parameters(40.0, 10, 0, 0, 0, 0,
				0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 7,5, 0);
		int[][] points = {{3, 4, 5, 6, 6, 8, 8}, {2, 4, 2, 3, 5, 3, 5}};

		var dec = new Decide(parameters, 7, points);
		assertFalse(dec.LIC13());
	}

	@Test
	void LIC9TrueTest() {
		int[][] points = new int[2][5];

		points[0][0] = -2;
		points[1][0] = 1;

		points[0][1] = -1;
		points[1][1] = -1;

		points[0][2] = 0;
		points[1][2] = 0;

		points[0][3] = 1;
		points[1][3] = 1;

		points[0][4] = 2;
		points[1][4] = 1;

		int cPts = 1; int dPts = 1;
		double eps = 0.1;

		Parameters parameters = new Parameters(0, 0, eps, 0, 0, 0, 0, 0, 0, 0, 0, cPts, dPts, 0, 0, 0, 0, 0, 0);
		var dec = new Decide(parameters, 5, points);
		assertTrue(dec.LIC9());
	}

		

	@Test
	void LIC9FalseTest() {
		int[][] points = new int[2][5];

		points[0][0] = -1;
		points[1][0] = 2;

		points[0][1] = -1;
		points[1][1] = -1;

		points[0][2] = 0;
		points[1][2] = 0;

		points[0][3] = 1;
		points[1][3] = 1;
		
		points[0][4] = 1;
		points[1][4] = 2;

		int cPts = 1; int dPts = 1;
		double eps = 3; 

		Parameters parameters = new Parameters(0, 0, eps, 0, 0, 0, 0, 0, 0, 0, 0, cPts, dPts, 0, 0, 0, 0, 0, 0);
		var dec = new Decide(parameters, 5, points);
		assertFalse(dec.LIC9());
	}

	void LIC10TrueTest() {
		int[][] points = new int[2][5];

<<<<<<< HEAD
    @Test
    public void pum_example1(){
        int[][] points = new int[0][0];
        Parameters parameters = new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		var dec = new Decide(parameters, 7, points);
    
        Boolean[] cmv = new Boolean[15];
        cmv[0]  = false;
        cmv[1]  = true;
        cmv[2]  = true;
        cmv[3]  = true;
        cmv[4]  = false;
        cmv[5]  = false;
        cmv[6]  = false;
        cmv[7]  = false;
        cmv[8]  = false;
        cmv[9]  = false;
        cmv[10] = false;
        cmv[11] = false;
        cmv[12] = false;
        cmv[13] = false;
        cmv[14] = false;
        Connectors[][] lcm = new Connectors[15][15];
        lcm[0][0] = Connectors.ANDD;
        lcm[0][1] = Connectors.ANDD;
        lcm[0][2] = Connectors.ORR;
        lcm[0][3] = Connectors.ANDD;

        lcm[1][0] = Connectors.ANDD;
        lcm[1][1] = Connectors.ANDD;
        lcm[1][2] = Connectors.ORR;
        lcm[1][3] = Connectors.ORR;

        lcm[2][0] = Connectors.ORR;
        lcm[2][1] = Connectors.ORR;
        lcm[2][2] = Connectors.ANDD;
        lcm[2][3] = Connectors.ANDD;

        lcm[3][0] = Connectors.ANDD;
        lcm[3][1] = Connectors.ORR;
        lcm[3][2] = Connectors.ANDD;
        lcm[3][3] = Connectors.ANDD;

        for (int i = 4; i < lcm.length; i++) {
            for (int j = 0; j < lcm.length; j++) {
                lcm[i][j] = Connectors.NOTUSED;
                lcm[j][i] = Connectors.NOTUSED;
            }
        }
        Boolean[][] pum = dec.PMV(cmv, lcm);

        boolean[][] expectedPUM = new boolean[15][15];
        expectedPUM[0][1] = false;
        expectedPUM[0][2] = true;
        expectedPUM[0][3] = false;
        expectedPUM[0][4] = true;

        expectedPUM[1][0] = false;
        expectedPUM[1][2] = true;
        expectedPUM[1][3] = true;
        expectedPUM[1][4] = true;

        expectedPUM[2][0] = true;
        expectedPUM[2][1] = true;
        expectedPUM[2][3] = true;
        expectedPUM[2][4] = true;
        
        expectedPUM[3][0] = false;
        expectedPUM[3][1] = true;
        expectedPUM[3][2] = true;
        expectedPUM[3][4] = true;

        expectedPUM[4][0] = true;
        expectedPUM[4][1] = true;
        expectedPUM[4][2] = true;
        expectedPUM[4][4] = true;

        for (int i = 4; i < expectedPUM.length; i++) {
            for (int j = 0; j < expectedPUM.length; j++) {
                if(i == j)
                    continue;
                expectedPUM[i][j] = true;
                expectedPUM[j][i] = true;
            }
        }

        for (int i = 0; i < expectedPUM.length; i++) {
            for (int j = 0; j < expectedPUM.length; j++) {
                if(i == j){

                }else{
                    assertEquals(expectedPUM[i][j], pum[i][j]);
                }
                
            }
        }
    }

=======
		points[0][0] = -2;
		points[1][0] = 2;

		points[0][1] = -1;
		points[1][1] = -1;

		points[0][2] = 0;
		points[1][2] = 0;

		points[0][3] = 1;
		points[1][3] = 1;

		points[0][4] = 2;
		points[1][4] = 2;	// forms a triangle with area=2

		int ePts = 1; int fPts = 1;
		double area = 1; 

		Parameters parameters = new Parameters(0, 0, 0, area, 0, 0, 0, 0, 0, 0, 0, 0, 0, ePts, fPts, 0, 0, 0, 0);
		var dec = new Decide(parameters, 5, points);
		assertTrue(dec.LIC10());
	}

	@Test
	void LIC10FalseTest() {
		int[][] points = new int[2][5];

		points[0][0] = -2;
		points[1][0] = 1;

		points[0][1] = -1;
		points[1][1] = -1;

		points[0][2] = 0;
		points[1][2] = 0;

		points[0][3] = 1;
		points[1][3] = 1;

		points[0][4] = 2;
		points[1][4] = 1;	// forms a triangle with area=2

		int ePts = 1; int fPts = 1;
		double area = 3; 

		Parameters parameters = new Parameters(0, 0, 0, area, 0, 0, 0, 0, 0, 0, 0, 0, 0, ePts, fPts, 0, 0, 0, 0);
		var dec = new Decide(parameters, 5, points);
		assertFalse(dec.LIC10());
	}
>>>>>>> origin
}