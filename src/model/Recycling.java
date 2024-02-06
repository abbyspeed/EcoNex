package model;

public class Recycling{
	private int recId, conId;
	private double wasteWeight, wasteAmount, oilWeight, oilAmount, carbonValue;
	private String image, description, status;
	
	public int getRecId() {
		return recId;
	}
	
	public void setRecId(int recid) {
		this.recId = recid;
	}
	
	public int getConId() {
		return conId;
	}
	
	public void setConId(int conid) {
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

	public double getCarbonValue() {
		return carbonValue;
	}

	public void setCarbonValue(double wasteWeight, double oilWeight) {
		carbonValue = (wasteWeight * 2.86) + (oilWeight * 2.86);
	}
}
