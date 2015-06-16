//This class inherits the class "worker" by using the word "extends". 
public class Doctor extends Worker 
{
	public Doctor() //This constructor changes the value of m_work
	{
		m_work = "I stitched someone's mouth closed today!";
	}
	
	public static void main(String[] args)
	{
//	Inheritance allows you to create an object with another class
//	Here, we are creating a worker object because we inherited the class Worker.
//	Therefore, the method DoWork will apply to the Worker class.
		Worker Dentist = new Worker();
		Dentist.DoWork();	
		
//	This object demonstrates Polymorphism!
//	Even though the object dentist was assigned to the class worker, here we can change it 
//	here to be assigned to the class Doctor.
//	This way, the method DoWork, will apply to the Doctor class.
		Dentist = new Doctor();
		Dentist.DoWork();
	}
}
