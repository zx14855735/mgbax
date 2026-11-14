package com.bytedance.sdk.openadsdk.core.miniapp;

import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static volatile xj xj;
    private String hf = "";

    private xj() {
    }

    public static xj xj() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public String hf() {
        return this.hf;
    }

    public void registerReceiver(Context context) {
        MiniAppBroadcastReceiver miniAppBroadcastReceiver = new MiniAppBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("com.byted.pma.PMA_DATA");
        intentFilter.addDataScheme("package");
        intentFilter.addDataAuthority(context.getPackageName(), null);
        try {
            context.registerReceiver(miniAppBroadcastReceiver, intentFilter, wo.io(), null);
        } catch (Throwable th) {
            pl.u("MiniAppManager", "register BroadcastReceiver : " + th.getMessage());
        }
    }

    public void xj(String str) {
        this.hf = str;
    }
}
