package com.demo.model;

public class InputModel {
	
	private String sequence;
	private String topic;
	private String title;
	private String category;
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "MessageTopicModel [sequence=" + sequence + ", topic=" + topic + ", title=" + title + ", category="
				+ category + "]";
	}
	
	
	
}
