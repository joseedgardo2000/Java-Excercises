import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SimpleSerialization {

	public static void main(String[] args) {
		System.out.println("--------------- SimpleSerialization ----------------");
		try {
			Employee employee = new Employee("Laura", 12345, 42000.50f);
			Employee employee2 = new Employee("Jose", 65461, 34567.78f);
			FileOutputStream fos = new FileOutputStream("Employee.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(employee);
			oos.writeObject(employee2);
			System.out.println("Serialized Objects: ");
			employee.display();
			employee2.display();
			oos.close();
			fos.close();
			
			FileInputStream fis = new FileInputStream("Employee.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Employee employeeRec = (Employee)ois.readObject();
			Employee employeeRec2 = (Employee)ois.readObject();
			System.out.println("Deserialized Objects: ");
			employeeRec.display();
			employeeRec2.display();
			ois.close();
			fis.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		System.out.println("--------------- ------------------- ----------------");
	}

}

class Employee implements Serializable{
	
	private static final long serialVersionUID = 1269896125550068804L;
	
	String eName;
	int eNumber;
	float eSalary;
	
	public Employee(String name, int number, float salary) {
		eName = name;
		eNumber = number;
		eSalary = salary;
	}
	
	void display() {
		System.out.println("Employee: " + eName + " - Number: " + eNumber + " - Salary: " + eSalary);
	}
}
