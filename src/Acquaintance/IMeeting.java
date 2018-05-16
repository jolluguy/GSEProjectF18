/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Rasmus
 */
public interface IMeeting {
    public Date getMeetingDate();
    public void setMeetingDate(Date date);
    
    public Collection<String> getAttendingCaseworkerIDs();
    public void removeAttendingCaseworkerID(String caseworkerID); // Tænker der skal være mulighed for at fjerne caseworkers?
    
    public String getMeetingDescription();
    public void setMeetingDescription(String description);
    
    public String getMeetingLocation();
    public void setMeetingLocation(String location);
}
