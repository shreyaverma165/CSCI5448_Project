package industree.Model;

import java.util.*;

import industree.Common.Constants.ClaimStatus;

public class EmployeeClaims {
	
	private List<EmployeeClaim> employeeClaims;
	
	private List<String> employeeclaimStatus;
	
	public List<EmployeeClaim> getEmployeeClaims()
	{
		return employeeClaims;
	}
	
	public void setEmployeeClaims(List<EmployeeClaim> employeeClaims)
	{
		this.employeeClaims= employeeClaims;
	}
	
	public List<String> getEmployeeclaimStatus() {
		return employeeclaimStatus;
	}

	public void setEmployeeclaimStatus(List<String> employeeclaimStatus) {
		this.employeeclaimStatus = employeeclaimStatus;
	}

	public EmployeeClaims()
	{
		employeeClaims=new ArrayList<EmployeeClaim>();
		employeeclaimStatus  = new ArrayList<String>();
		
		for(ClaimStatus claimStatus:ClaimStatus.values())
		{
			if(claimStatus != ClaimStatus.APPLIED){
			employeeclaimStatus.add(claimStatus.toString());
			}
		}
	}
	
	
	
}
