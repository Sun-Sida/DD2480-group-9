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
	public Decide() {}


    //LIC conditions
    public boolean LIC0(double[] X, double[] Y, int numpoints, double length1) {
		double x1, y1, x2, y2, dist;
		for(int i = 1; i < numpoints; i++){
			x1 = X[i-1];
			y1 = Y[i-1];
			x2 = X[i];
			y2 = Y[i];
			dist = Point2D.distance(x1,y1,x2,y2);
			if(dist > length1){return true;}
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
		//System.out.println(points[3][0]);

		for(int i = 0; i < (points.length - 1); i++){
			if ((points[i][0] > points[i+1][0])) {
				return true;
			}
		}
		return false;
	}

	public boolean LIC6() {
		//if (NUMPOINTS < 3) return false;
		if (3 >= parameters.getN_PTS() && parameters.getN_PTS() >= NUMPOINTS || parameters.getDIST() < 0 || NUMPOINTS < 3) return false;

		for(int i = 0; i < NUMPOINTS - parameters.getN_PTS() +1; i++){
			int end = i + parameters.getN_PTS() -1;
			if (points[i][0] == points[end][0] && points[0][i] == points[0][end]){
				//When there is no line: Euclidean distance is enough.
				for (int j = i+1; j<end; j++){
					//Calculate the distance to a point (using Euclidean distance)
					if (distance(points[i][0],points[end][0], points[0][i], points[0][end]) > parameters.getDIST()) {
						return true;
					}
				}
			} else {
				//Line equation: ax+by+c = 0
				int a,b,c;
				int diffX = difference(points[i][0],points[end][0]);
				int diffY = difference(points[0][i], points[0][end]);
				int k = diffY/diffX;
				int m = points[0][i] - k * points[i][0];
				a = -k;
				b = 1;
				c = -m;
				for (int j = i+1; j<end; j++){
					//Distance between point and line from wiki: abs(line equation) / sqrt(a² + b²)
					int distance_point_and_line = (int) (Math.abs(a*points[i][0] + b*points[0][i]+ c) / Math.sqrt(Math.pow(2, a) + Math.pow(2,b)));
					if (distance_point_and_line > parameters.getDIST()) return true;
				}
			}

		}


		return false;
	}

	public boolean LIC7() {
		return false;
	}

	public boolean LIC8() {
		return false;
	}

	public boolean LIC9() {
		return false;
	}

	public boolean LIC10() {
		return false;
	}

	public boolean LIC11() {
		return false;
	}

	public boolean LIC12() {
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
		return (int) Math.sqrt(Math.pow(2,diffX) + Math.pow(2, diffY));
	}

	public static int difference(int x1, int x2) {
		return x2-x1;
	}
}
