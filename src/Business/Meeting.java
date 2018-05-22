package Business;

import Acquaintance.IMeeting;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Rasmus
 */
public class Meeting implements IMeeting {
   private Timestamp meetingTime;
   private Collection<String> attendingCasworkerIDList;
   private String meetingDescription;
   private String meetingLocation;

    public Meeting(Timestamp meetingTime,String meetingDescription, String meetingLocation) {
        this.meetingTime = meetingTime;
        this.meetingDescription = meetingDescription;
        this.meetingLocation = meetingLocation;
    }
    
    // skriv metode til at fjerne en caseworker fra et møde

    @Override
    public Timestamp getMeetingTime() {
        return this.meetingTime;
    }

    @Override
    public void setMeetingTime(Timestamp time) {
        this.meetingTime = time;
    }

    @Override
    public Collection<String> getAttendingCaseworkerIDs() {
        return this.attendingCasworkerIDList;
    }

    @Override
    public void removeAttendingCaseworkerID(String caseworkerID) {
        this.attendingCasworkerIDList.remove(caseworkerID);
    }

    @Override
    public String getMeetingDescription() {
        return this.meetingDescription;
    }

    @Override
    public void setMeetingDescription(String description) {
        this.meetingDescription = description;
    }

    @Override
    public String getMeetingLocation() {
        return this.meetingLocation;
    }

    @Override
    public void setMeetingLocation(String location) {
        this.meetingLocation = location;
    }
}