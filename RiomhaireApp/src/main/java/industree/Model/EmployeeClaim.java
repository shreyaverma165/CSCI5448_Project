package industree.Model;

import javax.persistence.*;

import industree.Common.Constants.ClaimStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "EmployeeClaim_tbl")
public class EmployeeClaim {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		//Adding Column for employeeClaimId
		@Column(name = "employeeClaimId")
		private String employeeClaimId;
		//Adding Column for claimItemType
		@Column(name="claimItemType")
		private String claimItemType;
		//Adding Column for employeeId
		@Column(name = "employeeId")
		private String employeeId; 
		//Adding Column for amount
		@Column(name = "amount")
		private int amount;
		//Adding Column for purchaseDate
		@Column(name = "purchaseDate")
		private String purchaseDate;
		//Adding Column for appliedDate
		@Column(name = "appliedDate")
		private String appliedDate;
		//Adding Column for approvedDate
		@Column(name = "approvedDate")
		private String approvedDate;
		//Adding Column for claimStatusId
		@Column(name="claimStatusId")
		private int claimStatusId;
		//Adding Column for claimStatus
		@Transient
		private String claimStatus;
		//Adding Column for claimComment
		@Column(name = "claimComment")
		private String claimComment;
		
		//method to return claimStatus
		public String getClaimStatus() {
			return claimStatus;
		}
		//method to set claimStatus
		public void setClaimStatus(String claimStatus) {
			this.claimStatus = claimStatus;
			if(ClaimStatus.returnClaimStatusId(claimStatus) != this.claimStatusId)
			{
				this.claimStatusId=ClaimStatus.returnClaimStatusId(claimStatus);
			}
			if(this.claimStatus.compareTo("APPROVED")==0)
			{
				this.approvedDate=Calendar.getInstance().getTime().toString();
			}
			
		}
		//method to return employeeClaimId
		public String getEmployeeClaimId() {
			return employeeClaimId;
		}
		//method to set employeeClaimId
		public void setEmployeeClaimId(String employeeClaimId) {
			this.employeeClaimId = employeeClaimId;
		}
		//method to return claimItemType
		public String getClaimItemType() {
			return claimItemType;
		}
		//method to set claimItemType
		public void setClaimItemType(String claimItemType) {
			this.claimItemType = claimItemType;
		}
		//method to return employeeId
		public String getEmployeeId() {
			return employeeId;
		}
		//method to set employeeId
		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}
		//method to return amount
		public int getAmount() {
			return amount;
		}
		//method to set amount
		public void setAmount(int amount) {
			this.amount = amount;
		}
		//method to return purchaseDate
		public String getPurchaseDate() {
			return purchaseDate;
		}
		//method to set purchaseDate
		public void setPurchaseDate(String purchaseDate) {
			this.purchaseDate = purchaseDate;
		}
		//method to return appliedDate
		public String getAppliedDate() {
			return appliedDate;
		}
		//method to set appliedDate
		public void setAppliedDate(String appliedDate) {
			this.appliedDate = appliedDate;
		}
		//method to return approvedDate
		public String getApprovedDate() {
			return approvedDate;
		}
		//method to set approvedDate
		public void setApprovedDate(String approvedDate) {
			this.approvedDate = approvedDate;
		}
		//method to return claimStatusId
		public int getClaimStatusId() {
			return claimStatusId;
		}
		//method to set claimStatusId
		public void setClaimStatusId(int claimStatusId) {
			this.claimStatusId = claimStatusId;
			this.claimStatus= ClaimStatus.getClaimStatus(claimStatusId).toString();
		}
		//method to return employeeClaim
		public EmployeeClaim() {
			// TODO Auto-generated constructor stub
		}
		
		//method to return claimComment
		public String getClaimComment() {
			return claimComment;
		}
		//method to set claimComment
		public void setClaimComment(String claimComment) {
			this.claimComment = claimComment;
		}
		//Constructor
		public EmployeeClaim(String employeeId, String claimItemName, String purchaseDate, int amount, String comment)
		{	
			this.employeeId= employeeId;
			this.claimItemType= claimItemName;
			try {
				this.purchaseDate = new SimpleDateFormat("mm/dd/yyyy").parse(purchaseDate).toString();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.amount=amount;
			this.appliedDate = Calendar.getInstance().getTime().toString();
			this.claimComment=comment;
			this.claimStatusId=ClaimStatus.APPLIED.getClaimStatusId();
		}

		
		
}

