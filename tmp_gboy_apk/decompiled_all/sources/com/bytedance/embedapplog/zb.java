package com.bytedance.embedapplog;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class zb implements w {
    private static volatile zb xj;
    private final CopyOnWriteArraySet<w> hf = new CopyOnWriteArraySet<>();

    private zb() {
    }

    public static zb xj() {
        if (xj == null) {
            synchronized (zb.class) {
                try {
                    if (xj == null) {
                        xj = new zb();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    @Override // com.bytedance.embedapplog.w
    public void hf(boolean z, JSONObject jSONObject) {
        Iterator<w> it = this.hf.iterator();
        while (it.hasNext()) {
            it.next().hf(z, jSONObject);
        }
    }

    @Override // com.bytedance.embedapplog.w
    public void xj(String str, String str2, String str3) {
        Iterator<w> it = this.hf.iterator();
        while (it.hasNext()) {
            it.next().xj(str, str2, str3);
        }
    }

    @Override // com.bytedance.embedapplog.w
    public void xj(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<w> it = this.hf.iterator();
        while (it.hasNext()) {
            it.next().xj(z, str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.bytedance.embedapplog.w
    public void xj(boolean z, JSONObject jSONObject) {
        Iterator<w> it = this.hf.iterator();
        while (it.hasNext()) {
            it.next().xj(z, jSONObject);
        }
    }
}
