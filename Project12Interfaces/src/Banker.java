
public class Banker implements iTaxPayer 
{
	private double m_income;
	private boolean m_donePayingTaxes = false;
	
	public Banker(double income)
	{
		SetBankerIncome(income);
	}
	
	public double GetBankerIncome()
	{
		return m_income;
	}
	
	private void SetBankerIncome(double income)
	{
		m_income = income;
	}
	
	public void PayTaxes(double taxRate)
	{
		if(!m_donePayingTaxes)
		{
			double taxes = taxRate * GetBankerIncome();
			double newIncome = GetBankerIncome() - taxes;
			SetBankerIncome(newIncome);
			m_donePayingTaxes = true;
		}
		else
		{
			System.out.println("Banker already paid taxes for this year. Don't pay again!");
		}
	}
	
	public void FileTaxReturn()
	{
		if (m_donePayingTaxes == true)
		{
			System.out.println("Banker filed a tax return.");
		}
		else 
		{
			System.out.println("Banker has not yet filed taxes, return will be filed later!");
		}
	}
	
	public static void main(String[] args) 
	{
		Banker Michael = new Banker(120000.00);
		Michael.PayTaxes(0.33);
		Michael.FileTaxReturn();
		
		SchoolTeacher Tim = new SchoolTeacher(50000.00);
		Tim.PayTaxes(.23);
		Tim.FileTaxReturn();
		
		Scientists Tony = new Scientists(90000.00);
		Tony.PayTaxes(.23);
		Tony.FileTaxReturn();
		
		TaxAuditor Sam = new TaxAuditor();
		Sam.Audit(Michael);
		Sam.Audit(Tim);
		Sam.Audit(Tony);
		
	}
}
