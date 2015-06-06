import java.util.Scanner;
/* 
 * This is a scanner method that simply scans a particular variable.
 * It will be used later to scan and read the input of the console in order to execute a method with the input. 
 */
public class PalindromeWithScanner {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a word to check if it's a Palindrome: \n");
		
		String word = scanner.nextLine();
		
		isPalindrome(word);
		boolean BlahBlah = isPalindrome(word);
		if (BlahBlah)
		{
			System.out.println("The word you entered is a palindrome!");
		}
		else
		{
			System.out.println("The word you entered is NOT a palindrome!");
		}
		scanner.close();
	}

	public static boolean isPalindrome(String wordInput)
	{
		boolean isPalindrome = true;
		
		if (wordInput != null)
		{
			String wordInputNoSpace = wordInput.replace(" ", "").toLowerCase();
			char[] wordInputChars = wordInputNoSpace.toCharArray();
			
			for (int i = 0, k = wordInputChars.length -1; i < wordInputChars.length/2; i++, k--)
			{
				if (wordInputChars[i] != wordInputChars[k])
				{
					isPalindrome = false;
					//System.out.println("Your word is NOT a Palindrome");
		//Did not need a print statement since I put it in the Main method!
					break;
				}
				//System.out.println("Your word is a Palindrome!");
		//Did not need a print statement since I put it in the Main method!
			}
			
		}
		else
		{
			System.out.println("You gave me a null string :(");
			isPalindrome = false;
		}
		return isPalindrome;
	}
}
