package LoginPersistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DatabaseManager {
    
    Connection conn;
    String url = "jdbc:postgresql://horton.elephantsql.com:5432/ksevsemh";
    String dbUsername = "ksevsemh";
    String dbPassword = "S_ACh-Y8moY8kuw4BtFMiGDWoqLrzc_o";

    public boolean createUserInDB(String username, String password, int niveau, java.sql.Timestamp createdTime, java.sql.Timestamp lastLoginTime) {
        try {

            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement st = conn.prepareStatement("insert into login (brugernavn, kodeord, niveau, created_time, last_login_time) "
                    + "values ('" + username + "', '" + password + "', " + niveau + ", '" + createdTime + "', '" + lastLoginTime + "');");

            System.out.println("CreatedTime = " + createdTime);

            st.executeUpdate();

            System.out.println("Query successfull");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }
    
    public List getAllUsers(){
        
        List<DataUser> userList = new ArrayList();
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM login";
            
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()){
                String username = result.getString("brugernavn");
                String password = result.getString("kodeord");
                int level = Integer.parseInt(result.getString("niveau"));
                java.sql.Timestamp createdTime = result.getTimestamp("created_time");
                java.sql.Timestamp lastLoginTime = result.getTimestamp("last_login_time");

                System.out.println(username);
                userList.add(new DataUser(username, password, level, createdTime, lastLoginTime));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        System.out.println("userList = " + userList);
        
        return userList;
    }

    public int countUsers() {
        int userNumb = -1;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            Statement st = conn.createStatement();
            String sql = "SELECT COUNT(brugernavn) FROM login";
            
            ResultSet result = st.executeQuery(sql);
            
            userNumb = Integer.parseInt(result.getString("count"));
            
        } catch(Exception e){
            e.printStackTrace();
        }

        return userNumb;
    }

}
