package model;

import java.util.Date;

public class Event {
	private int eventId, userId;
	private String name, slogan, description, progress;
	private Date startDate, endDate;
	private String image;
	private Utils utils;
	
	public int getEventId() {
		return eventId;
	}
	
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSlogan() {
		return slogan;
	}
	
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public String parsedStartDate(Date startDate) {
		return utils.dateToStringParser(startDate);
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public String parsedEndDate(Date endDate) {
		return utils.dateToStringParser(endDate);
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public void setStatus(Date startDate, Date endDate) {
		if(this.getCurrentDate().compareTo(startDate) < 0) {
			progress = "Upcoming";
			
		} else if(this.getCurrentDate().compareTo(startDate) > 0 || this.getCurrentDate().compareTo(startDate) == 0){
			progress = "Ongoing";
			
		} else if(this.getCurrentDate().compareTo(endDate) > 0 || this.getCurrentDate().compareTo(endDate) == 0) {
			progress = "Ended";
		}
	}
	
	public String getStatus() {
		return progress;
	}
	
	public Date getCurrentDate() {
		return new Date();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
