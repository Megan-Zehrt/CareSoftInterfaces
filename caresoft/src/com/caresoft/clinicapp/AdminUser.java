// Pair programmed with Jacob Payne

package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
  
    
   
    
    public AdminUser(Integer employeeID, String role) {
    	this.employeeID = employeeID;
    	this.role = role;
    	
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.employeeID, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.employeeID, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		if(accessAuthorized(employeeID) == false) {
			return null;
		}else {
			this.getSecurityIncidents();
		}
		return securityIncidents;
	}
	@Override
	public boolean assignPin(int pin) {
		String pinString = String.valueOf(pin);
		if(pinString.length() >= 6) {
			this.setPin(pin);
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID == this.getEmployeeID()) {
			return true;
		}else if(confirmedAuthID != this.getEmployeeID()) {
			this.authIncident();
		}
		return false;
	}
	

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
	
    
	
	
	
	
}
