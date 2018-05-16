/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICaseWorker;

/**
 *
 * @author Rasmus
 */
public class CaseWorker extends Job implements ICaseWorker {
    
    
    
    public CaseWorker(int ID, int accessLevel, int departmentID, String departmentName) {
        super(ID, accessLevel, departmentID, departmentName);
    }
    
    
       
}
