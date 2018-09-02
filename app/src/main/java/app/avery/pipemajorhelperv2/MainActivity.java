package app.avery.pipemajorhelperv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Log: ";
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();
        final User user = realm.where(User.class).findFirst();

        if(user == null){
            setContentView(R.layout.activity_main_view_get_user);
        }
        else{
            String userName = user.getName();
            Band band = user.getBand();
            String bandName = band.getName();
            setContentView(R.layout.activity_main);
            TextView welcomeText = findViewById(R.id.welcomeText);
            welcomeText.setText("Welcome back, " + userName + "!\n" + bandName);
        }
    }

    public void onStartClick(View v){
        EditText userName = findViewById(R.id.userGetName);
        EditText bandName = findViewById(R.id.bandGetName);
        String newUserName = userName.getText().toString();
        String newBandName = bandName.getText().toString();
        String bandID = newBandName.substring(0, 3).toUpperCase();

        User newUser = new User(newUserName);
        Band newBand = new Band(bandID, newBandName, newUser);
        newUser.setBand(newBand);

        realm.beginTransaction();
        realm.copyToRealm(newUser);
        realm.copyToRealm(newBand);
        realm.commitTransaction();

        setContentView(R.layout.activity_main);
        TextView welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText("Welcome, " + newUser.getName() + "!\n" + newBand.getName());
    }

}