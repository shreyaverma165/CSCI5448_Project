package industree.Model;

//Inheriting properties of Employee in HRManager
public class HRManager extends Employee{

	public HRManager(int userId, String employeeId, String managerId, String workContactNumber, 
			 String department)
	{
		super(userId, employeeId, null, workContactNumber, department);
		this.setDesignation("HRManager");
		
	}
	
}
