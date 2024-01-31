package model;

public class Consumption {
	private int conId, housingId;
	private int month;
	
	public int getConid() {
		return conId;
	}
	
	public void setConid(int conid) {
		this.conId = conid;
	}
	
	public int getHousingid() {
		return housingId;
	}
	
	public void setHousingid(int housingid) {
		this.housingId = housingid;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public String monthToString() {
		if(this.month == 1) {
			return "January";
			
		} else if(this.month == 2) {
			return "February";
			
		} else if(this.month == 3) {
			return "March";
			
		} else if(this.month == 4) {
			return "April";
			
		} else if(this.month == 5) {
			return "May";
			
		} else if(this.month == 6) {
			return "June";
			
		} else if(this.month == 7) {
			return "July";
			
		} else if(this.month == 8) {
			return "August";
			
		} else if(this.month == 9) {
			return "September";
			
		} else if(this.month == 10) {
			return "October";
			
		} else if(this.month == 11) {
			return "November";
			
		} else {
			return "December";
		}
	}
}
