package com.alliance.ssp.ad.bean;

import GJee0v.AZOQYO;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

@A5SV6n.A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class Swipe implements Parcelable {
    public static final Parcelable.Creator<Swipe> CREATOR = new A2egSU();
    private static final String TAG = "Swipe: ";
    private int direction;
    private double limitAngle;
    private int swipeLengthDefault;
    private String swipeTemplate;

    public class A2egSU implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return new Swipe(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new Swipe[i];
        }
    }

    static {
        HmTR();
    }

    public Swipe(Parcel parcel) {
        this.swipeTemplate = "";
        try {
            this.swipeTemplate = parcel.readString();
            this.direction = parcel.readInt();
            this.limitAngle = parcel.readDouble();
            this.swipeLengthDefault = parcel.readInt();
        } catch (Exception unused) {
            int i = AZOQYO.f3039AcNBzu;
        }
    }

    private static /* synthetic */ void HmTR() {
        char[] charArray = "\u0088\u0084\u0086Å\u008c\u008a\u0086\u008eÅ\u0089\u0084\u0092Å\u0098\u0083\u008e\u0087\u0087Å¡\u0085\u0082©\u0099\u0082\u008f\u008c\u008e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 235);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0088\u0087\u0082\u0085\u0082\u009f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 235);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDirection() {
        return this.direction;
    }

    public double getLimitAngle() {
        return this.limitAngle;
    }

    public int getSwipeLengthDefault() {
        return this.swipeLengthDefault;
    }

    public String getSwipeTemplate() {
        return this.swipeTemplate;
    }

    public void setDirection(int i) {
        this.direction = i;
    }

    public void setLimitAngle(double d) {
        this.limitAngle = d;
    }

    public void setSwipeLengthDefault(int i) {
        this.swipeLengthDefault = i;
    }

    public void setSwipeTemplate(String str) {
        this.swipeTemplate = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.swipeTemplate);
    }
}
