package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.dq;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class jk {
    private boolean c = true;
    private NativeExpressView d;
    private int f;
    private int hf;
    private String kd;
    private int u;
    private List<com.bytedance.sdk.openadsdk.core.ra.qt> w;
    private double xj;
    private List<com.bytedance.adsdk.ugeno.hf.w<View>> y;

    public jk(ws wsVar, JSONObject jSONObject, NativeExpressView nativeExpressView) {
        com.bytedance.sdk.openadsdk.core.ra.qt xj;
        this.u = -1;
        this.f = -1;
        this.d = nativeExpressView;
        this.f = wo.xj(wsVar);
        if (jSONObject != null) {
            this.xj = jSONObject.optDouble("slide_threshold", 0.0d);
            this.hf = jSONObject.optInt("direction", 30);
            this.u = jSONObject.optInt(PointParamKey.TYPE, -1);
            this.kd = jSONObject.optString("rgb_color");
            JSONArray optJSONArray = jSONObject.optJSONArray("rects");
            if (optJSONArray != null) {
                this.w = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null && (xj = com.bytedance.sdk.openadsdk.core.ra.qt.xj(optJSONObject)) != null) {
                        this.w.add(xj);
                    }
                }
            }
        }
        List<com.bytedance.sdk.openadsdk.core.ra.qt> list = this.w;
        com.bytedance.sdk.component.utils.pl.xj("xdy", "priority:" + this.f + " dirction:" + this.hf + " type:" + this.u + " hold:" + this.xj + " size:" + (list != null ? list.size() : 0));
    }

    public void hf() {
        this.d.jk();
    }

    public void u() {
        this.c = false;
    }

    public boolean w() {
        return this.c;
    }

    public void xj(NativeExpressView nativeExpressView) {
        if (this.w != null) {
            Context context = nativeExpressView.getContext();
            for (com.bytedance.sdk.openadsdk.core.ra.qt qtVar : this.w) {
                View siteGestureView = new SiteGestureView(context, new dq(this.u, this.xj, this.hf, this.f), this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(r.w(context, (float) qtVar.w), r.w(context, (float) qtVar.u));
                layoutParams.leftMargin = r.w(context, (float) qtVar.xj);
                layoutParams.topMargin = r.w(context, (float) qtVar.hf);
                try {
                    if (!TextUtils.isEmpty(this.kd) && com.bytedance.sdk.component.utils.pl.w()) {
                        siteGestureView.setBackgroundColor(Color.parseColor(this.kd));
                    }
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
                nativeExpressView.addView(siteGestureView, layoutParams);
                com.bytedance.sdk.component.utils.pl.xj("xdy", "(" + qtVar.xj + "," + qtVar.hf + "," + qtVar.w + "," + qtVar.u + ")");
            }
        }
    }

    public boolean xj() {
        View d;
        List<com.bytedance.adsdk.ugeno.hf.w<View>> list = this.y;
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.bytedance.adsdk.ugeno.hf.w<View> wVar : this.y) {
            if (wVar != null && (d = wVar.d()) != null && d.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void xj(List<com.bytedance.adsdk.ugeno.hf.w<View>> list) {
        this.y = list;
    }

    public void xj(MotionEvent motionEvent) {
        this.d.xj(motionEvent);
    }

    public void xj(View view, int i, com.bytedance.sdk.component.adexpress.w wVar, dq dqVar) {
        NativeExpressView nativeExpressView = this.d;
        if (nativeExpressView != null) {
            nativeExpressView.xj(view, i, wVar, dqVar);
        }
    }
}
