public class Circle 
{
	String m_color;
	double m_radius;

	public Circle(double radius) 
	{
		m_radius = radius;
		m_color = "grey";
	}

	public Circle(double radius, String color) 
	{
		m_color = color;
		m_radius = radius;
	}

	public double CalculateArea() 
	{
		double area = 3.14 * m_radius * m_radius;
		return area;
	}
	
	public void PrintColor()
	{
		System.out.println("My color is: " + m_color);
	}
	public static void main(String[] args) 
	{
		Circle bigCircle = new Circle(10.0);
		double bigArea = bigCircle.CalculateArea();
		bigCircle.PrintColor();
		System.out.println("Big circle area is " + bigArea + " and the color is " + bigCircle.m_color + ".");
		
		Circle smallCircle = new Circle(5, "purple");
		double smallArea = smallCircle.CalculateArea();	
		smallCircle.PrintColor();
		System.out.println("Small circle area is " + smallArea + " and the color is " + smallCircle.m_color + ".");
		
		
	}

}
