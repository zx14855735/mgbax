package com.octopus.ad.internal.a;

import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    public final File f12388a;
    public final com.octopus.ad.internal.a.a.c b;
    public final com.octopus.ad.internal.a.a.a c;
    public final com.octopus.ad.internal.a.b.c d;
    public final f e;

    public c(File file, com.octopus.ad.internal.a.a.c cVar, com.octopus.ad.internal.a.a.a aVar, com.octopus.ad.internal.a.b.c cVar2, f fVar) {
        this.f12388a = file;
        this.b = cVar;
        this.c = aVar;
        this.d = cVar2;
        this.e = fVar;
    }

    public File a(String str) {
        return new File(this.f12388a, this.b.a(str));
    }
}
