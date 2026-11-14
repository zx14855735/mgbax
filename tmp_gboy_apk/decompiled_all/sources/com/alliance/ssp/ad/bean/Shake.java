package com.alliance.ssp.ad.bean;

import GJee0v.AZOQYO;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

@A5SV6n.A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class Shake implements Parcelable {
    public static final Parcelable.Creator<Shake> CREATOR = new A2egSU();
    private static final String TAG = "Shake: ";
    public double acceleration;
    public double accelerationDefault;
    public int direction;
    public double operationTime;
    public double operationTimeDefault;
    private int resetSensitivity;
    public double rotationAngle;
    public double rotationAngleDefault;
    private String shakeTemplate;

    public class A2egSU implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return new Shake(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new Shake[i];
        }
    }

    static {
        GyIQ();
    }

    public Shake(Parcel parcel) {
        this.shakeTemplate = "";
        this.resetSensitivity = 1;
        this.direction = 0;
        try {
            this.accelerationDefault = parcel.readDouble();
            this.operationTimeDefault = parcel.readDouble();
            this.rotationAngleDefault = parcel.readDouble();
            this.acceleration = parcel.readDouble();
            this.operationTime = parcel.readDouble();
            this.rotationAngle = parcel.readDouble();
            this.shakeTemplate = parcel.readString();
            this.resetSensitivity = parcel.readInt();
            this.direction = parcel.readInt();
        } catch (Exception unused) {
            int i = AZOQYO.f3039AcNBzu;
        }
    }

    private static /* synthetic */ void GyIQ() {
        char[] charArray = "ØÔÖ\u0095ÜÚÖÞ\u0095ÙÔÂ\u0095ÈÓÞ××\u0095ñÕÒùÉÒßÜÞ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 187);
        }
        String str = new String(charArray);
        char[] charArray2 = "Ø×ÒÕÒÏ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 187);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public double getAcceleration() {
        return this.acceleration;
    }

    public double getAccelerationDefault() {
        return this.accelerationDefault;
    }

    public int getDirection() {
        return this.direction;
    }

    public double getOperationTime() {
        return this.operationTime;
    }

    public double getOperationTimeDefault() {
        return this.operationTimeDefault;
    }

    public int getResetSensitivity() {
        return this.resetSensitivity;
    }

    public double getRotationAngle() {
        return this.rotationAngle;
    }

    public double getRotationAngleDefault() {
        return this.rotationAngleDefault;
    }

    public String getShakeTemplate() {
        return this.shakeTemplate;
    }

    public void setAcceleration(double d) {
        this.acceleration = d;
    }

    public void setAccelerationDefault(double d) {
        this.accelerationDefault = d;
    }

    public void setDirection(int i) {
        this.direction = i;
    }

    public void setOperationTime(double d) {
        this.operationTime = d;
    }

    public void setOperationTimeDefault(double d) {
        this.operationTimeDefault = d;
    }

    public void setResetSensitivity(int i) {
        this.resetSensitivity = i;
    }

    public void setRotationAngle(double d) {
        this.rotationAngle = d;
    }

    public void setRotationAngleDefault(double d) {
        this.rotationAngleDefault = d;
    }

    public void setShakeTemplate(String str) {
        this.shakeTemplate = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.accelerationDefault);
        parcel.writeDouble(this.operationTimeDefault);
        parcel.writeDouble(this.rotationAngleDefault);
        parcel.writeDouble(this.acceleration);
        parcel.writeDouble(this.operationTime);
        parcel.writeDouble(this.rotationAngle);
        parcel.writeString(this.shakeTemplate);
        parcel.writeInt(this.resetSensitivity);
        parcel.writeInt(this.direction);
    }
}
