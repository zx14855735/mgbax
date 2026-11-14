package com.sigmob.sdk.downloader.core.breakpoint;

import android.database.Cursor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f13346a;
    private final long b;
    private final long c;
    private final long d;

    public b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(f.h);
        this.f13346a = columnIndex >= 0 ? cursor.getInt(columnIndex) : 0;
        this.b = cursor.getColumnIndex(f.j) >= 0 ? cursor.getInt(r0) : 0L;
        this.c = cursor.getColumnIndex(f.k) >= 0 ? cursor.getInt(r0) : 0L;
        this.d = cursor.getColumnIndex(f.l) >= 0 ? cursor.getInt(r0) : 0L;
    }

    public int a() {
        return this.f13346a;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public a e() {
        return new a(this.b, this.c, this.d);
    }
}
