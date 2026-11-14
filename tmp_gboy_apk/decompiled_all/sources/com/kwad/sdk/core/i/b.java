package com.kwad.sdk.core.i;

import android.app.ActivityManager;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.LocaleList;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.czhj.sdk.common.Constants;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.m;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b implements c {
    private static Locale aOU;
    private String aJW;
    private boolean aOS = true;
    private Map<String, String> aOT = new LinkedHashMap();

    private StringBuilder LL() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.aOT.entrySet()) {
            sb.append(" ");
            sb.append(entry.getKey());
            sb.append("/");
            sb.append(entry.getValue());
        }
        return sb;
    }

    private static String LM() {
        LocaleList localeList;
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            localeList = LocaleList.getDefault();
            locale = localeList.get(0);
            aOU = locale;
        } else {
            aOU = Locale.getDefault();
        }
        if (aOU == null) {
            aOU = Locale.CHINESE;
        }
        return aOU.getLanguage();
    }

    private static long aH(long j) {
        if (j > 524288000) {
            return 524288000L;
        }
        return j;
    }

    private static long aI(long j) {
        long j2 = j / 512000;
        if (j2 == 0) {
            return 524288000L;
        }
        return (j2 == 1 ? j / 2 : j / 3) * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
    }

    private void bT(Context context) {
        this.aOT.put("Yoda", "3.2.11-rc1");
        this.aOT.put("Kwai", "11.8.10");
        this.aOT.put("OS_PRO_BIT", String.valueOf(AbiUtil.isArm64(context) ? 1 : 0));
        this.aOT.put("MAX_PHY_MEM", String.valueOf(br.ee(context) >> 20));
        this.aOT.put("KDT", "PHONE");
        this.aOT.put("AZPREFIX", "az4");
        this.aOT.put("ICFO", Constants.FAIL);
        this.aOT.put("StatusHT", String.valueOf(com.kwad.sdk.c.a.a.bq(context)));
        this.aOT.put("TitleHT", "44");
        this.aOT.put("NetType", bV(context));
        this.aOT.put("ISLP", String.valueOf(bW(context)));
        this.aOT.put("ISDM", String.valueOf(bX(context)));
        int ed = br.ed(context);
        this.aOT.put("ISLB", String.valueOf((ed <= 0 || ed >= 15) ? 0 : 1));
        this.aOT.put("locale", LM());
        this.aOT.put("SHP", String.valueOf(m.getScreenHeight(context)));
        this.aOT.put("SWP", String.valueOf(m.getScreenWidth(context)));
        this.aOT.put("SD", String.valueOf(m.cT(context)));
        this.aOT.put("CD", Constants.FAIL);
        this.aOT.put("ISLM", String.valueOf(bY(context)));
    }

    private String bU(Context context) {
        if (!TextUtils.isEmpty(this.aJW)) {
            return this.aJW;
        }
        if (context == null) {
            return "";
        }
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        if (!TextUtils.isEmpty(this.aJW)) {
            return this.aJW;
        }
        this.aJW = WebSettings.getDefaultUserAgent(context);
        return this.aJW;
    }

    private static String bV(Context context) {
        String str = "DISABLE";
        if (context == null) {
            return "DISABLE";
        }
        NetworkInfo dn = ao.dn(context);
        if (dn != null) {
            int type = dn.getType();
            if (type != 0) {
                return type != 1 ? MediationConfigUserInfoForSegment.GENDER_UNKNOWN : "WIFI";
            }
            str = dn.getSubtypeName();
            if (TextUtils.isEmpty(str)) {
                return dn.getTypeName();
            }
        }
        return str;
    }

    private static int bW(Context context) {
        return (!AbiUtil.isArm64(context) || (br.ee(context) >> 20) <= ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF) ? 1 : 0;
    }

    private static int bX(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 48) == 32 ? 1 : 0;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return 0;
        }
    }

    private static int bY(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return (memoryInfo.lowMemory || memoryInfo.availMem <= aH(memoryInfo.threshold) + aI(Debug.getPss())) ? 1 : 0;
    }

    @Override // com.kwad.sdk.core.i.c
    public final String LK() {
        return this.aOS ? "kwai-android aegon/4.6.3.1" : "kwai-android aegon/4.6.3";
    }

    @Override // com.kwad.sdk.core.i.c
    public final String bR(Context context) {
        return bU(context);
    }

    @Override // com.kwad.sdk.core.i.c
    public final String bS(Context context) {
        try {
            if (this.aOT.isEmpty()) {
                bT(context);
            }
            StringBuilder LL = LL();
            if (this.aOS) {
                LL.insert(0, " KRN/3.6.6");
            }
            return LL.toString();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.w("KwaiUAGetter", "getWebViewUASuffix: " + th.getMessage());
            return "";
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public final void bx(boolean z) {
        this.aOS = z;
    }
}
