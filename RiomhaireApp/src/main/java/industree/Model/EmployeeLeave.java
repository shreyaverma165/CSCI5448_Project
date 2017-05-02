package industree.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

import industree.Common.Constants.ClaimStatus;

@Entity
@Table(name="EmployeeLeave_tbl")
public class EmployeeLeave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeLeaveId")
	private String employeeLeaveId;
	
	@Column(name = "startDate")
	private String startDate;
	
	@Column(name = "employeeId")
	private String employeeId;
	
	@Column(name = "endDate")
	private String endDate;
	
	@Column(name = "appliedDate")
	private String appliedDate;
	
	@Column(name = "approvedDate")
	private String approvedDate;
	
	@Column(name = "leaveComment")
	private String leaveComment;
	
	@Column(name = "leaveStatusId")
	private int leaveStatusId;

	@Transient
	private String leaveStatus;

	public String getEmployeeLeaveId() {
		return employeeLeaveId;
	}

	public void setEmployeeLeaveId(String employeeLeaveId) {
		this.employeeLeaveId = employeeLeaveId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(String appliedDate) {
		this.appliedDate = appliedDate;
	}

	public String getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getLeaveComment() {
		return leaveComment;
	}

	public void setLeaveComment(String leaveComment) {
		this.leaveComment = leaveComment;
	}

	public int getLeaveStatusId() {
		return leaveStatusId;
	}

	public void setLeaveStatusId(int leaveStatusId) {
		this.leaveStatusId = leaveStatusId;
		this.leaveStatus = ClaimStatus.getClaimStatus(leaveStatusId).toString();
	}
	
	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
		if(ClaimStatus.returnClaimStatusId(leaveStatus) != this.leaveStatusId)
		{
			this.leaveStatusId=ClaimStatus.returnClaimStatusId(leaveStatus);
		}
		if(this.leaveStatus.compareTo("APPROVED")==0)
		{
			this.approvedDate=Calendar.getInstance().getTime().toString();
		}
	}

	public EmployeeLeave(String employeeId,String startDate, String endDate, String leaveComment) throws ParseException
	{
		this.employeeId = employeeId;
		this.startDate = new SimpleDateFormat("mm/dd/yyyy").parse(startDate).toString();
		this.endDate = new SimpleDateFormat("mm/dd/yyyy").parse(endDate).toString();
		this.leaveComment = leaveComment;
		this.appliedDate = Calendar.getInstance().getTime().toString();
		this.leaveStatusId= ClaimStatus.APPLIED.getClaimStatusId();
	
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public EmployeeLeave() {
		// TODO Auto-generated constructor stub
	}
}
