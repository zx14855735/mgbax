package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa;

import ADYaiT.CtFAbx;
import BPw6Q8.ASJ6gh;
import android.content.Context;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.kuaishou.weapon.p0.g;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.mta.PointType;
import io.dcloud.openapi.poly.base.utils.PrivacyManager;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaeo {
    private static String aaaaaaa0 = "1";
    private static String aaaaaaaa = "0";
    private static String aaaaaaac = "4";
    private static String aaaaaaae = "7";
    private static String aaaaaaan = "6";
    private static String aaaaaaao = "3";
    private static String aaaaaaau = "5";
    private static boolean aaaaaaav = false;
    private static String aaaaaaeo = "1";

    /* JADX WARN: Can't wrap try/catch for region: R(25:0|1|2|3|4|5|6|7|(1:9)|10|(1:39)(1:14)|15|16|17|(10:19|20|21|22|23|(1:25)|26|(1:28)(1:33)|29|30)|37|20|21|22|23|(0)|26|(0)(0)|29|30) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ea, code lost:
    
        r1 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject aaaaaaa0(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaeo.aaaaaaa0(android.content.Context):org.json.JSONObject");
    }

    public static JSONObject aaaaaaaa(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device", aaaaaaa0(context));
            jSONObject.put(TKDownloadReason.KSAD_TK_NET, aaaaaaao(context));
            jSONObject.put("gps", aaaaaaan.aaaaaaaa(context));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static String aaaaaaac(Context context) {
        if (!io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(context)) {
            return aaaaaaeo;
        }
        if (!PrivacyManager.getInstance().aaaaaaac()) {
            return aaaaaaeo;
        }
        if (ASJ6gh.A2egSU(context, g.b) != 0) {
            return aaaaaaeo;
        }
        if (aaaaaaav) {
            return aaaaaaeo;
        }
        String str = aaaaaaa0;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null) {
            str = aaaaaaaa;
            if (connectivityManager.getActiveNetworkInfo().getType() != 1) {
                if (connectivityManager.getActiveNetworkInfo().getType() == 0) {
                    int subtype = connectivityManager.getActiveNetworkInfo().getSubtype();
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                            str = aaaaaaac;
                            break;
                        case 3:
                        case 8:
                            str = aaaaaaau;
                            break;
                        case 5:
                        case 6:
                        case 12:
                        case 14:
                            str = aaaaaaau;
                            break;
                        case 9:
                        case 10:
                        case 11:
                        case 13:
                        case 15:
                            str = aaaaaaan;
                            break;
                        case 16:
                        case 19:
                        default:
                            str = CtFAbx.ARc23Z(subtype, "");
                            break;
                        case 17:
                        case 18:
                            str = aaaaaaau;
                            break;
                        case 20:
                            str = aaaaaaae;
                            break;
                    }
                }
            } else {
                str = aaaaaaao;
            }
        }
        aaaaaaeo = str;
        aaaaaaav = true;
        return str;
    }

    public static JSONObject aaaaaaao(Context context) {
        boolean aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(context);
        String str = "460";
        String str2 = PointType.SIGMOB_APP;
        if (aaaaaaaa2 && PrivacyManager.getInstance().aaaaaaac()) {
            try {
                String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() == 5) {
                    str = networkOperator.substring(0, 3);
                    str2 = networkOperator.substring(3);
                }
            } catch (Exception unused) {
            }
        }
        JSONObject jSONObject = new JSONObject(aaaaaaan.aaaaaaaa(context, str2));
        try {
            jSONObject.put(PointParamKey.TYPE, aaaaaaac(context));
            jSONObject.put("mcc", str);
            jSONObject.put("mnc", str2);
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    public static String aaaaaaau(Context context) {
        String aaaaaaaa2 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaau.aaaaaaaa(context, "dcloud-ads", "u-a");
        if (!TextUtils.isEmpty(aaaaaaaa2) || !io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(context) || !PrivacyManager.getInstance().aaaaaaac()) {
            return aaaaaaaa2;
        }
        try {
            WebView webView = new WebView(context);
            WebSettings settings = webView.getSettings();
            settings.setSavePassword(false);
            aaaaaaaa2 = settings.getUserAgentString();
            webView.destroy();
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaau.aaaaaaaa(context, "dcloud-ads", "u-a", aaaaaaaa2);
            return aaaaaaaa2;
        } catch (Throwable unused) {
            return aaaaaaaa2;
        }
    }
}
