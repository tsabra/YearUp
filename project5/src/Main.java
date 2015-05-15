
public class Main 
{

	public static void main(String[] args) 
	{
		Person Taha = new Person("Taha", 23, " 4043979809", " 1050 Curran Street"); //This sets Taha as a new person.
		System.out.println("There's an Egyptian guy in Ms. Uthra's class. His name is " + Taha.GetPersonsName() + "."); //This calls the getter for the name method.
		System.out.println("His information is the followin:");
		System.out.println("Age: " + Taha.GetPersonsAge());
		System.out.println("Phone number: " + Taha.GetPersonsPhoneNumber());
		System.out.println("Address: " + Taha.GetPersonsAddress());
		/** I wanted to have everything in order as a list.
		 *  I was able to do that by printing every piece of information on a new line.
		 */ 
		Taha.GrowsOlder();
		System.out.println("On September 1, though, he is turning " + Taha.GetPersonsAge() + ".");
		//This is the only way I could think of to use the GrowsOlder method.
	}
}