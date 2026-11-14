package com.ss.android.downloadlib.hf;

import android.os.Build;
import com.ss.android.downloadlib.c.g;
import com.ss.android.socialbase.downloader.xj.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w {
    public static void xj(final com.ss.android.downloadad.api.xj.hf hfVar, final com.ss.android.downloadlib.guide.install.xj xjVar) {
        boolean hf = com.ss.android.socialbase.downloader.xj.xj.xj().hf();
        if (!hf && Build.VERSION.SDK_INT >= 29) {
            g.w();
        }
        boolean hf2 = com.ss.android.socialbase.downloader.xj.xj.xj().hf();
        if (!hf && hf2 && hfVar != null) {
            hfVar.pl(true);
        }
        xjVar.xj();
        com.ss.android.socialbase.downloader.w.xj.hf("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->isAppForegroundSecond:::".concat(String.valueOf(hf2)));
        if (hf2) {
            return;
        }
        com.ss.android.socialbase.downloader.xj.xj.xj().xj(new xj.InterfaceC0510xj() { // from class: com.ss.android.downloadlib.hf.w.1
            @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
            public void hf() {
                com.ss.android.socialbase.downloader.w.xj.hf("AppInstallOptimiseHelper", "AppInstallOptimiseHelper-->onAppForeground");
                com.ss.android.socialbase.downloader.xj.xj.xj().hf(this);
                if (g.hf(com.ss.android.downloadad.api.xj.hf.this)) {
                    return;
                }
                com.ss.android.downloadad.api.xj.hf.this.g(true);
                com.ss.android.downloadlib.u.xj.xj().xj("install_delay_invoke", com.ss.android.downloadad.api.xj.hf.this);
                xjVar.xj();
            }

            @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
            public void w() {
            }
        });
    }
}
