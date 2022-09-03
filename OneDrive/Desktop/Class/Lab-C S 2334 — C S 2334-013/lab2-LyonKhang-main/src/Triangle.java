import java.lang.Math;


public class Triangle {
	//variable
	private double sideA;
	private double sideB;
	private double sideC;
	private static String POLYGONSHAPE = "Triangle";
	private static final double  DEFAULT_SIDE = 1;
	//constructor
	public Triangle() {
		sideA = DEFAULT_SIDE;
		sideB = DEFAULT_SIDE;
		sideC = DEFAULT_SIDE;
	}
	
	public Triangle(double sideA,double sideB,double sideC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		
	}

	public Triangle(double[] sides) {
		sideA = sides[0];
		sideB = sides[1];
		sideC = sides[2];
	
}
	public Triangle(Triangle triangle) {
	
}
	
	//method
	// getter
	public double getSideA() {
		return sideA;
	}
	
	public double getSideB() {
		return sideB;
	}
	
	public double getSideC() {
		return sideC;
	}
	
	public double[] getSides() {
		 double[] array = {sideA,sideB,sideC};
		return array;
	}
	// setter
	
	
	//helperMethods
	public static boolean isTriangle(double a,double b,double c){
		if(a+b >c || b+c >a || c+a>b)
			return false;
		if( Math.abs(a-b)<c|| a+b>c)
			return false;
		return true;
	}
	
	public static boolean isTriangle(double[] sides) {
		if(sides[0]+sides[1] >sides[2] || sides[1]+sides[2] >sides[0] || sides[2]+sides[0]>sides[1])
			return false;
		return true;
	}
	
	public double lawOfCosines(double a, double b, double c) {
		
	    return Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
	    }
	
	//theEnd
}
