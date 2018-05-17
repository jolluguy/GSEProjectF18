/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

/**
 *
 * @author rasmus
 */
public interface IJob {
    
    int getID();

    int getAccessLevel();
    
    public IDepartment getDepartment();
    
}

