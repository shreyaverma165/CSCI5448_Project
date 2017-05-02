package industree.Model;

import javax.persistence.*;

@Entity
@Table(name = "WorkingMachineLineStatus_tbl")
public class WorkingLineStatus {

	@Id
	@GeneratedValue
	@Column(name = "workingMachineLineStatusId")
	private int workingMachineLineStatusId;
	
	@Column(name = "employeeId")
	private String employeeId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "startPosition")
	private int startPosition;
	
	@Column(name = "endPosition")
	private int endPosition;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "machineType")
	private String machineType;
	
	@Column(name = "lineId")
	private int lineId;

	public int getWorkingMachineLineStatusId() {
		return workingMachineLineStatusId;
	}
	public void setWorkingMachineLineStatusId(int workingMachineLineStatusId) {
		this.workingMachineLineStatusId = workingMachineLineStatusId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStartPosition() {
		return startPosition;
	}
	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}
	public int getEndPosition() {
		return endPosition;
	}
	public void setEndPosition(int endPosition) {
		this.endPosition = endPosition;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getMachineType() {
		return machineType;
	}
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	
	public int getLineId(){
		return lineId;
	}
	
	public void setLineId(int lineId){
		this.lineId = lineId;
	}
	
	public WorkingLineStatus()
	{
		
	}
	
		
}
