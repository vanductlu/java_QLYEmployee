import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
	int id;
	String name;
	int age;
	String department;
	String code;
	double salaryRate;

	public Employee(int id, String name, int age, String department, String code, double salaryRate) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.department = department;
		this.code = code;
		this.salaryRate = salaryRate;
	}

	public String toString() {
		return String.format("| %-2d | %-13s | %-4d| %-11s | %-6s | %-12.2f |%n", id, name, age, department, code,
				salaryRate);
	}
}

public class EmployeeManagementApp {
	static List<Employee> employees = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[][] employeeInfo = {
				{ "Duc", "21", "63HT2", "215111", "7000.0" },
				{ "Hanh", "19", "63HT2", "215112", "7000.0" },
				{ "Duy", "23", "63HT2", "215113", "7000.0" },
				{ "Quan", "25", "63HT2", "215114", "7000.0" },
				{ "Khanh", "18", "63HT2", "215115", "7000.0" },
				{ "Minh", "29", "63HT2", "215116", "6000.0" },
				{ "Kien", "20", "63HT2", "215117", "7000.0" },
				{ "Tu", "16", "63HT2", "215118", "7000.0" },
				{ "Son", "80", "63HT2", "215119", "7000.0" },
				{ "Van", "30", "63HT2", "2151110", "7000.0" }
		};

		for (int i = 0; i < employeeInfo.length; i++) {
			String[] info = employeeInfo[i];
			employees.add(new Employee(i + 1, info[0], Integer.parseInt(info[1]), info[2], info[3],
					Double.parseDouble(info[4])));
		}
		displayEmployees();

		while (true)

		{
			System.out.println("\nChon chuc nang:");
			System.out.println("1. Them nhan vien moi");
			System.out.println("2. Xoa nhan vien");
			System.out.println("0. Thoat");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					addEmployee();
					break;
				case 2:
					removeEmployee();
					break;
				case 0:
					System.out.println("Thoat chuong trinh.");
					return;
				default:
					System.out.println("Lua chon khong hop le.");
			}
		}
	}

	static void displayEmployees() {
		System.out.println("+----+---------------+-----+-------------+--------+--------------+");
		System.out.println("| ID |     Name      | Age | Department  |  Code  | Salary Rate  |");
		System.out.println("+----+---------------+-----+-------------+--------+--------------+");

		for (Employee employee : employees) {
			System.out.printf(employee.toString());
		}

		System.out.println("+----+---------------+-----+-------------+--------+--------------+");
	}

	static void addEmployee() {
		System.out.print("Nhap id: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		// Kiểm tra id đã tồn tại hay chưa
		boolean isDuplicate = false;
		for (Employee employee : employees) {
			if (employee.id == id) {
				isDuplicate = true;
				break;
			}
		}

		if (isDuplicate) {
			System.out.println("Id da ton tai, vui long nhap id khac.");
			return;
		}

		System.out.print("Nhap ten nhan vien: ");
		String name = scanner.nextLine();

		System.out.print("Nhap tuoi nhan vien: ");
		int age = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Nhap phong ban: ");
		String department = scanner.nextLine();

		System.out.print("Nhap ma nhan vien: ");
		String code = scanner.nextLine();

		System.out.print("Nhap muc luong: ");
		double salaryRate = scanner.nextDouble();

		Employee newEmployee = new Employee(id, name, age, department, code, salaryRate);
		employees.add(newEmployee);
		System.out.println("Them thanh cong!");
		displayEmployees();
	}

	static void removeEmployee() {
		System.out.println("Nhap id nhan vien can xoa: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		boolean found = false;
		for (Employee employee : employees) {
			if (employee.id == id) {
				employees.remove(employee);
				found = true;
				System.out.println("Xoa nhan vien thanh cong!");
				break;
			}
		}
		if (!found) {
			System.out.println("Khong tim thay nhan vien voi id: " + id);
		}
		displayEmployees();
	}
}
