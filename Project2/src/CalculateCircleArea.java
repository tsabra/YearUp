
public class CalculateCircleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	double CircleArea = CalculateCircleArea(13);
	System.out.println("The area of the circle is " + CircleArea + ".");
	
	double RectangleArea = CalculateRectangleArea (5,9);
	System.out.println("The area of the rectangle is " + RectangleArea + ".");
	}
	
	static double CalculateCircleArea(int radius){
		double area = 3.14*radius*radius;
		return area; 
	}
	
	static double CalculateRectangleArea (int length, int breadth){ 
		double area = length*breadth; 
		return area; 
	}

}
