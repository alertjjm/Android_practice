package com.example.samplearcelable;
import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {
    int number;
    String message;
    public int describeContents(){
        return 0;
    }
    public SimpleData(int num, String msg){
        number=num;
        message=msg;
    }
    public SimpleData(Parcel src){
        number=src.readInt();
        message=src.readString();
    }
    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(number);
        dest.writeString(message);
    }
    public static final Parcelable.Creator CREATOR=new Parcelable.Creator(){
        public SimpleData createFromParcel(Parcel in){
            return new SimpleData(in);
        }
        public SimpleData[] newArray(int size){
            return new SimpleData[size];
        }
    };


}
