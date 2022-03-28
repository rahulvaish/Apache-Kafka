package com.demo.model;

public class Person {

	private String personName;
	private Address address;
	
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [personName=" + personName + ", address=" + address + "]";
	}
	
	
}
