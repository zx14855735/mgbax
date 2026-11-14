package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa;

import Dphsd2.AlLFFp;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaau;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan;
import io.dcloud.openapi.core.module.DCBaseAOL;
import io.dcloud.openapi.core.util.Const;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaa0 {
    private boolean aaaaaaaa = false;

    public void aaaaaaa0(Activity activity, DCBaseAOL dCBaseAOL) {
        aaaaaaau.aaaaaaaa("on ad show");
        if (dCBaseAOL == null) {
            return;
        }
        aaaaaaaa(activity, 40, dCBaseAOL, dCBaseAOL.aaoaaaaa(), String.valueOf(dCBaseAOL.aeaaaaaa()), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaa0(dCBaseAOL), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaaa(dCBaseAOL));
    }

    public abstract Activity aaaaaaaa();

    public void aaaaaaaa(int i, String str, String str2, String str3, JSONArray jSONArray, long j) {
        if (jSONArray == null || jSONArray.length() == 0 || i == 14) {
            return;
        }
        this.aaaaaaaa = true;
        if (aaaaaaao()) {
            HashMap hashMap = new HashMap();
            hashMap.put(PointParamKey.TYPE, i != 1 ? i != 7 ? i != 15 ? i != 4 ? i != 5 ? i != 9 ? i != 10 ? "" : "draw_flow" : "rewarded" : "video_paste" : ClickCommon.CLICK_SCENE_TEMPLATE : MediationConstant.RIT_TYPE_INTERSTITIAL : "full_screen_video" : MediationConstant.RIT_TYPE_SPLASH);
            hashMap.put("adpid", str);
            hashMap.put("ord", str2);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put(n.m, str3);
            }
            hashMap.put("rsp", jSONArray);
            hashMap.put("tid", 60);
            hashMap.put("lt", Long.valueOf(j));
            aaaaaaan.aaaaaaaa().aaaaaaaa(new AlLFFp(10, this, str, hashMap));
        }
    }

    public abstract boolean aaaaaaao();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aaaaaaaa(String str, HashMap hashMap) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaanaa.aaaaaaaa.aaaaaaaa(aaaaaaaa(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAppId(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAdId(), 60, str, hashMap);
    }

    private void aaaaaaaa(final Context context, final int i, final DCBaseAOL dCBaseAOL, final String str, final String str2, final String str3, final String str4) {
        if (i == 40) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaaa(context, dCBaseAOL.getDCloudId(), dCBaseAOL.getType());
        }
        final HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(dCBaseAOL.aoaaaaaa())) {
            hashMap.put(n.m, dCBaseAOL.aoaaaaaa());
        }
        aaaaaaan.aaaaaaaa().aaaaaaaa(new Runnable() { // from class: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.A2egSU
            @Override // java.lang.Runnable
            public final void run() {
                aaaaaaa0.aaaaaaaa(context, dCBaseAOL, i, hashMap, str, str2, str3, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void aaaaaaaa(Context context, DCBaseAOL dCBaseAOL, int i, HashMap hashMap, String str, String str2, String str3, String str4) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaanaa.aaaaaaaa.aaaaaaaa(context, dCBaseAOL.aaaaaaea(), dCBaseAOL.getSlotId(), dCBaseAOL.getTid(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAppId(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAdId(), i, dCBaseAOL.getDCloudId(), hashMap, str, str2, str3, str4);
    }

    public void aaaaaaaa(Activity activity, DCBaseAOL dCBaseAOL) {
        aaaaaaau.aaaaaaaa("on ad click");
        if (dCBaseAOL == null) {
            return;
        }
        aaaaaaaa(activity, 41, dCBaseAOL, null, null, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaa0(dCBaseAOL), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aauaaaaa.aaaaaaaa.aaaaaaaa(dCBaseAOL));
    }

    public void aaaaaaaa(final Activity activity, final DCBaseAOL dCBaseAOL, long j, final String str, final int i) {
        if (dCBaseAOL != null && Const.TYPE_GG.equals(dCBaseAOL.getType())) {
            final float f = j / 1000000.0f;
            aaaaaaau.aaaaaaaa("on ad paid");
            aaaaaaan.aaaaaaaa().aaaaaaaa(new Runnable() { // from class: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.A4TApA
                @Override // java.lang.Runnable
                public final void run() {
                    aaaaaaa0.aaaaaaaa(activity, dCBaseAOL, f, str, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void aaaaaaaa(Activity activity, DCBaseAOL dCBaseAOL, float f, String str, int i) {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaanaa.aaaaaaaa.aaaaaaaa(activity, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAppId(), dCBaseAOL.getDCloudId(), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAdId(), dCBaseAOL.aaaaaaea(), dCBaseAOL.getSlotId(), String.format(Locale.ENGLISH, "%f", Float.valueOf(f)), str, i, dCBaseAOL.aaoaaaaa());
    }
}
