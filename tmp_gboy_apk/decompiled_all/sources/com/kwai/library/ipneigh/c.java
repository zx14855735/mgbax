package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c {
    private static d D(Context context, boolean z) {
        return b(context, false, false);
    }

    private static d b(Context context, boolean z, boolean z2) {
        String str;
        try {
            if (!b.isWifiConnected(context)) {
                return new d("", false, "");
            }
            String fD = b.fD(((WifiManager) context.getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway);
            if (z) {
                str = "";
            } else {
                str = a.ii("timeout 5 ip neigh show " + fD);
            }
            if (z || TextUtils.isEmpty(str)) {
                str = KwaiIpNeigh.j(fD, false);
            }
            return new d(b.ik(str), !TextUtils.isEmpty(r3), str);
        } catch (Throwable th) {
            return new d("", false, th.getMessage());
        }
    }

    public static d eC(Context context) {
        return D(context, false);
    }
}
