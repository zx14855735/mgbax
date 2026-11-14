package com.bytedance.sdk.openadsdk.kd;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.adsdk.ugeno.w.d;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.e;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.io;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.upie.xj;
import com.bytedance.sdk.openadsdk.x.c;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public static boolean c(ws wsVar) {
        int[] kd;
        if (wsVar == null || (kd = h.kd(wsVar)) == null || kd.length < 2) {
            return true;
        }
        int i = kd[0];
        int i2 = kd[1];
        int u = h.u(wsVar);
        int w = h.w(wsVar);
        return (i >= i2 && u >= w) || (i <= i2 && u <= w);
    }

    public static com.bytedance.sdk.openadsdk.upie.xj d(ws wsVar) {
        if (!u(wsVar) && !xj(wsVar)) {
            return new xj.C0208xj().w(pl(wsVar)).xj();
        }
        xj.C0208xj p = p(wsVar);
        JSONObject ac = wsVar.ac();
        if (ac != null) {
            try {
                ac.put("os", "android");
            } catch (JSONException unused) {
            }
        }
        p.xj(ac);
        return p.xj();
    }

    public static boolean f(ws wsVar) {
        if (wsVar != null && !ws.hf(wsVar)) {
            if (u(wsVar)) {
                return true;
            }
            if (!pz.hf().oe() && (io.xj(wsVar) || io.hf(wsVar) || UGenVideoOrImgPanelView.xj(wsVar))) {
                return true;
            }
        }
        return false;
    }

    public static boolean kd(ws wsVar) {
        return wsVar != null && wsVar.uh() == 17;
    }

    private static xj.C0208xj p(ws wsVar) {
        int[] kd = h.kd(wsVar);
        e am = wsVar.am();
        String w = am != null ? am.w() : null;
        xj.C0208xj c0208xj = new xj.C0208xj();
        if (TextUtils.isEmpty(w)) {
            w = "";
        }
        xj.C0208xj hf = c0208xj.xj(w).xj((kd == null || kd.length < 2) ? 1280 : kd[0]).hf((kd == null || kd.length < 2) ? 720 : kd[1]);
        if (hf(wsVar)) {
            com.bykv.vk.openvk.component.video.api.w.xj zg = h.zg(wsVar);
            hf.w(pl(wsVar)).hf(zg != null ? zg.kd() : "").xj(((long) h.y(wsVar)) * 1000);
        }
        if (u(wsVar)) {
            hf.w(pl(wsVar));
        }
        return hf;
    }

    private static String pl(ws wsVar) {
        List<z> lx;
        if (wsVar == null || (lx = wsVar.lx()) == null || lx.size() <= 0) {
            return null;
        }
        return lx.get(0).xj();
    }

    public static com.bytedance.sdk.openadsdk.upie.image.lottie.xj tf(final ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.upie.image.lottie.xj() { // from class: com.bytedance.sdk.openadsdk.kd.xj.2
            @Override // com.bytedance.sdk.openadsdk.upie.image.lottie.xj
            public void xj(Map<String, Object> map) {
                am.xj().xj(ws.this, map.get(MediationConstant.EXTRA_DURATION));
            }

            @Override // com.bytedance.sdk.openadsdk.upie.image.lottie.xj
            public void xj(int i, String str) {
                am.xj().xj(ws.this, i, str);
            }
        };
    }

    public static boolean u(ws wsVar) {
        return kd(wsVar) || y(wsVar);
    }

    public static boolean w(ws wsVar) {
        return wsVar != null && wsVar.uh() == 16;
    }

    public static boolean xj(ws wsVar) {
        return hf(wsVar) || w(wsVar);
    }

    public static boolean y(ws wsVar) {
        return wsVar != null && wsVar.uh() == 18;
    }

    public static boolean hf(ws wsVar) {
        return wsVar != null && wsVar.uh() == 15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(ImageView imageView, UpieImageView upieImageView) {
        ViewGroup.LayoutParams layoutParams;
        ViewParent parent = imageView.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int i = 0;
            while (true) {
                if (i >= viewGroup.getChildCount()) {
                    i = -1;
                    break;
                } else if (imageView == viewGroup.getChildAt(i)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams2.gravity = 17;
                    layoutParams = layoutParams2;
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams3.addRule(13);
                    layoutParams = layoutParams3;
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams4.gravity = 17;
                    layoutParams = layoutParams4;
                } else {
                    layoutParams = new ViewGroup.LayoutParams(imageView.getWidth(), imageView.getHeight());
                }
                viewGroup.addView(upieImageView, i, layoutParams);
                viewGroup.removeView(imageView);
            }
        }
    }

    public static com.bytedance.sdk.openadsdk.upie.xj xj(ws wsVar, JSONObject jSONObject) {
        xj.C0208xj p = p(wsVar);
        if (jSONObject != null) {
            try {
                jSONObject.put("os", "android");
            } catch (JSONException unused) {
            }
        }
        p.xj(jSONObject);
        return p.xj();
    }

    public static void xj(JSONObject jSONObject, ws wsVar) {
        if (jSONObject != null) {
            if (xj(wsVar) || u(wsVar)) {
                try {
                    jSONObject.put("dynamic_join_type", wsVar.uh());
                } catch (JSONException e) {
                    pl.xj(e);
                }
            }
        }
    }

    public static void xj(boolean z, d.xj xjVar) {
        JSONObject u;
        if (xjVar == null || (u = xjVar.u()) == null || !TextUtils.equals("${image[0].url}", u.optString("src"))) {
            return;
        }
        try {
            if (z) {
                u.put(PointParamKey.TYPE, "UpieImage");
            } else {
                u.put("name", "UpieImage");
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
        xjVar.xj("UpieImage");
    }

    public static void xj(final ImageView imageView, final UpieImageView upieImageView) {
        c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.kd.xj.1
            @Override // java.lang.Runnable
            public void run() {
                final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.kd.xj.1.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        int width = imageView.getWidth();
                        int height = imageView.getHeight();
                        if (width <= 90 || height <= 90) {
                            return;
                        }
                        imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        xj.w(imageView, upieImageView);
                    }
                };
                imageView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
                imageView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.kd.xj.1.2
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        ImageView imageView2 = imageView;
                        if (imageView2 == view) {
                            imageView2.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
                        }
                    }
                });
            }
        });
    }
}
