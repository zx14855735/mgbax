package com.sigmob.sdk.base.common;

import android.os.Parcel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private int f13128a;
    private int b;

    public g(int i, int i2) {
        this.f13128a = i;
        this.b = i2;
    }

    public int a() {
        return this.f13128a;
    }

    public int b() {
        return this.b;
    }

    public g(Parcel parcel) {
        this.f13128a = parcel.readInt();
        this.b = parcel.readInt();
    }

    public void a(int i) {
        this.f13128a = i;
    }

    public void b(int i) {
        this.b = i;
    }
}
