package com.bytedance.adsdk.ugeno.widget.image;

import I3HV03.ADYaiT;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.adsdk.ugeno.u;
import com.bytedance.adsdk.ugeno.w.am;
import com.bytedance.adsdk.ugeno.w.c;
import com.bytedance.adsdk.ugeno.xj;
import com.bytedance.adsdk.ugeno.y.f;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends w<RoundImageView> {
    private int cu;
    protected boolean lm;
    protected ImageView.ScaleType my;
    private float no;
    private float qi;
    protected String vi;
    protected String xj;

    public hf(Context context) {
        super(context);
        this.my = ImageView.ScaleType.FIT_XY;
        this.cu = -1;
        this.no = -1.0f;
        this.qi = -1.0f;
    }

    private void s() {
        if (this.no > 0.0f) {
            c cVar = this.le;
            if (cVar != null) {
                cVar.xj();
            }
            u.xj().hf().xj(this.d, this.xj, new xj.InterfaceC0033xj() { // from class: com.bytedance.adsdk.ugeno.widget.image.hf.1
                @Override // com.bytedance.adsdk.ugeno.xj.InterfaceC0033xj
                public void xj(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (((w) hf.this).le != null) {
                            c cVar2 = ((w) hf.this).le;
                            hf hfVar = hf.this;
                            cVar2.hf(hfVar, hfVar.xj);
                            return;
                        }
                        return;
                    }
                    if (((w) hf.this).le != null) {
                        c cVar3 = ((w) hf.this).le;
                        hf hfVar2 = hf.this;
                        cVar3.xj(hfVar2, hfVar2.xj);
                    }
                    final Bitmap xj = f.xj(((w) hf.this).hf, bitmap, (int) hf.this.no);
                    if (xj != null) {
                        f.xj(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.hf.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((RoundImageView) ((w) hf.this).kd).setImageBitmap(xj);
                            }
                        });
                    }
                    hf hfVar3 = hf.this;
                    if (hfVar3.lm || hfVar3.qi > 0.0f) {
                        Bitmap xj2 = f.xj(((w) hf.this).hf, bitmap, hf.this.qi > 0.0f ? (int) hf.this.qi : 10);
                        if (xj2 != null) {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(((w) hf.this).hf.getResources(), xj2);
                            f.xj(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.hf.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((RoundImageView) ((w) hf.this).kd).setBackground(bitmapDrawable);
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        c cVar2 = this.le;
        if (cVar2 != null) {
            cVar2.xj();
        }
        com.bytedance.adsdk.ugeno.xj hf = u.xj().hf();
        am amVar = this.d;
        String str = this.xj;
        T t = this.kd;
        hf.xj(amVar, str, (ImageView) t, ((RoundImageView) t).getWidth(), ((RoundImageView) this.kd).getHeight(), new xj.InterfaceC0033xj() { // from class: com.bytedance.adsdk.ugeno.widget.image.hf.2
            @Override // com.bytedance.adsdk.ugeno.xj.InterfaceC0033xj
            public void xj(Bitmap bitmap) {
                if (bitmap == null) {
                    if (((w) hf.this).le != null) {
                        c cVar3 = ((w) hf.this).le;
                        hf hfVar = hf.this;
                        cVar3.hf(hfVar, hfVar.xj);
                        return;
                    }
                    return;
                }
                if (((w) hf.this).le != null) {
                    c cVar4 = ((w) hf.this).le;
                    hf hfVar2 = hf.this;
                    cVar4.xj(hfVar2, hfVar2.xj);
                }
            }
        });
        if (this.lm || this.qi > 0.0f) {
            u.xj().hf().xj(this.d, this.xj, new xj.InterfaceC0033xj() { // from class: com.bytedance.adsdk.ugeno.widget.image.hf.3
                @Override // com.bytedance.adsdk.ugeno.xj.InterfaceC0033xj
                public void xj(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap xj = f.xj(((w) hf.this).hf, bitmap, hf.this.qi > 0.0f ? (int) hf.this.qi : 10);
                    f.xj(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.hf.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (xj != null) {
                                ((RoundImageView) ((w) hf.this).kd).setBackground(new BitmapDrawable(((w) hf.this).hf.getResources(), xj));
                            }
                        }
                    });
                }
            });
        }
    }

    private void tu() {
        if (TextUtils.isEmpty(this.xj)) {
            return;
        }
        ((RoundImageView) this.kd).setImageDrawable(null);
        if (this.xj.startsWith("local://")) {
            try {
                String replace = this.xj.replace("local://", "");
                if (TextUtils.equals(c(), "raw")) {
                    ((RoundImageView) this.kd).setImageResource(com.bytedance.adsdk.ugeno.y.u.xj(this.hf, replace));
                    return;
                } else {
                    ((RoundImageView) this.kd).setImageResource(com.bytedance.adsdk.ugeno.y.u.hf(this.hf, replace));
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (!this.xj.startsWith("@")) {
            s();
            return;
        }
        try {
            ((RoundImageView) this.kd).setImageResource(Integer.parseInt(this.xj.substring(1)));
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    private ImageView.ScaleType p(String str) {
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
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    public String c() {
        return this.vi;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RoundImageView xj() {
        RoundImageView roundImageView = new RoundImageView(this.hf);
        roundImageView.xj(this);
        return roundImageView;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        tu();
        ((RoundImageView) this.kd).setScaleType(this.my);
        ((RoundImageView) this.kd).setBorderColor(this.qd);
        ((RoundImageView) this.kd).setCornerRadius(this.n);
        ((RoundImageView) this.kd).setBorderWidth(this.dq);
        int i = this.cu;
        if (i != -1) {
            ((RoundImageView) this.kd).setColorFilter(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w, com.bytedance.adsdk.ugeno.w
    public void kd() {
        super.kd();
        ((RoundImageView) this.kd).post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.hf.4
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = ((RoundImageView) ((w) hf.this).kd).getDrawable();
                if (Build.VERSION.SDK_INT < 28 || !ADYaiT.BI9f7h(drawable)) {
                    return;
                }
                ADYaiT.AaHO0E(drawable).start();
            }
        });
    }

    public void pl(String str) {
        this.xj = str;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w, com.bytedance.adsdk.ugeno.w
    public void y() {
        super.y();
        Drawable drawable = ((RoundImageView) this.kd).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !ADYaiT.BI9f7h(drawable)) {
            return;
        }
        ADYaiT.AaHO0E(drawable).stop();
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
            case "scaleType":
                this.my = p(str2);
                break;
            case "imageBlur":
                this.no = com.bytedance.adsdk.ugeno.y.w.xj(str2, -1.0f);
                break;
            case "isBgGaussianBlur":
                this.lm = com.bytedance.adsdk.ugeno.y.w.xj(str2, false);
                break;
            case "src":
                this.xj = str2;
                break;
            case "tintColor":
                this.cu = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
                break;
            case "imageBgBlur":
                this.qi = com.bytedance.adsdk.ugeno.y.w.xj(str2, -1.0f);
                break;
        }
    }

    public void hf(Drawable drawable) {
        ((RoundImageView) this.kd).setImageDrawable(drawable);
    }
}
