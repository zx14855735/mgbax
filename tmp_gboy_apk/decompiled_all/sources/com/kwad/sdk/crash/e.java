package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e {
    private com.kwad.sdk.crash.b.b aTM;
    private c aTN;
    private long aTO;

    public static class a {
        private static final e aTP = new e(0);

        static {
            wStb();
        }

        private static /* synthetic */ void wStb() {
            char[] charArray = "ÒÞÜ\u009fÖÐÜÔ\u009fÓÞÈ\u009fÂÙÔÝÝ\u009fûßØóÃØÕÖÔ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 177);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÒÝØßØÅ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 177);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static e Nj() {
        return a.aTP;
    }

    public final String[] Nk() {
        return this.aTM.Nw();
    }

    public final String[] Nl() {
        return this.aTM.Nl();
    }

    public final String Nm() {
        return this.aTN.aTk.aUq;
    }

    public final int Nn() {
        return this.aTN.aTk.aUu;
    }

    public final c No() {
        return this.aTN;
    }

    public final h Np() {
        return this.aTN.aTm;
    }

    public final long Nq() {
        return SystemClock.elapsedRealtime() - this.aTO;
    }

    public final void a(c cVar) {
        this.aTN = cVar;
        this.aTO = SystemClock.elapsedRealtime();
        this.aTM.a(cVar.aTn, cVar.aTo);
    }

    public final void b(int i, ExceptionMessage exceptionMessage) {
        f Ng = this.aTN.Ng();
        if (Ng != null) {
            Ng.a(i, exceptionMessage);
        }
    }

    public final String getAppId() {
        return this.aTN.aTl.mAppId;
    }

    public final Context getContext() {
        return this.aTN.context;
    }

    public final String getSdkVersion() {
        return this.aTN.aTk.mSdkVersion;
    }

    public final boolean isDebug() {
        return this.aTN.isDebugMode();
    }

    private e() {
        this.aTM = new com.kwad.sdk.crash.b.b();
        this.aTN = new c.a().Ni();
    }
}
