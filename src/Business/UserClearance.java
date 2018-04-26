/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author sdown
 */
 public enum UserClearance {
        INACTIVE_USER("inactive"), CASE_WORKER("caseWorker"), ADMIN("admin"), MANAGEMENT("management");
        
        private String clearanceString;

    private UserClearance(String clearanceString) {
        this.clearanceString = clearanceString;
    }

    @Override
    public String toString() {
        return clearanceString;
    }
        
        
        
        
        
        
        
        
        
        
        
    }
