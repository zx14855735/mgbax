package com.bytedance.sdk.openadsdk.core.ugeno.component.u;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.adsdk.ugeno.w.zg;
import com.bytedance.adsdk.ugeno.widget.frame.UGFrameLayout;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends com.bytedance.adsdk.ugeno.widget.w.xj {
    public xj(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.w.xj, com.bytedance.adsdk.ugeno.hf.xj, com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: tu, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout xj() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.hf);
        uGFrameLayout.xj(this);
        return uGFrameLayout;
    }

    public void xj(long j, long j2) {
        zg zgVar;
        JSONObject w;
        if (!xj(12) || (zgVar = this.oa.get(12)) == null || (w = zgVar.w()) == null) {
            return;
        }
        w.optString(PointParamKey.TYPE);
        JSONArray optJSONArray = w.optJSONArray("actions");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(PointParamKey.TYPE);
                int optInt = optJSONObject.optInt(PointCategory.PROGRESS) * 1000;
                if (optInt > j2) {
                    optInt = (int) j2;
                }
                if (j == optInt && TextUtils.equals(optString, "onShow")) {
                    w hf = hf(this);
                    String optString2 = optJSONObject.optString("nodeId");
                    if (hf != null) {
                        hf.u(optString2).hf(0);
                    }
                }
            }
        }
    }
}
