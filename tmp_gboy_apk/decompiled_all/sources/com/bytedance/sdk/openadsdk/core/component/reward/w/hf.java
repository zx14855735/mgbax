package com.bytedance.sdk.openadsdk.core.component.reward.w;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.kd.y;
import com.bytedance.adsdk.ugeno.w.qt;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.adsdk.ugeno.w.zg;
import com.bytedance.sdk.component.p.xj.hf;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.xv;
import com.bytedance.sdk.openadsdk.core.ugeno.c.kd;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class hf {
    protected AtomicBoolean am;
    protected ws c;
    protected xv d;
    protected Activity f;
    protected xj g;
    protected String p;

    /* renamed from: pl, reason: collision with root package name */
    protected String f10325pl;
    protected String qt;
    protected qt tf;
    protected Map<String, Object> zg;

    public hf(Activity activity, ws wsVar) {
        this.g = new xj(false, 0, "");
        this.am = new AtomicBoolean(false);
        this.f = activity;
        this.c = wsVar;
    }

    public int c() {
        return 0;
    }

    public String d() {
        return !TextUtils.isEmpty(this.qt) ? this.qt : xj();
    }

    public float f() {
        return 0.55f;
    }

    public boolean hf() {
        return false;
    }

    public void kd() {
    }

    public void u() {
    }

    public void w() {
    }

    public xj xj(tf tfVar) {
        return new xj(false, 0, "");
    }

    public abstract String xj();

    public boolean y() {
        return true;
    }

    public xj hf(tf tfVar) {
        return new xj(false, 0, "");
    }

    public void u(String str) {
        this.p = str;
    }

    public void w(String str) {
        this.f10325pl = str;
    }

    public void xj(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Map<String, Object> map2 = this.zg;
        if (map2 == null) {
            this.zg = map;
        } else {
            map2.putAll(map);
        }
    }

    public void hf(String str) {
        this.qt = str;
    }

    public void u(tf tfVar) {
        if (tfVar != null) {
            tfVar.xj();
        }
    }

    public xj w(final tf tfVar) {
        if (!y()) {
            return new xj(false, 0, "");
        }
        final com.bytedance.sdk.openadsdk.core.widget.y yVar = new com.bytedance.sdk.openadsdk.core.widget.y(this.f);
        xj(yVar);
        final FrameLayout frameLayout = new FrameLayout(this.f);
        yVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.hf.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                qt qtVar = hf.this.tf;
                if (qtVar != null) {
                    qtVar.xj((yo) null);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.ugeno.y.xj xjVar = new com.bytedance.sdk.openadsdk.core.ugeno.y.xj();
        xjVar.xj(this.d.u());
        xjVar.hf(this.d.kd());
        xjVar.w(this.d.u());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        com.bytedance.sdk.openadsdk.core.ugeno.c.kd.xj(xjVar, new kd.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.hf.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.kd.xj
            public void xj(JSONObject jSONObject) {
                if (hf.this.am.get()) {
                    return;
                }
                if (jSONObject == null) {
                    hf.this.g = new xj(false, 0, "");
                    countDownLatch.countDown();
                } else {
                    hf.this.xj(yVar, frameLayout, tfVar, jSONObject);
                    hf hfVar = hf.this;
                    hfVar.g = new xj(true, hfVar.c(), hf.this.d.u(), yVar);
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        this.am.set(true);
        return this.g;
    }

    public static class xj {
        private int hf;
        private Dialog u;
        private String w;
        private boolean xj;

        public xj(boolean z, int i, String str, Dialog dialog) {
            this.xj = z;
            this.hf = i;
            this.w = str;
            this.u = dialog;
        }

        public String hf() {
            return this.w;
        }

        public void kd() {
            Dialog dialog = this.u;
            if (dialog != null) {
                dialog.dismiss();
            }
        }

        public boolean u() {
            Dialog dialog = this.u;
            if (dialog == null) {
                return false;
            }
            return dialog.isShowing();
        }

        public boolean w() {
            return this.xj;
        }

        public int xj() {
            return this.hf;
        }

        public xj(boolean z, int i, String str) {
            this(z, i, str, null);
        }
    }

    public void xj(final com.bytedance.sdk.openadsdk.core.widget.y yVar, final ViewGroup viewGroup, final tf tfVar, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(d());
        } catch (JSONException unused) {
            jSONObject2 = new JSONObject();
        }
        final View xj2 = xj(jSONObject, jSONObject2, new yo() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.hf.3
            @Override // com.bytedance.adsdk.ugeno.w.yo
            public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
            }

            @Override // com.bytedance.adsdk.ugeno.w.yo
            public void xj(zg zgVar, yo.hf hfVar, yo.xj xjVar) {
                JSONObject w = zgVar.w();
                if (w == null) {
                    return;
                }
                String optString = w.optString(PointParamKey.TYPE);
                JSONObject optJSONObject = jSONObject.optJSONObject("event_template");
                boolean optBoolean = w.optBoolean("uchain", false);
                if (optJSONObject != null && optBoolean && hf.this.c != null) {
                    yVar.dismiss();
                    wo.x();
                    com.bytedance.sdk.component.p.w.hf.INSTANCE.xj(optJSONObject);
                    HashMap hashMap = new HashMap();
                    hashMap.put("reward_dialog_callback", tfVar);
                    new hf.xj(optString).xj(hf.this.c.ac()).xj(hashMap).xj().xj();
                    return;
                }
                optString.getClass();
                if (!optString.equals("exit_watch")) {
                    if (optString.equals("continue_watch")) {
                        yVar.dismiss();
                        hf.this.u(tfVar);
                        return;
                    }
                    return;
                }
                yVar.dismiss();
                tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.hf();
                }
            }
        });
        if (xj2 == null) {
            return;
        }
        this.f.getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.hf.4
            @Override // java.lang.Runnable
            public void run() {
                viewGroup.addView(xj2);
                hf hfVar = hf.this;
                hfVar.xj(yVar, xj2, hfVar.f());
                yVar.xj(viewGroup);
                yVar.show();
            }
        });
    }

    public hf(Activity activity, ws wsVar, xv xvVar) {
        this(activity, wsVar);
        this.d = xvVar;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.widget.y yVar) {
        yVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    public View xj(JSONObject jSONObject, JSONObject jSONObject2, yo yoVar) {
        qt qtVar = new qt(this.f);
        this.tf = qtVar;
        com.bytedance.adsdk.ugeno.hf.w<View> xj2 = qtVar.xj(jSONObject);
        this.tf.xj(yoVar);
        this.tf.hf(jSONObject2);
        if (xj2 == null) {
            return null;
        }
        return xj2.d();
    }

    public void xj(Dialog dialog, View view, float f) {
        if (dialog == null || view == null) {
            return;
        }
        if (this.c.rs() == 1) {
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.y = r.w(this.f, -20.0f);
            dialog.getWindow().setAttributes(attributes);
        }
        if (this.c.rs() == 2) {
            view.setScaleX(f);
            view.setScaleY(f);
            view.setPivotY(0.0f);
            view.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, view.getMeasuredHeight());
            layoutParams.leftMargin = (int) ((1.0f - f) * view.getMeasuredWidth());
            layoutParams.topMargin = (int) Math.max(((r.kd((Context) this.f) - (view.getMeasuredHeight() * f)) / 2.0f) - r.p((Context) this.f), r.p((Context) this.f));
            view.setLayoutParams(layoutParams);
        }
    }
}
