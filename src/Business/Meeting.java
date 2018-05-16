/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IMeeting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Rasmus
 */
public class Meeting implements IMeeting {
   Date meetingDate;
   Collection<String> attendingCasworkerIDList;
   String meetingDescription;
   String meetingLocation;

    public Meeting(Date meetingDate, Collection<String> attendingCasworkerIDList, String meetingDescription, String meetingLocation) {
        this.meetingDate = meetingDate;
        this.attendingCasworkerIDList = new ArrayList<>();
        for(String s: attendingCasworkerIDList){
            this.attendingCasworkerIDList.add(s);
        }
        this.meetingDescription = meetingDescription;
        this.meetingLocation = meetingLocation;
    }
    
    // skriv metode til at fjerne en caseworker fra et møde

    @Override
    public Date getMeetingDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMeetingDate(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<String> getAttendingCaseworkerIDs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAttendingCaseworkerID(String caseworkerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMeetingDescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMeetingDescription(String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMeetingLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMeetingLocation(String location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

       
}
