//Honor Pledge
//
//I pledge that I have neither given nor 
//received any help on this assignment.
//
//jwaggon

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Driver
{
	//Creating an array of length 4 filled with Employees
	private int arrayLength = 4;
	private Employee[] employeeArray = new Employee[arrayLength];

	//Array to hold each employees' hours
	private int[] eachHours = new int[arrayLength];
	
	//Boolean to make sure user enters hours befroe calculating paychecks
	private boolean hoursCheck = false;
	
	public double hoursWorked;

	//Starts off the program by opening the beginning menu
	public static void main(String args[])
	{
		Driver driver = new Driver();
		driver.showStartMenu();
	}
		
	//Displays the menu, reads the file, and saves each employee in the array`
	public void showStartMenu()
	{
		boolean keepGoing = true;
		Scanner input = new Scanner(System.in);
		//Counter to iterate through the array
		int arrayCounter = 0;
		while(keepGoing)
		{
			System.out.println("1. Load Employees (From File)");
			System.out.println("2. Exit Program");
			System.out.print("Enter Your Selection: ");
			String reply = input.next();
			if(reply.equals("1"))
			{
				try{
					File file = new File("employees.txt");	
					input = new Scanner(file);
					input.nextLine();	
					while(input.hasNextLine())
					{
						String tempEmployee = input.nextLine();
						String[] tempArray = tempEmployee.split(",");
						if(Integer.parseInt(tempArray[0]) == 1)
						{
							//Creating a new Pharmacy Manager with the
							//properties from the file based off their job
							//ID and storing into the employee array.
							employeeArray[arrayCounter] = new PharmacyManager(
									Integer.parseInt(tempArray[0]),
									Integer.parseInt(tempArray[1]),
									tempArray[2],
									tempArray[3],
									tempArray[4],
									true,
									true);
						}
						else if(Integer.parseInt(tempArray[0]) == 2)
						{ 
							//Same deal as the pharmacy manager above, but
							//swithce to proper job title, next two are similar
							//as well
							employeeArray[arrayCounter] = new StaffPharmacist(
									Integer.parseInt(tempArray[0]),
									Integer.parseInt(tempArray[1]),
									tempArray[2],
									tempArray[3],
									tempArray[4],
									true);
						}
						else if(Integer.parseInt(tempArray[0]) == 3)
						{
							employeeArray[arrayCounter] = new StaffTechnician(
									Integer.parseInt(tempArray[0]),
									Integer.parseInt(tempArray[1]),
									tempArray[2],
									tempArray[3],
									tempArray[4],
									true);
						}
						else
						{
							employeeArray[arrayCounter] = new SeniorTechnician(
									Integer.parseInt(tempArray[0]),
									Integer.parseInt(tempArray[1]),
									tempArray[2],
									tempArray[3],
									tempArray[4],
									true,
									true);
						}
						//increment the counter after every iteration so we
						//can get every job title
						arrayCounter++;
					}
				}
				//Exception handling that ends the program
				catch(FileNotFoundException e){
					System.out.println("\nIO Exception! Exiting Program!\n");
					keepGoing = false;
				}
				System.out.println("\nFile Loaded Succesfully!\n");
				showSecondaryMenu();
				keepGoing = false;
			}
			else if(reply.equals("2"))
			{
				keepGoing = false;
				System.out.println("\nGoodbye!\n");
			}
			else
			{
				System.out.println("\nPlease Enter a valid input selection, 1 or 2.\n");
			}	
		}
		input.close();
	}
	//Displays the secondary menu of the program
	public void showSecondaryMenu()
	{
		Scanner input = new Scanner(System.in);
		boolean keepGoing = true;
		while(keepGoing)
		{
			System.out.println("1. Print Employee Information");
			System.out.println("2. Enter Hours Worked");
			System.out.println("3. Calculate Paychecks");
			System.out.println("4. Exit Program");	
			System.out.print("Enter Your Selection: ");		
			String reply = input.next();
			switch(reply)
			{
				case "1": loadEmployees();
					break;
				case "2": enterHours(input);
					break;
				case "3": calculatePaychecks();
					break;
				case "4": 
				keepGoing = false;
				System.out.println("\nGoodbye!\n");
				break;
				default: System.out.println("\nPlease enter a valid selection: 1,2,3 or 4\n");
			}
		}
		input.close();
	}
	//Prints the employees off with their corect format, and job specific credentials
	public void loadEmployees()
	{
		for(int i = 0; i < arrayLength; i++)
		{
			String genericEmployee = "%-20s %-30s %-18s %-25s\n";
			String specialEmployee = "%-20s %-30s %-18s %-25s %-30s\n";
			//These if statements decide on what kind of job they have, out 
			//of the 4 ID's we are given, as to what they have credential wise
			if(employeeArray[i].getJobType() == 1)
			{
				System.out.format(specialEmployee,
				"ID: " + employeeArray[i].getID(),
				"Name: " + employeeArray[i].getFirstName()+" "+employeeArray[i].getLastName(), 
				"Rate: " + employeeArray[i].getRate(),
				"Licensed: " + ((PharmacyManager)employeeArray[i]).getLicense(),
				"Has Leadership: " + ((PharmacyManager)employeeArray[i]).getLeadership()
				);
			}
			else if(employeeArray[i].getJobType() == 2)
			{
				System.out.format(genericEmployee,
				"ID: " + employeeArray[i].getID(),
				"Name: " + employeeArray[i].getFirstName()+" "+employeeArray[i].getLastName(), 
				"Rate: " + employeeArray[i].getRate(),
				"Licensed: " + ((StaffPharmacist)employeeArray[i]).getLicense()
				);
			}
			else if(employeeArray[i].getJobType() == 3)
			{
				System.out.format(genericEmployee,
				"ID: " + employeeArray[i].getID(),
				"Name: " + employeeArray[i].getFirstName()+" "+employeeArray[i].getLastName(), 
				"Rate: " + employeeArray[i].getRate(),
				"Has Degree: " + ((StaffTechnician)employeeArray[i]).getDegree()
				);
			}
			else
			{
				System.out.format(specialEmployee,
				"ID: " + employeeArray[i].getID(),
				"Name: " + employeeArray[i].getFirstName()+" "+employeeArray[i].getLastName(), 
				"Rate: " + employeeArray[i].getRate(),
				"Has Degree: " + ((SeniorTechnician)employeeArray[i]).getDegree(),
				"Has Service Award: " + ((SeniorTechnician)employeeArray[i]).getAward()
				);
			}

		}
	}

	//Allows the user to input hours worked for each employee and stores it in an array
	public void enterHours(Scanner input)
	{
		int reply = 0;
		boolean error = false;
		while(error == false)
		{
			try{
				for(int i = 0; i < arrayLength; i++)
				{
					System.out.print("Please enter the hours worked for employee with ID, \"" + employeeArray[i].getID() + "\": ");
					reply = input.nextInt();
					eachHours[i] = reply;
				}
			}
			//Excpetion handling to make sure the user inputs a number
			catch(InputMismatchException e){
				System.out.println("\nPlease enter a valid number.\n");
				input.next();
				continue;
			}
			//IF they put a negative number, just make it non negative
			if(reply < 0)
			{
				System.out.println("\nCannot have negative hours. Setting " + reply + " to " + (reply*-1) +  ".\n"); 
			}
			error = true;
		}	
		hoursCheck = true;
	}
	//Calculates the employees payments based off of the user defined hours worked
	//by multiplying their hourly rate to the hours worked
	public void calculatePaychecks()
	{
		int hourCheck = 0;
		for(int i = 0; i < arrayLength; i++)
		{
			hourCheck += eachHours[i];
		}
		if(!hoursCheck && hourCheck == 0)
		{
			System.out.println("\nYou must enter hours worked (Option #2) before calculating paychecks!\n");
		}
		else
		{
			String formatter = "%-20s %-30s\n";
			for(int i = 0; i < arrayLength; i++)
			{
				System.out.format(formatter,
						"ID: " + employeeArray[i].getID(),
						"Check Amount: " + "$" + employeeArray[i].getRate() * eachHours[i]
						);
			}
		}
		hoursCheck = false;
	}
}




