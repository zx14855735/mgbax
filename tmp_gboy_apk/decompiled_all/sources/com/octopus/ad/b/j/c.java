package com.octopus.ad.b.j;

import android.database.ContentObserver;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private String f12382a;
    private int b;
    private b c;

    public c(b bVar, int i, String str) {
        super(null);
        this.c = bVar;
        this.b = i;
        this.f12382a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.b(this.b, this.f12382a);
        }
    }
}
