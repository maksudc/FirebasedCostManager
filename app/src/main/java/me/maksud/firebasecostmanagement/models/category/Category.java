package me.maksud.firebasecostmanagement.models.category;

import me.maksud.firebasecostmanagement.models.BaseModel;

/**
 * Created by maksud on 10/2/15.
 */
public class Category extends BaseModel {

    public static final String ID = "id";
    public String id;

    public static final String NAME = "name";
    public String name;

    public static final String PATH = "categories";

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
