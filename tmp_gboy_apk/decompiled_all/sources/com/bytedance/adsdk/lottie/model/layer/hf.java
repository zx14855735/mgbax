package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.openvk.component.video.api.xj;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends c {
    private final Handler am;
    private float d;
    private float f;
    private LottieAnimationView g;
    private volatile boolean p;

    /* renamed from: pl, reason: collision with root package name */
    private TextureView f10047pl;
    private final Runnable qt;
    private com.bykv.vk.openvk.component.video.xj.u.u tf;

    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public hf(com.bytedance.adsdk.lottie.f r3, com.bytedance.adsdk.lottie.model.layer.f r4, final android.content.Context r5) {
        /*
            r2 = this;
            r2.<init>(r3, r4)
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2.f = r4
            r2.d = r4
            android.os.Handler r4 = new android.os.Handler
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            r4.<init>(r0)
            r2.am = r4
            com.bytedance.adsdk.lottie.model.layer.hf$4 r4 = new com.bytedance.adsdk.lottie.model.layer.hf$4
            r4.<init>()
            r2.qt = r4
            com.bytedance.adsdk.lottie.d r4 = r2.c
            if (r4 == 0) goto La6
            if (r3 == 0) goto La6
            if (r5 == 0) goto La6
            com.bytedance.adsdk.lottie.LottieAnimationView r4 = r3.hf()
            r2.g = r4
            if (r4 != 0) goto L2d
            goto La6
        L2d:
            float r4 = com.bytedance.adsdk.lottie.kd.d.xj()
            com.bytedance.adsdk.lottie.d r0 = r2.c
            int r0 = r0.xj()
            float r0 = (float) r0
            float r0 = r0 * r4
            int r0 = (int) r0
            float r0 = (float) r0
            r2.f = r0
            com.bytedance.adsdk.lottie.d r0 = r2.c
            int r0 = r0.hf()
            float r0 = (float) r0
            float r0 = r0 * r4
            int r4 = (int) r0
            float r4 = (float) r4
            r2.d = r4
            com.bytedance.adsdk.lottie.jk r3 = r3.et()
            if (r3 == 0) goto L6b
            com.bytedance.adsdk.lottie.d r4 = r2.c
            java.lang.String r4 = r4.pl()
            java.lang.String r3 = r3.xj(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L6b
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L67
            r4.<init>(r3)     // Catch: org.json.JSONException -> L67
            goto L6c
        L67:
            r3 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r3)
        L6b:
            r4 = 0
        L6c:
            if (r4 == 0) goto La6
            java.lang.String r3 = "file_hash"
            java.lang.String r3 = r4.optString(r3)
            java.lang.String r0 = "video_url"
            java.lang.String r0 = r4.optString(r0)
            java.lang.String r1 = "video_duration"
            r4.optString(r1)
            java.lang.String r1 = "resolution"
            r4.optString(r1)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto La6
            android.view.TextureView r4 = new android.view.TextureView
            r4.<init>(r5)
            r2.f10047pl = r4
            com.bytedance.adsdk.lottie.model.layer.hf$1 r1 = new com.bytedance.adsdk.lottie.model.layer.hf$1
            r1.<init>()
            r4.setSurfaceTextureListener(r1)
            com.bytedance.adsdk.lottie.LottieAnimationView r3 = r2.g
            com.bytedance.adsdk.lottie.model.layer.hf$2 r4 = new com.bytedance.adsdk.lottie.model.layer.hf$2
            r4.<init>()
            r3.addOnAttachStateChangeListener(r4)
            r2.qt()
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.model.layer.hf.<init>(com.bytedance.adsdk.lottie.f, com.bytedance.adsdk.lottie.model.layer.f, android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am() {
        if (this.tf != null) {
            if (this.p) {
                this.tf.u();
            }
            this.tf.kd();
            this.tf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        zg();
        if (this.g != null) {
            this.am.postDelayed(this.qt, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qt() {
        ViewParent parent = this.f10047pl.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f10047pl);
        }
        ViewParent parent2 = this.g.getParent();
        if (parent2 instanceof ViewGroup) {
            this.f10047pl.setTranslationX(2.14748365E9f);
            ((ViewGroup) parent2).addView(this.f10047pl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zg() {
        this.am.removeCallbacksAndMessages(null);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.c, com.bytedance.adsdk.lottie.model.layer.w
    public void hf(Canvas canvas, Matrix matrix, int i) {
        if (this.f <= 0.0f || this.f10047pl == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        xj(i);
        float f = f();
        xj(this.f10047pl, (int) this.f, (int) this.d);
        this.f10047pl.setAlpha(f);
        this.f10047pl.draw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, String str2, Context context, SurfaceTexture surfaceTexture) {
        am();
        com.bykv.vk.openvk.component.video.xj.u.u uVar = new com.bykv.vk.openvk.component.video.xj.u.u("uttie");
        this.tf = uVar;
        uVar.xj(surfaceTexture);
        this.tf.xj(new xj.InterfaceC0014xj() { // from class: com.bytedance.adsdk.lottie.model.layer.hf.3
            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void hf(com.bykv.vk.openvk.component.video.api.xj xjVar, int i) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void w(com.bykv.vk.openvk.component.video.api.xj xjVar) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void hf(com.bykv.vk.openvk.component.video.api.xj xjVar) {
                hf.this.p = true;
                xjVar.w(true);
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, int i) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, int i, int i2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, int i, int i2, int i3) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, long j) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, long j, long j2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, JSONObject jSONObject, String str3) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, boolean z) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.xj.InterfaceC0014xj
            public void xj(com.bykv.vk.openvk.component.video.api.xj xjVar, com.bykv.vk.openvk.component.video.api.w.hf hfVar) {
                com.bytedance.sdk.component.utils.pl.u("uttie-video", hfVar.xj() + ":" + hfVar.hf() + ":" + hfVar.w());
            }
        });
        com.bykv.vk.openvk.component.video.api.w.w wVar = new com.bykv.vk.openvk.component.video.api.w.w();
        wVar.w(str);
        wVar.kd(str2);
        this.tf.xj(new com.bykv.vk.openvk.component.video.api.w.u(com.bytedance.adsdk.lottie.kd.hf.hf(context), wVar, null, 0, 0));
        this.tf.xj(true);
        this.tf.xj(true, 0L, true);
    }

    private static void xj(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
