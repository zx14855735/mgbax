package com.bytedance.msdk.core.y;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.xj.kd.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private final Map<String, com.bytedance.msdk.api.u.xj.hf.y.xj> xj = new ConcurrentHashMap();

    public Map<String, Object> hf(Context context, Map<String, Object> map, String str) {
        u.xj(context);
        com.bytedance.msdk.api.u.xj.hf.y.xj xj = xj(str);
        if (xj != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("buyerId", xj.xj(context, map));
            hashMap.put("sdkInfo", xj.hf(context, map));
            return hashMap;
        }
        com.bytedance.msdk.xj.xj.u hf = hf(str);
        if (hf == null) {
            return null;
        }
        return hf.hf(context, map);
    }

    public Map<String, com.bytedance.msdk.api.u.xj.hf.y.xj> xj() {
        return this.xj;
    }

    public void xj(String str, com.bytedance.msdk.api.u.xj.hf.y.xj xjVar) {
        this.xj.put(str, xjVar);
    }

    public com.bytedance.msdk.api.u.xj.hf.y.xj xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.xj.get(str);
    }

    public String xj(Context context, Map<String, Object> map, String str) {
        u.xj(context);
        com.bytedance.msdk.api.u.xj.hf.y.xj xj = xj(str);
        if (xj != null) {
            return xj.xj(null, null);
        }
        com.bytedance.msdk.xj.xj.u hf = hf(str);
        if (hf == null) {
            return null;
        }
        return hf.xj(context, map);
    }

    public com.bytedance.msdk.xj.xj.u hf(String str) {
        return com.bytedance.msdk.y.hf.hf.xj().xj(str);
    }
}
