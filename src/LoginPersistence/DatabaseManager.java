package LoginPersistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    
    public void createUserInDB {
        
}

}
