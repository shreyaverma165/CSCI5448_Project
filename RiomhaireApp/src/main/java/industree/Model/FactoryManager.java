package industree.Model;



public class FactoryManager extends Employee {

	public FactoryManager(int userId, String employeeId, String managerId, String workContactNumber, 
			 String department)
	{
		super(userId, employeeId, managerId, workContactNumber, department);
		this.setDesignation("FactoryManager");
		
	}
	
}
