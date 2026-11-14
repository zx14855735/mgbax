package com.bytedance.sdk.component.adexpress.widget;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.jk;
import com.bytedance.adsdk.lottie.u;
import com.bytedance.adsdk.lottie.w;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.tf;
import com.bytedance.sdk.component.y.zg;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicLottieView extends LottieAnimationView {
    private int c;
    private Map<String, String> f;
    private String hf;
    private int kd;
    private boolean u;
    private boolean w;
    private Map<String, Bitmap> xj;
    private int y;

    public DynamicLottieView(Context context) {
        super(context);
        this.xj = new HashMap();
    }

    private void p() {
        setAnimationFromUrl(this.hf);
        setImageAssetDelegate(new u() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3
            @Override // com.bytedance.adsdk.lottie.u
            public Bitmap xj(final d dVar) {
                if (dVar == null) {
                    return null;
                }
                final String g = dVar.g();
                String pl2 = dVar.pl();
                if (TextUtils.isEmpty(g) || !TextUtils.isEmpty(pl2)) {
                    g = (TextUtils.isEmpty(pl2) || !TextUtils.isEmpty(g)) ? (TextUtils.isEmpty(pl2) || TextUtils.isEmpty(g)) ? "" : CtFAbx.AcNBzu(g, pl2) : pl2;
                }
                if (TextUtils.isEmpty(g)) {
                    return null;
                }
                Bitmap bitmap = DynamicLottieView.this.xj == null ? null : (Bitmap) DynamicLottieView.this.xj.get(g);
                if (bitmap != null) {
                    return bitmap;
                }
                com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().kd().from(g).converter(new tf() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3.2
                    @Override // com.bytedance.sdk.component.y.tf
                    public Bitmap coverterTo(Bitmap bitmap2) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, dVar.xj(), dVar.hf(), false);
                        if (DynamicLottieView.this.xj != null) {
                            DynamicLottieView.this.xj.put(g, createScaledBitmap);
                        }
                        return createScaledBitmap;
                    }
                }).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.3.1
                    @Override // com.bytedance.sdk.component.y.dk
                    public void onFailed(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.y.dk
                    public void onSuccess(zg<Bitmap> zgVar) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(zgVar.getResult(), dVar.xj(), dVar.hf(), false);
                        if (DynamicLottieView.this.xj != null) {
                            DynamicLottieView.this.xj.put(g, createScaledBitmap);
                        }
                        DynamicLottieView.this.xj(dVar.p(), createScaledBitmap);
                    }
                });
                if (DynamicLottieView.this.xj == null) {
                    return null;
                }
                return (Bitmap) DynamicLottieView.this.xj.get(g);
            }
        });
        xj();
    }

    private void tf() {
        setAnimationFromUrl("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/lotties/" + this.hf + ".json");
        setImageAssetDelegate(new u() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1
            @Override // com.bytedance.adsdk.lottie.u
            public Bitmap xj(final d dVar) {
                final String pl2;
                pl2 = dVar.pl();
                pl2.getClass();
                switch (pl2) {
                    case "{appIcon}":
                        if (DynamicLottieView.this.f != null) {
                            pl2 = (String) DynamicLottieView.this.f.get("icon");
                            break;
                        }
                        break;
                    case "{adImage}":
                    case "{slot}":
                        if (DynamicLottieView.this.f != null) {
                            pl2 = (String) DynamicLottieView.this.f.get("imageUrl");
                            break;
                        }
                        break;
                }
                Bitmap bitmap = (Bitmap) DynamicLottieView.this.xj.get(pl2);
                if (bitmap != null) {
                    return bitmap;
                }
                com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().kd().from(pl2).type(2).converter(new tf() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1.2
                    @Override // com.bytedance.sdk.component.y.tf
                    public Bitmap coverterTo(Bitmap bitmap2) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, dVar.xj(), dVar.hf(), false);
                        DynamicLottieView.this.xj.put(pl2, createScaledBitmap);
                        return createScaledBitmap;
                    }
                }).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.1.1
                    @Override // com.bytedance.sdk.component.y.dk
                    public void onFailed(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.y.dk
                    public void onSuccess(zg<Bitmap> zgVar) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(zgVar.getResult(), dVar.xj(), dVar.hf(), false);
                        DynamicLottieView.this.xj.put(pl2, createScaledBitmap);
                        DynamicLottieView.this.xj(dVar.p(), createScaledBitmap);
                    }
                });
                return (Bitmap) DynamicLottieView.this.xj.get(pl2);
            }
        });
        if (this.f != null) {
            jk jkVar = new jk(this);
            String str = this.f.get("app_name");
            String str2 = this.f.get("description");
            String str3 = this.f.get("title");
            if (this.kd > 0 && str.length() > this.kd) {
                str = str.substring(0, this.kd - 1) + "...";
            } else if (this.kd <= 0) {
                str = "";
            }
            if (this.y > 0 && str3.length() > this.y) {
                str3 = str3.substring(0, this.y - 1) + "...";
            } else if (this.kd <= 0) {
                str3 = "";
            }
            if (this.c > 0 && str2.length() > this.c) {
                str2 = str2.substring(0, this.c - 1) + "...";
            } else if (this.kd <= 0) {
                str2 = "";
            }
            jkVar.hf("{appName}", str);
            jkVar.hf("{adTitle}", str3);
            jkVar.hf("{adDesc}", str2);
            setTextDelegate(jkVar);
            setFontAssetDelegate(new w() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicLottieView.2
                @Override // com.bytedance.adsdk.lottie.w
                public String hf(String str4) {
                    return null;
                }

                @Override // com.bytedance.adsdk.lottie.w
                public Typeface xj(String str4) {
                    return Typeface.MONOSPACE;
                }
            });
        }
        xj();
    }

    public void d() {
        if (TextUtils.isEmpty(this.hf)) {
            return;
        }
        setProgress(0.0f);
        xj(this.w);
        if (this.u) {
            p();
        } else {
            tf();
        }
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // com.bytedance.adsdk.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y();
    }

    public void setAnimationsLoop(boolean z) {
        this.w = z;
    }

    public void setData(Map<String, String> map) {
        this.f = map;
    }

    public void setImageLottieTosPath(String str) {
        this.hf = str;
    }

    public void setLottieAdDescMaxLength(int i) {
        this.c = i;
    }

    public void setLottieAdTitleMaxLength(int i) {
        this.y = i;
    }

    public void setLottieAppNameMaxLength(int i) {
        this.kd = i;
    }

    public void setOnlyLoadNetImage(boolean z) {
        this.u = z;
    }
}
