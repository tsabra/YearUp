
public class Programmer extends Worker
{
	public Programmer()
	{
		m_work = "I fixed a bug in my new App today!";
	}
	
	public static void main(String[] args) 
	{
		Programmer Taha = new Programmer();
		Taha.DoWork();
	
//	This is another example of Polymorphism!
//	Even though we are creating and object with the class Worker, we are
//	setting the value to another object (Taha) which was created with the 
//	Programmer class. Therefore, the DoWork method will apply to the 
//	Programmer class.
		Worker Jacob = Taha;
		Jacob.DoWork();
	}

}
