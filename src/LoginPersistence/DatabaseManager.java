package LoginPersistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseManager {

    Connection conn;
    String url = "jdbc:postgresql://horton.elephantsql.com:5432/ksevsemh";
    String dbUsername = "ksevsemh";
    String dbPassword = "S_ACh-Y8moY8kuw4BtFMiGDWoqLrzc_o";

    

    public boolean createUserInDB(String username, String password, boolean b, java.sql.Timestamp createdTime, java.sql.Timestamp lastLoginTime) {
        try {
            
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement st = conn.prepareStatement("insert into login (brugernavn, kodeord, status, created_time, last_login_time) "
                    + "values ('" + username + "', '" + password + "', " + b + ", '" + createdTime + "', '" + lastLoginTime + "');");
            
            System.out.println("CreatedTime = " + createdTime);


            st.executeUpdate();

            System.out.println("Query successfull");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
    
}
