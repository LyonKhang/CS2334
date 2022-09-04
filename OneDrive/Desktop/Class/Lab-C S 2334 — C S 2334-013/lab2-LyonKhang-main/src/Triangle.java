import java.lang.Math;
import java.text.DecimalFormat;

public class Triangle {
	//variable
	private double sideA;
	private double sideB;
	private double sideC;
	public static final String POLYGONSHAPE = "Triangle";
	public static final double DEFAULT_SIDE = 1;
	//constructor
	public Triangle() {
		sideA = DEFAULT_SIDE;
		sideB = DEFAULT_SIDE;
		sideC = DEFAULT_SIDE;
	}
	
	public Triangle(double sideA,double sideB,double sideC) {
		if(isTriangle(sideA,sideB,sideC)) {
			if (sideA <=0)
				this.sideA=DEFAULT_SIDE;
			if (sideB <=0)
				this.sideB=DEFAULT_SIDE;
			if (sideC <=0)
				this.sideC=DEFAULT_SIDE;
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		}
		else {
			
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}

		
	}
	//maybe finish
	public Triangle(double[] sides) {
		if(sides ==null) {
			sideA = DEFAULT_SIDE;
			sideB = DEFAULT_SIDE;
			sideC = DEFAULT_SIDE;
			
		}
		else {
			if(isTriangle(sides)) {
				for (int i =0; i < sides.length;i++)
						sides[i]=DEFAULT_SIDE;
			}
			for (int i =0; i < sides.length;i++) {
				if(sides[i]<=0)
					sides[i]=DEFAULT_SIDE;
			}
			if (sides.length == 3) {
			sideA = sides[0];
			sideB = sides[1];
			sideC = sides[2];
			}
			else if (sides.length == 2) {
			sideA = sides[0];
			sideB = sides[1];
			sideC = DEFAULT_SIDE;
			}
			else if(sides.length == 1){
			sideA = sides[0];
			sideB = DEFAULT_SIDE;
			sideC = DEFAULT_SIDE;
			}
			else {
				sideA = DEFAULT_SIDE;
				sideB = DEFAULT_SIDE;
				sideC = DEFAULT_SIDE;
				}
			
		}

}
	//not finish
	public Triangle(Triangle triangle) {
		if(triangle!=null) {
			this.sideA=triangle.getSideA();
			this.sideB=triangle.getSideB();
			this.sideC=triangle.getSideC();
		}
		else {
		this.sideA = DEFAULT_SIDE;
		this.sideB = DEFAULT_SIDE;
		this.sideC = DEFAULT_SIDE;
		}
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
	// getter Angle
	public double getAngleA() {
		return lawOfCosines(sideC, sideB, sideA);
	}
	
	public double getAngleB() {
		return lawOfCosines(sideC, sideA, sideB);
	}
	
	public double getAngleC() {
		return lawOfCosines(sideA, sideB, sideC);
	}
	
	public double[] getAngles() {
		 double[] array = {getAngleA(),getAngleB(),getAngleC()};
		return array;
	}
	
	//setter
	public boolean setSideA(double sideA) {
		if (sideA <=0 || !isTriangle(sideA,sideB,sideC))
			return false;
		this.sideA=sideA;
		return true;
	}
	
	public boolean setSideB(double sideB) {
		if (sideB <=0 || !isTriangle(sideA,sideB,sideC))
			return false;
		this.sideB=sideB;
		return true;
	}
	
	public boolean setSideC(double sideC) {
		if (sideC <=0 || !isTriangle(sideA,sideB,sideC))
			return false;
		this.sideC=sideC;
		return true;
	}
	public boolean setSides(double[] input) {
		if (  !isTriangle(input))
			return false;
		sideA = input[0];
		sideB = input[1];
		sideC = input[2];
		return true;
	}
	
	
	//helperMethods , not finish
	public static boolean isTriangle(double a,double b,double c){
		if((a+b >c)&& (a+c >b)&&(b+c>a)&&(a*b*c != 0))
		{
			return true;
		}
		else return false;
	}
	
	public static boolean isTriangle(double[] sides) {
		if(sides ==null)
			return false;
		else if(sides.length !=3) {
			return false;
		}
		else if(sides[0]== DEFAULT_SIDE && sides[1] == DEFAULT_SIDE && sides[2]== DEFAULT_SIDE) {
			return true;
		}
		else if( sides[0] <= 0 && sides[1] <= 0&& sides[2] <= 0)  {
			return false;
		}
		else if(!isTriangle(sides[0],sides[1],sides[2])) {
			if(sides[0]==sides[1]&& sides[1]== sides[2]&&sides[0]==sides[2])
				return true;
			return false;
		}
		else
			
		return true;
	}
	
	// finish
	public static double lawOfCosines(double a, double b, double c) {
		
	    return  Math.toDegrees(Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)));
	    }
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.0000");
		String formatA = df.format(getSideA());
		String formatB = df.format(getSideB());
		String formatC = df.format(getSideC());

		return POLYGONSHAPE +"("+ formatA + ", " +formatB + ", " + formatC +")";
	}
	//test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] test = new double[] {1,2,3};
		Triangle input = new Triangle(test);
		System.out.println(input.getSideA());
		System.out.println(input.getSideB());
		
		double[] testTwo = new double[] {1,1,1};

		Triangle cat = new Triangle(testTwo);
		System.out.println(cat.getSideA());
		System.out.println(cat.getSideB());
		
		double[] testThree = new double[] {4.5100,4.5100,4.5100};

		Triangle dog = new Triangle(testThree);
		System.out.println(dog.getSideA()== dog.getSideB());
		System.out.println(dog.getSideB());
		
	}
	//theEnd
}
