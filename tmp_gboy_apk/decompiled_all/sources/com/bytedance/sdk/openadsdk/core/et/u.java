package com.bytedance.sdk.openadsdk.core.et;

import android.content.Context;
import android.location.Address;
import com.bytedance.sdk.openadsdk.core.a.j;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.yo;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements com.bytedance.sdk.component.d.w.hf {
    private Context w;
    String xj = "sp_multi_ttadnet_config";
    com.bytedance.sdk.component.u.hf.w hf = j.xj("sp_multi_ttadnet_config");

    public u(Context context) {
        this.w = context;
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public Context getContext() {
        return this.w;
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public String hf() {
        return "openadsdk";
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public String kd() {
        return yo.w();
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public int u() {
        return ai.w;
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public String w() {
        return "android";
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public Address xj(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public String[] y() {
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public int xj() {
        return Integer.parseInt("1371");
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public String xj(Context context, String str, String str2) {
        return this.hf.get(str, str2);
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public void xj(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.hf.put(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.hf.put(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.hf.put(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.hf.put(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.hf.put(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
