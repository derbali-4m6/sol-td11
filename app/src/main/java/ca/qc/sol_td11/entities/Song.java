package ca.qc.sol_td11.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {
    private int rawID;
    private String title;

    public Song() {
    }

    public Song(int rawID, String title) {
        this.rawID = rawID;
        this.title = title;
    }

    public int getRawID() {
        return rawID;
    }

    public void setRawID(int rawID) {
        this.rawID = rawID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.rawID);
        dest.writeString(this.title);
    }

    public void readFromParcel(Parcel source) {
        this.rawID = source.readInt();
        this.title = source.readString();
    }

    protected Song(Parcel in) {
        this.rawID = in.readInt();
        this.title = in.readString();
    }

    public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel source) {
            return new Song(source);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
}
