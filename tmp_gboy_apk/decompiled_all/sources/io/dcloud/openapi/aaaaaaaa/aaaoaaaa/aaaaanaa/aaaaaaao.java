package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaanaa;

import J3FDQU.A2egSU;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.czhj.sdk.common.Constants;
import com.kuaishou.weapon.p0.bi;
import com.kuaishou.weapon.p0.t;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.sigmob.sdk.base.mta.PointParamKey;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaac;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaav;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaan;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaeo;
import io.dcloud.openapi.poly.base.utils.PrivacyManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaao {
    private static String aaaaaaa0(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TKDownloadReason.KSAD_TK_NET, aaaaaaeo.aaaaaaao(context));
            jSONObject.put("device", aaaaaaeo.aaaaaaa0(context));
            jSONObject.put("gps", aaaaaaan.aaaaaaaa(context));
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    private static boolean aaaaaaaa() {
        return true;
    }

    private static String aaaaaaac(Context context) {
        if (!io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(context) || !PrivacyManager.getInstance().aaaaaaac()) {
            return "";
        }
        try {
            Process exec = Runtime.getRuntime().exec("stat -c \"%x\" /data/data");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            char[] cArr = new char[256];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                stringBuffer.append(cArr, 0, read);
            }
            bufferedReader.close();
            exec.waitFor();
            String[] split = stringBuffer.toString().replace("\"", "").split("\\.");
            long time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(split[0]).getTime();
            String str = split[1];
            if (str.contains("+")) {
                str = str.substring(0, str.indexOf("+"));
            }
            return (time / 1000) + "." + Long.parseLong(str.trim());
        } catch (Exception unused) {
            return ".";
        }
    }

    private static String aaaaaaao(Context context) {
        if (!io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(context) || !PrivacyManager.getInstance().aaaaaaac()) {
            return "";
        }
        try {
            File file = new File("/proc/sys/kernel/random/boot_id");
            if (!file.exists()) {
                return "";
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[37];
            fileInputStream.read(bArr);
            String str = new String(bArr);
            try {
                fileInputStream.close();
                return str;
            } catch (Exception unused) {
                return str;
            }
        } catch (Exception unused2) {
            return "";
        }
    }

    public static HashMap aaaaaaaa(Context context) {
        String str;
        HashMap BI9f7h2 = A2egSU.BI9f7h(t.b, t.f);
        BI9f7h2.put("appid", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAppId());
        try {
            BI9f7h2.put("pname", context.getApplicationInfo().loadLabel(context.getPackageManager()));
        } catch (Exception unused) {
        }
        BI9f7h2.put("pn", context.getPackageName());
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        BI9f7h2.put("pv", str);
        BI9f7h2.put("imei", aaaaaaav.aaaaaaaa(context, true, true));
        BI9f7h2.put(LiveConfigKey.MEDIUM, Build.MODEL);
        BI9f7h2.put("vd", Build.MANUFACTURER);
        BI9f7h2.put("os", Integer.valueOf(Build.VERSION.SDK_INT));
        BI9f7h2.put("vb", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaao.aaaaaaaa());
        BI9f7h2.put(TKDownloadReason.KSAD_TK_NET, aaaaaaeo.aaaaaaac(context));
        BI9f7h2.put("mc", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaao.aaaaaaaa(context));
        BI9f7h2.put("paid", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAdId());
        BI9f7h2.put("dw", Integer.valueOf(context.getResources().getDisplayMetrics().widthPixels));
        BI9f7h2.put("dh", Integer.valueOf(context.getResources().getDisplayMetrics().heightPixels));
        BI9f7h2.put("psap", "dcloud,wanka,youdao,common");
        BI9f7h2.put("psas", "");
        BI9f7h2.put("ps", 0);
        BI9f7h2.put("psd", 0);
        BI9f7h2.put(PointParamKey.DATA, aaaaaaa0(context));
        BI9f7h2.put("pap", "1");
        BI9f7h2.put("papi", "1");
        BI9f7h2.put("psp", TextUtils.join(",", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aacaaaaa.aaaaaaaa.aaaaaaa0().aaaaaaao()));
        BI9f7h2.put("psaf", Constants.FAIL);
        BI9f7h2.put("psdk", Integer.valueOf(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaao.aaaaaaau()));
        BI9f7h2.put("mpap", "1");
        if (io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaao.aaaaaaao()) {
            BI9f7h2.put("uv", 2);
        }
        BI9f7h2.put("dpsp", "1");
        BI9f7h2.put("bm", aaaaaaao(context));
        BI9f7h2.put("um", aaaaaaac(context));
        BI9f7h2.put("aws", aaaaaaaa() ? "1" : Constants.FAIL);
        BI9f7h2.put("root", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaa0.aaaaaaaa() ? "1" : Constants.FAIL);
        BI9f7h2.put("ud", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaa0.aaaaaaa0(context) ? "1" : Constants.FAIL);
        BI9f7h2.put(bi.q, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaa0.aaaaaaao(context) ? "1" : Constants.FAIL);
        BI9f7h2.put("acc", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaa0.aaaaaaaa(context) ? "1" : Constants.FAIL);
        BI9f7h2.put("emu", aaaaaaac.aaaaaaeo().aaaaaaaa(context) ? "1" : Constants.FAIL);
        while (BI9f7h2.values().remove(null)) {
        }
        while (BI9f7h2.values().remove("null")) {
        }
        return BI9f7h2;
    }
}
