// Honor Pledge:
//
//I pledge that I have neither given nor
// received any help on this assignment.
//
// jwaggon

public class SeniorTechnician extends StaffTechnician
{
	//Senior Tech. specific value
	private boolean serviceAward;
	
	//Constructor taking in all values from StaffTechnician but also passing in the specific value serviceAward.
	//Basically, creating a specialized employee with Staff and Senior Tech. spealization
	public SeniorTechnician(int jobType, int ID, String FirstName, String LastName, String startDate, boolean Degree,boolean serviceAward)
	{
		//Caliing the StaffTechnician constructor passin in respective values
		super(jobType,ID,FirstName,LastName,startDate,Degree);
		this.serviceAward = serviceAward;
	}

	//Default
	public SeniorTechnician()
	{
		serviceAward = false;	
	}

	//Getter
	public boolean getAward()
	{
		return serviceAward;
	}
}
