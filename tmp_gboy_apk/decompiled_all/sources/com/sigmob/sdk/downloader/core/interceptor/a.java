package com.sigmob.sdk.downloader.core.interceptor;

import ADYaiT.CtFAbx;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.download.f;
import com.sigmob.sdk.downloader.core.exception.g;
import com.sigmob.sdk.downloader.core.interceptor.c;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a implements c.a, c.b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13407a = "BreakpointInterceptor";
    private static final Pattern b = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");

    static {
        CdvfBfn();
    }

    private static /* synthetic */ void CdvfBfn() {
        char[] charArray = "\u0004\b\nI\u0000\u0006\n\u0002I\u0005\b\u001eI\u0014\u000f\u0002\u000b\u000bI-\t\u000e%\u0015\u000e\u0003\u0000\u0002".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'g');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0004\u000b\u000e\t\u000e\u0013".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'g');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long a(com.sigmob.sdk.downloader.core.connection.a.InterfaceC0451a r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Content-Range"
            java.lang.String r0 = r7.c(r0)
            boolean r1 = com.sigmob.sdk.downloader.core.c.a(r0)
            r2 = 0
            if (r1 != 0) goto L1a
            long r0 = a(r0)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L1a
            r4 = 1
            long r0 = r0 + r4
            goto L1c
        L1a:
            r0 = -1
        L1c:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L30
            java.lang.String r2 = "Content-Length"
            java.lang.String r7 = r7.c(r2)
            boolean r2 = com.sigmob.sdk.downloader.core.c.a(r7)
            if (r2 != 0) goto L30
            long r0 = java.lang.Long.parseLong(r7)
        L30:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.downloader.core.interceptor.a.a(com.sigmob.sdk.downloader.core.connection.a$a):long");
    }

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.b
    public long b(f fVar) {
        long a2 = fVar.a();
        int e = fVar.e();
        boolean z = a2 != -1;
        com.sigmob.sdk.downloader.core.file.d g = fVar.g();
        long j = 0;
        while (true) {
            try {
                long p = fVar.p();
                if (p == -1) {
                    break;
                }
                j += p;
            } finally {
                fVar.j();
                if (!fVar.f().d()) {
                    g.a(e);
                }
            }
        }
        if (z) {
            g.b(e);
            if (j != a2) {
                StringBuilder B2KMhB2 = CtFAbx.B2KMhB("Fetch-length isn't equal to the response content-length, ", j, "!= ");
                B2KMhB2.append(a2);
                throw new IOException(B2KMhB2.toString());
            }
        }
        return j;
    }

    public static long a(String str) {
        Matcher matcher = b.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    @Override // com.sigmob.sdk.downloader.core.interceptor.c.a
    public a.InterfaceC0451a a(f fVar) {
        a.InterfaceC0451a n = fVar.n();
        com.sigmob.sdk.downloader.core.breakpoint.c d = fVar.d();
        if (fVar.f().k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.f13396a;
        }
        if (d.g() == 1 && !d.b()) {
            long a2 = a(n);
            long j = d.j();
            if (a2 > 0 && a2 != j) {
                StringBuilder B2KMhB2 = CtFAbx.B2KMhB("SingleBlock special check: the response instance-length[", a2, "] isn't equal to the instance length from trial-connection[");
                B2KMhB2.append(j);
                B2KMhB2.append("]");
                com.sigmob.sdk.downloader.core.c.b(f13407a, B2KMhB2.toString());
                boolean z = d.b(0).c() != 0;
                com.sigmob.sdk.downloader.core.breakpoint.a aVar = new com.sigmob.sdk.downloader.core.breakpoint.a(0L, a2);
                d.f();
                d.a(aVar);
                if (z) {
                    com.sigmob.sdk.downloader.core.c.a(f13407a, "Discard breakpoint because of on this special case, we have to download from beginning");
                    throw new g("Discard breakpoint because of on this special case, we have to download from beginning");
                }
                com.sigmob.sdk.downloader.g.j().b().a().a(fVar.c(), d, com.sigmob.sdk.downloader.core.cause.b.CONTENT_LENGTH_CHANGED);
            }
        }
        try {
            if (fVar.r().a(d)) {
                return n;
            }
            throw new IOException("Update store failed!");
        } catch (Exception e) {
            throw new IOException("Update store failed!", e);
        }
    }
}
