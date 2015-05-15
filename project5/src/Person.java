
public class Person 
{
	private String m_name;
	private int m_age;
	private String m_phoneNumber;
	private String m_address;
	
	public Person(String name, int age, String phoneNumber, String address)
	{
		m_name = name;
		m_age = age;
		m_phoneNumber = phoneNumber;
		m_address = address;
	}
	
	String GetPersonsName()
	{
		return m_name;
	}
	
	private void SetPersonsName(String name)
	{
		m_name = name;
	}
	
	int GetPersonsAge()
	{
		return m_age;
	}
	
	private void SetPersonsAge(int age)
	{
		m_age = age;
	}
	
	String GetPersonsAddress()
	{
		return m_address;
	}
	
	private void SetPersonsAddress(String address)
	{
		m_address = address;
	}
	
	String GetPersonsPhoneNumber()
	{
		return m_phoneNumber;
	}
	
	private void SetPersonsPhoneNumber(String phoneNumber)
	{
		m_phoneNumber = phoneNumber;
	}
	
	public void GrowsOlder()
	{
		m_age++;
	}
}
