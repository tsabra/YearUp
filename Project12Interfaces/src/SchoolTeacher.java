
public class SchoolTeacher implements iTaxPayer
{
	private double m_income;
	private boolean m_donePayingTaxes = false;
	
	public SchoolTeacher(double income)
	{
		SetSchoolTeacherIncome(income);
	}
	
	public double GetSchoolTeacherIncome()
	{
		return m_income;
	}
	
	private void SetSchoolTeacherIncome(double income)
	{
		m_income = income;
	}
	
	public void PayTaxes(double taxRate)
	{
		if(!m_donePayingTaxes)
		{
			double taxes = taxRate * GetSchoolTeacherIncome();
			double newIncome = GetSchoolTeacherIncome() - taxes;
			SetSchoolTeacherIncome(newIncome);
			m_donePayingTaxes = true;
		}
		else
		{
			System.out.println("School Teacher already paid taxes for this year. Don't pay again!");
		}
	}
	
	public void FileTaxReturn()
	{
		if (m_donePayingTaxes == true)
		{
			System.out.println("School Teacher has filed a tax return.");
		}
		else 
		{
			System.out.println("School Teacher has not yet filed taxes, return will be filed later!");
		}
	}
}
