package model;

public class Recycling{
	private int recId, conId;
	private double wasteWeight, wasteAmount, oilWeight, oilAmount;
	private String image, description, status;
	
	public int getRecid() {
		return recId;
	}
	
	public void setRecid(int recid) {
		this.recId = recid;
	}
	
	public int getConid() {
		return conId;
	}
	
	public void setConid(int conid) {
		this.conId = conid;
	}
	
	public double getWasteWeight() {
		return wasteWeight;
	}

	public void setWasteWeight(double wasteWeight) {
		this.wasteWeight = wasteWeight;
	}

	public double getWasteAmount() {
		return wasteAmount;
	}

	public void setWasteAmount(double wasteAmount) {
		this.wasteAmount = wasteAmount;
	}

	public double getOilWeight() {
		return oilWeight;
	}

	public void setOilWeight(double oilWeight) {
		this.oilWeight = oilWeight;
	}

	public double getOilAmount() {
		return oilAmount;
	}

	public void setOilAmount(double oilAmount) {
		this.oilAmount = oilAmount;
	}

	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus() {
		if(this.wasteWeight == 0.0 && this.wasteAmount == 0.0 && 
		   this.oilWeight == 0.0 && this.oilAmount == 0.0 &&
		   this.image == null) {
			
			this.status = "Incomplete";
		} else {
			this.status = "Completed";
		}
	}
}
