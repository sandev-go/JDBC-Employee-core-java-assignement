import java.util.Map;
import java.util.Scanner;

public class Manager {
	public static void main(String[] args) {
		String ch = "";
		do {
			menu();
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			EmployeeRepo employeeRepo = new EmployeeRepo();
			switch (choice) {
			case 1:
				Employee emp = getEmployee(sc);
				employeeRepo.createEmployee(emp);
				System.out.println("Employee with id " + emp.getId() + " is created!!");
				break;
			case 2:
				employeeRepo.updateEmployee(null);
				break;
			case 3:
				employeeRepo.deleteEmployee(null);
				break;
			case 4:
				Map<Integer, Employee> employees = employeeRepo.getAllEmployee();
				printEmployee(employees);

				break;
			case 5:
				employeeRepo.getEmployeeById();
				break;
			case 6:
				System.exit(0);
				break;

			default:
				System.out.println("please enter the choice within (1-7)");
				break;
			}
			System.out.println("Do you want to continue?(Y/N)");
			ch = sc.next();
		} while (ch.equalsIgnoreCase("y"));
		System.out.println("Thank you for using employee management service!!");
	}

	private static void printEmployee(Map<Integer, Employee> employees) {
		// Map.Entry<Integer, Employee> emmployee = employees.entrySet();
		employees.forEach((key, value) -> System.out.println(+key + "=" + value));
	}

	private static void menu() {
		System.out.println("*************EMPLOYEE MANAGEMENT************");
		System.out.println("1. Create");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. Get All");
		System.out.println("5. Get by Id");
		System.out.println("6. Download");
		System.out.println("7. Exit");
		System.out.println("Enter your choice? (1-7)");
	}

	private static Employee getEmployee(Scanner sc) {
		Employee emp = new Employee();
		System.out.println("Enter the employee id");
		emp.setId(sc.nextInt());
		System.out.println("Enter the first name");
		emp.setFirstName(sc.next());
		System.out.println("Enter the last name");
		emp.setLastName(sc.next());
		System.out.println("Enter the age");
		emp.setAge(sc.nextInt());
		System.out.println("Enter the designation");
		emp.setDesignation(sc.next());
		System.out.println("Enter the salary");
		emp.setSalary(sc.nextInt());
		return emp;
	}
}
