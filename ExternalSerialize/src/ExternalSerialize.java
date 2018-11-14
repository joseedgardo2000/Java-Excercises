import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class ExternalSerialize {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("---------------- External Serialize Example ----------------");
	    writeEmployeeObject();
	    readEmployeeObject();
		System.out.println("------------------------------------------------------------");

	}
	
	static private void readEmployeeObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("Employee.dat");
			ois = new ObjectInputStream(fis);
			
			Employee e1 = (Employee) ois.readObject();
			System.out.println(e1);
			
			Employee e2 = (Employee) ois.readObject();
			System.out.println(e2);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static private void writeEmployeeObject() throws FileNotFoundException, IOException{
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("Employee.dat");
			oos = new ObjectOutputStream(fos);
			
			Employee e1 = new Employee();
			e1.setId(1); e1.setName("María"); e1.setAge(20);
			System.out.println(e1);
		
			Employee e2 = new Employee();
			e2.setId(2); e2.setName("Ramón"); e2.setAge(40);
			System.out.println(e2);
			
			oos.writeObject(e1);
			oos.writeObject(e2);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				oos.close();
			}
			
			if(fos != null) {
				fos.close();
			}
			
		}
			
		
	}

}
