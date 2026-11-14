package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.multipro.hf.xj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.n;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ff {
    private static boolean xj;

    public static boolean xj(ws wsVar, String str) {
        if (wsVar == null) {
            return false;
        }
        String ol = wsVar.ol();
        if (TextUtils.isEmpty(ol)) {
            return false;
        }
        return xj(ol, wsVar, str);
    }

    public static boolean xj(String str, ws wsVar, String str2) {
        return xj(pz.getContext(), str, wsVar, wo.hf(str2), str2);
    }

    public static boolean xj(Context context, String str, ws wsVar, String str2) {
        return xj(context, str, wsVar, wo.hf(str2), str2);
    }

    public static boolean xj(Context context, String str, ws wsVar, int i, String str2) {
        try {
            return com.bytedance.sdk.component.utils.hf.xj(context, xj(context, str, wsVar, i, null, str2, false), null);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean xj(Object obj) {
        if (obj == null || !(obj instanceof xj.InterfaceC0173xj)) {
            return false;
        }
        try {
            return ((xj.InterfaceC0173xj) obj).q();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Intent xj(Context context, String str, ws wsVar, int i, Object obj, String str2, boolean z) {
        Class cls;
        boolean z2 = false;
        if (com.bytedance.sdk.openadsdk.core.ugeno.tf.y(wsVar)) {
            cls = TTNativePageActivity.class;
        } else if (!(obj instanceof com.bytedance.sdk.openadsdk.zg.w.hf.d) && ws.hf(wsVar) && !xj && !xj(obj) && wo.kd(wsVar) && (wsVar == null || !wsVar.c())) {
            cls = TTVideoWebPageActivity.class;
            z2 = true;
        } else {
            cls = TTWebPageActivity.class;
        }
        Intent intent = new Intent(context, (Class<?>) cls);
        if (z2) {
            xj(context, wsVar, obj, z, intent);
        }
        xj(context, str, wsVar, i, str2, intent);
        return intent;
    }

    private static void xj(Context context, ws wsVar, Object obj, boolean z, Intent intent) {
        int i;
        if (obj != null) {
            r1 = obj instanceof xj.InterfaceC0173xj ? ((xj.InterfaceC0173xj) obj).j() : null;
            if (r1 != null) {
                intent.putExtra("multi_process_data", r1.xj().toString());
            }
        }
        if ((obj instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.hf) && (r1 = ((com.bytedance.sdk.openadsdk.core.nativeexpress.hf) obj).p()) != null) {
            intent.putExtra("multi_process_data", r1.xj().toString());
        }
        if (r1 != null) {
            intent.putExtra("video_is_auto_play", r1.u);
            com.bytedance.sdk.component.utils.pl.xj("videoDataModel", "videoDataModel=" + r1.xj().toString());
        }
        if (r1 != null || z) {
            try {
                if (r1 != null) {
                    i = (int) ((r1.c / r1.kd) * 100.0f);
                } else {
                    com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.multipro.hf.xj();
                    xjVar.c = 100L;
                    xjVar.xj = true;
                    xjVar.u = wo.pz(wsVar);
                    intent.putExtra("multi_process_data", xjVar.xj().toString());
                    i = 100;
                }
                if (wsVar.jw() == 0) {
                    intent.setComponent(new ComponentName(context, (Class<?>) TTVideoScrollWebPageActivity.class));
                } else {
                    if (wsVar.jw() <= 0 || i <= wsVar.jw() || !wo.pz(wsVar)) {
                        return;
                    }
                    intent.setComponent(new ComponentName(context, (Class<?>) TTVideoScrollWebPageActivity.class));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void xj(Context context, String str, ws wsVar, int i, String str2, Intent intent) {
        if (!new com.bytedance.sdk.openadsdk.core.pl.w.w.w(context, wsVar).u(false)) {
            wsVar.w(true);
        }
        intent.putExtra("url", str);
        intent.putExtra("gecko_id", wsVar.db());
        intent.putExtra("title", wsVar.kr());
        intent.putExtra(PluginConstants.KEY_SDK_VERSION, ai.w);
        intent.putExtra(MediationConstant.EXTRA_ADID, wsVar.ho());
        intent.putExtra("log_extra", wsVar.jf());
        intent.putExtra("icon_url", wsVar.uf() == null ? null : wsVar.uf().xj());
        intent.putExtra("event_tag", str2);
        intent.putExtra(n.l, i);
        intent.putExtra("is_outer_click", true);
        intent.putExtra("get_phone_num_status", wsVar.w());
        if (!(context instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        wo.xj(intent, wsVar);
    }

    public static boolean xj(Context context, ws wsVar, int i, String str, String str2) {
        try {
            Intent intent = new Intent(context, (Class<?>) TTNativePageActivity.class);
            intent.putExtra("is_replace_dialog", true);
            xj(context, null, wsVar, i, str, intent);
            if (ws.hf(wsVar) && !TextUtils.isEmpty(str2)) {
                intent.putExtra("multi_process_data", str2);
            }
            return com.bytedance.sdk.component.utils.hf.xj(context, intent, null);
        } catch (Throwable unused) {
            return false;
        }
    }
}
