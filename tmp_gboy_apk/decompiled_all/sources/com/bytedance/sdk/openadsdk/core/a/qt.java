package com.bytedance.sdk.openadsdk.core.a;

import android.content.Intent;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class qt {
    private static volatile qt xj;
    private com.bytedance.sdk.component.u.hf.w hf;

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.u.hf.w hf() {
        if (this.hf == null) {
            this.hf = j.xj("hide_recent_activity_recorder");
        }
        return this.hf;
    }

    public static qt xj() {
        if (xj == null) {
            synchronized (qt.class) {
                try {
                    if (xj == null) {
                        xj = new qt();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void xj(Intent intent) {
        final boolean z = (intent.getFlags() & 8388608) == 8388608;
        com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.qt.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                int i2 = qt.this.hf().get("all_activity_count", 0) + 1;
                if (z) {
                    int i3 = qt.this.hf().get("hide_activity_count", 0) + 1;
                    if (i3 >= 10) {
                        qt.this.xj(i2);
                        i2 = 0;
                    } else {
                        i = i3;
                    }
                    qt.this.hf().put("hide_activity_count", i);
                }
                qt.this.hf().put("all_activity_count", i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final int i) {
        try {
            com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.a.qt.2
                @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ac", i);
                    return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("hide_activity_record").hf(jSONObject.toString());
                }
            }, "hide_activity_record");
        } catch (Throwable unused) {
        }
    }
}
