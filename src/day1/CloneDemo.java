package day1;

import java.util.Date;

public class CloneDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		//wrongImplementation();
		rightImplementation();
	}

	public static void rightImplementation() throws CloneNotSupportedException {
		Address address = new Address("3924", "Sector 47-D");
		Address another = address.clone();
		System.out.println(another);
	}

	public static void wrongImplementation() throws CloneNotSupportedException {
		WrongAddress wrongAddress = new WrongAddress("3924", "Sector 47-D");
		WrongAddress wrongAddressAnother = wrongAddress.clone();
		System.out.println(wrongAddressAnother);
	}

}

class WrongAddress {
	private String houseNo;
	private String street;
	
	
	public WrongAddress(String houseNo, String street) {
		super();
		this.houseNo = houseNo;
		this.street = street;
	}
	
	@Override
	public WrongAddress clone() throws CloneNotSupportedException {
		return (WrongAddress)super.clone();
	}
	
	@Override
	public String toString() {
		return "WrongAddress [houseNo=" + houseNo + ", street=" + street + "]";
	}

	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
}

class Address implements Cloneable {
	private String houseNo;
	private String street;
	
	
	public Address(String houseNo, String street) {
		super();
		this.houseNo = houseNo;
		this.street = street;
	}
	
	@Override
	public Address clone() throws CloneNotSupportedException {
		return (Address)super.clone();
	}
	
	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", street=" + street + "]";
	}

	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
}

class Employee {
	String name;
	String employeId;
	Date dateOfBirth;
	Address address;
	
	public Employee(String employeId) {
		super();
		this.employeId = employeId;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", employeId=" + employeId + ", dateOfBirth=" + dateOfBirth + ", address="
				+ address + "]";
	}
	
	@Override
	public Employee clone() throws CloneNotSupportedException {
		Employee emp = (Employee)super.clone();
		Address address = emp.getAddress().clone();
		emp.setAddress(address);
		return emp; //deep clone
		//return (Employee)super.clone(); // shallow cloning
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
