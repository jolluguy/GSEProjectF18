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
public interface ICitizen {
      
   public String getFirstName();  

   public String getLastName();

   public String getRoadName();

   public String getHouseNumber();

   public String getFloor();

   public int getPostalCode();

   public String getCity();

   public String getPhoneNumber();

   
   public String getCprNumber();
   
   public ICPR getCpr();

}
