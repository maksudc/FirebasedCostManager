package me.maksud.firebasecostmanagement.models.generalentity;

import me.maksud.firebasecostmanagement.models.BaseModel;

/**
 * Created by maksud on 10/2/15.
 */
public class GeneralEntity extends BaseModel {

    public String id;
    public String name;

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
}
