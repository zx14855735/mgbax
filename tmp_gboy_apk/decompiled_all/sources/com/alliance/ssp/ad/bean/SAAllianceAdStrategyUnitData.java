package com.alliance.ssp.ad.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

@A5SV6n.A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SAAllianceAdStrategyUnitData implements Parcelable {
    public static final Parcelable.Creator<SAAllianceAdStrategyUnitData> CREATOR = new A2egSU();
    private String appId;
    private String codeId;
    private String groupId;
    private String limitHour;
    private String limitInterval;
    private String limitTimes;
    private String originId;
    private String platformAppId;
    private String platformId;
    private String platformName;
    private String posId;
    private String screen;
    private String sortPrice;

    public class A2egSU implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return new SAAllianceAdStrategyUnitData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new SAAllianceAdStrategyUnitData[i];
        }
    }

    static {
        YAYrGU();
    }

    public SAAllianceAdStrategyUnitData(Parcel parcel) {
        this.appId = parcel.readString();
        this.codeId = parcel.readString();
        this.groupId = parcel.readString();
        this.originId = parcel.readString();
        this.platformAppId = parcel.readString();
        this.platformId = parcel.readString();
        this.platformName = parcel.readString();
        this.posId = parcel.readString();
        this.sortPrice = parcel.readString();
        this.screen = parcel.readString();
        this.limitHour = parcel.readString();
        this.limitInterval = parcel.readString();
        this.limitTimes = parcel.readString();
    }

    private static /* synthetic */ void YAYrGU() {
        char[] charArray = "ÖÚØ\u009bÒÔØÐ\u009b×ÚÌ\u009bÆÝÐÙÙ\u009bÿÛÜ÷ÇÜÑÒÐ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 181);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÖÙÜÛÜÁ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 181);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getScreen() {
        return this.screen;
    }

    public String getappId() {
        return this.appId;
    }

    public String getcodeId() {
        return this.codeId;
    }

    public String getgroupId() {
        return this.groupId;
    }

    public String getlimitHour() {
        return this.limitHour;
    }

    public String getlimitInterval() {
        return this.limitInterval;
    }

    public String getlimitTimes() {
        return this.limitTimes;
    }

    public String getoriginId() {
        return this.originId;
    }

    public String getplatformAppId() {
        return this.platformAppId;
    }

    public String getplatformId() {
        return this.platformId;
    }

    public String getplatformName() {
        return this.platformName;
    }

    public String getposId() {
        return this.posId;
    }

    public String getsortPrice() {
        return this.sortPrice;
    }

    public void setScreen(String str) {
        this.screen = str;
    }

    public void setappId(String str) {
        this.appId = str;
    }

    public void setcodeId(String str) {
        this.codeId = str;
    }

    public void setgroupId(String str) {
        this.groupId = str;
    }

    public void setlimitHour(String str) {
        this.limitHour = str;
    }

    public void setlimitInterval(String str) {
        this.limitInterval = str;
    }

    public void setlimitTimes(String str) {
        this.limitTimes = str;
    }

    public void setoriginId(String str) {
        this.originId = str;
    }

    public void setplatformAppId(String str) {
        this.platformAppId = str;
    }

    public void setplatformId(String str) {
        this.platformId = str;
    }

    public void setplatformName(String str) {
        this.platformName = str;
    }

    public void setposId(String str) {
        this.posId = str;
    }

    public void setsortPrice(String str) {
        this.sortPrice = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.codeId);
        parcel.writeString(this.groupId);
        parcel.writeString(this.originId);
        parcel.writeString(this.platformAppId);
        parcel.writeString(this.platformId);
        parcel.writeString(this.platformName);
        parcel.writeString(this.posId);
        parcel.writeString(this.sortPrice);
        parcel.writeString(this.screen);
    }
}
