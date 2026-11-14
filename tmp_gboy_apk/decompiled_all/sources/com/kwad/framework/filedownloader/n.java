package com.kwad.framework.filedownloader;

import android.content.Context;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class n implements u {
    private final u aqr;

    public static final class a {
        private static final n aqs = new n(0);

        static {
            HqGsSmS();
        }

        private static /* synthetic */ void HqGsSmS() {
            char[] charArray = "\u008a\u0086\u0084Ç\u008e\u0088\u0084\u008cÇ\u008b\u0086\u0090Ç\u009a\u0081\u008c\u0085\u0085Ç£\u0087\u0080«\u009b\u0080\u008d\u008e\u008c".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 233);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u008a\u0085\u0080\u0087\u0080\u009d".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 233);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ n(byte b) {
        this();
    }

    public static n ze() {
        return a.aqs;
    }

    public static e.a zf() {
        if (ze().aqr instanceof o) {
            return (e.a) ze().aqr;
        }
        return null;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        return this.aqr.a(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void aO(Context context) {
        this.aqr.aO(context);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bO(int i) {
        return this.aqr.bO(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte bP(int i) {
        return this.aqr.bP(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bQ(int i) {
        return this.aqr.bQ(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return this.aqr.isConnected();
    }

    private n() {
        this.aqr = com.kwad.framework.filedownloader.f.e.Bf().atP ? new o() : new p(FileDownloadService.SeparateProcessService.class);
    }
}
