package app.avery.pipemajorhelperv2;

import io.realm.RealmObject;

public class User extends RealmObject {
    private String name;
    private Band band;

    public User(){

    }

    public User(String name){
        this.name = name;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
