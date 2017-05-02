package industree.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import industree.Common.Utility;
import industree.Database.DBConnection;
import industree.Model.*;



@Controller
@RequestMapping("/")
public class HomeController {

	private DBConnection dbConnection;
	
	private User user;
	private Employee employee;
	private List<Notification> notifications;
	private EmployeeLeaves employeeLeaves;
	private EmployeeClaims employeeClaims;
	private EmployeeFactory employeeFactory;
	private List<WorkingLineStatus> workingLineStatus;
	private List<EmployeeClaim> appliedEmployeeClaimsList;
	private List<EmployeeLeave> appliedEmployeeLeavesList;
	private Utility utility;
	
	public HomeController()
	{
		dbConnection=new DBConnection();
		notifications = new ArrayList<Notification>();
		employeeLeaves = new EmployeeLeaves();
		employeeClaims = new EmployeeClaims();
		employeeFactory = new EmployeeFactory();
		workingLineStatus = new ArrayList<WorkingLineStatus>();
		appliedEmployeeClaimsList = new ArrayList<EmployeeClaim>();
		appliedEmployeeLeavesList  = new ArrayList<EmployeeLeave>();
		utility = new Utility();
	}
	
	@GetMapping("/home")
	public String home(Model model)
	{
		return "homePage";
	}
	
	@GetMapping("/login")
	public String login(Model model) 
	{
		return "loginPage";
	}
	
	@RequestMapping(value="processCredentials", method = RequestMethod.POST)
	public String processCredentials(@RequestParam("userName")String userName, @RequestParam("password")String password, Model model) {
		
		if(!userName.contains("@riomhaire.com"))
		{
			model.addAttribute("message", "Username is invalid");
			return "loginPage";
		}
		this.user = dbConnection.validateLoginUser(userName, utility.getHashPassword(password));
		if(user!=null)
		{
			this.initializeVariables();
			
			model = this.bindVariables(model);
			return "userHomePage";
		}
		else
		{
			model.addAttribute("message", "Invalid UserName or Password. Please try again!");
			return "loginPage";
		}
	}
	
	@RequestMapping(value="/sendmail", method = RequestMethod.POST)
	public ModelAndView forgotSendPassword(@RequestParam("emailAddress") String emailAddress, Model model) throws MessagingException{
		
		utility.sendMail(emailAddress);
		return new ModelAndView("loginPage", "message", "You Have Been Emailed a Link to Reset Your Password");
	}
	
	@RequestMapping(value="/ForgotPassword")
	public String forgotSendPassword() {
		
		return "forgotPasswordPage";
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(Model model)
	{
		return new ModelAndView("loginPage", "message", "You Have Been Logged Out");
	}
	
	@RequestMapping(value="SaveClaim", method = RequestMethod.POST)
	public String saveEmployeeClaim(@RequestParam("itemName") String claimItemName, @RequestParam("purchaseDate") String purchaseDate,
			@RequestParam("amount") int amount, @RequestParam("comment") String memo, Model model) throws ParseException
	{
		EmployeeClaim employeeClaim = new EmployeeClaim(employee.getEmployeeId(),claimItemName, purchaseDate, (int)amount, memo);
		
		dbConnection.saveAppliedClaim(employeeClaim);
		
		initializeVariables();
		model = this.bindVariables(model);
		model.addAttribute("alertMessage","Successfully Applied Claim");
		
		
		return "userHomePage"; 
	}
	
	
	@RequestMapping(value="SaveLeave", method = RequestMethod.POST)
	public String saveLeave(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("leaveComment") String memo, Model model) throws ParseException
	{
		EmployeeLeave employeeLeave = new EmployeeLeave(employee.getEmployeeId(),startDate, endDate, memo);
		Date start = (Date)new SimpleDateFormat("mm/dd/yyyy").parse(startDate);
		Date end = (Date)new SimpleDateFormat("mm/dd/yyyy").parse(endDate);
		if(start.compareTo(end)>0)
		{
			initializeVariables();
			model = this.bindVariables(model);
			model.addAttribute("alertMessage","StartDate Cannot be greater than EndDate !");
			
			
			return "userHomePage"; 
		}
		
		dbConnection.saveAppliedLeave(employeeLeave);
		initializeVariables();
		model = this.bindVariables(model);
		model.addAttribute("alertMessage","Successfully Applied Leave");
		
		
		return "userHomePage"; 
	}
	
	@RequestMapping(value="approvalLeaves", method = RequestMethod.POST )
	public String ApprovalLeaves(@ModelAttribute("employeeLeavesList") EmployeeLeaves  employeeLeave, Model model)
	{	
		System.out.print("approval leaves");
		if(!employeeLeave.getEmployeeLeaves().isEmpty())
		{
			dbConnection.saveApprovedLeaves(employeeLeave.getEmployeeLeaves());
			
			initializeVariables();
			model = this.bindVariables(model);
			model.addAttribute("alertMessage","Leave Status Updated");
			
			
			return "userHomePage";
		}
		
		model = this.bindVariables(model);
		model.addAttribute("alertMessage","No Updates");
		
		
		return "userHomePage";
	}
	
	@RequestMapping(value="approvalClaims", method = RequestMethod.POST )
	public String ApprovalClaims(@ModelAttribute("employeeClaimsList") EmployeeClaims  employeeClaim, Model model)
	{	
		
		if(!employeeClaim.getEmployeeClaims().isEmpty()){
		
			dbConnection.saveApprovedClaims(employeeClaim.getEmployeeClaims());
			
			initializeVariables();
			model = this.bindVariables(model);
			model.addAttribute("alertMessage","Claims Updated.");
			
			
			
			return "userHomePage";
		}
		model = this.bindVariables(model);
		model.addAttribute("alertMessage","No Updates.");
		
		
		return "userHomePage";
	}
	
	@RequestMapping(value="/createEmployee", method = RequestMethod.POST )
	public String CreateEmployee(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName, 
			@RequestParam("middleName") String middleName, @RequestParam("contactNumber") String contactNumber,
			@RequestParam("dateofBirth") String dateOfBirth, @RequestParam("designation") String designation,
			@RequestParam("department") String department, @RequestParam("address") String address
			, Model model) throws ParseException
	{	
		EmployeeFactory emp =new EmployeeFactory();
		Employee newemployee = emp.getEmployee(firstName, lastName, middleName, contactNumber, department, designation, dateOfBirth, employee.getEmployeeId(), address);
		
		System.out.print("of the funtion");
		initializeVariables();
		model = this.bindVariables(model);
		model.addAttribute("alertMessage", "Employee Created successfully");
		
		
		return "userHomePage";
	}
	
	@RequestMapping(value="/viewResults", method=RequestMethod.POST)
	public String ViewSearchResults(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("department") String department, Model model) 
	{
		List<SearchResults> searchResults = dbConnection.searchForEmployeeByDepartmentAndName(firstName, lastName, department);
		Boolean result = true;
		if(employee.getDesignation().compareTo("HRManager")==0 ||employee.getDesignation().compareTo("Admin")==0 )
		{
			model.addAttribute("isManager", result);
		}
		if(searchResults.size()==0)
		{
			model.addAttribute("alertMessage", "No results");
		}
		model.addAttribute("searchResults", searchResults);
		
		return "searchResultsPage";
	}
	
	@RequestMapping(value="/savePassword", method=RequestMethod.POST)
	public String SavePassword(@RequestParam("password") String password, @RequestParam("confirmpassword") String confirmPassword, Model model)
	{
		if(password.compareTo(confirmPassword)!=0)
		{
			initializeVariables();
			model = this.bindVariables(model);
			model.addAttribute("alertMessage", "Passwords Do Not Match");
			
			
			return "userHomePage";
			
		}
		user.setPassword(utility.getHashPassword(password));
		dbConnection.updateUser(user);
		
		initializeVariables();
		model = this.bindVariables(model);
		model.addAttribute("alertMessage", "Password Updated Successfully");
		
		
		return "userHomePage";
	}
	
	@RequestMapping(value="/deleteClaim", method=RequestMethod.POST)
	public String deleteClaim(@RequestParam("employeeClaimId") String employeeClaimId, Model model)
	{
		dbConnection.deleteClaim(employeeClaimId);
		initializeVariables();
		model = this.bindVariables(model);
		model.addAttribute("alertMessage", "Claim Deleted");
		
		return "userHomePage";
	}
	
	@RequestMapping(value="/deleteLeave", method=RequestMethod.POST)
	public String deleteLeave(@RequestParam("employeeLeaveId") String employeeLeaveId, Model model)
	{
		dbConnection.deleteLeave(employeeLeaveId);
		initializeVariables();
		model = this.bindVariables(model);
		model.addAttribute("alertMessage", "Leave Deleted");
		
		return "userHomePage";
	}
	
	@RequestMapping(value="/saveDetails", method=RequestMethod.POST)
	public String SaveDetails(@RequestParam("address") String address, Model model) 
	{
		
		user.setAddress(address);
		dbConnection.updateUser(user);
		
		
		initializeVariables();
		model = this.bindVariables(model);
		model.addAttribute("alertMessage", "Details saved!");
		
		
		return "userHomePage";
	}

	
	
	@RequestMapping(value="searchResults")
	public String searchResults(Model model)
	{
		initializeVariables();
		model= this.bindVariables(model);
		return "userHomePage";
	}
	
	@RequestMapping(value = "/userHome")
	public String RefreshHome(Model model)
	{
		initializeVariables();
		model = this.bindVariables(model);
		
		return "userHomePage";
	}
	
	@RequestMapping(value="deactiveProfile", method=RequestMethod.POST)
	public String deactivateProfile(@RequestParam("employeeId") String employeeId, Model model)
	{
		dbConnection.deleteEmployee(employeeId);
		initializeVariables();
		model = this.bindVariables(model);
		model.addAttribute("alertMessage", "Employee Deleted");
		
		return "userHomePage";
	}
	
	@RequestMapping(value="changeUserRole", method=RequestMethod.POST)
	public String changeUserRole(@RequestParam("employeeId") String employeeId,@RequestParam("userRoleStatus") String userRoleStatus, Model model)
	{
		int userRoleStatusId;
		
		if(userRoleStatus.compareTo("FactoryManager")==0){
			userRoleStatusId = 3;
		}
		else if(userRoleStatus.compareTo("FactoryEmployee")==0){
			userRoleStatusId = 2;
		}
		else
		{
			userRoleStatusId = 5;
		}
		
		dbConnection.updateUserRoleStatus(employeeId,userRoleStatus, userRoleStatusId);
		initializeVariables();
		model = this.bindVariables(model);
		model.addAttribute("alertMessage", "Employee Role Modified");
		
		return "userHomePage";
	}
	
	@RequestMapping(value = "requestStock", method= RequestMethod.POST)
	public String requestStock(@RequestParam("electronicsStock") String electronicsStock, @RequestParam("casingStock") String casingStock,
			@RequestParam("screenStock") String screenstock, @RequestParam("batteryStock") String batteryStock, Model model){
	
		
		this.initializeVariables();
		model = this.bindVariables(model);
		model.addAttribute("alertMessage", "Stock Requested");
		
		return "userHomePage";
		
		
	}
	
	private void initializeVariables()
	{
		this.employee=dbConnection.getEmployeeProfile(this.user.getUserId());
		this.notifications = dbConnection.getNotifications(employee.getEmployeeId());
		this.appliedEmployeeClaimsList = dbConnection.getAppliedClaims(employee.getEmployeeId());
		this.appliedEmployeeLeavesList = dbConnection.getAppliedLeaves(employee.getEmployeeId());
		if(employee.getDesignation().compareTo("HRManager") == 0)
		{
			this.employeeLeaves= dbConnection.getEmployeeLeaves(employee.getEmployeeId());
			this.employeeClaims= dbConnection.getEmployeeClaims(employee.getEmployeeId());
		}
		else
		{
			this.workingLineStatus = dbConnection.getWorkingMachineLinesStatuses(employee.getEmployeeId());
			
		}
		
	}
	
	
	private Model bindVariables(Model model)
	{
		model.addAttribute("employee", employee);
		model.addAttribute("notifications", notifications);
		model.addAttribute("employeeLeavesList", employeeLeaves);
		model.addAttribute("employeeClaimsList", employeeClaims);
		for(WorkingLineStatus worklineStatus:workingLineStatus)
		{
			if(worklineStatus.getMachineType().compareTo("Electronics")==0){
			model.addAttribute("electronicsStatus",worklineStatus );}
			else if(worklineStatus.getMachineType().compareTo("Screen")==0){
			model.addAttribute("screenStatus",worklineStatus );}
			else if(worklineStatus.getMachineType().compareTo("Casing")==0){
			model.addAttribute("casingStatus",worklineStatus );}
			else {
			model.addAttribute("batteryStatus",worklineStatus );}
		}
		model.addAttribute("appliedEmployeeClaimsList", appliedEmployeeClaimsList);
		model.addAttribute("appliedEmployeeLeavesList", appliedEmployeeLeavesList);
		
		return model;
	}
	
}
