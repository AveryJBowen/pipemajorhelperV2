package app.avery.pipemajorhelperv2.UI;

import android.app.Application;

import io.realm.Realm;

public class WholeApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Realm.init(this);
    }
}
