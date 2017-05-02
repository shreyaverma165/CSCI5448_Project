package industree.Model;

import java.util.Date;

public class SearchResults {
	
	private String name;
	private String contactNumber;
	private String department;
	private String designation;
	private String mailAddress;
	private Date dateOfJoining;
	private String employeeId;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		designation = designation;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	
	public SearchResults()
	{
		
	}
	
	public SearchResults(String name, String contactNumber, String department, String designation, Date dateOfJoining, String  mailAddress
			, String employeeId)
	{
		this.name= name;
		this.contactNumber = contactNumber;
		this.department = department;
		this.designation = designation;
		this.dateOfJoining = dateOfJoining;
		this.mailAddress = mailAddress;	
		this.employeeId = employeeId;
		
	}
	
	

}
