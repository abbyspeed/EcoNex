package model;

public class Water {
    private int waterid;
    private int conid;
    private int noofdays;
    private double profactor;
    private int currentUsage;
    private double amount;
    private String bill;
    private String description;
    private String status;

    public int getWaterid() {
        return waterid;
    }

    public void setWaterid(int waterid) {
        this.waterid = waterid;
    }

    public int getConid() {
        return conid;
    }

    public void setConid(int conid) {
        this.conid = conid;
    }

    public int getNoofdays() {
        return noofdays;
    }

    public void setNoofdays(int noofdays) {
        this.noofdays = noofdays;
    }

    public double getProfactor() {
        return profactor;
    }

    public void setProfactor(double profactor) {
        this.profactor = profactor;
    }

    public int getCurrentUsage() {
        return currentUsage;
    }

    public void setCurrentUsage(int currentUsage) {
        this.currentUsage = currentUsage;
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
}
