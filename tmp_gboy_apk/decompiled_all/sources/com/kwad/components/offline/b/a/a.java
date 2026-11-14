package com.kwad.components.offline.b.a;

import android.content.Context;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ah;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    private static final AtomicBoolean anu = new AtomicBoolean(false);
    private static final String anJ = ah.format("lib%s.so", "c++_shared");
    private static final String anK = ah.format("lib%s.so", "kwaiplayer");
    private static final String anL = ah.format("lib%s.so", "kste");
    private static final String anM = ah.format("lib%s.so", "hodor");
    private static final String anv = ah.format("lib%s.so", "aegon");

    static {
        pSzIYcm();
    }

    public static void a(Context context, final SoLoadListener soLoadListener) {
        String str;
        String str2;
        String str3;
        AtomicBoolean atomicBoolean = anu;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        HashMap<String, String> hashMap = new HashMap<>();
        if (AbiUtil.isArm64(context)) {
            hashMap.put(anJ, "dcd68cd059cb06a9596ba6839c2e8858");
            hashMap.put(anK, "cf71bcc476b2b25e2e62b541275ad78c");
            hashMap.put(anL, "ebb56fa9c5701350497e281c2446660f");
            hashMap.put(anM, "a61edf93bc5abc7799c5444ccbaf140b");
            hashMap.put(anv, "c256c0d7f79ad4d47db61cb8e8ab142a");
            str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adLive/ks_so-adLiveArm64v8aRelease-3.3.44.2-e8fbb3a5f8-666.apk";
            str2 = "adLive-v8a";
            str3 = "41a4213dcbf3ed262fc69daf7d4a29e5";
        } else {
            hashMap.put(anJ, "e3fdbf82716c2cb9b666a3880ab94003");
            hashMap.put(anK, "2ba24f9d0a6e786af477ed1e2dad148b");
            hashMap.put(anL, "71a9baa45905a6f0e527e5a2e06e8808");
            hashMap.put(anM, "d997935a035d00a67dc46e26427b8bf9");
            hashMap.put(anv, "bdac6eea0d25da98061c21234f3b20c5");
            str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adLive/ks_so-adLiveArmeabiv7aRelease-3.3.44.2-e8fbb3a5f8-666.apk";
            str2 = "adLive-v7a";
            str3 = "ceddd5a3aae9148992bee153a29a25fb";
        }
        b bVar = new b();
        com.kwad.library.b.a m = com.kwad.library.solder.a.a.m(context, IAdLiveOfflineCompo.PACKAGE_NAME);
        c.d("AdLiveSoLoadHelper", "adLiveOfflineCompoPlugin: " + m);
        if (m != null) {
            bVar.avU = m.Bm();
        }
        bVar.avM = com.kwad.sdk.core.network.idc.a.Jz().es(str);
        bVar.enable = true;
        bVar.avL = str2;
        bVar.version = "3.3.44.3";
        bVar.avR = hashMap;
        bVar.avO = str3;
        bVar.avP = true;
        com.kwad.library.solder.a.a.a(context, bVar, new b.c() { // from class: com.kwad.components.offline.b.a.a.1
            private void xU() {
                SoLoadListener.this.onLoaded();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0344b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar) {
                xU();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0344b, com.kwad.library.solder.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(e eVar, PluginError pluginError) {
                a(pluginError);
            }

            private void a(PluginError pluginError) {
                SoLoadListener.this.onFailed(pluginError.getCode(), pluginError);
            }
        });
    }

    private static /* synthetic */ void pSzIYcm() {
        char[] charArray = ":64w>84<w;6 w*1<55w\u001370\u001b+0=><".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'Y');
        }
        String str = new String(charArray);
        char[] charArray2 = ":5070-".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'Y');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
