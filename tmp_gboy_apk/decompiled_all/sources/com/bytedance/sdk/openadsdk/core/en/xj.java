package com.bytedance.sdk.openadsdk.core.en;

import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.p;
import com.bytedance.sdk.component.tf.xj.hf;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.pz;
import com.qq.e.comm.constants.ErrorCode;
import io.dcloud.openapi.core.util.Const;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static boolean hf = false;
    public static volatile boolean xj = true;

    public static void hf() {
        JSONObject bl = pz.hf().bl();
        if (bl == null) {
            return;
        }
        p pVar = p.hf;
        int optInt = bl.optInt("big_max_mum", 50);
        if (optInt > 0) {
            pVar.u(optInt);
        }
        int optInt2 = bl.optInt("core_count", 0);
        if (optInt2 > 0) {
            pVar.w(optInt2);
        }
        int optInt3 = bl.optInt("big_keep_alive", 0);
        if (optInt3 > 0) {
            pVar.xj(optInt3);
        }
        pVar.kd(bl.optBoolean("big_priority", false));
        pVar.w(bl.optBoolean("catch_oom", true));
        pVar.hf(bl.optBoolean("forbid_autosize_oom", true));
        pVar.y(bl.optBoolean("enable_proxy", true));
        xj = bl.optBoolean("can_set_crash", true);
        c.xj(bl.optBoolean("autosize", true));
        pVar.d(bl.optBoolean("report_task", false));
        pVar.hf(bl.optInt("wait_in_big", 50));
        pVar.w(bl.optInt("wait_in_little", 2000));
        pVar.u(bl.optInt("run_cost", ErrorCode.UNKNOWN_ERROR));
    }

    public static void xj() {
        if (hf) {
            return;
        }
        hf = true;
        p pVar = p.hf;
        pVar.xj(11);
        pVar.u(ai.xj());
        pVar.w(true);
        pVar.xj(true);
        pVar.hf(true);
        pVar.xj(new hf() { // from class: com.bytedance.sdk.openadsdk.core.en.xj.1
            @Override // com.bytedance.sdk.component.tf.xj.hf
            public String xj(String str) {
                return str != null ? str.startsWith(Const.TYPE_CSJ) ? str : "csj_".concat(str) : "csj_uk";
            }
        });
    }
}
