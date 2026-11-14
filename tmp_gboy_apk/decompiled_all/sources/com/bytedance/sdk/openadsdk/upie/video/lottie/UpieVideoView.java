package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bykv.vk.openvk.component.video.api.renderview.hf;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.jk;
import com.bytedance.adsdk.lottie.pz;
import com.bytedance.adsdk.lottie.u;
import com.bytedance.sdk.openadsdk.upie.hf;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class UpieVideoView extends FrameLayout implements com.bykv.vk.openvk.component.video.api.renderview.hf {
    private hf.xj c;
    private final LottieAnimationView hf;
    private final Handler kd;
    private final Map<String, Integer> u;
    private final Map<String, Bitmap> w;
    private final com.bykv.vk.openvk.component.video.api.renderview.hf xj;
    private final Runnable y;

    public UpieVideoView(final Context context, final com.bytedance.sdk.openadsdk.upie.xj xjVar) {
        super(context);
        this.w = new HashMap();
        this.u = new HashMap();
        this.kd = new Handler(Looper.getMainLooper());
        this.y = new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (UpieVideoView.this.hf != null && UpieVideoView.this.hf.kd()) {
                    UpieVideoView.this.hf.invalidate();
                }
                UpieVideoView.this.kd.postDelayed(UpieVideoView.this.y, 40L);
            }
        };
        SSRenderTextureView sSRenderTextureView = new SSRenderTextureView(context);
        this.xj = sSRenderTextureView;
        addView(sSRenderTextureView.getView());
        sSRenderTextureView.getView().setTranslationX(2.14748365E9f);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.hf = lottieAnimationView;
        lottieAnimationView.setImageAssetDelegate(new u() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.1
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
            
                if (r1.startsWith(com.czhj.sdk.common.Constants.HTTP) != false) goto L17;
             */
            @Override // com.bytedance.adsdk.lottie.u
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public android.graphics.Bitmap xj(com.bytedance.adsdk.lottie.d r6) {
                /*
                    r5 = this;
                    r0 = 0
                    if (r6 == 0) goto L56
                    java.lang.String r1 = r6.pl()
                    boolean r2 = android.text.TextUtils.isEmpty(r1)
                    if (r2 != 0) goto L56
                    java.lang.String r2 = "${"
                    boolean r2 = r1.startsWith(r2)
                    if (r2 == 0) goto L38
                    java.lang.String r2 = "}"
                    boolean r2 = r1.endsWith(r2)
                    if (r2 == 0) goto L38
                    com.bytedance.sdk.openadsdk.upie.xj r2 = r2
                    if (r2 == 0) goto L37
                    org.json.JSONObject r2 = r2.c()
                    java.lang.String r1 = com.bytedance.sdk.openadsdk.upie.xj.xj.xj(r1, r2)
                    boolean r2 = android.text.TextUtils.isEmpty(r1)
                    if (r2 != 0) goto L37
                    java.lang.String r2 = "http"
                    boolean r2 = r1.startsWith(r2)
                    if (r2 != 0) goto L38
                L37:
                    return r0
                L38:
                    com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView r2 = com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.this
                    java.util.Map r2 = com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.xj(r2)
                    java.lang.Object r2 = r2.get(r1)
                    android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
                    if (r2 == 0) goto L47
                    return r2
                L47:
                    com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView r2 = com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.this
                    android.content.Context r3 = r3
                    int r4 = r6.xj()
                    int r6 = r6.hf()
                    com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.xj(r2, r3, r1, r4, r6)
                L56:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.AnonymousClass1.xj(com.bytedance.adsdk.lottie.d):android.graphics.Bitmap");
            }
        });
        lottieAnimationView.setTextDelegate(new jk(lottieAnimationView) { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.2
            @Override // com.bytedance.adsdk.lottie.jk
            public String xj(String str) {
                com.bytedance.sdk.openadsdk.upie.xj xjVar2 = xjVar;
                return com.bytedance.sdk.openadsdk.upie.xj.xj.xj(str, xjVar2 != null ? xjVar2.c() : null);
            }
        });
        lottieAnimationView.setViewDelegate(new pz() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.3
            @Override // com.bytedance.adsdk.lottie.pz
            public View xj(String str, Map<String, Object> map) {
                if ("videoview:".equals(str)) {
                    return UpieVideoView.this.xj.getView();
                }
                return null;
            }
        });
        lottieAnimationView.setRepeatMode(1);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        lottieAnimationView.setClickable(false);
        lottieAnimationView.xj(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (UpieVideoView.this.hf != null) {
                    UpieVideoView.this.hf.hf(this);
                }
                UpieVideoView.this.u();
            }
        });
        lottieAnimationView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.5
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (UpieVideoView.this.hf == view) {
                    UpieVideoView.this.w();
                }
            }
        });
        addView(lottieAnimationView, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hf
    public SurfaceHolder getHolder() {
        return null;
    }

    public LottieAnimationView getLottieAnimationView() {
        return this.hf;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hf
    public View getView() {
        return this;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        LottieAnimationView lottieAnimationView = this.hf;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(hf.xj xjVar) {
        this.c = xjVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        w();
        if (this.hf != null) {
            this.kd.postDelayed(this.y, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.kd.removeCallbacksAndMessages(null);
    }

    public void hf() {
        com.bytedance.sdk.openadsdk.upie.xj.hf.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.w();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Context context, final String str, final int i, final int i2) {
        Integer num = this.u.get(str);
        if (num == null || num.intValue() != 1) {
            this.u.put(str, 1);
            com.bytedance.sdk.openadsdk.upie.hf.xj().xj(context, str, new hf.xj<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.7
                @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                public void xj(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                        }
                        UpieVideoView.this.w.put(str, bitmap);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                public void xj(int i3, String str2) {
                    UpieVideoView.this.u.put(str, 2);
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hf
    public void xj(com.bykv.vk.openvk.component.video.api.renderview.xj xjVar) {
        com.bykv.vk.openvk.component.video.api.renderview.hf hfVar = this.xj;
        if (hfVar != null) {
            hfVar.xj(xjVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.hf
    public void xj(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    public void xj() {
        com.bytedance.sdk.openadsdk.upie.xj.hf.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.u();
            }
        });
    }
}
