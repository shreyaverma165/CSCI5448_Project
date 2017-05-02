package industree.Model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import industree.Common.Constants.UserRoles;

@Entity
@Table(name="User_tbl")
public class User implements Serializable{
	//Adding Column for userId
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId")
	private int userId;
	//Adding Column for firstName
	@Column(name="firstName")
	private String firstName;
	//Adding Column for middleName
	@Column(name="middleName")
	private String middleName;
	//Adding Column for lastName
	@Column(name="lastName")
	private String lastName;
	//Adding Column for dateOfBirth
	@Temporal(TemporalType.DATE)
	@Column(name="dateOfBirth")
	private Date dateOfBirth;
	//Adding Column for userName
	@Column(name="username")
	private String userName;
	//Adding Column for password
	@Column(name="password")
	private String password;
	//Adding Column for emailAddress
	@Column(name="emailAddress")
	private String emailAddress;
	//Adding Column for userRoldId
	@Column(name="userRoleId")
	private int userRoleId;
	
	@Transient
	private UserRoles userRole;
	
	@Column(name="address")
	private String address;
	
	//method to return address
	public String getAddress() {
		return address;
	}
	//method to set address
	public void setAddress(String address) {
		this.address = address;
	}
	//method to return UserRole
	public UserRoles getUserRole(){
		return userRole;
	}
	
	//method to return UserRoledId
	public int getUserRoleId(){
		return userRoleId;
	}
	//method to set UserRoleId
	public void setUserRoleId(int userRoleId)
	{
		this.userRoleId=userRoleId;
		this.userRole = (UserRoles.getUserRole(userRoleId));
	}
	//method to return UserId
	public int getUserId() {
		return userId;
	}
	//method to set UserId
	public void setUserId(int userId) {
		this.userId = userId;
	}
	//method to return FirstName
	public String getFirstName() {
		return firstName;
	}
	//method to set FirstName
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	//method to return middleName
	public String getMiddleName() {
		return middleName;
	}
	//method to set middleName
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	//method to return LastName
	public String getLastName() {
		return lastName;
	}
	//method to set LastName
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	//method to return DateOfBirth
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	//method to set DateOfBirth
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	//method to return UserName
	public String getUserName() {
		return userName;
	}
	//method to set UserName
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//method to return password
	public String getPassword() {
		return password;
	}
	//method to set password
	public void setPassword(String password) {
		this.password = password;
	}
	//method to return EmailAddress
	public String getEmailAddress() {
		return emailAddress;
	}
	//method to set EmailAddress
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	//Constructor
	public User(String firstName, String middleName, String lastName, String emailAddress,Date dateOfBirth,
			String userName, String password, int userRoleId, String address)
	{
		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName=lastName;
		this.emailAddress=emailAddress;
		this.dateOfBirth = dateOfBirth;
		this.userName=userName;
		this.userRoleId= userRoleId;
		this.userRole=UserRoles.getUserRole(userRoleId);
		this.password=password;
		this.address = address;
	}

	public User() {
		this.setUserRole(UserRoles.FACTORY_EMPLOYEE);
	}

	public void setUserRole(UserRoles userRole) {
		this.userRole = userRole;
		this.userRoleId = userRole.getUserRoleId();
	}
	
	
}
