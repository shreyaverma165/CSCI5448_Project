package industree.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
	
	public HomeController()
	{
		dbConnection=new DBConnection();
		notifications = new ArrayList<Notification>();
		employeeLeaves = new EmployeeLeaves();
		employeeClaims = new EmployeeClaims();
		workingLineStatus = new ArrayList<WorkingLineStatus>();
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
		
		if(!userName.contains("@Riomhaire.edu"))
		{
			model.addAttribute("message", "username is invalid");
			return "loginPage";
		}
		this.user = dbConnection.validateLoginUser(userName, password);
		
		if(user!=null)
		{
			this.initializeVariables();
			
			model.addAttribute("employee", employee);
			model.addAttribute("notifications", notifications);
			model.addAttribute("employeeLeavesList",employeeLeaves );
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
			return "userHomePage";
		}
		else
		{
			model.addAttribute("message", "Invalid UserName or Password. Please try again!");
			return "loginPage";
		}
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(Model model)
	{
		return new ModelAndView("loginPage", "message", "You have been successfully logged out!");
	}
	
	@RequestMapping(value="SaveClaim", method = RequestMethod.POST)
	public String saveEmployeeClaim(@RequestParam("itemName") String claimItemName, @RequestParam("purchaseDate") String purchaseDate,
			@RequestParam("amount") int amount, @RequestParam("comment") String memo, Model model) throws ParseException
	{
		EmployeeClaim employeeClaim = new EmployeeClaim(employee.getEmployeeId(),claimItemName, purchaseDate, (int)amount, memo);
		
		dbConnection.saveAppliedClaim(employeeClaim);
		
		initializeVariables();
		model.addAttribute("alertMessage","Successfully Applied Claim!");
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
		
		return "userHomePage"; 
	}
	
	
	@RequestMapping(value="SaveLeave", method = RequestMethod.POST)
	public String saveLeave(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("leaveComment") String memo, Model model) throws ParseException
	{
		EmployeeLeave employeeLeave = new EmployeeLeave(employee.getEmployeeId(),startDate, endDate, memo);
		
		dbConnection.saveAppliedLeave(employeeLeave);
		initializeVariables();
		model.addAttribute("alertMessage","Successfully Applied Leave!");
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
			model.addAttribute("alertMessage","Successfully saved leaves!");
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
			
			return "userHomePage";
		}
		model.addAttribute("alertMessage","There ");
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
		
		return "userHomePage";
	}
	
	@RequestMapping(value="approvalClaims", method = RequestMethod.POST )
	public String ApprovalClaims(@ModelAttribute("employeeClaimsList") EmployeeClaims  employeeClaim, Model model)
	{	
		
		if(!employeeClaim.getEmployeeClaims().isEmpty()){
		
			dbConnection.saveApprovedClaims(employeeClaim.getEmployeeClaims());
			
			initializeVariables();
			model.addAttribute("alertMessage","Successfully saved claims!");
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
			
			
			return "userHomePage";
		}
		model.addAttribute("alertMessage","No approved saved claims!");
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
		
		
		initializeVariables();
		model.addAttribute("alertMessage", "Employee Created successfully;");
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
		
		return "userHomePage";
	}
	
	@RequestMapping(value="/savePassword", method=RequestMethod.POST)
	public String SavePassword(@RequestParam("password") String password, @RequestParam("confirmpassword") String confirmPassword, Model model)
	{
		user.setPassword(password);
		dbConnection.updateUser(user);
		
		initializeVariables();
		model.addAttribute("alertMessage", "Password Updated Successfully!");
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
		
		return "userHomePage";
	}
	
	@RequestMapping(value="/saveDetails", method=RequestMethod.POST)
	public String SaveDetails(@RequestParam("address") String address, Model model) 
	{
		
		user.setAddress(address);
		dbConnection.updateUser(user);
		
		
		initializeVariables();
		model.addAttribute("alertMessage", "Details successfully saved!");
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
		
		return "userHomePage";
	}

	@RequestMapping(value="/viewResults", method=RequestMethod.POST)
	public String ViewSearchResults(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("department") String department, Model model) 
	{
		List<SearchResults> searchResults = dbConnection.searchForEmployeeByDepartmentAndName(firstName, lastName, department);
		Boolean result = true;
		if(employee.getDesignation().compareTo("HRManager")==0)
		{
			model.addAttribute("isManager", result);
		}
		if(searchResults.size()==0)
		{
			model.addAttribute("alertMessage", "No results!");
		}
		model.addAttribute("searchResults", searchResults);
		
		return "searchResultsPage";
	}
	
	@RequestMapping(value="/searchResults")
	public String searchResults(Model model)
	{
		initializeVariables();
		return "userHomePage";
	}
	
	@RequestMapping(value = "/userHome")
	public String RefreshHome(Model model)
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
		
		return "userHomePage";
	}
	
	
	private void initializeVariables()
	{
		this.employee=dbConnection.getEmployeeProfile(this.user.getUserId());
		this.notifications = dbConnection.getNotifications(employee.getEmployeeId());
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
	
}
