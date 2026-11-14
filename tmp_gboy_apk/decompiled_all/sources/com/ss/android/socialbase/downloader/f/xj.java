package com.ss.android.socialbase.downloader.f;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.w;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.tf.f;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {
    private static xj c;
    private static Boolean kd;
    private static JSONObject u;
    private static JSONObject w;
    private static boolean y;
    private final JSONObject d;
    private final JSONObject f;
    private int p;
    private final Boolean tf;
    private static final f<Integer, xj> xj = new f<>(16, 16);
    private static final xj hf = new xj(null);

    static {
        xj();
        YHXuRD();
    }

    private xj(JSONObject jSONObject) {
        Boolean bool;
        this.f = jSONObject;
        JSONObject jSONObject2 = null;
        r0 = null;
        r0 = null;
        Boolean bool2 = null;
        if (jSONObject == null || y("bugfix")) {
            bool = null;
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("bugfix");
            if (optJSONObject != null && optJSONObject.has("default") && !y("default")) {
                bool2 = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool3 = bool2;
            jSONObject2 = optJSONObject;
            bool = bool3;
        }
        this.d = jSONObject2;
        this.tf = bool;
    }

    private static /* synthetic */ void YHXuRD() {
        char[] charArray = "ÃÏÍ\u008eÇÁÍÅ\u008eÂÏÙ\u008eÓÈÅÌÌ\u008eêÎÉâÒÉÄÇÅ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 160);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÃÌÉÎÉÔ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 160);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static JSONObject hf() {
        return w.en();
    }

    public static xj w() {
        return hf;
    }

    public static void xj() {
        Boolean bool;
        JSONObject en = w.en();
        y = en.optInt("disable_task_setting", 0) == 1;
        w = en.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = en.optJSONObject("bugfix");
        if (optJSONObject == null || !optJSONObject.has("default")) {
            bool = null;
        } else {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        u = optJSONObject;
        kd = bool;
    }

    public static boolean y(String str) {
        JSONObject jSONObject = w;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public JSONArray kd(String str) {
        JSONObject jSONObject = this.f;
        return (jSONObject == null || !jSONObject.has(str) || y(str)) ? hf().optJSONArray(str) : this.f.optJSONArray(str);
    }

    public JSONObject u(String str) {
        JSONObject jSONObject = this.f;
        return (jSONObject == null || !jSONObject.has(str) || y(str)) ? hf().optJSONObject(str) : this.f.optJSONObject(str);
    }

    public boolean hf(String str, boolean z) {
        if (this.d != null && !y(str)) {
            if (this.d.has(str)) {
                return this.d.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.tf;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = u;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return u.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = kd;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public String w(String str) {
        return xj(str, "");
    }

    private static xj w(int i) {
        DownloadInfo downloadInfo;
        if (y) {
            return hf;
        }
        Context tj = w.tj();
        if (tj != null && (downloadInfo = Downloader.getInstance(tj).getDownloadInfo(i)) != null) {
            return hf(downloadInfo);
        }
        return hf;
    }

    public static void xj(String str, boolean z) {
        try {
            if (u == null) {
                u = new JSONObject();
            }
            u.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    public static xj xj(int i) {
        return xj(i, (DownloadInfo) null);
    }

    public int hf(String str) {
        return xj(str, 0);
    }

    public static void hf(int i) {
        xj xjVar = c;
        if (xjVar != null && xjVar.p == i) {
            c = null;
        }
        f<Integer, xj> fVar = xj;
        synchronized (fVar) {
            fVar.remove(Integer.valueOf(i));
        }
    }

    public static xj xj(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return hf;
        }
        return xj(downloadInfo.getId(), downloadInfo);
    }

    private static xj xj(int i, DownloadInfo downloadInfo) {
        xj xjVar;
        xj xjVar2 = c;
        if (xjVar2 != null && xjVar2.p == i) {
            return xjVar2;
        }
        f<Integer, xj> fVar = xj;
        synchronized (fVar) {
            xjVar = fVar.get(Integer.valueOf(i));
        }
        if (xjVar == null) {
            xjVar = downloadInfo == null ? w(i) : hf(downloadInfo);
            synchronized (fVar) {
                fVar.put(Integer.valueOf(i), xjVar);
            }
        }
        xjVar.p = i;
        c = xjVar;
        return xjVar;
    }

    private static xj hf(DownloadInfo downloadInfo) {
        if (y) {
            return hf;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new xj(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        return hf;
    }

    public boolean xj(String str) {
        return hf(str, false);
    }

    public int xj(String str, int i) {
        JSONObject jSONObject = this.f;
        if (jSONObject != null && jSONObject.has(str) && !y(str)) {
            return this.f.optInt(str, i);
        }
        return hf().optInt(str, i);
    }

    public long xj(String str, long j) {
        JSONObject jSONObject = this.f;
        if (jSONObject != null && jSONObject.has(str) && !y(str)) {
            return this.f.optLong(str, j);
        }
        return hf().optLong(str, j);
    }

    public double xj(String str, double d) {
        JSONObject jSONObject = this.f;
        if (jSONObject != null && jSONObject.has(str) && !y(str)) {
            return this.f.optDouble(str, d);
        }
        return hf().optDouble(str, d);
    }

    public String xj(String str, String str2) {
        JSONObject jSONObject = this.f;
        if (jSONObject != null && jSONObject.has(str) && !y(str)) {
            return this.f.optString(str, str2);
        }
        return hf().optString(str, str2);
    }

    public static xj xj(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != hf() && !y) {
            xj xjVar = c;
            if (xjVar != null && xjVar.f == jSONObject) {
                return xjVar;
            }
            f<Integer, xj> fVar = xj;
            synchronized (fVar) {
                try {
                    for (xj xjVar2 : fVar.values()) {
                        if (xjVar2.f == jSONObject) {
                            c = xjVar2;
                            return xjVar2;
                        }
                    }
                    xj xjVar3 = new xj(jSONObject);
                    c = xjVar3;
                    return xjVar3;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return hf;
    }

    public static void xj(int i, JSONObject jSONObject) {
        xj xjVar;
        if (jSONObject == null || jSONObject == hf() || y) {
            return;
        }
        f<Integer, xj> fVar = xj;
        synchronized (fVar) {
            try {
                xj xjVar2 = c;
                if (xjVar2 != null && xjVar2.f == jSONObject) {
                    xjVar2.p = i;
                } else {
                    Iterator<xj> it = fVar.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            xjVar = null;
                            break;
                        }
                        xjVar = it.next();
                        if (xjVar.f == jSONObject) {
                            xjVar.p = i;
                            break;
                        }
                    }
                    if (xjVar == null) {
                        xjVar2 = new xj(jSONObject);
                        xjVar2.p = i;
                    } else {
                        xjVar2 = xjVar;
                    }
                    c = xjVar2;
                }
                xj.put(Integer.valueOf(i), xjVar2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
