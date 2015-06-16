//This class will be inherited by other Classes: Doctor, Lawyer, and Programmer.
//The purpose of this program is to demonstrate Inheritance and Polymorphism.
public class Worker 
{
	protected String m_work = "I work for a living.";
	
	protected void DoWork()
	{
		System.out.println(m_work);
	}
}
