package LoginPersistence;

import Acquaintance.IDepartment;
import Acquaintance.IJob;
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

    /**
     * vreates a User in the Database, this is written based on the notion that
     * the jobs and departments allready is created with the rigth atributes in
     * the database.
     *
     * @param user
     * @return
     */
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

        int jobID = user.getJob().getID();
        int departmentID = user.getJob().getDepartment().getDepartmentID();

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {

            Class.forName("org.postgresql.Driver");

            //Query 1
            PreparedStatement st1 = conn.prepareStatement("INSERT INTO login (brugernavn, kodeord, aktiv, oprettet, sidste_login) "
                    + "VALUES ('" + userName + "', '" + password + "', " + active + ", '" + createdTime + "', '" + lastLoginTime + "');");

            st1.executeUpdate();

            //Query 2
            PreparedStatement st2 = conn.prepareStatement("INSERT INTO bruger(fornavn, efternavn, telefonnummer, mail) "
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

            //Query connect user with job
            PreparedStatement st5 = conn.prepareStatement("INSERT INTO besidder VALUES('" + userID + "', " + jobID + ");");

            st5.executeUpdate();

            //Querry that connect user with department
            PreparedStatement st6 = conn.prepareStatement("INSERT INTO tilhører VALUES('" + userID + "', " + departmentID + ");");

            st6.executeUpdate();

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

            PreparedStatement st = conn.prepareStatement("UPDATE login SET sidste_login = '" + (user.getLastLoginTime()) + "' WHERE brugernavn = '" + userName + "';");

            st.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * updates alle parameters the concerens the users jobstatus, including the
     * job, department and active status.
     *
     * @param user
     * @return
     */
    public boolean updateJob(IUser user) {

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            Class.forName("org.postgresql.Driver");

            PreparedStatement st1 = conn.prepareStatement("UPDATE login SET aktiv = '" + user.getActive() + "' WHERE brugernavn = '" + user.getUserName() + "';");

            st1.executeUpdate();

            PreparedStatement st2 = conn.prepareStatement("UPDATE besidder SET stillings_id = '" + user.getJob().getID() + "' WHERE bruger_id = '" + user.getUserID() + "';");

            st2.executeUpdate();

            PreparedStatement st3 = conn.prepareStatement("UPDATE tilhører SET afdelings_id = '" + user.getJob().getDepartment().getDepartmentID() + "' WHERE bruger_id = '" + user.getUserID() + "';");

            st3.executeUpdate();

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
            String sql = "SELECT * FROM login "
                    + "INNER JOIN holder_info ON login.brugernavn = holder_info.brugernavn "
                    + "INNER JOIN bruger ON holder_info.bruger_id = bruger.bruger_id "
                    + "INNER JOIN tilhører ON bruger.bruger_id = tilhører.bruger_id "
                    + "INNER JOIN afdeling ON tilhører.afdelings_id = afdeling.afdelings_id "
                    + "INNER JOIN besidder ON bruger.bruger_id = besidder.bruger_id "
                    + "INNER JOIN stilling ON besidder.stillings_id = stilling.stillings_id";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                int tempUserID = result.getInt("bruger_id");
                String tempFirstName = result.getString("fornavn");
                String tempLastName = result.getString("efternavn");
                String tempPhone = result.getString("telefonnummer");
                String tempEmail = result.getString("mail");
                String tempUserName = result.getString("brugernavn");
                String tempPassword = result.getString("kodeord");
                boolean tempActive = result.getBoolean("aktiv");
                Timestamp tempCreatedTime = result.getTimestamp("oprettet");
                Timestamp tempLastLoginTime = result.getTimestamp("sidste_login");
                String tempJobTitle = result.getString("stillings_titel");
                int tempJobID = result.getInt("stillings_id");
                int tempAccess = result.getInt("adgangsniveau");
                int tempDepartmentID = result.getInt("afdelings_id");
                String tempDepartmentName = result.getString("afdelings_navn");

                userList.add(new DataUser(tempUserID, tempFirstName, tempLastName, tempPhone, tempEmail, tempUserName, tempPassword, tempActive, tempCreatedTime, tempLastLoginTime, tempJobTitle, tempJobID, tempAccess, tempDepartmentID, tempDepartmentName));
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

            Statement st = conn.createStatement();
            String sql = "SELECT * FROM login "
                    + "INNER JOIN holder_info ON login.brugernavn = holder_info.brugernavn "
                    + "INNER JOIN bruger ON holder_info.bruger_id = bruger.bruger_id "
                    + "INNER JOIN tilhører ON bruger.bruger_id = tilhører.bruger_id "
                    + "INNER JOIN afdeling ON tilhører.afdelings_id = afdeling.afdelings_id "
                    + "INNER JOIN besidder ON bruger.bruger_id = besidder.bruger_id "
                    + "INNER JOIN stilling ON besidder.stillings_id = stilling.stillings_id "
                    + "WHERE login.brugernavn = '" + userName + "';";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                int tempUserID = result.getInt("bruger_id");
                String tempFirstName = result.getString("fornavn");
                String tempLastName = result.getString("efternavn");
                String tempPhone = result.getString("telefonnummer");
                String tempEmail = result.getString("mail");
                String tempUserName = result.getString("brugernavn");
                String tempPassword = result.getString("kodeord");
                boolean tempActive = result.getBoolean("aktiv");
                Timestamp tempCreatedTime = result.getTimestamp("oprettet");
                Timestamp tempLastLoginTime = result.getTimestamp("sidste_login");
                String tempJobTitle = result.getString("stillings_titel");
                int tempJobID = result.getInt("stillings_id");
                int tempAccess = result.getInt("adgangsniveau");
                int tempDepartmentID = result.getInt("afdelings_id");
                String tempDepartmentName = result.getString("afdelings_navn");

                user = new DataUser(tempUserID, tempFirstName, tempLastName, tempPhone, tempEmail, tempUserName, tempPassword, tempActive, tempCreatedTime, tempLastLoginTime, tempJobTitle, tempJobID, tempAccess, tempDepartmentID, tempDepartmentName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    Collection<IJob> getJobList() {
        Collection<IJob> joblist = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            Class.forName("org.postgresql.Driver");

            Statement st = conn.createStatement();
            String sql = "SELECT * FROM stilling";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                String jobTitle = result.getString("stillings_titel");
                int accessLevel = result.getInt("adgangsniveau");
                int jobID = result.getInt("stillings_id");

                joblist.add(new DataJob(jobTitle, jobID, accessLevel));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return joblist;
    }

    Collection<IDepartment> getDepartmentList() {
        Collection<IDepartment> depList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            Class.forName("org.postgresql.Driver");

            Statement st = conn.createStatement();
            String sql = "SELECT * FROM afdeling";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                String departmentName = result.getString("afdelings_navn");
                int departmentID = result.getInt("afdelings_id");

                depList.add(new DataDepartment(departmentID, departmentName));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return depList;
    }

    IUser getUser(int userID) {
        DataUser user = null;

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            Class.forName("org.postgresql.Driver");

            Statement st = conn.createStatement();
            String sql = "SELECT * FROM bruger "
                    + "INNER JOIN holder_info ON bruger.bruger_id = holder_info.bruger_id "
                    + "INNER JOIN login ON holder_info.brugernavn = login.brugernavn "
                    + "INNER JOIN tilhører ON bruger.bruger_id = tilhører.bruger_id "
                    + "INNER JOIN afdeling ON tilhører.afdelings_id = afdeling.afdelings_id "
                    + "INNER JOIN besidder ON bruger.bruger_id = besidder.bruger_id "
                    + "INNER JOIN stilling ON besidder.stillings_id = stilling.stillings_id "
                    + "WHERE bruger.bruger_id = '" + userID + "';";

            ResultSet result = st.executeQuery(sql);

            while (result.next()) {
                int tempUserID = result.getInt("bruger_id");
                String tempFirstName = result.getString("fornavn");
                String tempLastName = result.getString("efternavn");
                String tempPhone = result.getString("telefonnummer");
                String tempEmail = result.getString("mail");
                String tempUserName = result.getString("brugernavn");
                String tempPassword = result.getString("kodeord");
                boolean tempActive = result.getBoolean("aktiv");
                Timestamp tempCreatedTime = result.getTimestamp("oprettet");
                Timestamp tempLastLoginTime = result.getTimestamp("sidste_login");
                String tempJobTitle = result.getString("stillings_titel");
                int tempJobID = result.getInt("stillings_id");
                int tempAccess = result.getInt("adgangsniveau");
                int tempDepartmentID = result.getInt("afdelings_id");
                String tempDepartmentName = result.getString("afdelings_navn");

                user = new DataUser(tempUserID, tempFirstName, tempLastName, tempPhone, tempEmail, tempUserName, tempPassword, tempActive, tempCreatedTime, tempLastLoginTime, tempJobTitle, tempJobID, tempAccess, tempDepartmentID, tempDepartmentName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    void updatePassword(IUser user) {
        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {

            Class.forName("org.postgresql.Driver");

            PreparedStatement st = conn.prepareStatement("UPDATE login SET kodeord = '" + (user.getPassword()) + "' WHERE brugernavn = '" + user.getUserName() + "';");

            st.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
