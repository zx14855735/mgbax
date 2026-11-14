package com.kwad.sdk.kgeo;

import android.content.Context;
import android.os.Build;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.s;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c {
    private static final AtomicBoolean sHasInit = new AtomicBoolean(false);

    public interface a {
        void onSuccess(String str);

        void qF();
    }

    static {
        BnOg();
    }

    private static /* synthetic */ void BnOg() {
        char[] charArray = "|pr1x~rz1}pf1lwzss1Uqv]mv{xz".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 31);
        }
        String str = new String(charArray);
        char[] charArray2 = "|svqvk".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 31);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void a(final Context context, final a aVar) {
        if (bc.useMacAddressDisable()) {
            aVar.qF();
            return;
        }
        if (!s.RI()) {
            aVar.qF();
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            aVar.qF();
            return;
        }
        AtomicBoolean atomicBoolean = sHasInit;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        boolean isArm64 = AbiUtil.isArm64(context);
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.version = "1.0.3";
        bVar.avL = isArm64 ? "kmc-v8a" : "kmc-v7a";
        bVar.avM = com.kwad.sdk.core.network.idc.a.Jz().es(isArm64 ? "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac64" : "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac32");
        bVar.avO = isArm64 ? "db9a8da62a0354ec5710ec03e2743f07" : "2440a8221230913d4287c6b1e02b49f1";
        bVar.enable = true;
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.sdk.kgeo.c.1
            private void xU() {
                com.kwad.sdk.core.d.c.d("KGeoSoHelper", "onPostLoad");
                try {
                    System.loadLibrary("ipneigh-android");
                    a.this.onSuccess(com.kwai.library.ipneigh.c.eC(context).bkk);
                } catch (Throwable unused) {
                    com.kwad.sdk.core.d.c.d("KGeoSoHelper", "loadLibrary fail");
                    a.this.qF();
                }
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0344b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar2) {
                xU();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0344b, com.kwad.library.solder.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(e eVar, PluginError pluginError) {
                a(pluginError);
            }

            private void a(PluginError pluginError) {
                com.kwad.sdk.core.d.c.d("KGeoSoHelper", "onFail error:" + pluginError.getMessage());
                a.this.qF();
            }
        });
    }
}
