package com.bytedance.sdk.openadsdk.upie.image.lottie;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.component.video.api.w.hf;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.jk;
import com.bytedance.adsdk.lottie.u;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.upie.hf;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class UpieImageView extends FrameLayout {
    private final Map<String, Integer> c;
    private int d;
    private int f;
    private ImageView hf;
    private Bitmap kd;
    private long p;
    private xj tf;
    private String u;
    private volatile LottieAnimationView w;
    private final Context xj;
    private final Map<String, Bitmap> y;

    public UpieImageView(Context context, com.bytedance.sdk.openadsdk.upie.xj xjVar, xj xjVar2) {
        super(context);
        this.y = new HashMap();
        this.c = new HashMap();
        this.f = 0;
        this.d = 0;
        this.xj = context;
        this.tf = xjVar2;
        xj(xjVar, xjVar2);
    }

    public static /* synthetic */ int f(UpieImageView upieImageView) {
        int i = upieImageView.f;
        upieImageView.f = i + 1;
        return i;
    }

    public static /* synthetic */ int w(UpieImageView upieImageView) {
        int i = upieImageView.d;
        upieImageView.d = i + 1;
        return i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.w == null || this.u == null) {
            return;
        }
        this.w.xj();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.w != null) {
            this.w.y();
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            if (this.w != null) {
                this.w.setScaleType(scaleType);
                return;
            }
            ImageView imageView = this.hf;
            if (imageView != null) {
                imageView.setScaleType(scaleType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(final String str) {
        if (TextUtils.isEmpty(str)) {
            new hf(60008, AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS, "广告主图url为空");
        } else {
            com.bytedance.sdk.openadsdk.upie.hf.xj().hf(str, new hf.xj<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.4
                @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                public void xj(Bitmap bitmap) {
                    UpieImageView.this.kd = bitmap;
                    final Bitmap xj = com.bytedance.sdk.component.adexpress.u.hf.xj(UpieImageView.this.xj, UpieImageView.this.kd, 25);
                    com.bytedance.sdk.openadsdk.upie.xj.hf.hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (UpieImageView.this.w != null) {
                                UpieImageView.this.w.invalidate();
                            }
                            UpieImageView.this.hf.setImageBitmap(UpieImageView.this.kd);
                            UpieImageView.this.hf.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            if (xj != null) {
                                UpieImageView.this.hf.setBackground(new BitmapDrawable(xj));
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                public void xj(int i, String str2) {
                    UpieImageView.f(UpieImageView.this);
                    if (UpieImageView.this.f <= 3) {
                        UpieImageView.this.hf(str);
                    } else {
                        new com.bykv.vk.openvk.component.video.api.w.hf(60008, AVMDLDataLoader.KeyIsStoRingBufferSizeKB, "广告主图url加载失败");
                    }
                }
            });
        }
    }

    public synchronized void xj(final com.bytedance.sdk.openadsdk.upie.xj xjVar, xj xjVar2) {
        if (xjVar == null) {
            return;
        }
        try {
            if (this.w != null) {
                return;
            }
            this.tf = xjVar2;
            final String w = xjVar.w();
            String xj = xjVar.xj();
            if (!TextUtils.isEmpty(xj)) {
                this.w = new LottieAnimationView(this.xj);
                this.w.setRepeatCount(-1);
                this.w.setRepeatMode(1);
                this.w.setClickable(false);
                this.w.setImageAssetDelegate(new u() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.1
                    @Override // com.bytedance.adsdk.lottie.u
                    public Bitmap xj(d dVar) {
                        if (dVar != null) {
                            String pl2 = dVar.pl();
                            if (!TextUtils.isEmpty(pl2)) {
                                if (pl2.startsWith("${") && pl2.endsWith("}")) {
                                    pl2 = com.bytedance.sdk.openadsdk.upie.xj.xj.xj(pl2, xjVar.c());
                                    if (TextUtils.isEmpty(pl2)) {
                                        return null;
                                    }
                                    if (TextUtils.equals(w, pl2)) {
                                        Bitmap bitmap = UpieImageView.this.kd;
                                        if (bitmap != null && (bitmap.getWidth() != dVar.xj() || bitmap.getHeight() != dVar.hf())) {
                                            UpieImageView.this.kd = Bitmap.createScaledBitmap(bitmap, dVar.xj(), dVar.hf(), false);
                                        }
                                        return UpieImageView.this.kd;
                                    }
                                }
                                Bitmap bitmap2 = (Bitmap) UpieImageView.this.y.get(pl2);
                                if (bitmap2 != null) {
                                    return bitmap2;
                                }
                                UpieImageView.this.xj(pl2, dVar.xj(), dVar.hf());
                            }
                        }
                        return null;
                    }
                });
                this.w.setTextDelegate(new jk(this.w) { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.2
                    @Override // com.bytedance.adsdk.lottie.jk
                    public String xj(String str) {
                        return com.bytedance.sdk.openadsdk.upie.xj.xj.xj(str, xjVar.c());
                    }
                });
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            ImageView imageView = new ImageView(this.xj);
            this.hf = imageView;
            addView(imageView, layoutParams);
            if (this.w != null) {
                addView(this.w, layoutParams);
            }
            this.p = SystemClock.elapsedRealtime();
            xj(xj);
            hf(w);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final String str) {
        if (TextUtils.isEmpty(str)) {
            xj(10000, "lottieJsonUrl为空");
        } else {
            com.bytedance.sdk.openadsdk.upie.xj.hf.w(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.3
                @Override // java.lang.Runnable
                public void run() {
                    String xj = com.bytedance.sdk.openadsdk.upie.hf.xj().xj(str);
                    if (TextUtils.isEmpty(xj)) {
                        com.bytedance.sdk.openadsdk.upie.hf.xj().xj(str, new hf.xj<String>() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.3.1
                            @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                            public void xj(String str2) {
                                pl.xj("UpieImageView", "--==-- lottie jsonStr ok");
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                UpieImageView.this.xj(str2, str);
                            }

                            @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                            public void xj(int i, String str2) {
                                pl.xj("UpieImageView", "--==-- lottie jsonStr load fail: " + i + ", " + str2);
                                if (i == 10006) {
                                    UpieImageView.this.xj(i, str2);
                                    return;
                                }
                                UpieImageView.w(UpieImageView.this);
                                if (UpieImageView.this.d > 3) {
                                    UpieImageView.this.xj(i, str2);
                                } else {
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    UpieImageView.this.xj(str);
                                }
                            }
                        });
                    } else {
                        UpieImageView.this.xj(xj, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final String str, final int i, final int i2) {
        Integer num = this.c.get(str);
        if (num == null || num.intValue() != 1) {
            this.c.put(str, 1);
            com.bytedance.sdk.openadsdk.upie.hf.xj().xj(this.xj, str, new hf.xj<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.5
                @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                public void xj(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                        }
                        UpieImageView.this.y.put(str, bitmap);
                        com.bytedance.sdk.openadsdk.upie.xj.hf.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UpieImageView.this.w != null) {
                                    UpieImageView.this.w.invalidate();
                                }
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.upie.hf.xj
                public void xj(int i3, String str2) {
                    UpieImageView.this.c.put(str, 2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, String str) {
        xj xjVar = this.tf;
        if (xjVar != null) {
            xjVar.xj(i, str);
        }
        com.bytedance.sdk.openadsdk.upie.xj.hf.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.6
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.w != null) {
                    UpieImageView upieImageView = UpieImageView.this;
                    upieImageView.removeView(upieImageView.w);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(long j) {
        if (this.tf != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(MediationConstant.EXTRA_DURATION, Long.valueOf(j - this.p));
            this.tf.xj(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final String str, final String str2) {
        this.u = str;
        com.bytedance.sdk.openadsdk.upie.xj.hf.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.w != null) {
                    UpieImageView.this.w.xj(str, str2);
                    UpieImageView.this.w.xj(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.7.1
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
                            UpieImageView.this.w.hf(this);
                            UpieImageView.this.xj(SystemClock.elapsedRealtime());
                        }
                    });
                    UpieImageView.this.w.xj();
                }
            }
        });
    }
}
