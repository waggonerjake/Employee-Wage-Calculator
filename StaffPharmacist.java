//Honor Pledge
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//jwaggon

public class StaffPharmacist extends Employee
{
	//Pharmacist specific value
	private boolean Licensed;

	//Constructor that takes in every value as the employee constructor and the licensed special value
	public StaffPharmacist(int jobType, int ID, String FirstName, String LastName, String startDate, boolean Licensed)
	{
		//Calls the Employee constructor passing in the respective values
		super(jobType,ID,FirstName,LastName,startDate);
		this.Licensed = Licensed;
	}
	
	//Default
	public StaffPharmacist()
	{
		Licensed = true;
	}	
	
	//Getter
	public boolean getLicense()
	{
		return Licensed;
	}
	
}
