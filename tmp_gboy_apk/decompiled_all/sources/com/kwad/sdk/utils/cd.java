package com.kwad.sdk.utils;

import BPw6Q8.ASJ6gh;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class cd {
    private static boolean bgN;
    private static final List<a> bgO = new CopyOnWriteArrayList();

    public static class a implements com.kwad.sdk.core.b {
        public String bgP;
        public String bgQ;
        public int level;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "level", this.level);
            aa.putValue(jSONObject, "ssid", this.bgP);
            aa.putValue(jSONObject, "bssid", this.bgQ);
            return jSONObject;
        }
    }

    static {
        UcjPK();
    }

    private static /* synthetic */ void UcjPK() {
        char[] charArray = "\u001b\u0017\u0015V\u001f\u0019\u0015\u001dV\u001a\u0017\u0001V\u000b\u0010\u001d\u0014\u0014V2\u0016\u0011:\n\u0011\u001c\u001f\u001d".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'x');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001b\u0014\u0011\u0016\u0011\f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'x');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean er(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ASJ6gh.A2egSU(context, com.kuaishou.weapon.p0.g.g) == -1 && ASJ6gh.A2egSU(context, com.kuaishou.weapon.p0.g.h) == -1 : ASJ6gh.A2egSU(context, com.kuaishou.weapon.p0.g.g) == -1;
    }

    public static List<a> o(Context context, int i) {
        WifiManager wifiManager;
        if (bc.useNetworkStateDisable()) {
            return new ArrayList();
        }
        if (!bgN && ServiceProvider.getSDKConfig().canReadNearbyWifiList()) {
            List<a> list = bgO;
            if (list.isEmpty() && context != null) {
                if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(32L)) {
                    try {
                    } catch (Exception e) {
                        bgN = true;
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    }
                    if (!er(context) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null) {
                        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        if (scanResults != null) {
                            for (ScanResult scanResult : scanResults) {
                                a aVar = new a();
                                aVar.bgP = scanResult.SSID;
                                aVar.bgQ = scanResult.BSSID;
                                aVar.level = scanResult.level;
                                if (connectionInfo.getBSSID() == null || scanResult.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || scanResult.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                                    bgO.add(aVar);
                                } else {
                                    bgO.add(0, aVar);
                                }
                                List<a> list2 = bgO;
                                if (list2.size() >= i) {
                                    return list2;
                                }
                            }
                        }
                        return bgO;
                    }
                }
                return list;
            }
        }
        return bgO;
    }
}
