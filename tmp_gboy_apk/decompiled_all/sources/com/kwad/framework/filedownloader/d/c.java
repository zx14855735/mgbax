package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.fl.saas.base.cache.DatabaseHelper;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.kwad.framework.filedownloader.d.c.1
        private static c[] cp(int i) {
            return new c[i];
        }

        private static c e(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c[] newArray(int i) {
            return cp(i);
        }
    };
    private String afW;
    private boolean asR;
    private boolean ate;
    private final AtomicInteger atf;
    private final AtomicLong atg;
    private long ath;
    private String ati;
    private String atj;
    private int atk;
    private String filename;
    private int id;
    private String url;

    static {
        xMrLm();
    }

    public c() {
        this.atg = new AtomicLong();
        this.atf = new AtomicInteger();
    }

    private String AF() {
        return this.ati;
    }

    private static /* synthetic */ void xMrLm() {
        char[] charArray = "\u0002\u000e\fO\u0006\u0000\f\u0004O\u0003\u000e\u0018O\u0012\t\u0004\r\rO+\u000f\b#\u0013\b\u0005\u0006\u0004".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'a');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0002\r\b\u000f\b\u0015".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'a');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final ContentValues AB() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_ID, Integer.valueOf(getId()));
        contentValues.put("url", getUrl());
        contentValues.put("path", getPath());
        contentValues.put("status", Byte.valueOf(yn()));
        contentValues.put("sofar", Long.valueOf(AD()));
        contentValues.put("total", Long.valueOf(getTotal()));
        contentValues.put("errMsg", AF());
        contentValues.put(f.c, AE());
        contentValues.put("connectionCount", Integer.valueOf(AG()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(yj()));
        if (yj() && getFilename() != null) {
            contentValues.put(f.e, getFilename());
        }
        return contentValues;
    }

    public final long AD() {
        return this.atg.get();
    }

    public final String AE() {
        return this.atj;
    }

    public final int AG() {
        return this.atk;
    }

    public final void AH() {
        this.atk = 1;
    }

    public final void Z(long j) {
        this.atg.set(j);
    }

    public final void aa(long j) {
        this.atg.addAndGet(j);
    }

    public final void ab(long j) {
        this.asR = j > 2147483647L;
        this.ath = j;
    }

    public final void bJ(String str) {
        this.atj = str;
    }

    public final void bK(String str) {
        this.ati = str;
    }

    public final void bL(String str) {
        this.filename = str;
    }

    public final void co(int i) {
        this.atk = i;
    }

    public final void d(String str, boolean z) {
        this.afW = str;
        this.ate = z;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPath() {
        return this.afW;
    }

    public final String getTargetFilePath() {
        return com.kwad.framework.filedownloader.f.f.a(getPath(), yj(), getFilename());
    }

    public final long getTotal() {
        return this.ath;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isChunked() {
        return this.ath == -1;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.c("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.id), this.url, this.afW, Integer.valueOf(this.atf.get()), this.atg, Long.valueOf(this.ath), this.atj, super.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.url);
        parcel.writeString(this.afW);
        parcel.writeByte(this.ate ? (byte) 1 : (byte) 0);
        parcel.writeString(this.filename);
        parcel.writeByte((byte) this.atf.get());
        parcel.writeLong(this.atg.get());
        parcel.writeLong(this.ath);
        parcel.writeString(this.ati);
        parcel.writeString(this.atj);
        parcel.writeInt(this.atk);
        parcel.writeByte(this.asR ? (byte) 1 : (byte) 0);
    }

    public final boolean yj() {
        return this.ate;
    }

    public final byte yn() {
        return (byte) this.atf.get();
    }

    public final boolean yt() {
        return this.asR;
    }

    public final String zV() {
        if (getTargetFilePath() == null) {
            return null;
        }
        return com.kwad.framework.filedownloader.f.f.bP(getTargetFilePath());
    }

    public final void d(byte b) {
        this.atf.set(b);
    }

    public c(Parcel parcel) {
        this.id = parcel.readInt();
        this.url = parcel.readString();
        this.afW = parcel.readString();
        this.ate = parcel.readByte() != 0;
        this.filename = parcel.readString();
        this.atf = new AtomicInteger(parcel.readByte());
        this.atg = new AtomicLong(parcel.readLong());
        this.ath = parcel.readLong();
        this.ati = parcel.readString();
        this.atj = parcel.readString();
        this.atk = parcel.readInt();
        this.asR = parcel.readByte() != 0;
    }
}
