
public class Palindrome 
{

	public static void main(String[] args) 
	{	
		
		String Word1 = "RaCeCaR";
		String Word2 = "Mercedez Benz";
//		Whenever I set the value to null, it prints that it's a null string, but it also considers it a Palindrome!
//		I tried to place the null check in various places inside and outside of all the methods and it wouldn't work.
//		However, If I don't include a null check, I don't get a null reference exception! 
//		So is it better to not include the null check at all?
		
	
		boolean isString1Palindrome = isPalindrome(Word1);
		boolean isString2Palindrome = isPalindrome(Word2);
		
		if (isString1Palindrome)
		{
			System.out.println(Word1 + " is a palindrome.");
		}
		else
		{
			System.out.println(Word1 + " is NOT a palindrome.");
		}
		if (isString2Palindrome)
		{
			System.out.println(Word2 + " is a palindrome.");
		}
		else
		{
			System.out.println(Word2 + " is NOT a palindrome.");
		}
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
					break;
				}
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
