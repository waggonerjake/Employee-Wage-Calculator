// Honor Pledge:
//
//I pledge that I have neither given nor
// received any help on this assignment.
//
// jwaggon

public class PharmacyManager extends StaffPharmacist
{
	//The pharamcy specific value
	private boolean Leadership;
	
	//Constructor that takes in all the values as the StaffPharmacist Class and the specific leadership value
	public PharmacyManager(int jobType, int ID, String FirstName, String LastName, String startDate, boolean License, boolean Leadership)
	{
		//calling the StaffPharmacist constructor passing in the respective values
		super(jobType,ID,FirstName,LastName,startDate,License);
		this.Leadership = Leadership;
	}
	
	//Default
	public PharmacyManager()
	{
		Leadership = false;
	}
	
	//Getter
	public boolean getLeadership()
	{
		return Leadership;
	}
}
