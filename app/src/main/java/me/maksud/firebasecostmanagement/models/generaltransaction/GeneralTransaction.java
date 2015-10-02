package me.maksud.firebasecostmanagement.models.generaltransaction;

import java.util.ArrayList;

import me.maksud.firebasecostmanagement.models.BaseModel;
import me.maksud.firebasecostmanagement.models.category.Category;
import me.maksud.firebasecostmanagement.models.generalaccount.GeneralAccount;
import me.maksud.firebasecostmanagement.models.generalentity.GeneralEntity;

/**
 * Created by maksud on 10/2/15.
 */
public class GeneralTransaction extends BaseModel {

    public String id;
    public GeneralAccount account;
    public Category category;

    public ArrayList<GeneralEntity> entities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GeneralAccount getAccount() {
        return account;
    }

    public void setAccount(GeneralAccount account) {
        this.account = account;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ArrayList<GeneralEntity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<GeneralEntity> entities) {
        this.entities = entities;
    }


}
