package com.octopus.ad.internal.view;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c implements d {

    /* renamed from: a, reason: collision with root package name */
    private final long f12598a;
    private final b b;
    private final boolean c;

    public c(b bVar, Long l, boolean z) {
        this.f12598a = l.longValue();
        this.b = bVar;
        this.c = z;
    }

    @Override // com.octopus.ad.internal.view.d
    public long a() {
        return this.f12598a;
    }

    @Override // com.octopus.ad.internal.view.d
    public boolean b() {
        return this.c;
    }

    @Override // com.octopus.ad.internal.view.d
    public a c() {
        b bVar = this.b;
        if (bVar == null) {
            return null;
        }
        return bVar.getAdWebView();
    }
}
