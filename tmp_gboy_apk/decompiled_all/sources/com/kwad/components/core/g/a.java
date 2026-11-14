package com.kwad.components.core.g;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    public static int QF;
    public static AtomicInteger QG = new AtomicInteger(0);

    static {
        MXnsYO();
    }

    private static /* synthetic */ void MXnsYO() {
        char[] charArray = "\u001d\u0011\u0013P\u0019\u001f\u0013\u001bP\u001c\u0011\u0007P\r\u0016\u001b\u0012\u0012P4\u0010\u0017<\f\u0017\u001a\u0019\u001b".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '~');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001d\u0012\u0017\u0010\u0017\n".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '~');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void a(final BusinessType businessType) {
        GlobalThreadPools.Lq().execute(new Runnable() { // from class: com.kwad.components.core.g.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    String Ig = e.Ig();
                    if (Ig == null) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(Ig);
                    boolean optBoolean = jSONObject.optBoolean("isCheatUser", false);
                    boolean optBoolean2 = jSONObject.optBoolean("enableAdClientCheaterReport", false);
                    a.QF = jSONObject.optInt("maxCollectCount", 0);
                    if (optBoolean2 && a.QG.incrementAndGet() <= a.QF) {
                        c.d(d.FH().cR(ILoggerReporter.Category.APM_LOG).i(1.0d).b(BusinessType.this).O("ad_sdk_feature_info_collect", "default_type").i(b.qy().aH(optBoolean).aJ(a.QF).toJson()));
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
