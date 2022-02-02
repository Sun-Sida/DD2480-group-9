import java.awt.geom.Point2D;
import java.util.Arrays;


class Decide {
    //Program for deciding hypothetical anti-ballistic missile system
    //Call method decide with appropriate input to decide to send an interceptor or not.
	
	
	//Global variables
	int NUMPOINTS = 3;
	double[] X = {0.23, 6.51, 0.15};
	double[] Y = {1.31, 2.20, 1.3};
	double LENGTH1 = 2.0;
	double AREA1 = 6.6;
	int PI = 180;
	int EPSILON = 90;
	Parameters parameters;
	int[][] points;

	public Decide(Parameters parameters, int NUMPOINTS, int[][] points){
		this.parameters = parameters;
		this.NUMPOINTS = NUMPOINTS;
		this.points = points;
	}


    //LIC conditions
    public boolean LIC0() {
		if (parameters.LENGTH1< 0) return false;
		double x1, y1, x2, y2, dist;
		for(int i = 0; i < NUMPOINTS-1; i++){
			x1 = points[0][i];
			y1 = points[1][i];
			x2 = points[0][i+1];
			y2 = points[1][i+1];
			//System.out.println(x1);
			dist = Point2D.distance(x1,y1,x2,y2);
			System.out.println(dist);
			if(dist > parameters.LENGTH1) return true;
		}
		return false;
	}

	public boolean LIC1() {
		return false;
	}

	public boolean LIC2() {
		double x1, y1, x2, y2, x3, y3, angle;
		for(int i = 2; i < NUMPOINTS; i++){
			x1 = X[i-2];
			y1 = Y[i-2];
			x2 = X[i-1];
			y2 = Y[i-1];
			x3 = X[i];
			y3 = Y[i];
			
			angle = Math.toDegrees((Math.atan2(y1-y2, x1-x2) - Math.atan2(y3-y2, x3-x2)));
			
			if (angle < 0) {
				angle += 360;
			}
			if (angle > 180) {
				angle = 360-angle;
			}
			
			//System.out.println(angle);
			
			//If P1 or P3 is equal to P2 there is no angle
			if (!((x1 == x2 && y1 == y2) || (x3 == x2 && y3 == y2))) {
				if(angle < (PI-EPSILON) || angle > PI+EPSILON ){
					return true;
				}
			}
		}
		return false;
	}

	public boolean LIC3() {
		double x1, y1, x2, y2, x3, y3, area;
		for(int i = 2; i < NUMPOINTS; i++){
			x1 = X[i-2];
			y1 = Y[i-2];
			x2 = X[i-1];
			y2 = Y[i-1];
			x3 = X[i];
			y3 = Y[i];
			area = (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
			
			//System.out.println(area);
			
			if(area > AREA1){
				return true;
			}
		}
		return false;
	}

	public boolean LIC4() {	
		boolean[] visitedQuads = new boolean[4];	
		int numberOfQuads = 0;
		//(1<=QUADS<=3)		
		if(parameters.getQUADS() < 1 || parameters.getQUADS() > 4) return false;
		//(2<=Q_PTS<=NumPOINTS)
		if(parameters.getQ_PTS() < 2 || parameters.getQ_PTS() > NUMPOINTS) return false;
	
		for(int i = 0; i < NUMPOINTS - parameters.getQ_PTS() +1; i++){
			
			Arrays.fill(visitedQuads, Boolean.FALSE);
			for(int j = i; j < i + parameters.getQ_PTS(); j++){
				//Checks which quadrants the point is located in
				if(points[0][j] >= 0 && points[1][j]>= 0) visitedQuads[0] = true;
				else if(points[0][j] < 0 && points[1][j]>= 0) visitedQuads[1] = true;
				else if(points[0][j] < 0 && points[1][j]  <= 0) visitedQuads[2] = true;
				else if(points[0][j] > 0 && points[1][j] < 0) visitedQuads[3] = true;
				
				//Checks how many quadrants we have points in
				numberOfQuads = 0;
				for(int k = 0; k < 4; k++){
					if(visitedQuads[k]==true) numberOfQuads++;
					System.out.println(numberOfQuads);
				}
				if(numberOfQuads > parameters.getQUADS()) return true;
			}
		}
	
		return false;
	}

	public boolean LIC5() {
		//System.out.println(points[0][1]);

		for(int i = 0; i < (points.length - 1); i++){
			if ((points[0][i] > points[0][i+1])) {
				return true;
			}
		}
		return false;
	}

	public boolean LIC6() {
		//if (NUMPOINTS < 3) return false;
		if (3 >= parameters.getN_PTS() && parameters.getN_PTS() >= NUMPOINTS || parameters.getDIST() < 0 || NUMPOINTS < 3) return false;

		for(int i = 0; i < NUMPOINTS - parameters.getN_PTS() +1; i++){
			int end = i + parameters.getN_PTS() - 1;
			if (points[0][i] == points[0][end] && points[1][i] == points[1][end]){
				//When there is no line: Euclidean distance is enough.
				for (int j = i+1; j<end; j++){
					//Calculate the distance to a point (using Euclidean distance)
					if (distance(points[0][i],points[0][j], points[1][i], points[1][j]) > parameters.getDIST()) {
						return true;
					}
				}
			} else {
				//Line equation: ax+by+c = 0
				int a,b,c;
				int diffX = difference(points[0][i],points[0][end]);
				int diffY = difference(points[1][i], points[1][end]);
				int k = diffY/diffX;
				int m = points[1][i] - k * points[0][i];
				a = -k;
				b = 1;
				c = -m;
				for (int j = i+1; j<end; j++){
					//Distance between point and line from wiki: abs(line equation) / sqrt(a² + b²)
					int distance_point_and_line = (int) (Math.abs(a*points[0][j] + b*points[1][j] + c) / Math.sqrt(a*a + b*b));
					if (distance_point_and_line > parameters.getDIST()) {
						return true;
					}
				}
			}

		}

		return false;
	}

	public boolean LIC7() {
		if (NUMPOINTS<3) {
			return false;
		}
		int k_pts = parameters.getK_PTS();
		for (int i = 0; i < NUMPOINTS-1-k_pts; i++){
			if (distance(points[0][i],points[0][i+k_pts],points[1][i], points[1][i+k_pts]) < parameters.getLENGTH1()) {
				return true;
			}
		}
		return false;
	}

	public boolean LIC8() {
		/*
		There exists at least one set of three data points separated by 
		exactly A PTS and B PTS consecutive intervening points, respectively, 
		that cannot be contained within or on a circle of radius RADIUS1. 
		The condition is not met when NUMPOINTS < 5.
		1 ≤ A PTS, 1 ≤ B PTS
		A PTS + B PTS ≤ (NUMPOINTS − 3)
		*/

		int aPts = parameters.getA_PTS();
		int bPts = parameters.getB_PTS();

		// Pre-existing conditions on success
		if ((NUMPOINTS < 5) || (aPts < 1 || bPts < 1) || (aPts + bPts > (NUMPOINTS - 3))) 
			return false;

		double rad = parameters.RADIUS1;

		for (int i = 0; i < (NUMPOINTS - (aPts + bPts + 2)); i++) {
			int x1 = points[0][i]; int x2 = points[0][i + 1 + aPts]; int x3 = points[0][i + aPts + 2 + bPts];
			int y1 = points[1][i]; int y2 = points[1][i + 1 + aPts]; int y3 = points[1][i + aPts + 2 + bPts];

			// points create a triangle in 2D space
			double dist12 = Point2D.distance(x1, y1, x2, y2);
			double dist13 = Point2D.distance(x1, y1, x3, y3);
			double dist23 = Point2D.distance(x2, y2, x3, y3);

			/*
			If the longest side of the triangle is larger than the diameter of the circle, 
			then no circle that spanns the three points is possible. In all other cases there 
			will be a circle that can contain all points.
			*/
			double maxDist = Math.max(dist12, Math.max(dist13, dist23));
			if (maxDist > 2 * rad) return true;
		}

		return false;
	}

	public boolean LIC9() {
		return false;
	}

	public boolean LIC10() {
		return false;
	}

	public boolean LIC11() {	
		//1 ≤G PTS ≤NUMPOINTS−2
		if (parameters.getG_PTS() < 1 || parameters.getG_PTS() > NUMPOINTS -2) return false;
		if (NUMPOINTS<3) return false;
		for(int i=0; i<NUMPOINTS-parameters.getG_PTS()-1; i++){
			int j = i + parameters.G_PTS +1;
			if((points[0][j]- points[0][i])<0) return true;
		}
		return false;
	}

	public boolean LIC12() {
		double x1, x2, y1, y2, dist;
		boolean cond1 = false;
		boolean cond2 = false;
		if(NUMPOINTS < 3){
			return false;
		}
		for(int i = 0; i < NUMPOINTS-parameters.getK_PTS()-1; i++){
			x1 = points[0][i];
			x2 = points[0][i+parameters.getK_PTS()+1];
			y1 = points[1][i];
			y2 = points[1][i+parameters.getK_PTS()+1];
			dist = Point2D.distance(x1,y1,x2,y2);
			if(dist > parameters.getLENGTH1()){
				cond1 = true;
			}
			if(dist < parameters.getLENGTH2()){
				cond2 = true;
			}
		if((cond1) & (cond2)){
			return true;
		}

		}
		return false;
	}

	public boolean LIC13() {
		return false;
	}

	public boolean LIC14() {
		return false;
	}
	
	
    //conditions met vector
    public int[] CMV() {
		//computes the conditions met vector from the LIC's
		int[] vector = {0};
        return vector;
    }
    
    //Preliminary unlock matrix
    public int[][] PMV() {
		//computes the PUM matrix from the CMV and the LCM
		int[][] matrix = { {0} };
        return matrix;
	}
	
	//Final unlock vector
	public int[] FUV() {
		//computes the FUV vector from the PMV and the PUV
		int[] vector = {0};
        return vector;
	}
	
    
    //decide method
    public void decide(int numpoints, int[] points, int[][] LCM, int[] PUV) {
		//decides method, calls CMV, PUM, FUV and decides if it launches or not

	}
	public static int distance(int x1, int x2, int y1, int y2){
		int diffX = difference(x2,x1);
		int diffY = difference(y2,y1);
		return (int) Math.sqrt(diffX*diffX + diffY*diffY);
	}

	public static int difference(int x1, int x2) {
		return x2-x1;
	}
}
