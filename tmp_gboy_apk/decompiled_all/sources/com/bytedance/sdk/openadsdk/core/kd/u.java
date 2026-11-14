package com.bytedance.sdk.openadsdk.core.kd;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.et;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.w.y;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    public static boolean xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, ws wsVar, boolean z) {
        if (!pz.hf().hf(hfVar.u())) {
            return true;
        }
        if (wsVar == null) {
            am.xj().hf(3);
            return false;
        }
        String pz = hfVar.pz();
        long ra = wsVar.ra();
        String en = wsVar.en();
        try {
            if (TextUtils.isEmpty(pz)) {
                am.xj().hf(1);
                return false;
            }
            JSONObject xj = y.xj(new JSONObject(pz), false, true);
            if (xj == null) {
                am.xj().hf(1);
                return false;
            }
            et.xj xj2 = et.xj.xj(xj, hfVar, null);
            com.bytedance.sdk.openadsdk.core.ra.xj xjVar = xj2.f;
            if (xjVar == null) {
                am.xj().hf(1);
                return false;
            }
            xjVar.xj(xj);
            List<ws> hf = xj2.f.hf();
            if (hf == null) {
                am.xj().hf(1);
                return false;
            }
            for (ws wsVar2 : hf) {
                if (TextUtils.isEmpty(wsVar2.en())) {
                    am.xj().hf(2);
                    return false;
                }
                if (!wsVar2.z()) {
                    am.xj().hf(5);
                    return false;
                }
                if (TextUtils.equals(wsVar2.en(), en)) {
                    wsVar.q(wsVar2.co());
                    if (wsVar.a() + ra >= System.currentTimeMillis()) {
                        return true;
                    }
                    com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(z ? 7 : 8).xj(hfVar.u());
                    am.xj().hf(4);
                    return false;
                }
            }
            am.xj().hf(3);
            return false;
        } catch (Exception e) {
            am.xj().hf(1000);
            pl.xj(e);
            return false;
        }
    }
}
