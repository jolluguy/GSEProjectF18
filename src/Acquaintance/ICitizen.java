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
   public void setFirstName(String firstName);
   public String getLastName();
   public void setLastName(String lastName);
   public String getRoadName();
   public void setRoadName(String roadName);
   public String getHouseNumber();
   public void setHouseNumber(String houseNumber);
   public String getFloor();
   public void setFloor(String floor);
   public int getPostalCode();
   public void setPostalCode(int postalCode);
   public String getCity();
   public void setCity(String city);
   public String getPhoneNumber();
   public void setPhoneNumber(String phoneNumber);
   
   public String getCprNumber();
   public ICPR getCpr();
}
