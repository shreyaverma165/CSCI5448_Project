package industree.Database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import industree.Model.*;

public class DBConnection implements IDBConnection {

	private Session beginSession()
	{
		SessionFactory sessionFactory = HibernateInitializer.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		return session;
	}

	@Override
	public industree.Model.User validateLoginUser(String userName, String password) {
		Session session = beginSession();
		String queried = "from User where username = :username and password = :password";
		Query query = session.createQuery(queried);
		query.setParameter("username", userName);
		query.setParameter("password", password);
		List<User> ls = (List<User>)query.list();
		
		if(ls==null || ls.isEmpty())
		{
			return null;
		}
		return ls.get(0);
		
	}
	
	@Override
	public Employee getEmployeeProfile(int userId){
		
		Session session = beginSession();
		String queried="from Employee e where e.userId = :userId";
		Query query = session.createQuery(queried);
		query.setParameter("userId", userId);
		List<Employee> ls = query.list();
		
		if(ls == null || ls.isEmpty())
		{
			return null;
		}
		session.close();
		return ls.get(0);
		
	}

	@Override
	public WorkingLineStatus getWorkingMachineLineStatus(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeLeaves getEmployeeLeaves(String managerId) {
		EmployeeLeaves employeeLeaves = new EmployeeLeaves();
		List<EmployeeLeave> employeeLeavesList= new ArrayList<EmployeeLeave>();
		Session session = beginSession();
		String queried = "from Employee where managerId = :managerId";
		
		Query query = session.createQuery(queried);
		query.setParameter("managerId", managerId);
		List<Employee> employeeList = query.list();
		if(employeeList == null || employeeList.isEmpty())
		{
			return null;
		}
		for(Employee employee : employeeList)
		{
			query = session.createQuery("from EmployeeLeave where employeeId = :employeeId and leaveStatusId = 1");
			query.setParameter("employeeId", employee.getEmployeeId());
			employeeLeavesList.addAll((List<EmployeeLeave>)query.list());
		}
		employeeLeaves.setEmployeeLeaves(employeeLeavesList);
		return employeeLeaves;
	}

	@Override
	public EmployeeClaims getEmployeeClaims(String managerId) {
		EmployeeClaims employeeClaims = new EmployeeClaims();
		List<EmployeeClaim> employeeClaimsList= new ArrayList<EmployeeClaim>();
		Session session = beginSession();
		String queried = "from Employee where managerId = :managerId";
		
		Query query = session.createQuery(queried);
		query.setParameter("managerId", managerId);
		List<Employee> employeeList = query.list();
		if(employeeList == null || employeeList.isEmpty())
		{
			return null;
		}
		for(Employee employee : employeeList)
		{
			query = session.createQuery("from EmployeeClaim where employeeId = :employeeId and claimStatusId = 1");
			query.setParameter("employeeId", employee.getEmployeeId());
			employeeClaimsList.addAll((List<EmployeeClaim>)query.list());
		}
		employeeClaims.setEmployeeClaims(employeeClaimsList);
		return employeeClaims;
	}

	@Override
	public List<WorkingLineStatus> getWorkingMachineLinesStatuses(String employeeId) {
		Session session = beginSession();
		String queried = "from WorkingLineStatus where employeeId = :employeeId";
		Query query = session.createQuery(queried);
		query.setParameter("employeeId", employeeId);
		List<WorkingLineStatus> ls = query.list();
		
		return ls;
	}


	@Override
	public void saveEmployeeProfile(Employee employeeProfile) {
		Session session =  beginSession();
		session.save(employeeProfile);
		session.beginTransaction().commit();
		
	}

	@Override
	public void saveAppliedLeave(EmployeeLeave employeeLeave) {
		Notification notification = new Notification(employeeLeave.getEmployeeId(),
				"Your leave for "+ employeeLeave.getStartDate()+ " to "+ employeeLeave.getEndDate()+
				" has been applied on " + employeeLeave.getAppliedDate());
		Session session =  beginSession();
		session.save(employeeLeave);
		session.beginTransaction().commit();
		this.createNotification(notification);
		
	}

	@Override
	public void saveAppliedClaim(EmployeeClaim employeeClaim) {
		Session session =  beginSession();
		session.save(employeeClaim);
		Notification notification = new Notification(employeeClaim.getEmployeeId(),
				"Your claim for "+ employeeClaim.getClaimItemType()+
				" has been applied");
		this.createNotification(notification);
		session.beginTransaction().commit();
	}

	@Override
	public void saveApprovedLeaves(List<EmployeeLeave> employeeLeaves) {
		
		Session session = beginSession();
		for(EmployeeLeave employeeLeave : employeeLeaves)
		{
			
			session.saveOrUpdate(employeeLeave);
			Notification notification = new Notification(employeeLeave.getEmployeeId(),
					"Your leave for "+ employeeLeave.getStartDate()+ " to "+ employeeLeave.getEndDate()+
					" has been approved");
			this.createNotification(notification);
			
		}
		session.beginTransaction().commit();
	}

	@Override
	public void saveApprovedClaims(List<EmployeeClaim> employeeClaims) {
		Session session = beginSession();
		for(EmployeeClaim employeeClaim : employeeClaims)
		{
			session.saveOrUpdate(employeeClaim);
			Notification notification = new Notification(employeeClaim.getEmployeeId(),
					"Your claim for "+ employeeClaim.getClaimItemType()+
					" has been approved");
			this.createNotification(notification);
			
		}
		session.beginTransaction().commit();
		
	}

	@Override
	public List<SearchResults> searchForEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SearchResults> searchForEmployeeByDepartmentAndName(String firstName, String lastName, String department) {
		
		Session session = beginSession();
		List<SearchResults> searchResults = new ArrayList<SearchResults>();
		String queried = "from User u where u.firstName like :firstParameter and lastName like :lastParameter";
		Query query = session.createQuery(queried);
		query.setParameter("firstParameter", firstName+"%");
		query.setParameter("lastParameter", lastName+"%");
		
		List<User> users = (List<User>)query.list();
		if(users!=null)
		{
		session.close();
		List<Integer> ids = new ArrayList<Integer>();
		for(User user:users)
		{
			ids.add(user.getUserId());
		}
		Employee employee= new Employee();
		List<Employee> employees= this.getEmployeeFromUserIds(ids, department);
		SearchResults searchResult;
		String name="";
		
		for(User user1:users)
		{
			name = user1.getFirstName().concat(" ");
			name = name.concat(user1.getLastName());
			for(Employee employeeLoop:employees)
			{
				if(employeeLoop.getUserId() == user1.getUserId())
				{
					employee = employeeLoop;
					searchResult = new SearchResults(name, employee.getWorkContact(), employee.getDepartment(), employee.getDesignation()
							, employee.getDateOfJoining(), user1.getEmailAddress(), employee.getEmployeeId());
					searchResults.add(searchResult);
					break;
				}
			}
			
		}
		}
		return searchResults;
	}
	
	private List<Employee> getEmployeeFromUserIds(List<Integer> ids, String department)
	{
		Session session = beginSession();
		String queried ;
		Query query = null;
		List<Employee> employees = new ArrayList<Employee>();
		
		if(ids!=null && department!= null){
		if(ids.size() == 0){
			employees = new ArrayList<Employee>();
		}
		else{
		if(department.isEmpty())
		{
			queried = "from Employee e where e.userId in :ids ";
			query =  session.createQuery(queried);
			query.setParameter("ids", ids);
		}
		else
		{
			queried="from Employee e where department = :department and e.userId in :ids ";
			query =  session.createQuery(queried);
			query.setParameter("department", department);
			query.setParameter("ids", ids);
			
		}
		}
		}
		if(query!=null){
		employees= query.list();
		}
		session.close();
		return employees;
	}
	
	@Override
	public User saveUser(User user)
	{

		Session session = beginSession();
		session.save(user);
		session.beginTransaction().commit();
		
		return this.validateLoginUser(user.getUserName(), user.getPassword());
	}
	
	@Override
	public List<Notification> getNotifications(String employeeId)
	{
		Session session = beginSession();
		String queried="from Notification e where e.employeeId = :employeeId";
		Query query = session.createQuery(queried);
		query.setParameter("employeeId", employeeId);
		List<Notification> ls = query.list();
		
		if(ls == null || ls.isEmpty())
		{
			return null;
		}
		session.close();
		return ls;
		
	}
	
	@Override
	public void updateUser(User user)
	{
		Session session = beginSession();
		session.saveOrUpdate(user);
		session.beginTransaction().commit();
		
	}
	
	@Override
	public void updateEmployee(Employee employee)
	{
		Session session = beginSession();
		session.saveOrUpdate(employee);
		session.beginTransaction().commit();
		
	}
	
	@Override
	public List<EmployeeLeave> getAppliedLeaves(String employeeId)
	{
		Session session = beginSession();
		String queried = "from EmployeeLeave e where e.employeeId = :employeeId";
		Query query = session.createQuery(queried);
		query.setParameter("employeeId", employeeId);
		List<EmployeeLeave> ls = query.list();
		
		session.close();
		return ls;
		
	}
	
	@Override
	public List<EmployeeClaim> getAppliedClaims(String employeeId)
	{
		Session session = beginSession();
		String queried = "from EmployeeClaim e where e.employeeId = :employeeId";
		Query query = session.createQuery(queried);
		query.setParameter("employeeId", employeeId);
		List<EmployeeClaim> ls = query.list();
		
		session.close();
		return ls;
		
	}
	
	
	private void createNotification(Notification notification)
	{
		
		Session session = beginSession();
		session.save(notification);
		session.beginTransaction().commit();
	}
	
	@Override
	public void deleteClaim(String employeeClaimId)
	{
		Session session= beginSession();
		String queried = "delete from EmployeeClaim where employeeClaimId = :employeeClaimId";
		Query query = session.createQuery(queried);
		query.setParameter("employeeClaimId", employeeClaimId);
		session.beginTransaction();
		query.executeUpdate();
		session.close();
	}
	
	@Override
	public void deleteLeave(String employeeLeaveId)
	{
		Session session= beginSession();
		String queried = "delete from EmployeeLeave where employeeLeaveId = :employeeLeaveId";
		Query query = session.createQuery(queried);
		query.setParameter("employeeLeaveId", employeeLeaveId);
		session.beginTransaction();
		query.executeUpdate();
		session.close();
	}
	
	public void deleteEmployee(String employeeId)
	{
		Session session = beginSession();
		String queried = "delete from EmployeeLeave where employeeId = :employeeId";
		String deleteClaimquery = "delete from EmployeeClaim where employeeId = :employeeId";
		String deleteLineStatus = "delete from WorkingLineStatus where employeeId = :employeeId";
		String deleteEmployee = "delete from Employee where employeeId  = :employeeId";
		Query query = session.createQuery(queried);
		query.setParameter("employeeId", employeeId);
		
		Query deleteClaim = session.createQuery(deleteClaimquery);
		deleteClaim.setParameter("employeeId", employeeId);
		
		Query deleteLineStatusQuery= session.createQuery(deleteLineStatus);
		deleteLineStatusQuery.setParameter("employeeId", employeeId);
		
		Query deleteEmployeeQuery = session.createQuery(deleteEmployee);
		deleteEmployeeQuery.setParameter("employeeId", employeeId);
		
		session.beginTransaction();
		query.executeUpdate();
		deleteClaim.executeUpdate();
		deleteLineStatusQuery.executeUpdate();
		deleteEmployeeQuery.executeUpdate();
		session.close();
		
	}
	
	@Override
	public void updateUserRoleStatus(String employeeId, String designation,int userRoleStatusId)
	{
		int userId  = this.getUserId(employeeId);
		if(userId > 0){
		Session session = beginSession();
		String queried = "Update Employee set designation= :designation where employeeId = :employeeId";
		Query query = session.createQuery(queried);
		query.setParameter("designation", designation);
		query.setParameter("employeeId", employeeId);
		
		
		String userqueried = "Update User set userRoleId= :userRoleStatusId where userId = :userId";
		Query userquery = session.createQuery(userqueried);
		userquery.setParameter("userRoleStatusId", userRoleStatusId);
		userquery.setParameter("userId", this.getUserId(employeeId));
		
		session.beginTransaction();
		query.executeUpdate();
		userquery.executeUpdate();
		session.close();
		}
	}
	
	private int getUserId(String employeeId)
	{
		Session session = beginSession();
		String queried = "from Employee e where e.employeeId = :employeeId";
		Query query = session.createQuery(queried);
		query.setParameter("employeeId", employeeId);
		List<Employee> user =  query.list();
		int userId=0;
		if(user != null && user.size()>0)
		{
			userId  = user.get(0).getUserId();
		}
		session.close();
		
		return userId;
	}
	
	public void updateStock(int stockTypeId , int lineId, int stock){
		
		Session session = beginSession();
		String queried = "Update WorkingLineStatus set stock = :stock where stockTypeId = :stockTypeId and lineId = :lineId";
		Query query = session.createQuery(queried);
		query.setParameter("stock", stock);
		query.setParameter("stockTypeId", stockTypeId);
		query.setParameter("lineId", lineId);
		session.beginTransaction();
		query.executeUpdate();
		session.close();
	}
	
	
}
