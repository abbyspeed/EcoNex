package model;

public class Electricity {
	private int electId, conId, noOfDays, currentUsage;
	private double profactor, amount, carbonValue;
	private String bill, description, status;
	
	public int getElectId() {
		return electId;
	}
	
	public void setElectId(int electId) {
		this.electId = electId;
	}
	
	public int getConId() {
		return conId;
	}
	
	public void setConId(int conId) {
		this.conId = conId;
	}
	
	public int getNoOfDays() {
		return noOfDays;
	}
	
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	
	public int getCurrentUsage() {
		return currentUsage;
	}
	
	public void setCurrentUsage(int currentUsage) {
		this.currentUsage = currentUsage;
	}
	
	public double getProfactor() {
		return profactor;
	}
	
	public void setProfactor(double profactor) {
		this.profactor = profactor;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getBill() {
		return bill;
	}
	
	public void setBill(String bill) {
		this.bill = bill;
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
	
	public void setStatus(String status) {
		this.status = status;
	}

	public double getCarbonValue() {
		return carbonValue;
	}

	public void setCarbonValue(int currentUsage) {
		carbonValue = currentUsage * 0.584;
	}
}
