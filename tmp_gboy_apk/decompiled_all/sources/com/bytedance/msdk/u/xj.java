package com.bytedance.msdk.u;

import android.content.Context;
import android.location.Address;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.f.dk;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements com.bytedance.sdk.component.d.w.hf {
    private Context hf;
    String xj = "sp_multi_ttmadnet_config";
    private final ai w = ai.xj("sp_multi_ttmadnet_config", getContext());

    public xj(Context context) {
        this.hf = context;
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public Context getContext() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public String hf() {
        return "msdk";
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public String kd() {
        return dk.xj();
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public int u() {
        return com.bytedance.msdk.hf.hf.xj();
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public String w() {
        return "android";
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public int xj() {
        return 4741;
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public String[] y() {
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public Address xj(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public String xj(Context context, String str, String str2) {
        return this.w.hf(str, str2);
    }

    @Override // com.bytedance.sdk.component.d.w.hf
    public void xj(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.w.xj(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.w.xj(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.w.xj(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.w.xj(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.w.xj(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
