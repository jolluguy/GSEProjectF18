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
   public String getFirstname();  
   public void setFirstname(String firstname);
   public String getSurname();
   public void setSurname(String surname);
   public String getRoadName();
   public void setRoadName(String roadName);
   public String getHouseNumber();
   public void setHouseNumber(String houseNumber);
   public String getFloor();
   public void setFloor(String floor);
   public int getPostNumber();
   public void setPostNumber(int postNumber);
   public String getCity();
   public void setCity(String city);
   public String getTlfNumber();
   public void setTlfNumber(String tlfNumber);
   
   public long getCprNumber();
   public ICPR getCpr();
}
