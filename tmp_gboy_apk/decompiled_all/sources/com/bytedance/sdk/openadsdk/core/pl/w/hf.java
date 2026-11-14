package com.bytedance.sdk.openadsdk.core.pl.w;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.zg;
import com.sigmob.sdk.base.n;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends y {
    public hf(Context context, ws wsVar, String str, boolean z) {
        super(context, wsVar, str, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd
    public boolean y() {
        if (this.kd.yt() == null) {
            return false;
        }
        String hf = this.kd.yt().hf();
        if (!TextUtils.isEmpty(hf)) {
            zg.xj((String) null);
            Uri parse = Uri.parse(hf);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            wo.hf(intent);
            if (this.e) {
                com.bytedance.sdk.openadsdk.core.am.u.hf(this.kd, this.y, "lp_open_dpl", xj(hf));
            }
            try {
                Context context = getContext();
                if (!(context instanceof Activity)) {
                    intent.addFlags(C.ENCODING_PCM_MU_LAW);
                }
                if (!xj(this.y, "open_url_app", this.kd)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(n.l, "AndroidRDMLicManager");
                    com.bytedance.sdk.openadsdk.core.am.u.f(this.kd, this.y, "open_url_app", hashMap);
                }
                wo.xj(this.e, this.kd, this.y);
                com.bytedance.sdk.component.utils.hf.startActivity(context, intent, TextUtils.equals("main", "internal"));
                com.bytedance.sdk.openadsdk.core.am.c.xj().xj(this.kd, this.y, this.e);
                if (this.e) {
                    com.bytedance.sdk.openadsdk.core.am.u.w(this.kd, this.y, "lp_openurl");
                    com.bytedance.sdk.openadsdk.core.am.u.xj(this.kd, this.y, "lp_deeplink_success_realtime", (Throwable) null);
                } else {
                    com.bytedance.sdk.openadsdk.core.am.u.xj(this.kd, this.y, "deeplink_success_realtime", (Throwable) null);
                }
                return true;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.core.am.u.w(this.kd, this.y, "open_fallback_download");
                if (this.e) {
                    com.bytedance.sdk.openadsdk.core.am.u.w(this.kd, this.y, "lp_openurl_failed");
                    xj(this.kd, this.y, "lp_deeplink_fail_realtime", th);
                } else {
                    xj(this.kd, this.y, "deeplink_fail_realtime", th);
                }
            }
        }
        if (this.c.get() == 4 || this.c.get() == 3) {
            return false;
        }
        if (this.d && !this.f.get()) {
            return false;
        }
        this.d = true;
        if (xj(this.y, "open_fallback_url", this.kd)) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.am.u.f(this.kd, this.y, "open_fallback_url", null);
        return false;
    }
}
