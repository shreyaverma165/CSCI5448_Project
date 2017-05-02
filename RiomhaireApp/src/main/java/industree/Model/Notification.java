package industree.Model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Notification_tbl")
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="notificationId")
	private int notificationId;
	
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "employeeId")
	private String employeeId;
	
	@Column(name = "senderId")
	private String senderId;
	
	@Column(name = "dateSent")
	private Date dateSent;

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public Date getDateSent() {
		return dateSent;
	}

	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	} 
	
	public Notification()
	{
		Calendar calendar=Calendar.getInstance();
		this.dateSent= calendar.getTime();
	}
	
	public Notification(String employeeId, String message)
	{
		 this.employeeId = employeeId;
		 this.dateSent = Calendar.getInstance().getTime();
		 this.message = message;
	}
	
}
