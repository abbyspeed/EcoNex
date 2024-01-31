package model;

public class Housing {
	private int housingId, eventId, userId, householdNo;
	private String address, eligibility;
	
	public int getHousingid() {
		return housingId;
	}
	
	public void setHousingid(int housingid) {
		this.housingId = housingid;
	}
	
	public int getEventid() {
		return eventId;
	}
	
	public void setEventid(int eventid) {
		this.eventId = eventid;
	}
	
	public int getUserid() {
		return userId;
	}
	
	public void setUserid(int userid) {
		this.userId = userid;
	}
	
	public int getHouseholdno() {
		return householdNo;
	}
	
	public void setHouseholdno(int householdno) {
		this.householdNo = householdno;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEligibility() {
		return eligibility;
	}
	
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
}
