//This Program demonstrates Exception handling by deliberately creating exceptions, catching them,
//and printing out an error message!
public class ExceptionCentral 
{	
	public static void main(String[] args) 
	{		
		ExceptionCentral exceptionsCentral = new ExceptionCentral();
	
		try		//This try and catch block is used for the Arithmetic Exception
		{
			exceptionsCentral.Divide(5, 0); //Here, we are deliberately dividing by zero to create an error!
		}
		catch(Exception ex)
		{
			System.out.println("Could not divide by zero"); //here, the exception is caught and the message is printed.
			ex.printStackTrace(); //This method prints the actual error message that is usually printed by Java
		}
		
		try		//This try and catch block is used for the NullPointerException!
		{
			exceptionsCentral.PrintSomething(null);
		}
		catch(NullPointerException nullEx)
		{
			System.out.println("Null value entered!");
			nullEx.printStackTrace();
		}
		
		String[] stringArray = {"Tim", "John", "Khalid", "Jim"}; //This string is to be used for the IndexOutOfBoundsException!
		try 
		{
			exceptionsCentral.printArrayValue5(stringArray);
		}
		catch(ArrayIndexOutOfBoundsException ex3)
		{
			System.out.println("Array did not have a 5th slot!");
			ex3.printStackTrace();
		}
		
		int[] Array1 = {}; //this array will also throw an IndexOutOfBoundsException
		exceptionsCentral.PrintArrayValues(Array1);
	}
	
	int Divide(int number, int divisor) throws ArithmeticException
	{
		int quotient = number/divisor;
		System.out.println(quotient);
		return quotient;
	}
	
	void PrintSomething(String someString) throws NullPointerException
	{
		String smallString = someString.toLowerCase();
		System.out.println(smallString);
	}
	
	void printArrayValue5 (String[] sArray) throws ArrayIndexOutOfBoundsException
	{
		System.out.println(sArray[5]);
	}
	
	void PrintArrayValues(int[] array)
	{
		try
		{
			for (int i = 0; i < 10; i++)
			{
				System.out.println(array[i]);
			}
		}
		catch(ArrayIndexOutOfBoundsException indexException)
		{
			System.out.println("array passed in did not have 10 slots");
			indexException.printStackTrace();
		}
	}
}
