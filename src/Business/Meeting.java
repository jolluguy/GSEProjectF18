package Business;

import Acquaintance.IMeeting;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Rasmus
 */
class Meeting implements IMeeting {

    private Timestamp meetingTime;
    private Collection<String> attendingCasworkerIDList;
    private String meetingDescription;
    private String meetingLocation;

    Meeting(Timestamp meetingTime, String meetingDescription, String meetingLocation) {
        this.meetingTime = meetingTime;
        this.meetingDescription = meetingDescription;
        this.meetingLocation = meetingLocation;
    }

    // skriv metode til at fjerne en caseworker fra et møde
    @Override
    public Timestamp getMeetingTime() {
        return this.meetingTime;
    }

    void setMeetingTime(Timestamp time) {
        this.meetingTime = time;
    }

    @Override
    public Collection<String> getAttendingCaseworkerIDs() {
        return this.attendingCasworkerIDList;
    }

    void removeAttendingCaseworkerID(String caseworkerID) {
        this.attendingCasworkerIDList.remove(caseworkerID);
    }

    @Override
    public String getMeetingDescription() {
        return this.meetingDescription;
    }

    void setMeetingDescription(String description) {
        this.meetingDescription = description;
    }

    @Override
    public String getMeetingLocation() {
        return this.meetingLocation;
    }

    void setMeetingLocation(String location) {
        this.meetingLocation = location;
    }
}
