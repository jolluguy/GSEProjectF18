package Acquaintance;

/**
 *
 * @author Rasmus
 */
public interface IPerson {
    
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