package industree.Model;

import java.util.*;

import industree.Common.Constants.ClaimStatus;

public class EmployeeLeaves {

	private List<String> employeeLeaveStatus;
	
	public List<String> getEmployeeLeaveStatus() {
		return employeeLeaveStatus;
	}

	public void setEmployeeLeaveStatus(List<String> employeeLeaveStatus) {
		this.employeeLeaveStatus = employeeLeaveStatus;
	}

	private List<EmployeeLeave> employeeLeaves;
	
	public List<EmployeeLeave> getEmployeeLeaves() {
		return employeeLeaves;
	}

	public void setEmployeeLeaves(List<EmployeeLeave> employeeLeaves) {
		this.employeeLeaves = employeeLeaves;
	}
	
	public EmployeeLeaves()
	{
		employeeLeaves = new ArrayList<EmployeeLeave>();
		employeeLeaveStatus  = new ArrayList<String>();
		
		for(ClaimStatus claimStatus:ClaimStatus.values())
		{
			if(claimStatus != ClaimStatus.APPLIED){
			employeeLeaveStatus.add(claimStatus.toString());
			}
		}

	}

	
}
