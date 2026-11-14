package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.w.ht;
import com.bytedance.sdk.component.adexpress.hf.am;
import com.bytedance.sdk.openadsdk.core.nativeexpress.yo;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.io;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.express.hf;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends hf {
    private boolean c;
    private final com.bytedance.sdk.openadsdk.core.dk.hf d;
    private int f;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.u kd;
    private final c tf;
    private View y;

    public kd(ws wsVar, boolean z, xj xjVar, w wVar) {
        super(wsVar, xjVar, wVar);
        this.c = false;
        this.f = 2;
        this.tf = new c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.kd.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void hf() {
                kd.this.c = true;
                kd.this.kd();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void kd() {
                kd.this.y();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void u() {
                if (io.xj() && kd.this.d != null) {
                    kd.this.d.xj(kd.this.xj);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void w() {
                kd.this.c = false;
                if (kd.this.y != null) {
                    kd.this.y.setVisibility(8);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void xj() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c
            public void xj(boolean z2) {
            }
        };
        this.d = new com.bytedance.sdk.openadsdk.core.dk.hf(wsVar);
        this.u = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.hf
    public int xj() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd() {
        View view = this.y;
        if (view == null || !this.c) {
            return;
        }
        view.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        View view = this.y;
        if (view != null) {
            view.setVisibility(8);
            if (this.y.getParent() != null) {
                ((ViewGroup) this.y.getParent()).removeView(this.y);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.hf
    public c hf() {
        return this.tf;
    }

    public void u() {
        this.y = null;
        com.bytedance.sdk.openadsdk.core.ugeno.express.u uVar = this.kd;
        if (uVar != null) {
            uVar.p();
        }
    }

    public boolean w() {
        return io.xj(this.xj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.hf
    public boolean xj(int i, int i2) {
        return io.y(this.xj).xj(i, i2);
    }

    public void xj(final ViewGroup viewGroup, final View view, final boolean z) {
        if (viewGroup == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("render_type", Integer.valueOf(xj()));
            hashMap.put("error_code", 100);
            this.w.xj(false, (Map<String, Object>) hashMap);
            return;
        }
        String u = io.y(this.xj).u();
        String kd = io.y(this.xj).kd();
        this.f = io.y(this.xj).xj();
        com.bytedance.sdk.openadsdk.core.ugeno.tf.xj(kd, u, new com.bytedance.sdk.openadsdk.core.ugeno.w() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.kd.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.w
            public void xj() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.w
            public void xj(String str) {
                try {
                    kd.this.xj(new JSONObject(str), viewGroup, view, z);
                } catch (JSONException unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final JSONObject jSONObject, final ViewGroup viewGroup, final View view, final boolean z) {
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.kd.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject2;
                kd kdVar = kd.this;
                if (kdVar.xj == null) {
                    return;
                }
                if (kdVar.f == 3) {
                    JSONObject xj = com.bytedance.sdk.openadsdk.core.nativeexpress.hf.hf.xj(view);
                    kd kdVar2 = kd.this;
                    jSONObject2 = com.bytedance.sdk.openadsdk.core.nativeexpress.hf.hf.xj(kdVar2.xj, xj, jSONObject, kdVar2.u, null);
                } else {
                    jSONObject2 = jSONObject;
                }
                hf.xj xjVar = new hf.xj();
                kd kdVar3 = kd.this;
                xjVar.kd(com.bytedance.sdk.openadsdk.core.ugeno.tf.xj(kdVar3.xj, viewGroup, kdVar3.u));
                xjVar.xj(jSONObject2);
                xjVar.xj((ht) new yo());
                int height = viewGroup.getHeight();
                int width = viewGroup.getWidth();
                xjVar.hf(height);
                xjVar.xj(width);
                xjVar.xj(com.bytedance.sdk.openadsdk.core.f.zg().kd());
                xjVar.tf(kd.this.xj.kd());
                com.bytedance.sdk.openadsdk.core.ugeno.express.hf xj2 = xjVar.xj();
                if (kd.this.f == 3) {
                    kd.this.kd = new com.bytedance.sdk.openadsdk.core.ugeno.express.y(pz.getContext(), kd.this.xj, xj2, viewGroup);
                } else {
                    kd.this.kd = new com.bytedance.sdk.openadsdk.core.ugeno.express.u(pz.getContext(), kd.this.xj, xj2, viewGroup);
                }
                kd.this.kd.xj(kd.this.tf);
                kd.this.kd.xj(new com.bytedance.sdk.component.adexpress.hf.f() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.kd.3.1
                    @Override // com.bytedance.sdk.component.adexpress.hf.f
                    public void xj(View view2, int i, com.bytedance.sdk.component.adexpress.w wVar) {
                        kd.this.hf.xj(view2, i, wVar);
                    }

                    @Override // com.bytedance.sdk.component.adexpress.hf.f
                    public void xj(View view2, int i, com.bytedance.sdk.component.adexpress.w wVar, int i2) {
                        kd.this.hf.xj(view2, i, wVar);
                    }
                });
                kd.this.kd.xj(new f() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.kd.3.2
                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.f
                    public void xj() {
                        if (kd.this.y != null) {
                            kd.this.y.setVisibility(8);
                            try {
                                if (kd.this.y.getParent() != null) {
                                    ((ViewGroup) kd.this.y.getParent()).removeView(kd.this.y);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
                kd kdVar4 = kd.this;
                kdVar4.w.xj(kdVar4.xj());
                kd.this.kd.xj(new com.bytedance.sdk.component.adexpress.hf.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.kd.3.3
                    @Override // com.bytedance.sdk.component.adexpress.hf.c
                    public void xj(View view2, am amVar) {
                        boolean z2;
                        if (view2 == null) {
                            return;
                        }
                        kd.this.y = view2;
                        kd.this.y.setVisibility(8);
                        boolean z3 = false;
                        if (!(kd.this.y instanceof ViewGroup) || ((ViewGroup) kd.this.y).getChildCount() <= 0) {
                            z2 = false;
                        } else {
                            View childAt = ((ViewGroup) kd.this.y).getChildAt(0);
                            if (childAt != null && childAt.getVisibility() == 8) {
                                z3 = true;
                            }
                            z2 = z3;
                        }
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        kd kdVar5 = kd.this;
                        ViewGroup viewGroup2 = viewGroup;
                        View view3 = view;
                        View view4 = kdVar5.y;
                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                        kdVar5.xj(viewGroup2, view3, view4, z, z2, kd.this.kd.u(), kd.this.d);
                        kd.this.kd();
                    }

                    @Override // com.bytedance.sdk.component.adexpress.hf.c
                    public void xj(int i, String str) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        kd.this.hf.xj(viewGroup);
                        HashMap hashMap = new HashMap();
                        hashMap.put("error_code", Integer.valueOf(i));
                        hashMap.put("error_msg", str);
                        hashMap.put("render_type", Integer.valueOf(kd.this.xj()));
                        kd.this.w.xj(false, (Map<String, Object>) hashMap);
                    }
                });
            }
        });
    }

    public void xj(com.bytedance.sdk.openadsdk.dk.xj.hf.xj.hf hfVar) {
        this.d.xj(hfVar);
    }
}
