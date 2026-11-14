package com.bytedance.sdk.openadsdk.core.pl;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.pl.u.qt;
import com.bytedance.sdk.openadsdk.core.pz;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c implements u {
    private w xj;

    public c(w wVar) {
        this.xj = wVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u
    public boolean xj(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u
    public boolean xj(final String str, final String str2, final String str3, final int i, final String str4, String str5, int i2, final String str6, final String str7) {
        if (!this.xj.w()) {
            return false;
        }
        long u = this.xj.u();
        final TTAdInteractionListener xj = qt.xj();
        if (xj == null || !xj(1440L, this.xj.c())) {
            return false;
        }
        com.bytedance.sdk.component.utils.f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pl.c.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("app_name", str);
                hashMap.put("app_icon_url", str2);
                hashMap.put("event_id", Integer.valueOf(i));
                hashMap.put(n.p, str3);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("value", str7);
                    jSONObject.put("log_extra", str4);
                    jSONObject.putOpt("tag", str6);
                } catch (Exception unused) {
                }
                boolean w = wo.w(pz.getContext(), str3);
                hashMap.put("event_token", com.bytedance.sdk.component.utils.xj.hf(jSONObject.toString()));
                xj.onAdEvent(w ? 102 : 101, hashMap);
            }
        }, u * 1000);
        return true;
    }

    public boolean xj(long j, int i) {
        try {
            Long l = -1L;
            try {
                l = Long.valueOf(j * 60000);
            } catch (Exception e) {
                pl.hf("notification", "error", e.getMessage());
                i = -1;
            }
            if (l.longValue() >= 0 && i >= 0 && l.longValue() != 0 && i != 0) {
                String xj = xj();
                StringBuilder sb = new StringBuilder();
                long currentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(xj)) {
                    sb.append(currentTimeMillis);
                    xj(sb.toString());
                    return true;
                }
                String[] split = xj.split("_");
                int length = split.length;
                if (length < i) {
                    Long.parseLong(split[length - 1]);
                    for (String str : split) {
                        sb.append(str);
                        sb.append("_");
                    }
                    sb.append(currentTimeMillis);
                    xj(sb.toString());
                    return true;
                }
                int i2 = length - i;
                boolean z = currentTimeMillis - Long.parseLong(split[i2]) > l.longValue();
                for (int i3 = i2; i3 < length; i3++) {
                    String str2 = split[i3];
                    if (i3 != i2 && !TextUtils.isEmpty(str2)) {
                        sb.append(str2);
                        sb.append("_");
                    }
                }
                sb.append(currentTimeMillis);
                xj(sb.toString());
                return z;
            }
            return false;
        } catch (Exception e2) {
            pl.xj(e2);
            return false;
        }
    }

    public static String xj() {
        return com.bytedance.sdk.openadsdk.core.hf.xj().get("notification_b", "");
    }

    public static void xj(String str) {
        com.bytedance.sdk.openadsdk.core.hf.xj().put("notification_b", str);
    }
}
