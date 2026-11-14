package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;
import com.bytedance.sdk.component.adexpress.dynamic.u.d;
import com.bytedance.sdk.component.adexpress.dynamic.w.c;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.adexpress.hf.g;
import com.bytedance.sdk.component.adexpress.u.y;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.y.am;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.tf;
import com.bytedance.sdk.component.y.zg;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicBaseWidgetImp extends DynamicBaseWidget {
    private static String jk = "";
    private Runnable hf;
    private ImageView ht;
    private volatile boolean pz;
    protected InteractViewContainer v;
    private Runnable xj;

    public static class hf implements dk<Bitmap> {
        private final WeakReference<DynamicBaseWidget> hf;
        private final WeakReference<View> xj;

        public hf(View view, DynamicBaseWidget dynamicBaseWidget) {
            this.xj = new WeakReference<>(view);
            this.hf = new WeakReference<>(dynamicBaseWidget);
        }

        @Override // com.bytedance.sdk.component.y.dk
        public void onFailed(int i, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.component.y.dk
        public void onSuccess(zg<Bitmap> zgVar) {
            Bitmap result;
            DynamicBaseWidget dynamicBaseWidget;
            View view = this.xj.get();
            if (view == null || (result = zgVar.getResult()) == null || zgVar.getOriginResult() == null || (dynamicBaseWidget = this.hf.get()) == null) {
                return;
            }
            view.setBackground(dynamicBaseWidget.xj(result));
        }
    }

    public static class w implements tf {
        private final int hf;
        private final WeakReference<Context> xj;

        public w(Context context, int i) {
            this.xj = new WeakReference<>(context);
            this.hf = i;
        }

        @Override // com.bytedance.sdk.component.y.tf
        public Bitmap coverterTo(Bitmap bitmap) {
            Context context = this.xj.get();
            if (context != null) {
                return com.bytedance.sdk.component.adexpress.u.hf.xj(context, bitmap, this.hf);
            }
            return null;
        }
    }

    public static class xj implements dk<Bitmap> {
        private final WeakReference<DynamicRootView> hf;
        private final f w;
        private final WeakReference<View> xj;

        public xj(View view, DynamicRootView dynamicRootView, f fVar) {
            this.xj = new WeakReference<>(view);
            this.hf = new WeakReference<>(dynamicRootView);
            this.w = fVar;
        }

        @Override // com.bytedance.sdk.component.y.dk
        public void onFailed(int i, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.component.y.dk
        public void onSuccess(zg<Bitmap> zgVar) {
            View view = this.xj.get();
            if (!com.bytedance.sdk.component.adexpress.u.xj()) {
                DynamicRootView dynamicRootView = this.hf.get();
                if (dynamicRootView == null) {
                    return;
                }
                if ("open_ad".equals(dynamicRootView.getRenderRequest().y()) || "splash_ad".equals(dynamicRootView.getRenderRequest().y())) {
                    view.setBackground(new BitmapDrawable(zgVar.getResult()));
                    return;
                } else {
                    view.setBackground(new BitmapDrawable(zgVar.getResult()));
                    return;
                }
            }
            if (view == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(zgVar.getResult()));
            f fVar = this.w;
            if (fVar == null || fVar.tf() == null || 6 != this.w.tf().xj() || view.getBackground() == null) {
                return;
            }
            view.getBackground().setAutoMirrored(true);
        }
    }

    public DynamicBaseWidgetImp(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        this.pz = true;
        setTag(Integer.valueOf(getClickArea()));
        String type = fVar.tf().getType();
        if ("logo-union".equals(type)) {
            dynamicRootView.setLogoUnionHeight(this.f - ((int) com.bytedance.sdk.component.adexpress.u.f.xj(context, this.f10177pl.xj() + this.f10177pl.hf())));
        } else if ("scoreCountWithIcon".equals(type)) {
            dynamicRootView.setScoreCountWithIcon(this.f - ((int) com.bytedance.sdk.component.adexpress.u.f.xj(context, this.f10177pl.xj() + this.f10177pl.hf())));
        }
    }

    private void d() {
        if (this.pz) {
            int vm = this.f10177pl.vm();
            int dc = this.f10177pl.dc();
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.6
                @Override // java.lang.Runnable
                public void run() {
                    DynamicRootView dynamicRootView = DynamicBaseWidgetImp.this.am;
                    if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                        DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp.v = new InteractViewContainer(dynamicBaseWidgetImp2.p, dynamicBaseWidgetImp2, dynamicBaseWidgetImp2.f10177pl);
                    } else {
                        g renderRequest = DynamicBaseWidgetImp.this.am.getRenderRequest();
                        com.bytedance.sdk.component.adexpress.dynamic.w.tf tfVar = new com.bytedance.sdk.component.adexpress.dynamic.w.tf();
                        tfVar.xj(renderRequest.yo());
                        tfVar.hf(renderRequest.v());
                        tfVar.w(renderRequest.jk());
                        tfVar.xj(renderRequest.pz());
                        tfVar.hf(renderRequest.ht());
                        tfVar.w(renderRequest.ra());
                        tfVar.u(renderRequest.dk());
                        tfVar.kd(renderRequest.et());
                        DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                        DynamicBaseWidgetImp dynamicBaseWidgetImp4 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp3.v = new InteractViewContainer(dynamicBaseWidgetImp4.p, dynamicBaseWidgetImp4, dynamicBaseWidgetImp4.f10177pl, tfVar, renderRequest);
                    }
                    DynamicBaseWidgetImp dynamicBaseWidgetImp5 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp5.hf(dynamicBaseWidgetImp5.v);
                    if (DynamicBaseWidgetImp.this.getParent() instanceof ViewGroup) {
                        ((ViewGroup) DynamicBaseWidgetImp.this.getParent()).setClipChildren(false);
                    }
                    DynamicBaseWidgetImp.this.setClipChildren(false);
                    DynamicBaseWidgetImp.this.v.setTag(2);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp6 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp6.xj((ViewGroup) dynamicBaseWidgetImp6);
                    DynamicBaseWidgetImp dynamicBaseWidgetImp7 = DynamicBaseWidgetImp.this;
                    dynamicBaseWidgetImp7.addView(dynamicBaseWidgetImp7.v, new FrameLayout.LayoutParams(-1, -1));
                    DynamicBaseWidgetImp.this.v.w();
                }
            };
            this.xj = runnable;
            postDelayed(runnable, vm * 1000);
            if (this.f10177pl.wn() || dc >= Integer.MAX_VALUE || vm >= dc) {
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.7
                @Override // java.lang.Runnable
                public void run() {
                    DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                    if (dynamicBaseWidgetImp.v != null) {
                        dynamicBaseWidgetImp.pz = false;
                        DynamicBaseWidgetImp.this.v.u();
                        DynamicBaseWidgetImp.this.v.setVisibility(4);
                        DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                        dynamicBaseWidgetImp2.removeView(dynamicBaseWidgetImp2.v);
                    }
                }
            };
            this.hf = runnable2;
            postDelayed(runnable2, dc * 1000);
        }
    }

    private static String getBuildModel() {
        try {
            jk = com.bytedance.sdk.component.utils.dk.xj();
        } catch (Throwable unused) {
            jk = Build.MODEL;
        }
        if (TextUtils.isEmpty(jk)) {
            jk = Build.MODEL;
        }
        return jk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable hf(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            String str2 = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getString(i).startsWith("#")) {
                    arrayList.add(jSONArray.getString(i));
                } else if (jSONArray.getString(i).endsWith("deg")) {
                    str2 = jSONArray.getString(i);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = c.xj(((String) arrayList.get(i2)).substring(0, 7));
            }
            GradientDrawable xj2 = xj(xj(str2), iArr);
            xj2.setShape(0);
            xj2.setCornerRadius(com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.qt()));
            return xj2;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public boolean f() {
        Drawable backgroundDrawable;
        DynamicRootView dynamicRootView;
        JSONObject optJSONObject;
        final View view = this.qt;
        if (view == null) {
            view = this;
        }
        setContentDescription(this.g.xj(this.f10177pl.x()));
        String ne = this.f10177pl.ne();
        String str = null;
        String xj2 = (TextUtils.isEmpty(ne) || (dynamicRootView = this.am) == null || dynamicRootView.getRenderRequest() == null || this.am.getRenderRequest().kd() == null || (optJSONObject = this.am.getRenderRequest().kd().optJSONObject("creative")) == null) ? null : xj(optJSONObject.opt(ne));
        if (TextUtils.isEmpty(xj2)) {
            xj2 = this.f10177pl.pz();
        }
        if (this.f10177pl.jk()) {
            com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().kd().from(this.f10177pl.hf).type(2).converter(new w(this.p, this.f10177pl.v())).to(new hf(view, this));
        } else if (!TextUtils.isEmpty(xj2)) {
            if (!xj2.startsWith("http:") && !xj2.startsWith("https:")) {
                DynamicRootView dynamicRootView2 = this.am;
                if (dynamicRootView2 != null && dynamicRootView2.getRenderRequest() != null) {
                    str = this.am.getRenderRequest().x();
                }
                xj2 = d.hf(xj2, str);
            }
            am type = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().kd().from(xj2).type(2);
            xj(type);
            if (com.bytedance.sdk.component.adexpress.u.xj()) {
                type.to(new xj(view, this.am, this.g));
            } else if ((view instanceof FrameLayout) && A2egSU.BNL6CD(this.g, "vessel")) {
                if (com.bytedance.sdk.component.adexpress.u.tf.hf(xj2)) {
                    this.ht = new GifView(this.p);
                } else {
                    this.ht = new ImageView(this.p);
                }
                ((FrameLayout) view).addView(this.ht, new FrameLayout.LayoutParams(-1, -1));
                type.type(3).to(new dk() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.1
                    @Override // com.bytedance.sdk.component.y.dk
                    public void onFailed(int i, String str2, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.y.dk
                    public void onSuccess(zg zgVar) {
                        Object result = zgVar.getResult();
                        if (result instanceof byte[]) {
                            DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                            y.hf(DynamicBaseWidgetImp.this.ht, (byte[]) result, dynamicBaseWidgetImp.c, dynamicBaseWidgetImp.f);
                        }
                    }
                }, 4);
            } else {
                xj(type, view);
            }
        }
        if (getBackground() == null && (backgroundDrawable = getBackgroundDrawable()) != null) {
            view.setBackground(backgroundDrawable);
        }
        if (this.f10177pl.q() > 0.0d) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (DynamicBaseWidgetImp.this.f10177pl.ff() > 0) {
                            DynamicBaseWidgetImp dynamicBaseWidgetImp = DynamicBaseWidgetImp.this;
                            Drawable hf2 = dynamicBaseWidgetImp.hf(dynamicBaseWidgetImp.am.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.f10177pl.ff())));
                            if (hf2 == null) {
                                DynamicBaseWidgetImp dynamicBaseWidgetImp2 = DynamicBaseWidgetImp.this;
                                hf2 = dynamicBaseWidgetImp2.xj(true, dynamicBaseWidgetImp2.am.getBgMaterialCenterCalcColor().get(Integer.valueOf(DynamicBaseWidgetImp.this.f10177pl.ff())));
                            }
                            if (hf2 != null) {
                                view.setBackground(hf2);
                                return;
                            }
                            View view2 = view;
                            DynamicBaseWidgetImp dynamicBaseWidgetImp3 = DynamicBaseWidgetImp.this;
                            view2.setBackground(dynamicBaseWidgetImp3.xj(true, dynamicBaseWidgetImp3.am.getBgColor()));
                        }
                    } catch (Exception unused) {
                    }
                }
            }, (long) (this.f10177pl.q() * 1000.0d));
        }
        View view2 = this.qt;
        if (view2 != null) {
            view2.setPadding((int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.w()), (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.hf()), (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.u()), (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.xj()));
        }
        if (this.zg || this.f10177pl.am() > 0.0d) {
            setShouldInvisible(true);
            view.setVisibility(4);
            setVisibility(4);
        }
        return true;
    }

    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.c, this.f);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        View view = this.qt;
        if (view == null) {
            view = this;
        }
        double jk2 = this.g.tf().kd().jk();
        if (jk2 < 90.0d && jk2 > 0.0d) {
            com.bytedance.sdk.component.utils.f.hf().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.4
                @Override // java.lang.Runnable
                public void run() {
                    DynamicBaseWidgetImp.this.setVisibility(8);
                }
            }, (long) (jk2 * 1000.0d));
        }
        xj(this.g.tf().kd().v(), view);
        if (!TextUtils.isEmpty(this.f10177pl.eu())) {
            d();
        }
        super.onAttachedToWindow();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            removeCallbacks(this.xj);
            removeCallbacks(this.hf);
        } catch (Exception unused) {
        }
    }

    private String xj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof JSONArray) {
            return xj(((JSONArray) obj).opt(0));
        }
        if (obj instanceof JSONObject) {
            return xj((Object) ((JSONObject) obj).optString("url"));
        }
        return null;
    }

    private void xj(am amVar, final View view) {
        amVar.to(new dk<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.3
            @Override // com.bytedance.sdk.component.y.dk
            public void onFailed(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.y.dk
            public void onSuccess(zg<Bitmap> zgVar) {
                DynamicRootView dynamicRootView = DynamicBaseWidgetImp.this.am;
                if (dynamicRootView == null) {
                    return;
                }
                if (!"open_ad".equals(dynamicRootView.getRenderRequest().y()) && !"splash_ad".equals(DynamicBaseWidgetImp.this.am.getRenderRequest().y())) {
                    view.setBackground(new BitmapDrawable(zgVar.getResult()));
                } else {
                    if (!com.bytedance.sdk.component.adexpress.u.xj()) {
                        view.setBackground(new BitmapDrawable(zgVar.getResult()));
                        return;
                    }
                    view.setBackground(new com.bytedance.sdk.component.adexpress.dynamic.dynamicview.xj(zgVar.getResult(), ((DynamicRoot) DynamicBaseWidgetImp.this.am.getChildAt(0)).xj));
                }
            }
        });
    }

    private static void xj(am amVar) {
        if ("SMARTISAN".equals(Build.BRAND) && "SM901".equals(getBuildModel())) {
            amVar.config(Bitmap.Config.ARGB_8888);
        }
    }

    private void xj(double d, final View view) {
        if (d > 0.0d) {
            com.bytedance.sdk.component.utils.f.hf().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp.5
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicBaseWidgetImp.this.g.tf().kd().cu() != null) {
                        return;
                    }
                    view.setVisibility(0);
                    DynamicBaseWidgetImp.this.setVisibility(0);
                }
            }, (long) (d * 1000.0d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) instanceof InteractViewContainer) {
                viewGroup.removeViewAt(i);
            }
        }
    }
}
