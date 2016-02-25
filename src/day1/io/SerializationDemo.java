package day1.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class SerializationDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Employee employee = new Employee("123");
		employee.setDateOfBirth(new Date());
		employee.setName("Rajan");
		employee.setI(1000);

		System.out.println(employee);
		
		String srcFile = "data/object.dat";
		File file = new File(srcFile);
		
		System.out.println("------- Writing ----------");
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(employee);
		oos.close();
		
		System.out.println("------- Reading ----------");
		
		ObjectInputStream ois  = new ObjectInputStream(new FileInputStream(file));
		Object obj  = ois.readObject();
		ois.close();
		System.out.println(obj);
	}

}

class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1432332637781554811L;

	private String name;
	private String employeId;
	private Date dateOfBirth;
	private transient int i = 30;

	public Employee(String employeId) {
		super();
		this.employeId = employeId;
		System.out.println("In Constructor");
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", employeId=" + employeId + ", dateOfBirth=" + dateOfBirth + ", i=" + i
				+ "]";
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployeId() {
		return employeId;
	}

	public void setEmployeId(String employeId) {
		this.employeId = employeId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
