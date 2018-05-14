package DataPersistence;

import Acquaintance.IMeeting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class DataMeeting implements IMeeting {
    private Date meetingDate;
    private Collection<String> attendingCaseworkerIDList;
    private String meetingDescription;
    private String meetingLocation;

    
    // er lidt usikker på den her constructor
    DataMeeting(Date meetingDate, Collection<String> attendingCaseworkerIDList, String meetingDescription, String meetingLocation) {
        this.meetingDate = meetingDate;
        this.attendingCaseworkerIDList = new ArrayList<>();
        for(String s: attendingCaseworkerIDList){
            this.attendingCaseworkerIDList.add(s);
        }
        this.meetingDescription = meetingDescription;
        this.meetingLocation = meetingLocation;
    }
    
    
    @Override
    public Date getMeetingDate() {
        return this.meetingDate;
    }

    @Override
    public void setMeetingDate(Date date) {
        this.meetingDate = date;
    }

    @Override
    public Collection<String> getAttendingCaseworkerIDs() {
        return this.attendingCaseworkerIDList;
    }

    @Override
    public void removeAttendingCaseworkerID(String caseworkerID) {
        this.attendingCaseworkerIDList.remove(caseworkerID);
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