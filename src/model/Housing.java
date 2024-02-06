package model;

public class Housing {
	private int housingId, eventId, userId, householdNo, postcode;
	private String name, address, area, category;
	
	public int getHousingId() {
		return housingId;
	}

	public void setHousingId(int housingId) {
		this.housingId = housingId;
	}

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
	
	public int getHouseholdNo() {
		return householdNo;
	}
	
	public void setHouseholdNo(int householdNo) {
		this.householdNo = householdNo;
	}
	
	public int getPostcode() {
		return postcode;
	}
	
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
