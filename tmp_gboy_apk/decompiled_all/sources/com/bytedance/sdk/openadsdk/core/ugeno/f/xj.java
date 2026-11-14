package com.bytedance.sdk.openadsdk.core.ugeno.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.adsdk.ugeno.kd.y;
import com.bytedance.adsdk.ugeno.w.am;
import com.bytedance.adsdk.ugeno.w.jk;
import com.bytedance.adsdk.ugeno.w.qt;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.adsdk.ugeno.w.zg;
import com.bytedance.sdk.openadsdk.core.a.dk;
import com.bytedance.sdk.openadsdk.core.et.hf;
import com.bytedance.sdk.openadsdk.core.hf.hf;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.c;
import com.bytedance.sdk.openadsdk.core.ugeno.webview.PageWebView;
import com.bytedance.sdk.openadsdk.core.v;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements jk, yo {
    private hf c;
    private JSONObject d;
    private tf f;
    private ViewGroup hf;
    private w kd;
    private Map<String, Object> tf;
    private ws u;
    private com.bytedance.sdk.openadsdk.core.ugeno.y.xj w;
    private Context xj;
    private com.bytedance.sdk.openadsdk.core.ugeno.u.xj y;

    public xj(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.ugeno.y.xj xjVar, ws wsVar) {
        this.xj = context;
        this.hf = viewGroup;
        this.w = xjVar;
        this.u = wsVar;
    }

    @Override // com.bytedance.adsdk.ugeno.w.yo
    public void xj(w wVar, String str, y.xj xjVar) {
    }

    public void hf() {
        PageWebView.xj(this.d);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.ugeno.u.xj xjVar) {
        this.y = xjVar;
    }

    public void xj(DownloadListener downloadListener) {
        PageWebView.xj(this.d, downloadListener);
    }

    public void xj() {
        com.bytedance.sdk.openadsdk.core.ugeno.y.xj xjVar = this.w;
        if (xjVar == null) {
            com.bytedance.sdk.openadsdk.core.ugeno.u.xj xjVar2 = this.y;
            if (xjVar2 != null) {
                xjVar2.xj(-1);
                return;
            }
            return;
        }
        JSONObject xj = c.xj().xj(xjVar.xj(), this.w.hf());
        if (xj == null) {
            com.bytedance.sdk.openadsdk.core.et.hf.xj(this.w, new hf.InterfaceC0163hf() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.f.xj.1
                @Override // com.bytedance.sdk.openadsdk.core.et.hf.InterfaceC0163hf
                public void xj(JSONObject jSONObject) {
                    xj.this.xj(jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.core.et.hf.InterfaceC0163hf
                public void xj() {
                    if (xj.this.y != null) {
                        xj.this.y.xj(-1);
                    }
                }
            });
        } else {
            xj(xj);
        }
    }

    public void xj(final JSONObject jSONObject) {
        final qt qtVar = new qt(this.xj);
        final JSONObject ac = this.u.ac();
        this.d = ac;
        am amVar = new am();
        amVar.xj(this.xj);
        HashMap hashMap = new HashMap();
        hashMap.put("key_reward_page", this.tf);
        amVar.xj(hashMap);
        qtVar.xj("reward_page", amVar);
        qtVar.xj((yo) this);
        v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.f.xj.2
            @Override // java.lang.Runnable
            public void run() {
                xj.this.kd = qtVar.xj(jSONObject);
                if (xj.this.kd == null) {
                    if (xj.this.y != null) {
                        xj.this.y.xj(-1);
                    }
                } else {
                    qtVar.hf(ac);
                    xj.this.hf.addView(xj.this.kd.d(), new FrameLayout.LayoutParams(xj.this.kd.l(), xj.this.kd.ff()));
                    if (xj.this.y != null) {
                        xj.this.y.xj(xj.this.kd.d());
                    }
                }
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.w.yo
    public void xj(zg zgVar, yo.hf hfVar, yo.xj xjVar) {
        if (zgVar != null && zgVar.hf() == 1) {
            xj(zgVar, zgVar.w());
        }
    }

    private void xj(zg zgVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(PointParamKey.TYPE);
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        optString.getClass();
        if (!optString.equals("clickEvent")) {
            if (optString.equals("openPolicy")) {
                com.bytedance.sdk.openadsdk.core.a.y.xj(this.xj, this.u);
            }
        } else {
            com.bytedance.sdk.openadsdk.core.hf.hf hfVar = this.c;
            if (hfVar != null) {
                hfVar.xj(zgVar.xj().d(), this.f);
            }
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.core.hf.hf hfVar) {
        this.c = hfVar;
    }

    @Override // com.bytedance.adsdk.ugeno.w.jk
    public void xj(w wVar, MotionEvent motionEvent) {
        this.f.w(motionEvent.getDeviceId());
        this.f.hf(motionEvent.getToolType(0));
        this.f.u(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.f.w(motionEvent.getRawX());
                this.f.u(motionEvent.getRawY());
                this.f.hf(System.currentTimeMillis());
                return;
            } else {
                if (actionMasked != 2) {
                    return;
                }
                this.f.w(motionEvent.getRawX());
                this.f.u(motionEvent.getRawY());
                return;
            }
        }
        this.f.kd((int) motionEvent.getRawX());
        this.f.y((int) motionEvent.getRawY());
        this.f.xj(motionEvent.getRawX());
        this.f.hf(motionEvent.getRawY());
        this.f.xj(System.currentTimeMillis());
        this.f.hf(motionEvent.getToolType(0));
        this.f.w(motionEvent.getDeviceId());
        this.f.u(motionEvent.getSource());
        this.f.xj(true);
        dk.xj(motionEvent);
    }

    public void xj(Map<String, Object> map) {
        this.tf = map;
    }
}
