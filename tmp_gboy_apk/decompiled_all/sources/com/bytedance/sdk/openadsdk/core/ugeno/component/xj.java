package com.bytedance.sdk.openadsdk.core.ugeno.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.adsdk.ugeno.widget.image.RoundImageView;
import com.bytedance.adsdk.ugeno.y.u;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.f.hf;
import com.bytedance.sdk.openadsdk.x.c;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends w<RoundImageView> {
    protected int my;
    protected String xj;

    public xj(Context context) {
        super(context);
        this.my = 25;
    }

    private void f() {
        if (TextUtils.isEmpty(this.xj)) {
            return;
        }
        ((RoundImageView) this.kd).setImageDrawable(null);
        if (this.xj.startsWith("local://")) {
            c.xj(new d("UG_decode_img") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap decodeResource = BitmapFactory.decodeResource(((w) xj.this).hf.getResources(), u.w(((w) xj.this).hf, xj.this.xj.replace("local://", "")));
                    if (decodeResource != null) {
                        xj.this.xj(decodeResource);
                    }
                }
            });
        } else {
            hf.xj(this.xj).type(2).to(new dk() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.xj.2
                @Override // com.bytedance.sdk.component.y.dk
                public void onFailed(int i, String str, Throwable th) {
                    pl.hf("UGBlurWidget", str, th);
                }

                @Override // com.bytedance.sdk.component.y.dk
                public void onSuccess(zg zgVar) {
                    Object result = zgVar.getResult();
                    if (result == null || !(result instanceof Bitmap)) {
                        return;
                    }
                    xj.this.xj((Bitmap) result);
                }
            }, 4);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public RoundImageView xj() {
        RoundImageView roundImageView = new RoundImageView(this.hf);
        roundImageView.xj(this);
        return roundImageView;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        f();
        ((RoundImageView) this.kd).setScaleType(ImageView.ScaleType.FIT_XY);
        ((RoundImageView) this.kd).setBorderColor(this.qd);
        ((RoundImageView) this.kd).setCornerRadius(this.n);
        ((RoundImageView) this.kd).setBorderWidth(this.dq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Bitmap bitmap) {
        final Bitmap xj = com.bytedance.sdk.component.adexpress.u.hf.xj(this.hf, bitmap, 25);
        if (xj != null) {
            c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.xj.3
                @Override // java.lang.Runnable
                public void run() {
                    if (((w) xj.this).kd != null) {
                        ((RoundImageView) ((w) xj.this).kd).setImageBitmap(xj);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.xj(str, str2);
        str.getClass();
        if (!str.equals("blurRate")) {
            if (str.equals("src")) {
                this.xj = str2;
            }
        } else {
            try {
                this.my = Integer.parseInt(str2);
            } catch (Exception e) {
                pl.hf("UGBlurWidget", e);
            }
        }
    }
}
