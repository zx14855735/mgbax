package com.bytedance.sdk.openadsdk.core.d.xj.xj.xj;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c implements com.bytedance.sdk.openadsdk.core.d.xj.xj.xj {
    private Context hf;
    private String u;
    private ws w;
    private com.bytedance.sdk.openadsdk.core.ra.kd xj;

    public c(com.bytedance.sdk.openadsdk.core.ra.kd kdVar, Context context) {
        this.xj = kdVar;
        this.hf = context;
    }

    private void hf() {
        new CountDownTimer(3000L, 3000L) { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.c.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (com.bytedance.sdk.openadsdk.core.f.zg() == null || com.bytedance.sdk.openadsdk.core.f.zg().xj()) {
                    c.this.xj(true);
                } else {
                    c.this.xj(false);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    public void xj(ws wsVar) {
        this.w = wsVar;
    }

    public boolean hf(String str) {
        if (this.hf == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            com.bytedance.sdk.component.utils.hf.startActivity(this.hf, intent, TextUtils.equals("main", "internal"));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void xj(String str) {
        this.u = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.d.xj.xj.xj
    public boolean xj(Map<String, Object> map) {
        return xj();
    }

    private boolean xj() {
        com.bytedance.sdk.openadsdk.core.ra.kd kdVar = this.xj;
        if (kdVar == null) {
            return false;
        }
        String xj = kdVar.xj();
        if (jk.y(this.w) != 3 || TextUtils.isEmpty(xj)) {
            return false;
        }
        boolean hf = hf(xj);
        if (hf) {
            hf();
            return hf;
        }
        xj(false);
        return hf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(boolean z) {
        if (z) {
            com.bytedance.sdk.openadsdk.core.am.u.hf(this.w, this.u, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.core.am.u.hf(this.w, this.u, "quickapp_fail");
        }
    }
}
