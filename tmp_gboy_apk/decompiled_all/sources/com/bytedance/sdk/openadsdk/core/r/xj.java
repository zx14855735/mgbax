package com.bytedance.sdk.openadsdk.core.r;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.dk;
import com.bytedance.sdk.openadsdk.core.a.p;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.gj;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static final xj xj = new xj();
    private gj c;
    private int[] d;
    private boolean f;
    private String hf = "";
    private String w = "";
    private String u = "";
    private String kd = "";
    private JSONArray y = new JSONArray();

    static {
        pWxUhU();
    }

    private xj() {
    }

    private String hf() {
        Enumeration<InetAddress> inetAddresses;
        String hostAddress;
        String str = null;
        if (!p.tf()) {
            return null;
        }
        try {
            NetworkInterface byName = NetworkInterface.getByName("wlan0");
            if (byName != null && (inetAddresses = byName.getInetAddresses()) != null) {
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if ((nextElement instanceof Inet6Address) && nextElement.isLinkLocalAddress() && (hostAddress = nextElement.getHostAddress()) != null && hostAddress.startsWith("fe80")) {
                        str = hostAddress;
                    }
                }
            }
        } catch (Exception e) {
            pl.xj(e);
        }
        this.hf = TextUtils.isEmpty(str) ? "" : str;
        return str;
    }

    private static /* synthetic */ void pWxUhU() {
        char[] charArray = "\u0091\u009d\u009fÜ\u0095\u0093\u009f\u0097Ü\u0090\u009d\u008bÜ\u0081\u009a\u0097\u009e\u009eÜ¸\u009c\u009b°\u0080\u009b\u0096\u0095\u0097".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 242);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0091\u009e\u009b\u009c\u009b\u0086".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 242);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private Long u() {
        long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        this.kd = String.valueOf(currentTimeMillis);
        return Long.valueOf(currentTimeMillis);
    }

    private Long w() {
        Long valueOf = Long.valueOf(new StatFs(Environment.getExternalStorageDirectory().getPath()).getTotalBytes());
        this.w = valueOf.toString();
        return valueOf;
    }

    public static xj xj() {
        return xj;
    }

    public void xj(Context context) {
        if (!pz.hf().pl()) {
            this.f = false;
            return;
        }
        if (this.f) {
            return;
        }
        try {
            hf();
            u();
            w();
            hf(context);
            w(context);
            this.c = dk.p();
            this.f = true;
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    private JSONArray w(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("com.ss.android.ugc.aweme", t.f);
            hashMap.put("com.ss.android.ugc.aweme.lite", "al");
            hashMap.put("com.dragon.read", t.k);
            hashMap.put("com.ss.android.article.news", "n");
            hashMap.put("com.ss.android.article.lite", "nl");
            PackageManager packageManager = context.getPackageManager();
            for (Map.Entry entry : hashMap.entrySet()) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo((String) entry.getKey(), 0);
                    long j = packageInfo.firstInstallTime;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", entry.getValue());
                    jSONObject.put("i", j);
                    if (TextUtils.equals((CharSequence) entry.getValue(), t.f) || TextUtils.equals((CharSequence) entry.getValue(), "n")) {
                        jSONObject.put(t.i, packageInfo.lastUpdateTime);
                    }
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
            this.y = jSONArray;
        } catch (Throwable unused2) {
        }
        return jSONArray;
    }

    private ActivityManager.MemoryInfo hf(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
        this.u = String.valueOf(memoryInfo.totalMem);
        return memoryInfo;
    }

    public void xj(gj gjVar) {
        this.c = gjVar;
    }

    public void xj(int[] iArr) {
        this.d = iArr;
    }

    public void xj(JSONObject jSONObject) {
        if (pz.hf().pl()) {
            try {
                gj gjVar = this.c;
                if (gjVar != null) {
                    JSONObject w = gjVar.w();
                    w.put("sl", 0);
                    jSONObject.put("u_t", w);
                }
                jSONObject.put("boot_time_sec", this.kd);
                jSONObject.put("memory", this.u);
                jSONObject.put("disk", this.w);
                jSONObject.put("client_tun", this.hf);
                jSONObject.put("pkg_info", this.y);
                int[] iArr = this.d;
                if (iArr != null) {
                    jSONObject.put("inode", Arrays.toString(iArr));
                }
            } catch (Exception e) {
                pl.xj(e);
            }
        }
    }
}
