package com.kwad.sdk.api.loader;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kwad.sdk.api.loader.a;
import com.kwad.sdk.api.loader.h;
import java.io.File;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class s {

    public static abstract class a<T> implements c<T> {
        c<T> ayQ;

        public a(c<T> cVar) {
            this.ayQ = cVar;
        }
    }

    public static class b implements f<a.C0346a> {
        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<a.C0346a> cVar) {
            try {
                new com.kwad.sdk.api.loader.h(abVar).a(new h.a() { // from class: com.kwad.sdk.api.loader.s.b.1
                    @Override // com.kwad.sdk.api.loader.h.a
                    public final void a(a.b bVar) {
                        Objects.toString(bVar);
                        if (bVar.isLegal()) {
                            cVar.k(bVar.axR);
                        } else {
                            new RuntimeException("UpdateData is illegal");
                        }
                        try {
                            com.kwad.sdk.api.loader.f.bf(abVar.getContext()).cancel();
                        } catch (Throwable unused) {
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    public interface c<T> {
        void k(T t);
    }

    public static class d implements f<a.C0346a> {
        f<a.C0346a> ayU;

        public d(f<a.C0346a> fVar) {
            this.ayU = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<a.C0346a> cVar) {
            this.ayU.a(abVar, new a<a.C0346a>(cVar) { // from class: com.kwad.sdk.api.loader.s.d.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void k(a.C0346a c0346a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = null;
                    try {
                        l.a(c0346a);
                        file = j.u(abVar.getContext(), c0346a.sdkVersion);
                        k.c(c0346a.axP, file);
                        l.a(c0346a, System.currentTimeMillis() - currentTimeMillis);
                        c0346a.axQ = file;
                        cVar.k(c0346a);
                    } catch (Throwable th) {
                        l.a(c0346a, System.currentTimeMillis() - currentTimeMillis, Log.getStackTraceString(th));
                        j.j(file);
                    }
                }
            });
        }
    }

    public static class e implements f<Boolean> {
        f<a.C0346a> ayU;

        public e(f<a.C0346a> fVar) {
            this.ayU = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<Boolean> cVar) {
            this.ayU.a(abVar, new c<a.C0346a>() { // from class: com.kwad.sdk.api.loader.s.e.1
                private void a(a.C0346a c0346a, int i, Throwable th) {
                    j.j(c0346a.axQ);
                    l.b(c0346a, i, Log.getStackTraceString(th));
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void k(a.C0346a c0346a) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        l.b(c0346a);
                        if (!com.kwad.sdk.api.loader.d.a(abVar.getContext(), AnonymousClass1.class.getClassLoader(), c0346a.axQ.getPath(), c0346a.sdkVersion)) {
                            a(c0346a, 1, new RuntimeException("Apk pre install fail"));
                            return;
                        }
                        i.s(abVar.getContext(), c0346a.sdkVersion);
                        j.j(c0346a.axQ);
                        l.b(c0346a, System.currentTimeMillis() - currentTimeMillis);
                        cVar.k(Boolean.TRUE);
                    } catch (Throwable th) {
                        a(c0346a, 2, th);
                    }
                }
            });
        }
    }

    public interface f<T> {
        void a(ab abVar, c<T> cVar);
    }

    public static class g implements f<a.C0346a> {
        f<a.C0346a> ayU;

        public g(f<a.C0346a> fVar) {
            this.ayU = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(ab abVar, final c<a.C0346a> cVar) {
            this.ayU.a(abVar, new a<a.C0346a>(cVar) { // from class: com.kwad.sdk.api.loader.s.g.1
                private void a(a.C0346a c0346a, int i, Throwable th) {
                    j.j(c0346a.axQ);
                    l.a(c0346a, i, th.getMessage());
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void k(a.C0346a c0346a) {
                    try {
                        File file = c0346a.axQ;
                        if (!x.k(file)) {
                            a(c0346a, 1, new RuntimeException("Security checkFileValid fail"));
                        } else if (x.a(file, c0346a.md5)) {
                            cVar.k(c0346a);
                        } else {
                            a(c0346a, 2, new RuntimeException("Security checkMd5 fail"));
                        }
                    } catch (Throwable th) {
                        a(c0346a, 3, th);
                    }
                }
            });
        }
    }

    public static class h implements f<a.C0346a> {
        f<a.C0346a> ayU;

        public h(f<a.C0346a> fVar) {
            this.ayU = fVar;
        }

        @Override // com.kwad.sdk.api.loader.s.f
        public final void a(final ab abVar, final c<a.C0346a> cVar) {
            this.ayU.a(abVar, new c<a.C0346a>() { // from class: com.kwad.sdk.api.loader.s.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.api.loader.s.c
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void k(a.C0346a c0346a) {
                    String bg = i.bg(abVar.getContext());
                    if (TextUtils.isEmpty(bg)) {
                        bg = com.kwad.sdk.api.c.EP().getSDKVersion();
                    }
                    String str = c0346a.sdkVersion;
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), "interval", c0346a.interval);
                    com.kwad.sdk.api.loader.b.a(abVar.getContext(), "lastUpdateTime", System.currentTimeMillis());
                    if (c0346a.EV()) {
                        aa.bn(abVar.getContext());
                        new RuntimeException(CtFAbx.BChYOn("DynamicType == -1, curVersion: ", bg));
                    } else {
                        if (i.L(c0346a.sdkVersion, bg) && c0346a.EU()) {
                            cVar.k(c0346a);
                            return;
                        }
                        StringBuilder sb = new StringBuilder("No new sdkVersion. remote sdkVersion:");
                        A2egSU.BIYEnU(sb, c0346a.sdkVersion, " currentDynamicVersion:", bg, " dynamicType:");
                        sb.append(c0346a.axO);
                        new RuntimeException(sb.toString());
                    }
                }
            });
        }
    }

    public static f<Boolean> Fe() {
        return new e(new g(new d(new h(new b()))));
    }
}
