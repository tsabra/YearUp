import java.util.Scanner;
public class ChineseYear 
{
	public static void main(String[] args) 
	{	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a new year: \n");
		int year = scanner.nextInt();
		System.out.println("I have read this year as " + year + ".");
		//takes integer input from the user 
		//integer represents year
		ChineseYear ChineseYearEvaluator = new ChineseYear();
		ChineseYearEvaluator.EvaluateChineseYear(year);
		//calls the method which evaluates the Chinese Year
		scanner.close();
		
	}
	

	public void EvaluateChineseYear(int unknownYear)
	{
		int s_knownYear = 1900;
		if(unknownYear >= s_knownYear)
		{
			int yearDifference = unknownYear - s_knownYear;
			int remainder = yearDifference % 12;
			switch (remainder)
			{
				case 0: remainder = 0;
					System.out.println(unknownYear + " is the year of rat.");
					break;
				case 1: remainder = 1;
					System.out.println(unknownYear + " is the year of the ox.");
					break;
				case 2: remainder = 2;
					System.out.println(unknownYear + " is the year of the tiger.");
					break;
				case 3: remainder = 3;
					System.out.println(unknownYear + " is the year of the rabbit.");
					break;
				case 4: remainder = 4;
					System.out.println(unknownYear + " is the year of the dragon.");
					break;
				case 5: remainder = 5;
					System.out.println(unknownYear + " is the year of the snake.");
					break;
				case 6: remainder = 6;
					System.out.println(unknownYear + " is the year of the horse.");
					break;	
				case 7: remainder = 7;
					System.out.println(unknownYear + " is the year of the sheep.");
					break;
				case 8: remainder = 8;
					System.out.println(unknownYear + " is the year of the monkey.");
					break;
				case 9: remainder = 9;
					System.out.println(unknownYear + " is the year of the rooster.");
					break;
				case 10: remainder = 10;
					System.out.println(unknownYear + " is the year of the dog.");
					break;
				case 11: remainder = 11;
					System.out.println(unknownYear + " is the year of the pig.");
					break;
						
			}
			
		}	
		else
			//for any number less than 1900
				{	
					System.out.println("Invalid Entery - Check year");
				}
		
	}
}
