package com.demo.model;

public class MessageModel {
	private String topic;
	private String personName;
	private String city;
	private String country;
	
	public String getTopic() {
		return topic;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	
	
}
