package me.maksud.firebasecostmanagement.models;

import java.util.Date;

/**
 * Created by maksud on 10/3/15.
 */
public class TimeTrackableModel {
    public static final String DATE_ADDED = "dateAdded";
    public Date dateAdded;

    public static final String LAST_UPDATED = "lastUpdated";
    public Date lastUpdated;

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
