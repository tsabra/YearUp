import java.util.Scanner;
public class Loop {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a value to search for: \n");
		int value = scanner.nextInt();
		
		
		int[] Array1 = {34,2,7,9};
		Problem1(Array1 , value);
		
		int[] Array2 = {7,3,12,7,8,7,32};
		Problem2(Array2 , value);
		
		scanner.close();
	}
	
	public static void Problem1(int[] arr, int SearchValue)
	{

		boolean there = false;
		for (int i = 0; i < arr.length; i++)
		{
			if (SearchValue == arr[i])
			{
				there = true;
				System.out.println("The search value for Problem1 is in index " + i + ".");
				break;
			}
		}
		
		if (there == false)
		{
			System.out.println("Your value is not found in Problem1!");
		}
	}
	
	
	public static void Problem2(int[] arr, int SearchValue)
	{
		boolean there = false;
		int numberOfOccurrences = 0; 
		for (int i = 0; i < arr.length; i++)
		{
			if (SearchValue == arr[i])
			{
				there = true;
				numberOfOccurrences++;
			}
		}
		if (there == true)
		{
			System.out.println("Your serach value for Problem2 was found " + numberOfOccurrences + " times.");	
		}
		else
		{
			System.out.println("Your value is not found in Problem2!");
		}
	}
}
