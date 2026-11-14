package com.ss.android.socialbase.downloader.model;

import ADYaiT.CtFAbx;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import com.fl.saas.base.cache.DatabaseHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf implements Parcelable {
    public static final Parcelable.Creator<hf> CREATOR = new Parcelable.Creator<hf>() { // from class: com.ss.android.socialbase.downloader.model.hf.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public hf createFromParcel(Parcel parcel) {
            return new hf(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public hf[] newArray(int i) {
            return new hf[i];
        }
    };
    private static final String xj = "hf";
    private AtomicBoolean am;
    private int c;
    private long d;
    private AtomicInteger f;
    private boolean g;
    private int hf;
    private long kd;
    private hf p;

    /* renamed from: pl, reason: collision with root package name */
    private int f13856pl;
    private com.ss.android.socialbase.downloader.d.hf qt;
    private List<hf> tf;
    private AtomicLong u;
    private long w;
    private long y;

    public static class xj {
        private long c;
        private hf f;
        private long hf;
        private long kd;
        private long u;
        private long w;
        private int xj;
        private int y;

        public xj(int i) {
            this.xj = i;
        }

        public xj hf(long j) {
            this.w = j;
            return this;
        }

        public xj kd(long j) {
            this.c = j;
            return this;
        }

        public xj u(long j) {
            this.kd = j;
            return this;
        }

        public xj w(long j) {
            this.u = j;
            return this;
        }

        public xj xj(long j) {
            this.hf = j;
            return this;
        }

        public xj xj(int i) {
            this.y = i;
            return this;
        }

        public xj xj(hf hfVar) {
            this.f = hfVar;
            return this;
        }

        public hf xj() {
            return new hf(this);
        }
    }

    static {
        sEZOlpK();
    }

    private static /* synthetic */ void sEZOlpK() {
        char[] charArray = "\u0000\f\u000eM\u0004\u0002\u000e\u0006M\u0001\f\u001aM\u0010\u000b\u0006\u000f\u000fM)\r\n!\u0011\n\u0007\u0004\u0006".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'c');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0000\u000f\n\r\n\u0017".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'c');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public long am() {
        if (!u() || !y()) {
            return g();
        }
        long j = 0;
        for (int i = 0; i < this.tf.size(); i++) {
            hf hfVar = this.tf.get(i);
            if (hfVar != null) {
                if (!hfVar.d()) {
                    return hfVar.g();
                }
                if (j < hfVar.g()) {
                    j = hfVar.g();
                }
            }
        }
        return j;
    }

    public List<hf> c() {
        return this.tf;
    }

    public boolean d() {
        long j = this.w;
        if (u()) {
            long j2 = this.d;
            if (j2 > this.w) {
                j = j2;
            }
        }
        return am() - j >= this.y;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.y;
    }

    public boolean f() {
        hf hfVar = this.p;
        if (hfVar == null) {
            return true;
        }
        if (!hfVar.y()) {
            return false;
        }
        for (int i = 0; i < this.p.c().size(); i++) {
            hf hfVar2 = this.p.c().get(i);
            if (hfVar2 != null) {
                int indexOf = this.p.c().indexOf(this);
                if (indexOf > i && !hfVar2.d()) {
                    return false;
                }
                if (indexOf == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public long g() {
        AtomicLong atomicLong = this.u;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public int hf() {
        AtomicInteger atomicInteger = this.f;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public hf kd() {
        hf hfVar = !u() ? this.p : this;
        if (hfVar == null || !hfVar.y()) {
            return null;
        }
        return hfVar.c().get(0);
    }

    public int p() {
        return this.hf;
    }

    public long pl() {
        return this.w;
    }

    public long qt() {
        long am = am() - this.w;
        if (y()) {
            am = 0;
            for (int i = 0; i < this.tf.size(); i++) {
                hf hfVar = this.tf.get(i);
                if (hfVar != null) {
                    am = (hfVar.am() - hfVar.pl()) + am;
                }
            }
        }
        return am;
    }

    public long tf() {
        hf hfVar = this.p;
        if (hfVar != null && hfVar.c() != null) {
            int indexOf = this.p.c().indexOf(this);
            boolean z = false;
            for (int i = 0; i < this.p.c().size(); i++) {
                hf hfVar2 = this.p.c().get(i);
                if (hfVar2 != null) {
                    if (z) {
                        return hfVar2.am();
                    }
                    if (indexOf == i) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    public boolean u() {
        return hf() == -1;
    }

    public int v() {
        return this.c;
    }

    public boolean w() {
        AtomicBoolean atomicBoolean = this.am;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.hf);
        parcel.writeLong(this.w);
        AtomicLong atomicLong = this.u;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.kd);
        parcel.writeLong(this.y);
        parcel.writeInt(this.c);
        AtomicInteger atomicInteger = this.f;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public ContentValues xj() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_ID, Integer.valueOf(this.hf));
        contentValues.put("chunkIndex", Integer.valueOf(this.c));
        contentValues.put("startOffset", Long.valueOf(this.w));
        contentValues.put("curOffset", Long.valueOf(am()));
        contentValues.put("endOffset", Long.valueOf(this.kd));
        contentValues.put("chunkContentLen", Long.valueOf(this.y));
        contentValues.put("hostChunkIndex", Integer.valueOf(hf()));
        return contentValues;
    }

    public boolean y() {
        List<hf> list = this.tf;
        return list != null && list.size() > 0;
    }

    public void yo() {
        this.d = am();
    }

    public long zg() {
        return this.kd;
    }

    private hf(xj xjVar) {
        if (xjVar == null) {
            return;
        }
        this.hf = xjVar.xj;
        this.w = xjVar.hf;
        this.u = new AtomicLong(xjVar.w);
        this.kd = xjVar.u;
        this.y = xjVar.kd;
        this.c = xjVar.y;
        this.d = xjVar.c;
        this.f = new AtomicInteger(-1);
        xj(xjVar.f);
        this.am = new AtomicBoolean(false);
    }

    public void hf(boolean z) {
        this.g = z;
    }

    public void w(int i) {
        this.c = i;
    }

    public void hf(int i) {
        this.hf = i;
    }

    public long w(boolean z) {
        long am = am();
        long j = this.y;
        long j2 = this.d;
        long j3 = j - (am - j2);
        if (!z && am == j2) {
            j3 = j - (am - this.w);
        }
        com.ss.android.socialbase.downloader.w.xj.hf("DownloadChunk", "contentLength:" + this.y + " curOffset:" + am() + " oldOffset:" + this.d + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public void hf(long j) {
        AtomicLong atomicLong = this.u;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.u = new AtomicLong(j);
        }
    }

    public void xj(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.f13856pl = 0;
        sQLiteStatement.clearBindings();
        int i = this.f13856pl + 1;
        this.f13856pl = i;
        sQLiteStatement.bindLong(i, this.hf);
        int i2 = this.f13856pl + 1;
        this.f13856pl = i2;
        sQLiteStatement.bindLong(i2, this.c);
        int i3 = this.f13856pl + 1;
        this.f13856pl = i3;
        sQLiteStatement.bindLong(i3, this.w);
        int i4 = this.f13856pl + 1;
        this.f13856pl = i4;
        sQLiteStatement.bindLong(i4, am());
        int i5 = this.f13856pl + 1;
        this.f13856pl = i5;
        sQLiteStatement.bindLong(i5, this.kd);
        int i6 = this.f13856pl + 1;
        this.f13856pl = i6;
        sQLiteStatement.bindLong(i6, this.y);
        int i7 = this.f13856pl + 1;
        this.f13856pl = i7;
        sQLiteStatement.bindLong(i7, hf());
    }

    public hf(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.hf = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
        this.c = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.w = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.u = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.u = new AtomicLong(0L);
        }
        this.kd = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.f = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.f = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.y = cursor.getLong(columnIndex3);
        }
        this.am = new AtomicBoolean(false);
    }

    public void xj(int i) {
        AtomicInteger atomicInteger = this.f;
        if (atomicInteger == null) {
            this.f = new AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    public void xj(com.ss.android.socialbase.downloader.d.hf hfVar) {
        this.qt = hfVar;
        yo();
    }

    public void xj(boolean z) {
        AtomicBoolean atomicBoolean = this.am;
        if (atomicBoolean == null) {
            this.am = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.qt = null;
    }

    public hf(Parcel parcel) {
        this.hf = parcel.readInt();
        this.w = parcel.readLong();
        this.u = new AtomicLong(parcel.readLong());
        this.kd = parcel.readLong();
        this.y = parcel.readLong();
        this.c = parcel.readInt();
        this.f = new AtomicInteger(parcel.readInt());
    }

    public void xj(hf hfVar) {
        this.p = hfVar;
        if (hfVar != null) {
            xj(hfVar.v());
        }
    }

    public void xj(List<hf> list) {
        this.tf = list;
    }

    public void xj(long j) {
        this.y = j;
    }

    public List<hf> xj(int i, long j) {
        long zg;
        long j2;
        long j3;
        long j4;
        long j5;
        int i2 = i;
        if (!u() || y()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long g = g();
        long w = w(true);
        long j6 = w / i2;
        String str = xj;
        StringBuilder B2KMhB2 = CtFAbx.B2KMhB("retainLen:", w, " divideChunkForReuse chunkSize:");
        B2KMhB2.append(j6);
        B2KMhB2.append(" current host downloadChunk index:");
        B2KMhB2.append(this.c);
        com.ss.android.socialbase.downloader.w.xj.hf(str, B2KMhB2.toString());
        int i3 = 0;
        while (i3 < i2) {
            if (i3 == 0) {
                j2 = pl();
            } else {
                int i4 = i2 - 1;
                if (i3 == i4) {
                    long zg2 = zg();
                    j3 = w;
                    j4 = zg2 > g ? (zg2 - g) + 1 : w - (i4 * j6);
                    j5 = zg2;
                    j2 = g;
                    hf xj2 = new xj(this.hf).xj((-i3) - 1).xj(j2).hf(g).kd(g).w(j5).u(j4).xj(this).xj();
                    long j7 = j6;
                    com.ss.android.socialbase.downloader.w.xj.hf(xj, "divide sub chunk : " + i3 + " startOffset:" + j2 + " curOffset:" + g + " endOffset:" + j5 + " contentLen:" + j4);
                    arrayList.add(xj2);
                    g += j7;
                    i3++;
                    i2 = i;
                    w = j3;
                    j6 = j7;
                } else {
                    j2 = g;
                }
            }
            j5 = (g + j6) - 1;
            j3 = w;
            j4 = j6;
            hf xj22 = new xj(this.hf).xj((-i3) - 1).xj(j2).hf(g).kd(g).w(j5).u(j4).xj(this).xj();
            long j72 = j6;
            com.ss.android.socialbase.downloader.w.xj.hf(xj, "divide sub chunk : " + i3 + " startOffset:" + j2 + " curOffset:" + g + " endOffset:" + j5 + " contentLen:" + j4);
            arrayList.add(xj22);
            g += j72;
            i3++;
            i2 = i;
            w = j3;
            j6 = j72;
        }
        long j8 = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            hf hfVar = (hf) arrayList.get(size);
            if (hfVar != null) {
                j8 += hfVar.e();
            }
        }
        com.ss.android.socialbase.downloader.w.xj.hf(xj, "reuseChunkContentLen:".concat(String.valueOf(j8)));
        hf hfVar2 = (hf) arrayList.get(0);
        if (hfVar2 != null) {
            if (zg() == 0) {
                zg = j - pl();
            } else {
                zg = (zg() - pl()) + 1;
            }
            hfVar2.xj(zg - j8);
            hfVar2.w(this.c);
            com.ss.android.socialbase.downloader.d.hf hfVar3 = this.qt;
            if (hfVar3 != null) {
                hfVar3.xj(hfVar2.zg(), e() - j8);
            }
        }
        xj(arrayList);
        return arrayList;
    }
}
