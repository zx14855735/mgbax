package com.bytedance.sdk.openadsdk.core.x.xj;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.component.d.hf.w;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.ats.u;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.et.kd;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.x.hf;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.sigmob.sdk.base.views.r;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements hf {
    private static final FileFilter hf = new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.x.xj.xj.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith(IAdInterListener.AdProdType.PRODUCT_CPU)) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    };
    private static volatile xj xj;

    static {
        WCsn();
    }

    private static /* synthetic */ void WCsn() {
        char[] charArray = "}qs0y\u007fs{0|qg0mv{rr0Tpw\\lwzy{".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 30);
        }
        String str = new String(charArray);
        char[] charArray2 = "}rwpwj".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 30);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private int d() {
        int hf2 = hf(pz.getContext());
        int tf = tf();
        int i = 2;
        if (hf2 != 0 && hf2 != 1 && tf != 0) {
            if (hf2 != 2 || tf <= 0) {
                if (hf2 <= 2) {
                    i = -1000;
                } else if (tf > 1) {
                    i = 0;
                }
            }
            i = 1;
        }
        xj("ram_level", String.valueOf(hf2));
        xj("cpu_level", String.valueOf(tf));
        xj("update_time", String.valueOf(System.currentTimeMillis()));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ram", hf2);
            jSONObject.put(IAdInterListener.AdProdType.PRODUCT_CPU, tf);
            jSONObject.put("level", i);
        } catch (JSONException e) {
            pl.xj(e);
        }
        am.xj().kd(jSONObject);
        xj(i);
        return i;
    }

    private void f() {
        try {
            w w = kd.xj().hf().w();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("os", "android");
            jSONObject.put("device_model", Build.MODEL);
            w.xj(Uri.parse(wo.f("/api/ad/union/sdk/device_score")).buildUpon().appendQueryParameter("is_bidding", "1").appendQueryParameter(BaseConstants.EVENT_LABEL_EXTRA, com.bytedance.sdk.component.utils.xj.hf(jSONObject.toString())).toString());
            com.bytedance.sdk.component.d.hf xj2 = w.xj();
            if (xj2 == null || !xj2.f()) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(xj2.u());
            if (jSONObject2.optInt(PluginConstants.KEY_ERROR_CODE) != 200) {
                xj("bytebench_value", "-1.0");
                return;
            }
            double optDouble = jSONObject2.optDouble("score");
            xj("bytebench_update_time", String.valueOf(System.currentTimeMillis()));
            xj("bytebench_value", String.valueOf(optDouble));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("score", optDouble);
            am.xj().y(jSONObject3);
        } catch (Exception e) {
            pl.xj(e);
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("score", -1);
                am.xj().y(jSONObject4);
            } catch (JSONException e2) {
                pl.xj(e2);
            }
        }
    }

    private static int hf(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                int w = w(readLine);
                fileInputStream.close();
                return w;
            } finally {
            }
        } catch (IOException unused) {
            return -1;
        }
    }

    private static int tf() {
        int w = w() / 1000;
        if (w <= 1600) {
            return 0;
        }
        if (w <= 2000) {
            return 1;
        }
        return w <= 2500 ? 2 : 3;
    }

    public static int u() {
        try {
            int hf2 = hf("/sys/devices/system/cpu/possible");
            if (hf2 == -1) {
                hf2 = hf("/sys/devices/system/cpu/present");
            }
            return hf2 == -1 ? new File("/sys/devices/system/cpu/").listFiles(hf).length : hf2;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    public static int w() {
        int i = -1;
        for (int i2 = 0; i2 < u(); i2++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[r.b.d];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i3 = 0;
                        while (Character.isDigit(bArr[i3]) && i3 < 128) {
                            i3++;
                        }
                        int parseInt = Integer.parseInt(new String(bArr, 0, i3));
                        if (parseInt > i) {
                            i = parseInt;
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                    fileInputStream.close();
                }
            } catch (IOException unused2) {
                return -1;
            }
        }
        if (i == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int xj2 = xj("cpu MHz", fileInputStream2) * 1000;
                if (xj2 > i) {
                    i = xj2;
                }
            } finally {
                fileInputStream2.close();
            }
        }
        return i;
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

    public boolean c() {
        String xj2 = xj("bytebench_update_time");
        return xj2.isEmpty() || System.currentTimeMillis() - Long.parseLong(xj2) >= 15552000000L;
    }

    public void kd() {
        if (pz.hf().rs() && y()) {
            d();
        }
        if (pz.hf().yq() && c()) {
            f();
        }
    }

    public boolean y() {
        String xj2 = xj("update_time");
        return xj2.isEmpty() || System.currentTimeMillis() - Long.parseLong(xj2) >= 15552000000L;
    }

    @TargetApi(16)
    public static long xj(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    private static int hf(Context context) {
        long xj2 = xj(context) / BaseConstants.MB_VALUE;
        if (xj2 <= 2000) {
            return 0;
        }
        if (xj2 <= 3000) {
            return 1;
        }
        if (xj2 <= 4000) {
            return 2;
        }
        return xj2 <= 6000 ? 3 : 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.hf
    public String hf() {
        return "DeviceRate";
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int xj(java.lang.String r6, java.io.FileInputStream r7) {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            int r7 = r7.read(r0)     // Catch: java.lang.Throwable -> L37
            r1 = 0
        L9:
            if (r1 >= r7) goto L3b
            r2 = r0[r1]     // Catch: java.lang.Throwable -> L37
            r3 = 10
            if (r2 == r3) goto L13
            if (r1 != 0) goto L34
        L13:
            if (r2 != r3) goto L17
            int r1 = r1 + 1
        L17:
            r2 = r1
        L18:
            if (r2 >= r7) goto L34
            int r3 = r2 - r1
            r4 = r0[r2]     // Catch: java.lang.Throwable -> L37
            char r5 = r6.charAt(r3)     // Catch: java.lang.Throwable -> L37
            if (r4 != r5) goto L34
            int r4 = r6.length()     // Catch: java.lang.Throwable -> L37
            int r4 = r4 + (-1)
            if (r3 != r4) goto L31
            int r6 = xj(r0, r2)     // Catch: java.lang.Throwable -> L37
            return r6
        L31:
            int r2 = r2 + 1
            goto L18
        L34:
            int r1 = r1 + 1
            goto L9
        L37:
            r6 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r6)
        L3b:
            r6 = -1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.x.xj.xj.xj(java.lang.String, java.io.FileInputStream):int");
    }

    private static int w(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    private static int xj(byte[] bArr, int i) {
        byte b;
        while (i < bArr.length && (b = bArr[i]) != 10) {
            if (Character.isDigit(b)) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.hf
    public String xj(String str) {
        return u.xj(hf()).get(str, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.hf
    public void xj(String str, String str2) {
        u.xj(hf()).put(str, str2);
    }

    private void xj(int i) {
        xj("device_level", String.valueOf(i));
        com.bytedance.sdk.openadsdk.core.w.u.xj().f(i);
    }
}
