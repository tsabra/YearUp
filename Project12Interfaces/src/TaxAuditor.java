
public class TaxAuditor 
{
	public void Audit(iTaxPayer taxpayer)
	{
		System.out.println(taxpayer.getClass() + " has been audited");
	}
}
