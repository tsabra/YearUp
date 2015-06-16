
public class Lawyer extends Worker
{
	public Lawyer()
	{
		m_work = "I saved someone from a life sentence today!";
	}
	
	public static void main(String[] args)
	{
		Lawyer jim = new Lawyer();
		jim.DoWork();
	}
}
