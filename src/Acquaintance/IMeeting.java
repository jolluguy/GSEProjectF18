package Acquaintance;

import java.sql.Timestamp;
import java.util.Collection;

/**
 *
 * @author Rasmus
 */
public interface IMeeting {
    public Timestamp getMeetingTime();
    
    public Collection<String> getAttendingCaseworkerIDs();
    
    public String getMeetingDescription();
    
    public String getMeetingLocation();

}