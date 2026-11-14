package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class gj {
    private static volatile boolean d;
    private static volatile int f;
    public static JSONObject xj;
    private static volatile boolean y;
    private static final String[] u = {an.c, an.b};
    private static final String[] kd = {"aid", com.sigmob.sdk.base.n.r, "tt_data"};
    static final String[] hf = {"aid", "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", "iid", "device_platform"};
    public static final String[] w = {"tt_data", "device_platform"};
    private static Object c = new Object();

    static {
        pekdxhi();
    }

    private static void hf(Context context) {
        if (d || context == null) {
            return;
        }
        synchronized (c) {
            try {
                SharedPreferences.Editor edit = no.hf(context).edit();
                if (f > 2) {
                    f -= 2;
                } else {
                    f = 0;
                }
                edit.putInt("app_log_encrypt_faild_count", f);
                edit.apply();
                d = true;
            } catch (Throwable unused) {
            }
        }
    }

    private static /* synthetic */ void pekdxhi() {
        char[] charArray = "þòð³úüðø³ÿòä³îõøññ³×óôßïôùúø".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 157);
        }
        String str = new String(charArray);
        char[] charArray2 = "þñôóôé".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 157);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static JSONObject w(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String xj2 = xj(1, str, null, oa.xj(jSONObject.toString()));
        if (xj2 != null) {
            try {
                jSONObject2 = new JSONObject(xj2);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
            if (jSONObject2 == null && cb.o.equals(jSONObject2.optString("message", ""))) {
                return jSONObject2.optJSONObject(PointParamKey.DATA);
            }
            return null;
        }
        jSONObject2 = null;
        if (jSONObject2 == null) {
        }
        return null;
    }

    public static boolean xj(int i) {
        return i >= 500 && i < 600;
    }

    private static String xj(String str) {
        if (TextUtils.isEmpty(str) || !xj.f()) {
            return str;
        }
        Uri parse = Uri.parse(str);
        String query = parse.getQuery();
        ArrayList arrayList = new ArrayList();
        for (String str2 : kd) {
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(new Pair(str2, queryParameter));
            }
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            buildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        buildUpon.appendQueryParameter("tt_info", new String(Base64.encode(oa.xj(query), 8)));
        return buildUpon.build().toString();
    }

    public static JSONObject hf(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        HashMap hashMap = new HashMap(2);
        if (xj.f()) {
            hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            hashMap.put("Content-Type", "application/json; charset=utf-8");
        }
        String xj2 = xj(1, str, hashMap, oa.xj(jSONObject.toString()));
        if (xj2 != null) {
            try {
                jSONObject2 = new JSONObject(xj2);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
            if (jSONObject2 == null && "ss_app_log".equals(jSONObject2.optString("magic_tag", ""))) {
                return jSONObject2.optJSONObject("config");
            }
            return null;
        }
        jSONObject2 = null;
        if (jSONObject2 == null) {
        }
        return null;
    }

    public static String xj(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        HashMap hashMap = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                hashMap.put(str2, queryParameter);
            }
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (String str3 : hashMap.keySet()) {
            buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
        }
        return buildUpon.build().toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x017f, code lost:
    
        if (r0 == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0181, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01ac, code lost:
    
        if (r0 == null) goto L81;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String xj(int r8, java.lang.String r9, java.util.HashMap<java.lang.String, java.lang.String> r10, byte[] r11) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.gj.xj(int, java.lang.String, java.util.HashMap, byte[]):java.lang.String");
    }

    public static JSONObject xj(String str, JSONObject jSONObject) {
        HashMap hashMap = new HashMap(2);
        if (xj.f()) {
            hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            hashMap.put("Content-Type", "application/json; charset=utf-8");
        }
        String xj2 = xj(1, xj(str), hashMap, oa.xj(jSONObject.toString()));
        if (xj2 == null) {
            return null;
        }
        try {
            return new JSONObject(xj2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    public static String xj(Context context, String str, byte[] bArr, String str2, boolean z, boolean z2) {
        byte[] xj2;
        try {
            try {
                HashMap hashMap = new HashMap();
                if (z) {
                    try {
                        xj2 = xj(bArr);
                        hashMap.put("Content-Encoding", "gzip");
                    } catch (Exception unused) {
                        return null;
                    }
                } else {
                    xj2 = xj(context, bArr);
                    hashMap.put("log-encode-type", "gzip");
                    str = str + "&tt_data=a";
                    if (z2) {
                        str = str + "&config_retry=b";
                    }
                    hashMap.remove("Content-Encoding");
                    hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
                }
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put("Content-Type", str2);
                }
                return xj(1, str, hashMap, xj2);
            } catch (RuntimeException e) {
                v.w("__kite", e.getMessage());
                return "";
            }
        } catch (Exception e2) {
            v.w("__kite", e2.getMessage());
            return "";
        }
    }

    public static byte[] xj(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                gZIPOutputStream2.close();
            }
            throw th;
        }
    }

    private static byte[] xj(Context context, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (context != null) {
                xj(context);
                if (f >= 3) {
                    return null;
                }
                byte[] a2 = TTEncryptUtils.a(byteArray, byteArray.length);
                hf(context);
                return a2;
            }
            return TTEncryptUtils.a(byteArray, byteArray.length);
        } catch (Throwable th) {
            try {
                v.w("__kite", "gzip ".concat(String.valueOf(th)));
                return null;
            } finally {
                gZIPOutputStream.close();
            }
        }
    }

    private static void xj(Context context) {
        if (y || context == null) {
            return;
        }
        synchronized (c) {
            try {
                SharedPreferences hf2 = no.hf(context);
                f = hf2.getInt("app_log_encrypt_faild_count", 0);
                SharedPreferences.Editor edit = hf2.edit();
                edit.putInt("app_log_encrypt_faild_count", f + 1);
                edit.apply();
                y = true;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int xj(java.lang.String[] r8, byte[] r9, com.bytedance.embedapplog.wn r10) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.gj.xj(java.lang.String[], byte[], com.bytedance.embedapplog.wn):int");
    }
}
