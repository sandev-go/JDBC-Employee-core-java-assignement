import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import util.DbUtil;

public class EmployeeRepo
{
	public void createEmployee(Employee emp)
	{

		try {
			// Statement stmt = DbUtil.getConnection().createStatement();
			String sql = "insert into Employee values(?,?,?,?,?,?)";
			PreparedStatement pstmt = DbUtil.getConnection()
					.prepareStatement(sql);
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setString(4, emp.getDesignation());
			pstmt.setInt(5, emp.getAge());
			pstmt.setInt(6, emp.getSalary());
			/*
			 * String sql = "insert into Employee values(" + emp.getId() + ",'"
			 * + emp.getFirstName() + "','" + emp.getLastName() + "','" +
			 * emp.getDesignation() + "'," + emp.getAge() + "," +
			 * emp.getSalary() + ")"; System.out.println(sql);
			 * stmt.executeUpdate(sql);
			 */
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployee(Employee emp)
	{
		System.out.println("Under construction");

	}

	public void deleteEmployee(Object object)
	{
		System.out.println("Under construction");

	}

	public Map<Integer, Employee> getAllEmployee()
	{
		Map<Integer, Employee> map = new HashMap<>();
		String sql = "Select * from Employee";
		try {
			PreparedStatement preparedStatement = DbUtil.getConnection()
					.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				Employee employee = new Employee();
				employee.setId(id);
				employee.setFirstName(resultSet.getString(2));
				employee.setLastName(resultSet.getString(3));
				employee.setDesignation(resultSet.getString(4));
				employee.setAge(resultSet.getInt(5));
				employee.setSalary(resultSet.getInt(6));
				map.put(id, employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	public void getEmployeeById()
	{
		System.out.println("Under construction");

	}

}
