package LoginPersistence;

import Acquaintance.IUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

public class DatabaseManager {

    Connection conn;
    String url = "jdbc:postgresql://pellefant.db.elephantsql.com:5432/ciouhfgp";
    String dbUsername = "ciouhfgp";
    String dbPassword = "z0qIbACfFzXvrWfMqNV8ThVbgfyV8k76";

    public boolean createUserInDB(IUser user) {

        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String phoneNumber = user.getPhoneNumber();
        String mail = user.getMail();
        String userName = user.getUserName();
        String password = user.getPassword();
        int niveau = user.getLevel();
        Timestamp createdTime = user.getCreatedTime();
        Timestamp lastLoginTime = user.getLastLoginTime();

        try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {

            Class.forName("org.postgresql.Driver");

            //Query 1
            PreparedStatement st1 = conn.prepareStatement("INSERT INTO login (brugernavn, kodeord, niveau, created_time, last_login_time) "
                    + "VALUES ('" + userName + "', '" + password + "', " + niveau + ", '" + createdTime + "', '" + lastLoginTime + "');");

            st1.executeUpdate();

            //Query 2
            PreparedStatement st2 = conn.prepareStatement("INSERT INTO bruger(fornavn, efternavn, telefonnummer,mail) "
                    + "VALUES('" + firstName + "', '" + lastName + "', '" + phoneNumber + "', '" + mail + "');");

            st2.executeUpdate();

            Thread.sleep(1000);

            //Query 3
            String userID = null;

            Statement st3 = conn.createStatement();
            String sql = "SELECT bruger_id FROM bruger WHERE mail LIKE('" + userName + "%');";

            ResultSet result = st3.executeQuery(sql);

            while (result.next()) {
                userID = result.getString("bruger_id");
            }

            //Query 4
            PreparedStatement st4 = conn.prepareStatement("INSERT INTO holder_info VALUES('" + userName + "', " + userID + ");");

            st4.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean updateLastLogin(String userName) {
        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
            
            Class.forName("org.postgresql.Driver");
            

            PreparedStatement st = conn.prepareStatement("UPDATE login SET last_login_time = '" + (new Timestamp(System.currentTimeMillis())) + "' WHERE brugernavn = '" + userName + "';");

            st.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean updateJob(String userName, int level) {
        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
            Class.forName("org.postgresql.Driver");
            

            PreparedStatement st = conn.prepareStatement("UPDATE login SET niveau = '" + level + "' WHERE brugernavn = '" + userName + "';");

            st.executeUpdate();

            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public Collection getAllUsers() {

        Collection<IUser> userList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
            Class.forName("org.postgresql.Driver");
            
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM login";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                String username = result.getString("brugernavn");
                String password = result.getString("kodeord");
                int level = Integer.parseInt(result.getString("niveau"));
                java.sql.Timestamp createdTime = result.getTimestamp("created_time");
                java.sql.Timestamp lastLoginTime = result.getTimestamp("last_login_time");

                System.out.println(username);
                userList.add(new DataUser(username, password, level, createdTime, lastLoginTime));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }

}
