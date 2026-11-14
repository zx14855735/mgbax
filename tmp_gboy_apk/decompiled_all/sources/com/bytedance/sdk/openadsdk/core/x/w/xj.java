package com.bytedance.sdk.openadsdk.core.x.w;

import ADYaiT.CtFAbx;
import android.content.Context;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.openadsdk.ats.u;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.x.d;
import com.bytedance.sdk.openadsdk.core.x.hf;
import com.bytedance.sdk.openadsdk.core.x.tf;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends tf implements hf {
    private static volatile xj xj;
    private AtomicBoolean hf = new AtomicBoolean(false);

    private xj() {
    }

    public static String u() {
        return CtFAbx.ASJ6gh(Calendar.getInstance().get(11), "q_", am.u(pz.getContext()) ? IAdInterListener.AdReqParam.WIDTH : "c");
    }

    public static xj w() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.tf
    public JSONObject hf(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.tf
    public void xj(int i, d dVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.hf
    public String hf() {
        return "network";
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.tf
    public boolean xj() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.hf
    public String xj(String str) {
        return u.xj(hf()).get(u(), "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.hf
    public void xj(String str, String str2) {
        u.xj(hf()).put(str, str2);
    }
}
