package com.sigmob.sdk.downloader.core.interceptor.connect;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.download.f;
import com.sigmob.sdk.downloader.core.interceptor.c;
import com.sigmob.sdk.downloader.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b implements c.a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13409a = "HeaderInterceptor";

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.a
    public a.InterfaceC0451a a(f fVar) {
        com.sigmob.sdk.downloader.core.breakpoint.c d = fVar.d();
        com.sigmob.sdk.downloader.core.connection.a i = fVar.i();
        com.sigmob.sdk.downloader.f c = fVar.c();
        Map<String, List<String>> b = c.b();
        if (b != null) {
            com.sigmob.sdk.downloader.core.c.a(b, i);
        }
        if (b == null || !b.containsKey("User-Agent")) {
            com.sigmob.sdk.downloader.core.c.a(i);
        }
        int e = fVar.e();
        com.sigmob.sdk.downloader.core.breakpoint.a b2 = d.b(e);
        if (b2 == null) {
            throw new IOException(CtFAbx.ARc23Z(e, "No block-info found on "));
        }
        String str = "bytes=" + b2.c() + "-";
        if (!d.b()) {
            StringBuilder A4TApA2 = AYUAbz.A4TApA(str);
            A4TApA2.append(b2.e());
            str = A4TApA2.toString();
        }
        i.a(com.sigmob.sdk.downloader.core.c.b, str);
        com.sigmob.sdk.downloader.core.c.b(f13409a, "AssembleHeaderRange (" + c.c() + ") block(" + e + ") downloadFrom(" + b2.c() + ") currentOffset(" + b2.a() + ")");
        String k = d.k();
        if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) k)) {
            i.a(com.sigmob.sdk.downloader.core.c.c, k);
        }
        if (fVar.f().k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.f13396a;
        }
        g.j().b().a().b(c, e, i.c());
        a.InterfaceC0451a n = fVar.n();
        if (fVar.f().k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.f13396a;
        }
        Map<String, List<String>> f = n.f();
        if (f == null) {
            f = new HashMap<>();
        }
        g.j().b().a().a(c, e, n.d(), f);
        g.j().g().a(n, e, d).a();
        String c2 = n.c(com.sigmob.sdk.downloader.core.c.e);
        fVar.a((c2 == null || c2.length() == 0) ? com.sigmob.sdk.downloader.core.c.d(n.c(com.sigmob.sdk.downloader.core.c.f)) : com.sigmob.sdk.downloader.core.c.b(c2));
        return n;
    }
}
