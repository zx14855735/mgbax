package com.bytedance.pangle.c;

import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.u;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends u.xj {
    private final ZeusPluginInstallListener xj;

    public hf(ZeusPluginInstallListener zeusPluginInstallListener) {
        this.xj = zeusPluginInstallListener;
    }

    @Override // com.bytedance.pangle.u
    public void xj(String str, int i, String str2) {
        ZeusPluginInstallListener zeusPluginInstallListener = this.xj;
        if (zeusPluginInstallListener != null) {
            zeusPluginInstallListener.onPluginInstall(str, i, str2);
        }
    }
}
