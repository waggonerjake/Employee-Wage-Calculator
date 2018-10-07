// Honor Pledge:
//
// 
//I pledge that I have neither given nor
//received any help on this assignment.
//
//jwaggon

public class StaffTechnician extends Employee
{
	//Tech. specific value
	private boolean Degree;

	//Constructor taking in all the values as Employee does and the special Degree value
	public StaffTechnician(int jobType, int ID, String FirstName, String LastName, String startDate, boolean Degree)
	{
		//calling the employee constructor passing in respecive values
		super(jobType,ID,FirstName,LastName,startDate);
		this.Degree = Degree;
	}

	//Default
	public StaffTechnician()
	{
		Degree = false;
	}

	//GEtter
	public boolean getDegree()
	{
		return Degree;
	}
}
