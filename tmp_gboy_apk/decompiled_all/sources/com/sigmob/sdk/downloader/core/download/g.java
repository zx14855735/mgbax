package com.sigmob.sdk.downloader.core.download;

import android.net.ConnectivityManager;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.exception.i;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g {
    private static final String b = "DownloadStrategy";
    private static final long c = 1048576;
    private static final long d = 5242880;
    private static final long e = 52428800;
    private static final long f = 104857600;
    private static final Pattern g = Pattern.compile(".*\\\\|/([^\\\\|/|?]*)\\??");

    /* renamed from: a, reason: collision with root package name */
    Boolean f13392a = null;
    private ConnectivityManager h = null;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private volatile String f13393a;
        private final boolean b = false;

        public a() {
        }

        public String a() {
            return this.f13393a;
        }

        public boolean b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                return this.f13393a == null ? ((a) obj).f13393a == null : this.f13393a.equals(((a) obj).f13393a);
            }
            return false;
        }

        public int hashCode() {
            if (this.f13393a == null) {
                return 0;
            }
            return this.f13393a.hashCode();
        }

        public a(String str) {
            this.f13393a = str;
        }

        public void a(String str) {
            this.f13393a = str;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private a.InterfaceC0451a f13394a;
        private com.sigmob.sdk.downloader.core.breakpoint.c b;
        private int c;

        public b(a.InterfaceC0451a interfaceC0451a, int i, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            this.f13394a = interfaceC0451a;
            this.b = cVar;
            this.c = i;
        }

        public void a() {
            com.sigmob.sdk.downloader.core.breakpoint.a b = this.b.b(this.c);
            int d = this.f13394a.d();
            com.sigmob.sdk.downloader.core.cause.b a2 = com.sigmob.sdk.downloader.g.j().g().a(d, b.a() != 0, this.b, this.f13394a.c(com.sigmob.sdk.downloader.core.c.g));
            if (a2 != null) {
                throw new com.sigmob.sdk.downloader.core.exception.f(a2);
            }
            if (com.sigmob.sdk.downloader.g.j().g().a(d, b.a() != 0)) {
                throw new i(d, b.a());
            }
        }
    }

    static {
        YJJU();
    }

    private static /* synthetic */ void YJJU() {
        char[] charArray = "W[Y\u001aSUYQ\u001aV[M\u001aG\\QXX\u001a~Z]vF]PSQ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '4');
        }
        String str = new String(charArray);
        char[] charArray2 = "WX]Z]@".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '4');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public int a(com.sigmob.sdk.downloader.f fVar, long j) {
        if (fVar.u() != null) {
            return fVar.u().intValue();
        }
        if (j < 1048576) {
            return 1;
        }
        if (j < d) {
            return 2;
        }
        if (j < e) {
            return 3;
        }
        return j < f ? 4 : 5;
    }

    public String b(String str, com.sigmob.sdk.downloader.f fVar) {
        if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) str)) {
            return str;
        }
        String i = fVar.i();
        Matcher matcher = g.matcher(i);
        String str2 = null;
        while (matcher.find()) {
            str2 = matcher.group(1);
        }
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) str2)) {
            str2 = com.sigmob.sdk.downloader.core.c.a(i);
        }
        if (str2 != null) {
            return str2;
        }
        throw new IOException("Can't find valid filename.");
    }

    public long a() {
        return 10240L;
    }

    public void b() {
        if (this.f13392a == null) {
            this.f13392a = Boolean.valueOf(com.sigmob.sdk.downloader.core.c.c(com.kuaishou.weapon.p0.g.b));
        }
        if (this.f13392a.booleanValue()) {
            if (this.h == null) {
                this.h = (ConnectivityManager) com.sigmob.sdk.downloader.g.j().h().getSystemService("connectivity");
            }
            if (!com.sigmob.sdk.downloader.core.c.b(this.h)) {
                throw new UnknownHostException("network is not available!");
            }
        }
    }

    public com.sigmob.sdk.downloader.core.cause.b a(int i, boolean z, com.sigmob.sdk.downloader.core.breakpoint.c cVar, String str) {
        String k = cVar.k();
        if (i == 412) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_PRECONDITION_FAILED;
        }
        if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) k) && !com.sigmob.sdk.downloader.core.c.a((CharSequence) str) && !str.equals(k)) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_ETAG_CHANGED;
        }
        if (i == 201 && z) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_CREATED_RANGE_NOT_FROM_0;
        }
        if (i == 205 && z) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_RESET_RANGE_NOT_FROM_0;
        }
        return null;
    }

    public void b(com.sigmob.sdk.downloader.f fVar) {
        if (this.f13392a == null) {
            this.f13392a = Boolean.valueOf(com.sigmob.sdk.downloader.core.c.c(com.kuaishou.weapon.p0.g.b));
        }
        if (fVar.f()) {
            if (!this.f13392a.booleanValue()) {
                throw new IOException("required for access network state but don't have the permission of Manifest.permission.ACCESS_NETWORK_STATE, please declare this permission first on your AndroidManifest, so we can handle the case of downloading required wifi state.");
            }
            if (this.h == null) {
                this.h = (ConnectivityManager) com.sigmob.sdk.downloader.g.j().h().getSystemService("connectivity");
            }
            if (com.sigmob.sdk.downloader.core.c.a(this.h)) {
                throw new com.sigmob.sdk.downloader.core.exception.d();
            }
        }
    }

    public b a(a.InterfaceC0451a interfaceC0451a, int i, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        return new b(interfaceC0451a, i, cVar);
    }

    public void a(com.sigmob.sdk.downloader.f fVar, j jVar) {
        long length;
        com.sigmob.sdk.downloader.core.breakpoint.c e2 = jVar.e(fVar.c());
        if (e2 == null) {
            e2 = new com.sigmob.sdk.downloader.core.breakpoint.c(fVar.c(), fVar.i(), fVar.l(), fVar.d());
            if (com.sigmob.sdk.downloader.core.c.a(fVar.h())) {
                length = com.sigmob.sdk.downloader.core.c.c(fVar.h());
            } else {
                File m = fVar.m();
                if (m == null) {
                    com.sigmob.sdk.downloader.core.c.a(b, "file is not ready on valid info for task on complete state " + fVar);
                    length = 0;
                } else {
                    length = m.length();
                }
            }
            long j = length;
            e2.a(new com.sigmob.sdk.downloader.core.breakpoint.a(0L, j, j));
        }
        f.c.a(fVar, e2);
    }

    public void a(String str, com.sigmob.sdk.downloader.f fVar) {
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) fVar.d())) {
            fVar.g().a(str);
        }
    }

    public void a(String str, com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) fVar.d())) {
            String b2 = b(str, fVar);
            if (com.sigmob.sdk.downloader.core.c.a((CharSequence) fVar.d())) {
                synchronized (fVar) {
                    try {
                        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) fVar.d())) {
                            fVar.g().a(b2);
                            cVar.n().a(b2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    public boolean a(int i, boolean z) {
        if (i == 206 || i == 200) {
            return i == 200 && z;
        }
        return true;
    }

    public boolean a(com.sigmob.sdk.downloader.f fVar) {
        String a2 = com.sigmob.sdk.downloader.g.j().c().a(fVar.i());
        if (a2 == null) {
            return false;
        }
        fVar.g().a(a2);
        return true;
    }

    public boolean a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, long j) {
        com.sigmob.sdk.downloader.core.breakpoint.g c2;
        com.sigmob.sdk.downloader.core.breakpoint.c a2;
        if (!fVar.a() || (a2 = (c2 = com.sigmob.sdk.downloader.g.j().c()).a(fVar, cVar)) == null) {
            return false;
        }
        c2.b(a2.a());
        if (a2.i() <= com.sigmob.sdk.downloader.g.j().g().a()) {
            return false;
        }
        if ((a2.k() != null && !a2.k().equals(cVar.k())) || a2.j() != j || a2.o() == null || !a2.o().exists()) {
            return false;
        }
        cVar.a(a2);
        com.sigmob.sdk.downloader.core.c.b(b, "Reuse another same info: " + cVar);
        return true;
    }

    public boolean a(boolean z) {
        if (com.sigmob.sdk.downloader.g.j().e().a()) {
            return z;
        }
        return false;
    }
}
