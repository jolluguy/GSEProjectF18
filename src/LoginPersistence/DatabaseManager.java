package LoginPersistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManager {

    Connection conn;
    String url = "jdbc:postgresql://horton.elephantsql.com:5432/ksevsemh";
    String username = "ksevsemh";
    String password = "S_ACh-Y8moY8kuw4BtFMiGDWoqLrzc_o";

    

    public boolean createUserInDB(String username, String password, boolean b, java.util.Date createdTime, java.util.Date lastLoginTime) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("insert into login (brugernavn, kodeord, status, created_time, last_login_time) "
                    + "values (" + username + ", " + password + ", " + b + ", " + createdTime + ", " + lastLoginTime + ");");

//            String sql = "INSERT INTO login(brugernavn, kodeord, status, created_time, last_login_time) "
//                    + "VALUES(" + username + ", " + password + ", " + true + ", "
//                    + createdTime + ", " + lastLoginTime + ");";

            st.setString(1, username);
            st.setString(2, password);
            st.setBoolean(3, true);
            st.setObject(4, createdTime);
            st.setObject(5, lastLoginTime);

            st.executeUpdate();

            System.out.println("Query successfull");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;

    }

}
