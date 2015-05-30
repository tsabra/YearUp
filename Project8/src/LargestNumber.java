
public class LargestNumber 
{
	public static void main(String[] args) 
	{
		int[] array1 = {1,5,6,10,13,2,28};
		int[] array2 = {};
		int[] array3 = null;
		LargestNumberUsingForLoop(array1);
		LargestNumberUsingForLoop(array2);
		LargestNumberUsingForLoop(array3);
		
		LargestNumberUsingWhileLoop(array1);
		LargestNumberUsingWhileLoop(array2);
		LargestNumberUsingWhileLoop(array3);
	}
	
	public static void LargestNumberUsingWhileLoop(int[] inputArray)
	{
		if (inputArray != null)
		{
			if (inputArray.length > 0)
			{
				int largestNumber = inputArray[0];
				int i = 0;
				// largestNumber = 6
				// i = 3
				while (i < inputArray.length)
				{
					if (largestNumber < inputArray[i])
					{
						largestNumber = inputArray[i];
					}
					
					i++;
				}
				System.out.println("The largest number I found is: " + largestNumber);
			}
			else
			{
				System.out.println("This array does not have any numbers!");
			}
		}
		else
		{
			System.out.println("You gave me a null");
		}
	}
	
	//This is a method that takes in an ARRAY [] of INTEGERS int, and
	//returns a VOID
	public static void LargestNumberUsingForLoop(int[] inputArray)
	{	
		//This means, if the inputArray is NOT null, then
		//go into the method and do more work
		if (inputArray != null)
		{
		//This is the rest of the method that the computer will go into
		//and keep working, and as you see, there's another if statement
			if (inputArray.length > 0)
			{
				int largestNumber = inputArray[0];
			//	[1, 5, 6]
	//now you make the "For Loop"
	//This statement tells the loop to start from i (index), which is equal to 0, check whether
	//it's less than the array, and then increment the index (i) by 1
	//The index is the holder of the values.
	//The i<inputArray.length is the termination condition.
				for (int i = 0; i < inputArray.length; i++)
				{
					if (largestNumber < inputArray[i])
					{
						largestNumber = inputArray[i];
					}
				}
				
				
				System.out.println("The largest number that I found is: " + largestNumber);
			}
			else
			{
				System.out.println("This array does not have any numbers!");
			}
		}
	//This responds to the opposite of the IF statement, in this case,
	//it tells the program what to do If the array IS a null.
	//The else statement has to line up with the If statement, in other 
	//words, it can't be inside the {} of the If statement.
		else
		{
			System.out.println("You gave me a null");
		}
	}

}
