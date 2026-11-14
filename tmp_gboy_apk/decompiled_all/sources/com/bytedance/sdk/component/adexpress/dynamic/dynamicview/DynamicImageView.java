package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import I3HV03.ADYaiT;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationImageView;
import com.bytedance.sdk.component.adexpress.dynamic.u.d;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.adexpress.hf.g;
import com.bytedance.sdk.component.adexpress.u.y;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.adexpress.widget.TTRoundRectImageView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.y.am;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.ht;
import com.bytedance.sdk.component.y.tf;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicImageView extends DynamicBaseWidgetImp {
    private String xj;

    public static class hf implements dk<Bitmap> {
        private Resources hf;
        private WeakReference<View> xj;

        public hf(View view, Resources resources) {
            this.xj = new WeakReference<>(view);
            this.hf = resources;
        }

        @Override // com.bytedance.sdk.component.y.dk
        public void onFailed(int i, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.component.y.dk
        public void onSuccess(zg<Bitmap> zgVar) {
            Bitmap result;
            View view = this.xj.get();
            if (view == null || (result = zgVar.getResult()) == null || zgVar.getOriginResult() == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(this.hf, result));
        }
    }

    public static class xj implements tf {
        private final WeakReference<Context> xj;

        public xj(Context context) {
            this.xj = new WeakReference<>(context);
        }

        @Override // com.bytedance.sdk.component.y.tf
        public Bitmap coverterTo(Bitmap bitmap) {
            Context context = this.xj.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.u.hf.xj(context, bitmap, 25);
            }
            return null;
        }
    }

    public DynamicImageView(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        if (!TextUtils.isEmpty(this.f10177pl.ss()) && fVar.v()) {
            DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
            dynamicLottieView.setAnimationsLoop(this.f10177pl.gj());
            dynamicLottieView.setImageLottieTosPath(this.f10177pl.ss());
            dynamicLottieView.setLottieAppNameMaxLength(this.f10177pl.vl());
            dynamicLottieView.setLottieAdTitleMaxLength(this.f10177pl.xv());
            dynamicLottieView.setLottieAdDescMaxLength(this.f10177pl.cy());
            dynamicLottieView.setData(fVar.jk());
            this.qt = dynamicLottieView;
        } else if (this.f10177pl.qt() > 0.0f) {
            TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
            this.qt = tTRoundRectImageView;
            tTRoundRectImageView.setXRound((int) com.bytedance.sdk.component.adexpress.u.f.xj(context, this.f10177pl.qt()));
            ((TTRoundRectImageView) this.qt).setYRound((int) com.bytedance.sdk.component.adexpress.u.f.xj(context, this.f10177pl.qt()));
        } else if (!c() && "arrowButton".equals(fVar.tf().getType())) {
            AnimationImageView animationImageView = new AnimationImageView(context);
            animationImageView.setBrickNativeValue(this.f10177pl);
            this.qt = animationImageView;
        } else if (com.bytedance.sdk.component.adexpress.u.tf.hf(this.f10177pl.p())) {
            this.qt = new GifView(context);
        } else {
            String p = this.f10177pl.p();
            g renderRequest = dynamicRootView.getRenderRequest();
            if (renderRequest == null || renderRequest.hf() == null || !TextUtils.equals(p, renderRequest.xj())) {
                this.qt = new ImageView(context);
            } else {
                this.qt = renderRequest.hf();
            }
        }
        this.xj = hf(this.f10177pl.p());
        this.qt.setTag(Integer.valueOf(getClickArea()));
        if ("arrowButton".equals(fVar.tf().getType())) {
            if (this.f10177pl.hf() > 0 || this.f10177pl.xj() > 0) {
                int min = Math.min(this.c, this.f);
                this.c = min;
                this.f = Math.min(min, this.f);
                this.d = (int) (com.bytedance.sdk.component.adexpress.u.f.xj(context, (this.f10177pl.xj() / 2) + this.f10177pl.hf() + 0.5f) + this.d);
            } else {
                int max = Math.max(this.c, this.f);
                this.c = max;
                this.f = Math.max(max, this.f);
            }
            this.f10177pl.xj(this.c / 2);
        }
        addView(this.qt, new FrameLayout.LayoutParams(this.c, this.f));
    }

    private boolean d() {
        String pl2 = this.f10177pl.pl();
        if (this.f10177pl.jk()) {
            return true;
        }
        if (TextUtils.isEmpty(pl2)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(pl2);
            return Math.abs((((float) this.c) / (((float) this.f) * 1.0f)) - (((float) jSONObject.optInt(MediaFormat.KEY_WIDTH)) / (((float) jSONObject.optInt(MediaFormat.KEY_HEIGHT)) * 1.0f))) > 0.01f;
        } catch (JSONException e) {
            pl.xj(e);
            return false;
        }
    }

    private void xj(am amVar) {
        amVar.type(3).to(new dk() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView.1
            @Override // com.bytedance.sdk.component.y.dk
            public void onFailed(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.y.dk
            public void onSuccess(zg zgVar) {
                Object result = zgVar.getResult();
                if (result instanceof byte[]) {
                    DynamicImageView dynamicImageView = DynamicImageView.this;
                    View view = dynamicImageView.qt;
                    if (view instanceof ImageView) {
                        y.hf((ImageView) view, (byte[]) result, dynamicImageView.c, dynamicImageView.f);
                    }
                }
            }
        }, 4);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        super.f();
        try {
            View view = this.qt;
            if (view instanceof UpieImageView) {
                view.setBackgroundColor(this.f10177pl.ai());
                if (d()) {
                    ((UpieImageView) this.qt).setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    ((UpieImageView) this.qt).setScaleType(ImageView.ScaleType.FIT_XY);
                }
                if ("cover".equals(getImageObjectFit())) {
                    ((UpieImageView) this.qt).setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                return true;
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        if (!TextUtils.isEmpty(this.f10177pl.ss())) {
            ((ImageView) this.qt).setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        }
        if ("arrowButton".equals(this.g.tf().getType())) {
            ((ImageView) this.qt).setImageResource(jk.kd(this.p, "tt_white_righterbackicon_titlebar"));
            if (((ImageView) this.qt).getDrawable() != null) {
                ((ImageView) this.qt).getDrawable().setAutoMirrored(true);
            }
            this.qt.setPadding(0, 0, 0, 0);
            ((ImageView) this.qt).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        this.qt.setBackgroundColor(this.f10177pl.ai());
        String hf2 = this.g.tf().hf();
        if ("user".equals(hf2)) {
            ((ImageView) this.qt).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ((ImageView) this.qt).setColorFilter(this.f10177pl.c());
            jk.xj(getContext(), "tt_user", (ImageView) this.qt);
            ImageView imageView = (ImageView) this.qt;
            int i = this.c;
            imageView.setPadding(i / 10, this.f / 5, i / 10, 0);
        } else if (hf2 != null && hf2.startsWith("@")) {
            try {
                ((ImageView) this.qt).setImageResource(Integer.parseInt(hf2.substring(1)));
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        ht kd = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().kd();
        String p = this.f10177pl.p();
        if (!TextUtils.isEmpty(p) && !p.startsWith("http:") && !p.startsWith("https:")) {
            DynamicRootView dynamicRootView = this.am;
            p = d.hf(p, (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) ? null : this.am.getRenderRequest().x());
        }
        am key = kd.from(p).key(this.xj);
        String e2 = this.am.getRenderRequest().e();
        if (!TextUtils.isEmpty(e2)) {
            key.cacheDir(e2);
        }
        if (d()) {
            ((ImageView) this.qt).setScaleType(ImageView.ScaleType.FIT_CENTER);
            key.config(Bitmap.Config.ARGB_4444).type(2).converter(new xj(this.p)).to(new hf(this.qt, getResources()));
        } else {
            if (com.bytedance.sdk.component.adexpress.u.xj()) {
                key.to((ImageView) this.qt);
            }
            ((ImageView) this.qt).setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if ((this.qt instanceof ImageView) && "cover".equals(getImageObjectFit())) {
            ((ImageView) this.qt).setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (!com.bytedance.sdk.component.adexpress.u.xj()) {
            xj(key);
        }
        return true;
    }

    public String hf(String str) {
        Map<String, String> am = this.am.getRenderRequest().am();
        if (am == null || am.size() <= 0) {
            return null;
        }
        return am.get(str);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View view = this.qt;
        if (view instanceof ImageView) {
            Drawable drawable = ((ImageView) view).getDrawable();
            if (Build.VERSION.SDK_INT < 28 || !ADYaiT.BI9f7h(drawable)) {
                return;
            }
            ADYaiT.AaHO0E(drawable).start();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        View view = this.qt;
        if (view instanceof ImageView) {
            Drawable drawable = ((ImageView) view).getDrawable();
            if (Build.VERSION.SDK_INT < 28 || !ADYaiT.BI9f7h(drawable)) {
                return;
            }
            ADYaiT.AaHO0E(drawable).stop();
        }
    }
}
