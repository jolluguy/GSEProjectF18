package DataPersistence;

import Acquaintance.IMeeting;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

public class DataMeeting implements IMeeting {
    private Timestamp meetingTime;
    private Collection<String> attendingCaseworkerIDList;
    private String meetingDescription;
    private String meetingLocation;

    
    // er lidt usikker på den her constructor
    DataMeeting(Timestamp meetingTime, Collection<String> attendingCaseworkerIDList, String meetingDescription, String meetingLocation) {
        this.meetingTime = meetingTime;
        this.attendingCaseworkerIDList = new ArrayList<>();
        for(String s: attendingCaseworkerIDList){
            this.attendingCaseworkerIDList.add(s);
        }
        this.meetingDescription = meetingDescription;
        this.meetingLocation = meetingLocation;
    }
    
    
    @Override
    public Timestamp getMeetingTime() {
        return this.meetingTime;
    }

       @Override
    public Collection<String> getAttendingCaseworkerIDs() {
        return this.attendingCaseworkerIDList;
    }

   @Override
    public String getMeetingDescription() {
        return this.meetingDescription;
    }

    @Override
    public String getMeetingLocation() {
        return this.meetingLocation;
    }
}