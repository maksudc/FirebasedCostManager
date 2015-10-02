package me.maksud.firebasecostmanagement.models.generalaccount;

import java.util.Date;

import me.maksud.firebasecostmanagement.models.BaseModel;

/**
 * Created by maksud on 10/2/15.
 */
public class GeneralAccount extends BaseModel {

    public String id;
    public String name;

    public Date dateAdded;
    public Date lastUpdated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
