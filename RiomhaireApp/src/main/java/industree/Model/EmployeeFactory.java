package industree.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import industree.Common.Constants.UserRoles;
import industree.Database.*;

public class EmployeeFactory {
	
		private  DBConnection dbConnection;
		
		public EmployeeFactory()
		{
			dbConnection= new DBConnection();
		}
	
		public Employee getEmployee(String firstName, String lastName, String middleName, String contactNumber, 
				String department, String employeeDesignation, String dateOfBirth, String managerId, String address) throws ParseException
		{
			Employee employee;
			String employeeId = this.generateEmployeeId(firstName, employeeDesignation);
			String emailAddress = this.generateEmailAddress(employeeId);
			String userName = emailAddress;
			String password = "password";
			User user;
			
			if(employeeDesignation.compareToIgnoreCase("HRManager")==0)
			{
				
				user = dbConnection.saveUser(new User(firstName, middleName, lastName, emailAddress, (Date)new SimpleDateFormat("mm/dd/yyyy").parse(dateOfBirth),userName, password, UserRoles.HR_MANAGER.getUserRoleId(), address));
				
				employee= new Employee(user.getUserId(), employeeId, null, contactNumber, department);
				employee.setDesignation("HRManager");
			}
			else if(employeeDesignation.compareToIgnoreCase("FactoryManager")==0)
			{
				user = dbConnection.saveUser(new User(firstName, middleName, lastName, emailAddress, (Date)new SimpleDateFormat("mm/dd/yyyy").parse(dateOfBirth),userName, password, UserRoles.FACTORY_MANAGER.getUserRoleId(), address));
				employee = new Employee(user.getUserId(), employeeId, managerId, contactNumber, department);
				employee.setDesignation("FactoryManager");
			}
			else{
				user = dbConnection.saveUser(new User(firstName, middleName, lastName, emailAddress, (Date)new SimpleDateFormat("mm/dd/yyyy").parse(dateOfBirth),userName, password, UserRoles.FACTORY_EMPLOYEE.getUserRoleId(), address));
				employee = new Employee(user.getUserId(), employeeId, managerId, contactNumber, department);
			}
			dbConnection.saveEmployeeProfile(employee);
			return employee;
		}
		
		private String generateEmployeeId(String firstName,String employeeDesignation)
		{
			String employeeId="";
			if(employeeDesignation.compareToIgnoreCase("HRManager")==0)
			{
				employeeId = employeeId.concat("HR");
			}
			else if(employeeDesignation.compareToIgnoreCase("FactoryManager")==0)
			{
				employeeId= employeeId.concat("FM");
			}
			else{
				employeeId= employeeId.concat("FE");
			}
			
			employeeId = employeeId.concat(firstName.substring(0, 2));
			employeeId = employeeId.concat(String.format("%04d", (new Random()).nextInt(10000)));
			
			
			return employeeId;
		}
		
		private String generateEmailAddress(String employeeId)
		{
			return employeeId.concat("@Riomhaire.com");
		}
		
		
}
