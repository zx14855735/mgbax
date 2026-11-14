package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.qt;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class hf {
    protected xj hf;
    private EasyPlayableContainer kd;
    protected boolean u = false;
    protected w w;
    protected final ws xj;

    public hf(ws wsVar, xj xjVar, w wVar) {
        this.xj = wsVar;
        this.hf = xjVar;
        this.w = wVar;
    }

    public abstract c hf();

    public abstract int xj();

    public abstract boolean xj(int i, int i2);

    public void xj(final ViewGroup viewGroup, final View view, final View view2, final boolean z, final boolean z2, final float[] fArr, final com.bytedance.sdk.openadsdk.core.dk.hf hfVar) {
        final HashMap hashMap = new HashMap();
        hashMap.put("render_type", Integer.valueOf(xj()));
        if (viewGroup != null && view != null && view2 != null) {
            view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.hf.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!hf.this.xj(view.getWidth(), view.getHeight())) {
                        hashMap.put("view_width", Integer.valueOf(view.getWidth()));
                        hashMap.put("view_height", Integer.valueOf(view.getHeight()));
                        hashMap.put("error_code", 103);
                        hf.this.w.xj(false, (Map<String, Object>) hashMap);
                        return;
                    }
                    boolean[] zArr = {true};
                    qt xj = hf.this.xj(zArr, fArr, hfVar, view.getWidth(), view.getHeight());
                    if (!zArr[0]) {
                        hf.this.xj(hfVar);
                        return;
                    }
                    hf hfVar2 = hf.this;
                    hfVar2.w.hf(hfVar2.xj());
                    if (view2.getParent() != null) {
                        ((ViewGroup) view2.getParent()).removeView(view2);
                    }
                    hf.this.kd = new EasyPlayableContainer(pz.getContext(), hf.this.hf(), xj, hf.this.xj);
                    hf.this.kd.setTag("easy_pfwv");
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                    layoutParams.gravity = 17;
                    hf.this.kd.addView(view2, layoutParams);
                    hashMap.put("container_name", viewGroup.getClass().getName());
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationInWindow(iArr2);
                    ViewGroup viewGroup2 = viewGroup;
                    if (viewGroup2 instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(view.getWidth(), view.getHeight());
                        layoutParams2.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                        hf.this.kd.setLayoutParams(layoutParams2);
                        viewGroup.addView(hf.this.kd);
                        if (!z) {
                            viewGroup.setClipChildren(false);
                        }
                        if (!z2) {
                            hf.this.w.xj(true, (Map<String, Object>) hashMap);
                            hf.this.xj(hfVar, xj);
                            return;
                        }
                        hashMap.put("error_code", 105);
                    } else if (viewGroup2 instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                        layoutParams3.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                        hf.this.kd.setLayoutParams(layoutParams3);
                        viewGroup.addView(hf.this.kd);
                        if (!z) {
                            viewGroup.setClipChildren(false);
                        }
                        if (!z2) {
                            hf.this.w.xj(true, (Map<String, Object>) hashMap);
                            hf.this.xj(hfVar, xj);
                            return;
                        }
                        hashMap.put("error_code", 105);
                    }
                    hf.this.w.xj(false, (Map<String, Object>) hashMap);
                }
            });
        } else {
            hashMap.put("error_code", 102);
            this.w.xj(false, (Map<String, Object>) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public qt xj(boolean[] zArr, float[] fArr, com.bytedance.sdk.openadsdk.core.dk.hf hfVar, float f, float f2) {
        qt qtVar;
        final double d;
        qt xj = hfVar != null ? qt.xj(hfVar.hf()) : null;
        if (fArr == null) {
            if (xj == null) {
                return new qt(0.0d, 0.0d, r.u(pz.getContext(), f), r.u(pz.getContext(), f2));
            }
            return xj;
        }
        final qt xj2 = xj(fArr, f, f2);
        if (xj == null) {
            return xj2;
        }
        double xj3 = qt.xj(xj, xj2);
        final double d2 = xj2.w * xj2.u;
        final double d3 = xj.w * xj.u;
        final qt hf = qt.hf(xj, xj2);
        if (hf != null) {
            qtVar = null;
            d = hf.w * hf.u;
        } else {
            qtVar = null;
            d = 0.0d;
        }
        if (hfVar != null) {
            hfVar.xj(new com.bytedance.sdk.openadsdk.core.dk.w() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.hf.2
                @Override // com.bytedance.sdk.openadsdk.core.dk.w
                public JSONObject getActualRectJson() {
                    return qt.xj(xj2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.dk.w
                public double getExceedAreaRate() {
                    double d4 = d3;
                    if (d4 <= 0.0d) {
                        return 1.0d;
                    }
                    if (d2 <= 0.0d) {
                        return -1.0d;
                    }
                    return (d - d4) / d4;
                }

                @Override // com.bytedance.sdk.openadsdk.core.dk.w
                public JSONObject getMaxRectJson() {
                    return qt.xj(hf);
                }
            });
        }
        if (d3 <= 0.0d) {
            zArr[0] = false;
            return qtVar;
        }
        if (d2 <= 0.0d) {
            zArr[0] = false;
            return qtVar;
        }
        double d4 = xj3 / d2;
        boolean z = d4 >= 0.8d;
        com.bytedance.sdk.component.utils.pl.xj("xeasy", "A:" + d3 + " B:" + d2 + " o:" + xj3 + " R:" + d4);
        if (z) {
            return hf;
        }
        zArr[0] = false;
        return qtVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.core.dk.hf hfVar, qt qtVar) {
        if (hfVar != null) {
            hfVar.xj(true, qt.xj(qtVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.core.dk.hf hfVar) {
        if (hfVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", 1);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.pl.hf("xeasy", e.getMessage());
            }
            hfVar.xj(false, jSONObject);
        }
    }

    private qt xj(float[] fArr, float f, float f2) {
        int u = r.u(pz.getContext(), f);
        int u2 = r.u(pz.getContext(), f2);
        float f3 = fArr[1];
        float f4 = fArr[0];
        float f5 = (u - f3) - fArr[3];
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        return new qt(f3, f4, f5, (u2 - f4) - fArr[2] >= 0.0f ? r15 : 0.0f);
    }
}
