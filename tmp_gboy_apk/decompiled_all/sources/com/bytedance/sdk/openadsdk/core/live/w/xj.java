package com.bytedance.sdk.openadsdk.core.live.w;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.am.c;
import com.bytedance.sdk.openadsdk.core.am.u;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.v;
import com.sigmob.sdk.base.n;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private String xj = "";

    public xj xj(String str) {
        this.xj = str;
        return this;
    }

    public void xj(final Context context, final ws wsVar) {
        if (wsVar == null || wsVar.yt() == null || TextUtils.isEmpty(wsVar.yt().hf())) {
            return;
        }
        v.y().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.w.xj.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(wsVar.yt().hf()));
                    intent.addFlags(C.ENCODING_PCM_MU_LAW);
                    if (com.bytedance.sdk.component.utils.hf.xj(context, intent, null, TextUtils.equals("main", "internal"))) {
                        u.xj(wsVar, xj.this.xj, "deeplink_success_realtime", (Throwable) null);
                    } else {
                        u.xj(wsVar, xj.this.xj, "deeplink_fail_realtime", (Throwable) null);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(n.l, "LiveDoubleOpenProcessor");
                    u.f(wsVar, xj.this.xj, "open_url_app", hashMap);
                    c.xj().xj(wsVar, xj.this.xj, false);
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        }, 50L);
    }
}
