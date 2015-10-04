package me.maksud.firebasecostmanagement.models.generaltransaction;

import java.util.ArrayList;

import me.maksud.firebasecostmanagement.models.BaseModel;
import me.maksud.firebasecostmanagement.settings.generaltransaction.TransactionSettings;

/**
 * Created by maksud on 10/2/15.
 */
public class GeneralTransaction extends BaseModel {

    public String id;
    public String account;
    public String  category;

    public String description;
    public double amount;
    public int direction = TransactionSettings.DEFAULT_TRANSACTION_DIRECTION;

    public ArrayList<String> entities;

    public static final String PATH = "generaltransactions";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<String> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<String> entities) {
        this.entities = entities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
