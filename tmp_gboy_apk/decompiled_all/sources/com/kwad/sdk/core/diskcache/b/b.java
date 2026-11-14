package com.kwad.sdk.core.diskcache.b;

import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    public static void a(final com.kwad.sdk.core.diskcache.a.a aVar, final String str, final String str2) {
        h.execute(new bg() { // from class: com.kwad.sdk.core.diskcache.b.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                OutputStream outputStream = null;
                try {
                    a.C0356a dR = com.kwad.sdk.core.diskcache.a.a.this.dR(str2);
                    if (dR != null) {
                        outputStream = dR.dK(0);
                        if (b.a(str, outputStream, new a.C0366a())) {
                            dR.commit();
                        } else {
                            dR.abort();
                        }
                        com.kwad.sdk.core.diskcache.a.a.this.flush();
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                } catch (IOException unused) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                } catch (Throwable th) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                    throw th;
                }
            }
        });
    }

    public static File a(com.kwad.sdk.core.diskcache.a.a aVar, String str) {
        a.c cVar;
        a.c cVar2 = null;
        try {
            cVar = aVar.dQ(str);
            if (cVar != null) {
                try {
                    File dN = cVar.dN(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
                    return dN;
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    cVar2 = cVar;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cVar2);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            cVar = null;
        } catch (Throwable th2) {
            th = th2;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cVar);
        return null;
    }

    public static boolean a(com.kwad.sdk.core.diskcache.a.a aVar, String str, String str2, a.C0366a c0366a) {
        boolean z = false;
        OutputStream outputStream = null;
        try {
            try {
                a.C0356a dR = aVar.dR(str2);
                if (dR != null) {
                    outputStream = dR.dK(0);
                    if (a(str, outputStream, c0366a)) {
                        dR.commit();
                        z = true;
                    } else {
                        dR.abort();
                    }
                    aVar.flush();
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                return z;
            } catch (IOException e) {
                c0366a.msg = e.getMessage();
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                return z;
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            throw th;
        }
    }

    public static boolean a(String str, OutputStream outputStream, a.C0366a c0366a) {
        return com.kwad.sdk.core.network.a.a.a(str, outputStream, c0366a, -1L, true, null);
    }
}
