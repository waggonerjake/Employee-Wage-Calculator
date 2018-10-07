// Honor Pledge:
// 
//I pledge that I have neither given nor
// received any help on this assignment.
//
// jwaggon

public class Employee
{
	//Things all employees have
	protected int ID;
	protected String FirstName;
	protected String LastName;
	protected String startDate;
	protected double Rate;
	protected int jobType;
	
	//Default Constructor
	public Employee()
	{
		ID = 0;
		FirstName = "";
		LastName = "";
		Rate = 0.0;
		startDate = "";
		jobType = 0;
	}
	//Constructor passing in all the availiable values from the .txt provided
	public Employee(int jobType, int ID, String FirstName, String LastName, String startDate)
	{
		this.jobType = jobType;
		this.ID = ID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.startDate = startDate;
	}
	
	//Everything below are getters
	public int getID()
	{
		return ID;
	}
	
	public String getFirstName()
	{
		return FirstName;
	}

	public String getLastName()
	{
		return LastName;
	}

	public int getJobType()
	{
		return jobType;
	}		

	public String getStartDate()
	{
		return startDate;
	}

	public double getRate()
	{
		//Depending on their job ID,
		//the rate with change
		switch(jobType)
		{
			case 1: Rate = 50.0;
				break;
			case 2: Rate = 40.0;
				break;
			case 3: Rate = 20.0;
				break;
			case 4: Rate = 25.0;
				break;
			default: Rate = 0.0;
				break;
		}
		return Rate;
	}
}
