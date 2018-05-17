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

public class LoginDatabaseManager {

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
            PreparedStatement st1 = conn.prepareStatement("INSERT INTO login (brugernavn, kodeord, niveau, oprettet, sidste_login) "
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

    public boolean updateLastLogin(IUser user) {
        String userName = user.getUserName();
        
        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
            
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
        int level = user.getLevel();
        
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
                java.sql.Timestamp createdTime = result.getTimestamp("oprettet");
                java.sql.Timestamp lastLoginTime = result.getTimestamp("sidste_login");

                System.out.println(username);
                userList.add(new DataUser(username, password, level, createdTime, lastLoginTime));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }
    
    public boolean doesUserExist(String userName){
        int matches = -1;
        try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
            Class.forName("org.postgresql.Driver");
            
            Statement st = conn.createStatement();
            String sql = "SELECT COUNT('brugernavn') FROM login WHERE brugernavn = '" + userName + "';";
            
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()){
                matches = result.getInt("count");
            }
            
            if(matches == 1){
                return true;
            }            
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
    public IUser getUser(String userName){
        DataUser user = null;
                
        try(Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)){
            Class.forName("org.postgresql.Driver");
            
            if(doesUserExist(userName)){
                Statement st2 = conn.createStatement();
                String sql2 = "SELECT brugernavn, kodeord, niveau, oprettet, sidste_login FROM login WHERE brugernavn = '" + userName + "';";
                
                ResultSet result2 = st2.executeQuery(sql2);
                
                while(result2.next()){
                    String tempUserName = result2.getString("brugernavn");
                    String tempPassword = result2.getString("kodeord");
                    int tempLevel = result2.getInt("niveau");
                    Timestamp tempCreatedTime = result2.getTimestamp("oprettet");
                    Timestamp tempLastLoginTime = result2.getTimestamp("sidste_login");
                    
                    user = new DataUser(tempUserName, tempPassword, tempLevel, tempCreatedTime, tempLastLoginTime);
                }
            } else {
                System.out.println("User does not exist");
                return null;
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
