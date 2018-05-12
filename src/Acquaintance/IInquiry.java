/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

/**
 *
 * @author Rasmus
 */
public interface IInquiry {
    
public ICitizen getCitizen();

public void setCitizen(ICitizen citizen);

public String getProblemDescription();

public void setProblemDescription(String problemDescription);
}
