/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.sql.Timestamp;
import java.util.Collection;

/**
 *
 * @author Rasmus
 */
public interface IMeeting {
    public Timestamp getMeetingTime();
    public void setMeetingTime(Timestamp time);
    
    public Collection<String> getAttendingCaseworkerIDs();
    public void removeAttendingCaseworkerID(String caseworkerID); // Tænker der skal være mulighed for at fjerne caseworkers?
    
    public String getMeetingDescription();
    public void setMeetingDescription(String description);
    
    public String getMeetingLocation();
    public void setMeetingLocation(String location);
}
