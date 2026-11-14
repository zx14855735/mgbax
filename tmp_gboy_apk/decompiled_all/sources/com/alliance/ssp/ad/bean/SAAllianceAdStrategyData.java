package com.alliance.ssp.ad.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;
import java.util.List;

@A5SV6n.A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SAAllianceAdStrategyData implements Parcelable {
    public static final Parcelable.Creator<SAAllianceAdStrategyData> CREATOR = new A2egSU();
    private List<SAAllianceAdStrategyUnitData> ads;
    private String isNewUser;
    private String registerTime;
    private String serialflag;
    private String sposid;

    public class A2egSU implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return new SAAllianceAdStrategyData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new SAAllianceAdStrategyData[i];
        }
    }

    static {
        syJbYeK();
    }

    public SAAllianceAdStrategyData(Parcel parcel) {
        this.ads = parcel.readArrayList(SAAllianceAdStrategyUnitData.class.getClassLoader());
        this.isNewUser = parcel.readString();
        this.registerTime = parcel.readString();
        this.serialflag = parcel.readString();
        this.sposid = parcel.readString();
    }

    private static /* synthetic */ void syJbYeK() {
        char[] charArray = "úöô·þøôü·ûöà·êñüõõ·Ó÷ðÛëðýþü".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 153);
        }
        String str = new String(charArray);
        char[] charArray2 = "úõð÷ðí".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 153);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSerialflag() {
        return this.serialflag;
    }

    public String getSposid() {
        return this.sposid;
    }

    public List<SAAllianceAdStrategyUnitData> getStrategyUnitdatas() {
        return this.ads;
    }

    public String getisNewUser() {
        return this.isNewUser;
    }

    public String getregisterTime() {
        return this.registerTime;
    }

    public void setSerialflag(String str) {
        this.serialflag = str;
    }

    public void setSposid(String str) {
        this.sposid = str;
    }

    public void setStrategyUnitdatas(List<SAAllianceAdStrategyUnitData> list) {
        this.ads = list;
    }

    public void setisNewUser(String str) {
        this.isNewUser = str;
    }

    public void setregisterTime(String str) {
        this.registerTime = this.registerTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.isNewUser);
        parcel.writeString(this.registerTime);
        parcel.writeString(this.sposid);
        parcel.writeString(this.serialflag);
        parcel.writeTypedList(this.ads);
    }
}
