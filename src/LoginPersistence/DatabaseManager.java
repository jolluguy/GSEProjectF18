package LoginPersistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManager {

    Connection conn;
    String url = "postgres://ksevsemh:S_ACh-Y8moY8kuw4BtFMiGDWoqLrzc_o@horton.elephantsql.com:5432/ksevsemh";
    String username = "ksevsemh";
    String password = "S_ACh-Y8moY8kuw4BtFMiGDWoqLrzc_o";

    public final Connection dbConnection() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            DriverManager.getConnection(url, username, password);

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public void createUserInDB(String username, String password, boolean b, java.util.Date createdTime, java.util.Date lastLoginTime) {
        System.out.println("createUserInDB entered");
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();

            
            
            String sql = "INSERT INTO login(brugernavn, kodeord, status, created_time, last_login_time) "
                    + "VALUES(" + username + ", " + password + ", " + true + ", "
                    + createdTime + ", " + lastLoginTime + ");";
            
            st.executeUpdate(sql);
            
            System.out.println("Query successfull");
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
