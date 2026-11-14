package com.ss.android.socialbase.downloader.hf;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.tf.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {
    private SQLiteStatement c;
    private SQLiteStatement f;
    private final String hf;
    private SQLiteStatement kd;
    private final String[] u;
    private final String[] w;
    private final SQLiteDatabase xj;
    private SQLiteStatement y;

    public c(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.xj = sQLiteDatabase;
        this.hf = str;
        this.w = strArr;
        this.u = strArr2;
    }

    public SQLiteStatement hf() {
        if (this.c == null) {
            SQLiteStatement compileStatement = this.xj.compileStatement(d.xj(this.hf, this.u));
            synchronized (this) {
                try {
                    if (this.c == null) {
                        this.c = compileStatement;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.c != compileStatement) {
                compileStatement.close();
            }
        }
        return this.c;
    }

    public SQLiteStatement u() {
        if (this.f == null) {
            SQLiteStatement compileStatement = this.xj.compileStatement(d.hf(this.hf, this.w, this.u));
            synchronized (this) {
                try {
                    if (this.f == null) {
                        this.f = compileStatement;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f;
    }

    public SQLiteStatement w() {
        if (this.y == null) {
            SQLiteStatement compileStatement = this.xj.compileStatement(d.xj(this.hf, this.w, this.u));
            synchronized (this) {
                try {
                    if (this.y == null) {
                        this.y = compileStatement;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.y != compileStatement) {
                compileStatement.close();
            }
        }
        return this.y;
    }

    public SQLiteStatement xj() {
        if (this.kd == null) {
            SQLiteStatement compileStatement = this.xj.compileStatement(d.xj("INSERT INTO ", this.hf, this.w));
            synchronized (this) {
                try {
                    if (this.kd == null) {
                        this.kd = compileStatement;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.kd != compileStatement) {
                compileStatement.close();
            }
        }
        return this.kd;
    }
}
