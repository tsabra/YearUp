
public class Scientists implements iTaxPayer 
{
	private double m_income;
	private boolean m_donePayingTaxes = false;
	
	public Scientists(double income)
	{
		SetScientistsIncome(income);
	}
	
	public double GetScientistsIncome()
	{
		return m_income;
	}
	
	private void SetScientistsIncome(double income)
	{
		m_income = income;
	}
	
	public void PayTaxes(double taxRate)
	{
		if(!m_donePayingTaxes)
		{
			double taxes = taxRate * GetScientistsIncome();
			double newIncome = GetScientistsIncome() - taxes;
			SetScientistsIncome(newIncome);
			m_donePayingTaxes = true;
		}
		else
		{
			System.out.println("Scientist already paid taxes for this year. Don't pay again!");
		}
	}
	
	public void FileTaxReturn()
	{
		if (m_donePayingTaxes == true)
		{
			System.out.println("Scientist has filed a tax return.");
		}
		else 
		{
			System.out.println("Scientist has not yet filed taxes, return will be filed later!");
		}
	}
}
