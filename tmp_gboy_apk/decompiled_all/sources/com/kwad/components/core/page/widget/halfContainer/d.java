package com.kwad.components.core.page.widget.halfContainer;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: com.kwad.components.core.page.widget.halfContainer.d.1
        private static d b(Parcel parcel) {
            return new d(parcel);
        }

        private static d[] be(int i) {
            return new d[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ d createFromParcel(Parcel parcel) {
            return b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ d[] newArray(int i) {
            return be(i);
        }
    };
    public boolean YV;
    public float YW;
    public float YX;
    public float YY;
    public int YZ;
    public boolean Za;
    public boolean Zb;
    public boolean Zc;
    public int Zd;
    public boolean Ze = true;
    public ContainerBottomSheetBehavior Zf;
    public Map<String, String> Zg;

    static {
        vknZgEv();
    }

    public d() {
    }

    private static float aC(Context context) {
        return com.kwad.sdk.c.a.a.br(context);
    }

    private static /* synthetic */ void vknZgEv() {
        char[] charArray = "\u0092\u009e\u009cß\u0096\u0090\u009c\u0094ß\u0093\u009e\u0088ß\u0082\u0099\u0094\u009d\u009dß»\u009f\u0098³\u0083\u0098\u0095\u0096\u0094".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 241);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0092\u009d\u0098\u009f\u0098\u0085".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 241);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final float aB(Context context) {
        float f = this.YX;
        return f > 0.0f ? f : aC(context);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.YV ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.YW);
        parcel.writeFloat(this.YX);
        parcel.writeFloat(this.YY);
        parcel.writeInt(this.YZ);
        parcel.writeByte(this.Za ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.Zb ? (byte) 1 : (byte) 0);
    }

    public d(Parcel parcel) {
        this.YV = parcel.readByte() != 0;
        this.YW = parcel.readFloat();
        this.YX = parcel.readFloat();
        this.YY = parcel.readFloat();
        this.YZ = parcel.readInt();
        this.Za = parcel.readByte() != 0;
        this.Zb = parcel.readByte() != 0;
    }
}
