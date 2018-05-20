/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IUser;

/**
 *
 * @author Rasmus
 */
public class DomainID {

    String domainID;
    String userIDpart;
    String jobIDPart;
    String departmentIDPart;
    Character seperator = '-';

    DomainID() {
    }

    String getDomainID(IUser user) {
        domainID = ("" + user.getJob().getID() + seperator + user.getJob().getDepartment().getDepartmentID() + seperator + user.getUserID() + "");
        return domainID;
    }

    int getUserID(String domainID) {
        loadId(domainID);
        return Integer.parseInt(userIDpart);        
    }
    
    int getJobID(String domainID){
                loadId(domainID);
        return Integer.parseInt(jobIDPart);   
    }

        int getDepartmentID(String domainID){
                loadId(domainID);
        return Integer.parseInt(departmentIDPart);   
    }
        
    private void loadId(String domainID) {
        String parts[] = domainID.split("-");
        jobIDPart = parts[0];
        departmentIDPart = parts[1];
        userIDpart = parts[2];
    }
}
