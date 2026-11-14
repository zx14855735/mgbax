package com.sigmob.sdk.downloader.core.file;

import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final c f13406a = new c();

    public c a() {
        return this.f13406a;
    }

    public boolean b(f fVar) {
        if (!g.j().e().a()) {
            return false;
        }
        if (fVar.v() != null) {
            return fVar.v().booleanValue();
        }
        return true;
    }

    public d a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, j jVar) {
        return new d(fVar, cVar, jVar);
    }

    public void a(d dVar, f fVar) {
    }

    public void a(f fVar) {
        File m = fVar.m();
        if (m != null && m.exists() && !m.delete()) {
            throw new IOException("Delete file failed!");
        }
    }
}
