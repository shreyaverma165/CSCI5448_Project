package industree.Common;

public class Constants {
	
		public static enum UserRoles {
		FACTORY_EMPLOYEE (2),
		FACTORY_MANAGER (3),
		HR_MANAGER (5);
	
		private final int UserRoleId;
		
		UserRoles(int roleId)
		{
			this.UserRoleId=roleId;
		}
	
		public int getUserRoleId()
		{
			return UserRoleId;
		}
		
		public static UserRoles getUserRole(int userRoleId)
		{
			UserRoles result = null;
			for(UserRoles userRole : UserRoles.values())
			{
				if(userRole.getUserRoleId() == userRoleId)
				{
					result = userRole;
				}
			}
			return result;
		}
	
	}

		public static enum MachineTypes {
		ELECTRONICS (1),
		CASING (2),
		SCREEN (3),
		BATTERY (4);
	
		private final int MachineTypeId;
		
		MachineTypes(int machineTypeId)
		{
			this.MachineTypeId=machineTypeId;
		}
	
		public int getMachineTypeId()
		{
			return MachineTypeId;
		}
		
		public static MachineTypes getMachineType(int machineTypeId)
		{
			MachineTypes result = null;
			for(MachineTypes machineType : MachineTypes.values())
			{
				if(machineType.getMachineTypeId() == machineTypeId)
				{
					result = machineType;
				}
			}
			return result;
		}
	
	}
		
		public static enum LineStatus {
		WORKING (1),
		MALFUNCTION (2),
		STOCK_LOW (3),
		OFF (4);
	
		private final int LineStatusId;
		
		LineStatus(int lineStatusId)
		{
			this.LineStatusId=lineStatusId;
		}
	
		public int getLineStatusId()
		{
			return LineStatusId;
		}
		
		public static LineStatus getLineStatus(int lineStatusId)
		{
			LineStatus result = null;
			for(LineStatus lineStatus : LineStatus.values())
			{
				if(lineStatus.getLineStatusId() == lineStatusId)
				{
					result = lineStatus;
				}
			}
			return result;
		}
	
	}	
		
		public static enum LeaveAndClaimStatus {
			APPLIED (1),
			PENDING (2),
			APPROVED (3);
			
			private final int LeaveAndClaimStatusId;
			
			LeaveAndClaimStatus(int leaveAndClaimStatusId)
			{
				this.LeaveAndClaimStatusId=leaveAndClaimStatusId;
			}
		
			public int getLeaveAndClaimStatusId()
			{
				return LeaveAndClaimStatusId;
			}
			
			public static LeaveAndClaimStatus getLeaveAndClaimStatu(int leaveAndClaimStatusId)
			{
				LeaveAndClaimStatus result = null;
				for(LeaveAndClaimStatus leaveAndClaimStatus : LeaveAndClaimStatus.values())
				{
					if(leaveAndClaimStatus.getLeaveAndClaimStatusId() == leaveAndClaimStatusId)
					{
						result = leaveAndClaimStatus;
					}
				}
				return result;
			}
		
		}
		
		public static enum LeaveTypes {
			OPTIONAL (1),
			SICK (2),
			CASUAL (3);
			
			private final int LeaveTypeId;
			
			LeaveTypes(int leaveTypeId)
			{
				this.LeaveTypeId=leaveTypeId;
			}
		
			public int getLeaveTypeId()
			{
				return this.LeaveTypeId;
			}
			
			public static LeaveTypes getLeaveType(int leaveTypeId)
			{
				LeaveTypes result = null;
				for(LeaveTypes leaveTypes : LeaveTypes.values())
				{
					if(leaveTypes.getLeaveTypeId() == leaveTypeId)
					{
						result = leaveTypes;
					}
				}
				return result;
			}
		
		}
		
		public static enum ClaimItemTypes {
			STAPLER (1),
			PRINTER (2),
			TRAVELLER (3);
			
			private final int ClaimItemTypeId;
			
			ClaimItemTypes(int claimItemTypeId)
			{
				this.ClaimItemTypeId=claimItemTypeId;
			}
		
			public int getClaimItemTypeId()
			{
				return this.ClaimItemTypeId;
			}
			
			public static ClaimItemTypes getClaimItemType(int claimItemTypeId)
			{
				ClaimItemTypes result = null;
				for(ClaimItemTypes claimItemTypes : ClaimItemTypes.values())
				{
					if(claimItemTypes.getClaimItemTypeId() == claimItemTypeId)
					{
						result = claimItemTypes;
					}
				}
				return result;
			}
		
		}
		
		public static enum Departments
		{
			HR (0),
			RndD (1),
			MANUFACTURING (2);
			
			
			private final int DepartmentId;
			
			Departments(int departmentId){
				this.DepartmentId=departmentId;
			}
			
			public int getDepartmentId()
			{
				return this.DepartmentId;
			}
			
			public static Departments getDepartment(int departmentId)
			{
				Departments result=null;
				for(Departments department:Departments.values())
				{
					if(department.getDepartmentId() == departmentId)
					{
						result = department;
					}
				}
				return result;
			}
			
			
		}
		public static enum Positions
		{
			INTERN (0),
			EMPLOYEE (1),
			MANUFACTURING (2);
			
			
			private final int PositionId;
			
			Positions(int positionId){
				this.PositionId=positionId;
			}
			
			public int getPositionId()
			{
				return this.PositionId;
			}
			
			public static Positions getPosition(int positionId)
			{
				Positions result=null;
				for(Positions position:Positions.values())
				{
					if(position.getPositionId() == positionId)
					{
						result = position;
					}
				}
				return result;
			}
			
			
		}
		
		public static enum ClaimStatus
		{
			PENDING (2),
			APPLIED (1),
			APPROVED (3);
			
			
			private final int ClaimStatusId;
			
			ClaimStatus(int claimStatusId){
				this.ClaimStatusId=claimStatusId;
			}
			
			public int getClaimStatusId()
			{
				return this.ClaimStatusId;
			}
			
			public static ClaimStatus getClaimStatus(int claimStatusId)
			{
				ClaimStatus result=null;
				for(ClaimStatus claimstatus:ClaimStatus.values())
				{
					if(claimstatus.getClaimStatusId() == claimStatusId)
					{
						result = claimstatus;
					}
				}
				return result;
			}
			
			public static int returnClaimStatusId(String name)
			{
				int id=0;
				for(ClaimStatus claimStatus:ClaimStatus.values())
				{
					if(claimStatus.toString().compareTo(name) ==0 )
					{
						id=claimStatus.getClaimStatusId();
					}
				}
				return id;
			}
			
			
		}

}
