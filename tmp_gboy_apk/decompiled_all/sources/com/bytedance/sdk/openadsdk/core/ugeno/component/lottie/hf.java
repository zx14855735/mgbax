package com.bytedance.sdk.openadsdk.core.ugeno.component.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.mobads.sdk.internal.ax;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.u;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.adsdk.ugeno.xj;
import com.bytedance.adsdk.ugeno.y.f;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends w<UgenLottieView> {
    protected ImageView.ScaleType cu;
    private float he;

    @Deprecated
    private boolean kc;
    protected final Map<String, Integer> lm;
    private boolean mg;
    protected HashMap<String, Bitmap> my;
    private String no;
    private boolean qi;
    private float ut;
    protected ImageView.ScaleType vi;
    protected String xj;
    private int zd;

    /* renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.hf$1, reason: invalid class name */
    public class AnonymousClass1 implements u {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.adsdk.lottie.u
        public Bitmap xj(final d dVar) {
            final String str;
            if (dVar == null) {
                return null;
            }
            String g = dVar.g();
            String pl2 = dVar.pl();
            if (!TextUtils.isEmpty(g) && TextUtils.isEmpty(pl2)) {
                str = com.bytedance.adsdk.ugeno.u.hf.xj(g, ((w) hf.this).u);
            } else if (!TextUtils.isEmpty(pl2) && TextUtils.isEmpty(g)) {
                str = com.bytedance.adsdk.ugeno.u.hf.xj(pl2, ((w) hf.this).u);
            } else if (TextUtils.isEmpty(pl2) || TextUtils.isEmpty(g)) {
                str = null;
            } else {
                str = com.bytedance.adsdk.ugeno.u.hf.xj(g, ((w) hf.this).u) + com.bytedance.adsdk.ugeno.u.hf.xj(pl2, ((w) hf.this).u);
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bitmap bitmap = hf.this.my.get(str);
            if (bitmap != null) {
                return bitmap;
            }
            Integer num = hf.this.lm.get(str);
            if (num == null || num.intValue() == 2) {
                hf.this.lm.put(str, 1);
            } else if (num.intValue() == 1) {
                return null;
            }
            com.bytedance.adsdk.ugeno.u.xj().hf().xj(((w) hf.this).d, str, new xj.InterfaceC0033xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.hf.1.1
                @Override // com.bytedance.adsdk.ugeno.xj.InterfaceC0033xj
                public void xj(Bitmap bitmap2) {
                    if (bitmap2 == null) {
                        hf.this.lm.put(str, 2);
                        return;
                    }
                    final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, dVar.xj(), dVar.hf(), false);
                    hf.this.my.put(str, createScaledBitmap);
                    hf.this.lm.remove(str);
                    f.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.hf.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((UgenLottieView) ((w) hf.this).kd).xj(dVar.p(), createScaledBitmap);
                        }
                    });
                }
            });
            return hf.this.my.get(str);
        }
    }

    public hf(Context context) {
        super(context);
        this.no = "images";
        this.he = 1.0f;
        this.lm = new ConcurrentHashMap();
        this.vi = ImageView.ScaleType.FIT_CENTER;
        this.cu = ImageView.ScaleType.FIT_XY;
        this.my = new HashMap<>();
    }

    private ImageView.ScaleType g(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.getClass();
        switch (str) {
            case "center":
            case "none":
                return ImageView.ScaleType.CENTER;
            case "fit":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    private String p(String str) {
        return (!TextUtils.isEmpty(str) && str.contains(ax.f9749a)) ? str.contains("shake_phone") ? "lottie_json/shake_phone.json" : str.contains("swipe_right") ? "lottie_json/swipe_right.json" : "" : "";
    }

    private ImageView.ScaleType pl(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.getClass();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public UgenLottieView xj() {
        UgenLottieView ugenLottieView = new UgenLottieView(this.hf);
        ugenLottieView.xj(this);
        return ugenLottieView;
    }

    public void f() {
        ((UgenLottieView) this.kd).xj();
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        ((UgenLottieView) this.kd).setProgress(this.ut);
        if (this.he <= 0.0f) {
            this.he = 1.0f;
        }
        ((UgenLottieView) this.kd).setSpeed(this.he);
        if (this.xj.startsWith(ax.f9749a)) {
            ((UgenLottieView) this.kd).setAnimation(p(this.xj));
            ((UgenLottieView) this.kd).setImageAssetsFolder(this.no);
        } else {
            ((UgenLottieView) this.kd).setAnimationFromUrl(this.xj);
        }
        ((UgenLottieView) this.kd).setImageAssetDelegate(new AnonymousClass1());
        if (q()) {
            ((UgenLottieView) this.kd).setScaleType(this.cu);
        } else {
            ((UgenLottieView) this.kd).setScaleType(this.vi);
        }
        if (q()) {
            ((UgenLottieView) this.kd).setRepeatCount(this.zd);
        } else {
            ((UgenLottieView) this.kd).xj(this.kc);
        }
        f();
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.xj(str, str2);
        str.getClass();
        switch (str) {
            case "scaleMode":
                this.cu = g(str2);
                break;
            case "scaleType":
                this.vi = pl(str2);
                break;
            case "progress":
                this.ut = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case "imagePath":
                this.no = str2;
                break;
            case "autoReverse":
                this.qi = com.bytedance.adsdk.ugeno.y.w.xj(str2, false);
                break;
            case "src":
                this.xj = str2;
                break;
            case "loop":
                if (q()) {
                    this.zd = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0);
                    break;
                } else {
                    this.kc = com.bytedance.adsdk.ugeno.y.w.xj(str2, false);
                    break;
                }
            case "speed":
                this.he = com.bytedance.adsdk.ugeno.y.w.xj(str2, 1.0f);
                break;
            case "autoPlay":
                this.mg = com.bytedance.adsdk.ugeno.y.w.xj(str2, false);
                break;
            case "autoplay":
                this.mg = com.bytedance.adsdk.ugeno.y.w.xj(str2, true);
                break;
        }
    }
}
