package com.alliance.ssp.ad.bean;

import GJee0v.AZOQYO;
import NOd7IU.AlLFFp;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;

@A5SV6n.A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class Interaction implements Parcelable {
    public static final Parcelable.Creator<Interaction> CREATOR = new A2egSU();
    private static final String TAG = "Interaction: ";
    private Click auto;
    public int autoCloseCountdownTime;
    private Click click;
    public int clickArea;
    private Shake shake;
    private Swipe swipe;

    public class A2egSU implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return new Interaction(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            return new Interaction[i];
        }
    }

    static {
        ouGJ();
    }

    public Interaction(Parcel parcel) {
        this.clickArea = -1;
        try {
            this.clickArea = parcel.readInt();
            this.shake = (Shake) parcel.readParcelable(Shake.class.getClassLoader());
            this.swipe = (Swipe) parcel.readParcelable(Swipe.class.getClassLoader());
            this.click = (Click) parcel.readParcelable(Click.class.getClassLoader());
            this.auto = (Click) parcel.readParcelable(Click.class.getClassLoader());
            this.autoCloseCountdownTime = parcel.readInt();
        } catch (Exception unused) {
            int i = AZOQYO.f3039AcNBzu;
        }
    }

    private static /* synthetic */ void ouGJ() {
        char[] charArray = "»·µö¿¹µ½öº·¡ö«°½´´ö\u0092¶±\u009aª±¼¿½".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 216);
        }
        String str = new String(charArray);
        char[] charArray2 = "»´±¶±¬".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 216);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Click getAuto() {
        return this.auto;
    }

    public Integer getAutoCloseCountdownTime() {
        return Integer.valueOf(this.autoCloseCountdownTime);
    }

    public Click getClick() {
        return this.click;
    }

    public int getClickArea() {
        return this.clickArea;
    }

    public Shake getShake() {
        if (AlLFFp.f5900BPw6Q8) {
            return this.shake;
        }
        return null;
    }

    public Swipe getSwipe() {
        return this.swipe;
    }

    public void setAuto(Click click) {
        this.auto = click;
    }

    public void setAutoCloseCountdownTime(Integer num) {
        this.autoCloseCountdownTime = num.intValue();
    }

    public void setClick(Click click) {
        this.click = click;
    }

    public void setClickArea(int i) {
        this.clickArea = i;
    }

    public void setShake(Shake shake) {
        this.shake = shake;
    }

    public void setSwipe(Swipe swipe) {
        this.swipe = swipe;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeInt(this.clickArea);
            parcel.writeParcelable(this.shake, i);
            parcel.writeParcelable(this.swipe, i);
            parcel.writeParcelable(this.click, i);
            parcel.writeParcelable(this.auto, i);
            parcel.writeInt(this.autoCloseCountdownTime);
        } catch (Exception unused) {
            int i2 = AZOQYO.f3039AcNBzu;
        }
    }
}
