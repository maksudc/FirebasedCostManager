package me.maksud.firebasecostmanagement.factories;

import android.content.Context;

import com.firebase.client.Firebase;

import me.maksud.firebasecostmanagement.settings.core.BaseSettings;

/**
 * Created by maksud on 10/2/15.
 */
public class BigBangFactory {

    private Firebase firebaseRef = null;

    public static final Object factoryLockObject = new Object();
    private static BigBangFactory factory = null;

    private Context context;

    private BigBangFactory(Context context){

        Firebase.setAndroidContext(context);
        firebaseRef = new Firebase(BaseSettings.FIREBASE_DB_URL);
    }

    public static BigBangFactory getInstance(Context context){

        synchronized (factoryLockObject){
            if(factory==null){
                factory = new BigBangFactory(context);
            }
        }

        return factory;
    }

    public Firebase getFirebaseRef() {
        return firebaseRef;
    }

    public void setFirebaseRef(Firebase firebaseRef) {
        this.firebaseRef = firebaseRef;
    }
}
