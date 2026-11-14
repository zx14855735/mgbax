package com.kwad.framework.filedownloader.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.sdk.utils.ax;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.kwad.framework.filedownloader.d.b.1
        private static b[] cn(int i) {
            return new b[i];
        }

        private static b d(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b createFromParcel(Parcel parcel) {
            return d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ b[] newArray(int i) {
            return cn(i);
        }
    };
    private HashMap<String, List<String>> atd;

    static {
        vMROqJK();
    }

    public b() {
    }

    private static /* synthetic */ void vMROqJK() {
        char[] charArray = "\u0004\b\nI\u0000\u0006\n\u0002I\u0005\b\u001eI\u0014\u000f\u0002\u000b\u000bI-\t\u000e%\u0015\u000e\u0003\u0000\u0002".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'g');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0004\u000b\u000e\t\u000e\u0013".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'g');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final HashMap<String, List<String>> AC() {
        return this.atd;
    }

    public final void bI(String str) {
        HashMap<String, List<String>> hashMap = this.atd;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return this.atd.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.atd);
    }

    public final void y(String str, String str2) {
        ax.hy(str);
        ax.hy(str2);
        if (this.atd == null) {
            this.atd = new HashMap<>();
        }
        List<String> list = this.atd.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.atd.put(str, list);
        }
        if (list.contains(str2)) {
            return;
        }
        list.add(str2);
    }

    public b(Parcel parcel) {
        this.atd = parcel.readHashMap(String.class.getClassLoader());
    }
}
