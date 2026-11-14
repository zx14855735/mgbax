package com.bytedance.msdk.f;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.fl.saas.videocache.ProxyCacheUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class l {
    private static String hf = null;
    private static String u = "ToolUtils";
    private static String w;
    private static String xj;

    public static synchronized String hf() {
        String str;
        synchronized (l.class) {
            try {
                if (TextUtils.isEmpty(hf) && com.bytedance.msdk.core.hf.getContext() != null) {
                    try {
                        PackageInfo packageInfo = com.bytedance.msdk.core.hf.getContext().getPackageManager().getPackageInfo(xj(), 0);
                        hf = String.valueOf(packageInfo.versionCode);
                        w = packageInfo.versionName;
                    } catch (Throwable th) {
                        com.bytedance.msdk.xj.kd.w.u(u, "ToolUtils getVersionCode throws exception :" + th);
                    }
                }
                str = hf;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str;
    }

    public static String kd() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return g.xj(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String u() {
        String str;
        try {
            str = System.getProperty("http.agent");
        } catch (Exception unused) {
            str = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(";");
        if (lastIndexOf != -1 && str.length() > lastIndexOf) {
            int i = lastIndexOf + 1;
            String substring = str.substring(0, i);
            str = substring.concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(str.substring(i));
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static synchronized String w() {
        String str;
        synchronized (l.class) {
            try {
                if (TextUtils.isEmpty(w) && com.bytedance.msdk.core.hf.getContext() != null) {
                    try {
                        PackageInfo packageInfo = com.bytedance.msdk.core.hf.getContext().getPackageManager().getPackageInfo(xj(), 0);
                        hf = String.valueOf(packageInfo.versionCode);
                        w = packageInfo.versionName;
                    } catch (Throwable th) {
                        com.bytedance.msdk.xj.kd.w.u(u, "ToolUtils getVersionName throws exception :" + th);
                    }
                }
                str = w;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str;
    }

    public static synchronized String xj() {
        String str;
        synchronized (l.class) {
            try {
                if (TextUtils.isEmpty(xj) && com.bytedance.msdk.core.hf.getContext() != null) {
                    try {
                        xj = com.bytedance.msdk.core.hf.getContext().getPackageName();
                    } catch (Throwable th) {
                        com.bytedance.msdk.xj.kd.w.u(u, "ToolUtils getPackageName throws exception :" + th);
                    }
                }
                str = xj;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str;
    }

    public static com.bytedance.sdk.component.u.xj y() {
        return (com.bytedance.sdk.component.u.xj) com.bytedance.sdk.openadsdk.ats.w.xj("armor_service");
    }

    public static String xj(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return xj.hf(str.substring(17), w(str.substring(1, 17)));
    }

    public static boolean xj(com.bytedance.sdk.component.d.hf hfVar) {
        if (hfVar == null || !com.bytedance.sdk.component.d.u.xj.xj(hfVar.w())) {
            return (hfVar == null || hfVar.u() == null || hfVar.u().startsWith("{") || hfVar.u().endsWith("}")) ? false : true;
        }
        return true;
    }

    public static byte[] hf(String str) {
        com.bytedance.sdk.component.u.xj y = y();
        if (y == null) {
            return null;
        }
        return y.encrypt(u(str));
    }

    private static String w(String str) {
        String xj2 = xj.xj(str);
        if (str != null) {
            return xj2;
        }
        String xj3 = hf.xj();
        return xj3.concat(xj3).substring(8, 24);
    }

    public static String xj(byte[] bArr) {
        com.bytedance.sdk.component.u.xj y;
        if (bArr != null) {
            try {
                if (bArr.length == 0 || (y = y()) == null) {
                    return null;
                }
                String hf2 = com.bytedance.sdk.openadsdk.core.a.g.hf(y.decrypt(bArr));
                if (TextUtils.isEmpty(hf2)) {
                    return null;
                }
                return hf2;
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
        return null;
    }

    private static byte[] u(String str) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            try {
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                } catch (IOException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
        } catch (Exception e3) {
            e = e3;
            gZIPOutputStream2 = gZIPOutputStream;
            com.bytedance.sdk.component.utils.pl.xj(e);
            if (gZIPOutputStream2 != null) {
                gZIPOutputStream2.close();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            if (gZIPOutputStream2 != null) {
                try {
                    gZIPOutputStream2.close();
                } catch (IOException e4) {
                    com.bytedance.sdk.component.utils.pl.xj(e4);
                }
            }
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static JSONObject xj(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                try {
                    String xj2 = xj.xj();
                    String str = "2" + xj2 + xj.xj(jSONObject.toString(), xj.xj(xj2));
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject2.put("message", str);
                        jSONObject2.put("cypher", 2);
                        return jSONObject2;
                    }
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                    return jSONObject2;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        }
        return jSONObject2;
    }
}
