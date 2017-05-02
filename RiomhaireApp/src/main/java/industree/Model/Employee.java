package industree.Model;
import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="Employee_tbl")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Employee {
	//Adding Column for employeeId
	@Id
	@Column(name="employeeId")
	private String employeeId;
	//Adding Column for userId
	@Column(name="userId")
	private int userId;
	//Adding Column for designation
	@Column(name="designation")
	private String designation;
	//Adding Column for dateOfJoining
	@Column(name="dateOfJoining")
	private Date dateOfJoining;
	//Adding Column for workContact
	@Column(name="workContact")
	private String workContact;
	//Adding Column for department
	@Column(name="department")
	private String department;
	
	//method to return the department
	public String getDepartment() {
		return department;
	}
	//method to set the department
	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name="managerId")
	private String managerId;
	//method to return the employeeId
	public String getEmployeeId() {
		return employeeId;
	}
	//method to set the employeeId
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	//method to return userId
	public int getUserId() {
		return userId;
	}
	//method to set the userId
	public void setUserId(int userId) {
		this.userId = userId;
	}
	//method to return designation
	public String getDesignation() {
		return designation;
	}
	//method to set the designation
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	//method to return dateOfJoining
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	//method to set dateOfJoining
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	//method to return WorkContact
	public String getWorkContact() {
		return workContact;
	}
	//method to set WorkContact
	public void setWorkContact(String workContact) {
		this.workContact = workContact;
	}
	//method to return ManagerId
	public String getManagerId() {
		return managerId;
	}
	//method to set managerId
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	
	public Employee()
	{
		
	}
	
	//Constructor
	public Employee(int userId, String employeeId, String managerId, String workContactNumber, 
			 String department)
	{
		this.userId = userId;
		this.employeeId = employeeId;
		this.managerId =managerId;
		this.workContact = workContactNumber;
		this.dateOfJoining = Calendar.getInstance().getTime();
		this.department = department;
		this.setDesignation("FactoryEmployee");
		
	}
	
}
