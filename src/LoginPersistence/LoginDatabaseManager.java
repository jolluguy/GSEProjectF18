package LoginPersistence;

import Acquaintance.IUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

public class LoginDatabaseManager {

    Connection conn;
    String url = "jdbc:postgresql://pellefant.db.elephantsql.com:5432/ciouhfgp";
    String dbUsername = "ciouhfgp";
    String dbPassword = "z0qIbACfFzXvrWfMqNV8ThVbgfyV8k76";

    public void pingDatabase() throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            Class.forName("org.postgresql.Driver");
            if (!conn.isValid(0)) {
                throw new SQLException();
            }
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }

    }

    public boolean createUserInDB(IUser user) {

        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String phoneNumber = user.getPhoneNumber();
        String mail = user.getMail();
        String userName = user.getUserName();
        String password = user.getPassword();
        boolean active = user.getActive();
        Timestamp createdTime = user.getCreatedTime();
        Timestamp lastLoginTime = user.getLastLoginTime();

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {

            Class.forName("org.postgresql.Driver");

            //Query 1
            PreparedStatement st1 = conn.prepareStatement("INSERT INTO login (brugernavn, kodeord, niveau, oprettet, sidste_login) "
                    + "VALUES ('" + userName + "', '" + password + "', " + active + ", '" + createdTime + "', '" + lastLoginTime + "');");

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

    public boolean updateLastLogin(IUser user) {
        String userName = user.getUserName();

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {

            Class.forName("org.postgresql.Driver");

            PreparedStatement st = conn.prepareStatement("UPDATE login SET sidste_login = '" + (new Timestamp(System.currentTimeMillis())) + "' WHERE brugernavn = '" + userName + "';");

            st.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean updateJob(IUser user) {
        String userName = user.getUserName();
        boolean active = user.getActive();

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            Class.forName("org.postgresql.Driver");

            PreparedStatement st = conn.prepareStatement("UPDATE login SET niveau = '" + active + "' WHERE brugernavn = '" + userName + "';");

            st.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public Collection getAllUsers() {

        Collection<IUser> userList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            Class.forName("org.postgresql.Driver");

            Statement st = conn.createStatement();
            String sql = "SELECT login.brugernavn, login.kodeord, login.aktiv, login.oprettet, login.sidste_login FROM login";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                String userName = result.getString("brugernavn");
                String password = result.getString("kodeord");
                boolean active = result.getBoolean("aktiv");
                java.sql.Timestamp createdTime = result.getTimestamp("oprettet");
                java.sql.Timestamp lastLoginTime = result.getTimestamp("sidste_login");
                
                userList.add(new DataUser(userName, password, active, createdTime, lastLoginTime));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }

    public boolean doesUserExist(String userName) {
        int matches = -1;
        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            Class.forName("org.postgresql.Driver");

            Statement st = conn.createStatement();
            String sql = "SELECT COUNT('brugernavn') FROM login WHERE brugernavn = '" + userName + "';";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                matches = result.getInt("count");
            }

            if (matches == 1) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public IUser getUser(String userName) {
        DataUser user = null;

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            Class.forName("org.postgresql.Driver");

            if (doesUserExist(userName)) {
                Statement st = conn.createStatement();
                String sql = "SELECT brugernavn, kodeord, aktiv, oprettet, sidste_login FROM login "
                        + "WHERE brugernavn = '" + userName + "';";

                ResultSet result = st.executeQuery(sql);

                while (result.next()) {
                    String tempUserName = result.getString("brugernavn");
                    String tempPassword = result.getString("kodeord");
                    boolean tempActive = result.getBoolean("aktiv");
                    Timestamp tempCreatedTime = result.getTimestamp("oprettet");
                    Timestamp tempLastLoginTime = result.getTimestamp("sidste_login");

                    user = new DataUser(tempUserName, tempPassword, tempActive, tempCreatedTime, tempLastLoginTime);
                }
            } else {
                System.out.println("User does not exist");
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    
    
    public int getAccess(String userName) {
        int access = -1;
        
        try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
            Class.forName("org.postgresql.Driver");
            
            if(doesUserExist(userName)){
                Statement st = conn.createStatement();
                String sql = "SELECT login.brugernavn, stilling.adgangsniveau from login "
                        + "INNER JOIN holder_info on login.brugernavn = holder_info.brugernavn "
                        + "INNER JOIN bruger on holder_info.bruger_id = bruger.bruger_id "
                        + "INNER JOIN besidder on bruger.bruger_id = besidder.bruger_id "
                        + "INNER JOIN Stilling on besidder.stillings_id = stilling.stillings_id "
                        + "WHERE login.brugernavn = '" + userName + "';";
                
                ResultSet result = st.executeQuery(sql);
                
                while(result.next()){
                    String tempUserName = result.getString("brugernavn");
                    access = result.getInt("adgangsniveau");
                }
            } else return access; //returns -1
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return access; //returns access level for the user
    }

}