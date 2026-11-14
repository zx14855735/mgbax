package com.bytedance.sdk.component.d.w;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private static final Object u = new Object();
    private w hf = new w();
    private int kd;
    private boolean w;
    private Context xj;

    static {
        UFqsWw();
    }

    public u(Context context, boolean z, int i) {
        this.xj = context;
        this.w = z;
        this.kd = i;
    }

    private static /* synthetic */ void UFqsWw() {
        char[] charArray = "3?=~71=5~2?)~#85<<~\u001a>9\u0012\"9475".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'P');
        }
        String str = new String(charArray);
        char[] charArray2 = "3<9>9$".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'P');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void hf() {
        try {
            String xj = com.bytedance.sdk.component.d.u.u.xj(this.xj, 1, this.kd);
            if (TextUtils.isEmpty(xj)) {
                com.bytedance.sdk.component.d.u.w.hf("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            w hf = hf(new JSONObject(xj));
            StringBuilder sb = new StringBuilder("loadLocalConfigForOtherProcess, config: ");
            sb.append(hf == null ? "null" : hf.toString());
            com.bytedance.sdk.component.d.u.w.hf("TNCConfigHandler", sb.toString());
            if (hf != null) {
                this.hf = hf;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.d.u.w.hf("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    public w w() {
        return this.hf;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0126 A[Catch: all -> 0x0074, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0074, blocks: (B:8:0x001d, B:11:0x0028, B:15:0x0042, B:16:0x0048, B:18:0x004e, B:20:0x006a, B:22:0x0077, B:25:0x007a, B:27:0x0080, B:28:0x0089, B:30:0x008f, B:31:0x0099, B:33:0x009f, B:36:0x00ae, B:39:0x00b8, B:40:0x00d4, B:43:0x00ea, B:55:0x0126, B:67:0x00e6, B:69:0x00c2, B:71:0x00cf), top: B:7:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e6 A[Catch: all -> 0x0074, TryCatch #3 {all -> 0x0074, blocks: (B:8:0x001d, B:11:0x0028, B:15:0x0042, B:16:0x0048, B:18:0x004e, B:20:0x006a, B:22:0x0077, B:25:0x007a, B:27:0x0080, B:28:0x0089, B:30:0x008f, B:31:0x0099, B:33:0x009f, B:36:0x00ae, B:39:0x00b8, B:40:0x00d4, B:43:0x00ea, B:55:0x0126, B:67:0x00e6, B:69:0x00c2, B:71:0x00cf), top: B:7:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2 A[Catch: all -> 0x0074, TryCatch #3 {all -> 0x0074, blocks: (B:8:0x001d, B:11:0x0028, B:15:0x0042, B:16:0x0048, B:18:0x004e, B:20:0x006a, B:22:0x0077, B:25:0x007a, B:27:0x0080, B:28:0x0089, B:30:0x008f, B:31:0x0099, B:33:0x009f, B:36:0x00ae, B:39:0x00b8, B:40:0x00d4, B:43:0x00ea, B:55:0x0126, B:67:0x00e6, B:69:0x00c2, B:71:0x00cf), top: B:7:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(org.json.JSONObject r10) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.w.u.xj(org.json.JSONObject):void");
    }

    private w hf(JSONObject jSONObject) {
        try {
            w wVar = new w();
            if (jSONObject.has("local_enable")) {
                wVar.xj = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                wVar.hf = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap hashMap = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(string, 0);
                        }
                    }
                }
                wVar.w = hashMap;
            } else {
                wVar.w = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap hashMap2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            hashMap2.put(next, string2);
                        }
                    }
                }
                wVar.u = hashMap2;
            } else {
                wVar.u = null;
            }
            wVar.kd = jSONObject.optInt("req_to_cnt", wVar.kd);
            wVar.y = jSONObject.optInt("req_to_api_cnt", wVar.y);
            wVar.c = jSONObject.optInt("req_to_ip_cnt", wVar.c);
            wVar.f = jSONObject.optInt("req_err_cnt", wVar.f);
            wVar.d = jSONObject.optInt("req_err_api_cnt", wVar.d);
            wVar.tf = jSONObject.optInt("req_err_ip_cnt", wVar.tf);
            wVar.p = jSONObject.optInt("update_interval", wVar.p);
            wVar.f10201pl = jSONObject.optInt("update_random_range", wVar.f10201pl);
            wVar.g = jSONObject.optString("http_code_black", wVar.g);
            return wVar;
        } catch (Throwable th) {
            pl.xj(th);
            return null;
        }
    }

    public void xj() {
        if (this.w) {
            String string = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(this.xj, c.xj().xj(this.kd).xj(), 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                com.bytedance.sdk.component.d.u.w.hf("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                w hf = hf(new JSONObject(string));
                if (hf != null) {
                    this.hf = hf;
                }
                StringBuilder sb = new StringBuilder("loadLocalConfig: ");
                sb.append(hf == null ? "null" : hf.toString());
                com.bytedance.sdk.component.d.u.w.hf("TNCConfigHandler", sb.toString());
            } catch (Throwable th) {
                pl.xj(th);
                com.bytedance.sdk.component.d.u.w.hf("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }
}
