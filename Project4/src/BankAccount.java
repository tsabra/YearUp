
public class BankAccount
{
	private int m_accountId = -1;
	private String m_accountName;
	private int m_customerId = -1;
	private double m_amount = 0.0;
	
	public BankAccount(int accountId, String accountName, int customerId)
	{
		m_accountId = accountId;
		m_accountName = accountName;
		m_customerId = customerId;
	}
	
	private void UpdateAmount(double newAmount)
	{
		m_amount = newAmount;
	}
	//While in debug mode, I was only able to get into UpdateAmountSecurely method by having a break point there.
	//Some errors appeared when I tried to hit run saying that the terminal was unavailable. 
	public void UpdateAmountSecurely(double newAmount, String password)
	{
		if(password != null) //always do a null check
		{
			if(password.equals("admin"))
			{
				UpdateAmount(newAmount);
				System.out.println("Updated amount in account ID " + m_accountId + " to " + m_amount);
			}
			else
			{
				System.out.println("Call the police! Unsecure access!!");
			}
			
		}
		else
		{
			System.out.println("Null password submitted, please check and resubmit.");
		}
	}
	
	int GetAccountId()
	{
		return m_accountId;
	}
	
	private void SetAccountId(int accountId)
	{
		m_accountId = accountId;
	}
	
	String GetAccountName()
	{
		return m_accountName;
	}
	
	private void SetAccountName(String accountName)
	{
		m_accountName = accountName;
	}
	
	int GetCustomerId()
	{
		return m_customerId;
	}
	
	private void SetCustomerId(int customerId)
	{
		m_customerId = customerId;
	}
	
	double GetAmount()
	{
		return m_amount;
	}
	
	private void SetAmount(double amount)
	{
		m_amount = amount;
	}
}
