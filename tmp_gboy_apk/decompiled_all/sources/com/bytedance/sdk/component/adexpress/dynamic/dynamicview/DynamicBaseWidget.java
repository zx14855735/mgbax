package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.component.sdk.annotation.ColorInt;
import com.bytedance.sdk.component.adexpress.dynamic.w.c;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;
import com.bytedance.sdk.component.adexpress.dynamic.w.y;
import com.bytedance.sdk.component.adexpress.hf.g;
import com.bytedance.sdk.component.utils.ht;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class DynamicBaseWidget extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.animation.view.hf, kd, u {
    protected DynamicRootView am;
    protected int c;
    protected int d;
    protected com.bytedance.sdk.component.adexpress.dynamic.animation.xj.hf e;
    protected int f;
    protected f g;
    private float hf;
    private boolean ht;
    private float jk;
    protected float kd;
    protected Context p;

    /* renamed from: pl, reason: collision with root package name */
    protected c f10177pl;
    private ht pz;
    protected View qt;
    protected int tf;
    protected float u;
    private float v;
    protected float w;
    private float xj;
    protected float y;
    com.bytedance.sdk.component.adexpress.dynamic.animation.view.xj yo;
    protected boolean zg;
    private static final View.OnTouchListener ra = new View.OnTouchListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };
    private static final View.OnClickListener dk = new View.OnClickListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };

    static {
        pJnd();
    }

    public DynamicBaseWidget(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context);
        this.ht = true;
        this.p = context;
        this.am = dynamicRootView;
        this.g = fVar;
        this.w = fVar.y();
        this.u = fVar.c();
        this.kd = fVar.f();
        this.y = fVar.d();
        this.d = (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.w);
        this.tf = (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.u);
        this.c = (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.kd);
        this.f = (int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.y);
        c cVar = new c(fVar.tf());
        this.f10177pl = cVar;
        if (cVar.yo() > 0) {
            this.c = (this.f10177pl.yo() * 2) + this.c;
            this.f = (this.f10177pl.yo() * 2) + this.f;
            this.d -= this.f10177pl.yo();
            this.tf -= this.f10177pl.yo();
            List<f> p = fVar.p();
            if (p != null) {
                for (f fVar2 : p) {
                    fVar2.w(fVar2.y() + com.bytedance.sdk.component.adexpress.u.f.hf(this.p, this.f10177pl.yo()));
                    fVar2.u(fVar2.c() + com.bytedance.sdk.component.adexpress.u.f.hf(this.p, this.f10177pl.yo()));
                    fVar2.xj(com.bytedance.sdk.component.adexpress.u.f.hf(this.p, this.f10177pl.yo()));
                    fVar2.hf(com.bytedance.sdk.component.adexpress.u.f.hf(this.p, this.f10177pl.yo()));
                }
            }
        }
        this.zg = this.f10177pl.am() > 0.0d;
        this.yo = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.xj();
    }

    private void d() {
        if (isShown()) {
            int xj = com.bytedance.sdk.component.adexpress.dynamic.hf.xj.xj(this.f10177pl);
            if (xj == 2) {
                if (this.pz == null) {
                    this.pz = new ht(getContext().getApplicationContext(), 1, this.ht);
                }
                this.pz.xj(new ht.xj() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.3
                    @Override // com.bytedance.sdk.component.utils.ht.xj
                    public void xj(int i) {
                        if (i == 1 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.tf();
                        }
                    }
                });
                g renderRequest = this.am.getRenderRequest();
                if (renderRequest != null) {
                    this.pz.xj(renderRequest.yo());
                    this.pz.kd(renderRequest.dk());
                    this.pz.w(renderRequest.ht());
                    this.pz.hf(renderRequest.jk());
                    this.pz.y(renderRequest.et());
                    this.pz.xj(renderRequest.pz());
                    this.pz.hf(renderRequest.ra());
                }
            } else if (xj == 3) {
                if (this.pz == null) {
                    this.pz = new ht(getContext().getApplicationContext(), 2, this.ht);
                }
                this.pz.xj(new ht.xj() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.4
                    @Override // com.bytedance.sdk.component.utils.ht.xj
                    public void xj(int i) {
                        if (i == 2 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.tf();
                        }
                    }
                });
                g renderRequest2 = this.am.getRenderRequest();
                if (renderRequest2 != null) {
                    this.pz.hf(renderRequest2.jk());
                    this.pz.y(renderRequest2.et());
                    this.pz.xj(renderRequest2.pz());
                    this.pz.hf(renderRequest2.ra());
                }
            }
            ht htVar = this.pz;
            if (htVar != null) {
                DynamicRootView dynamicRootView = this.am;
                if (dynamicRootView == null) {
                    htVar.xj(0);
                    return;
                }
                g renderRequest3 = dynamicRootView.getRenderRequest();
                if (renderRequest3 != null) {
                    this.pz.xj(renderRequest3.q());
                }
            }
        }
    }

    private static /* synthetic */ void pJnd() {
        char[] charArray = "GKI\nCEIA\nFK]\nWLAHH\nnJMfVM@CA".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '$');
        }
        String str = new String(charArray);
        char[] charArray2 = "GHMJMP".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '$');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tf() {
        try {
            View view = this.qt;
            if (view == null) {
                view = this;
            }
            view.setOnClickListener((View.OnClickListener) getDynamicClickListener());
            view.performClick();
            view.setOnClickListener(dk);
        } catch (Exception unused) {
        }
    }

    public boolean c() {
        f fVar = this.g;
        return fVar == null || fVar.tf() == null || this.g.tf().kd() == null || this.g.tf().kd().cu() == null;
    }

    public Drawable getBackgroundDrawable() {
        return xj(false, "");
    }

    public boolean getBeginInvisibleAndShow() {
        return this.zg;
    }

    public int getClickArea() {
        return this.f10177pl.x();
    }

    public GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    public com.bytedance.sdk.component.adexpress.dynamic.kd.xj getDynamicClickListener() {
        return this.am.getDynamicClickListener();
    }

    public int getDynamicHeight() {
        return this.f;
    }

    public y getDynamicLayoutBrickValue() {
        com.bytedance.sdk.component.adexpress.dynamic.w.kd tf;
        f fVar = this.g;
        if (fVar == null || (tf = fVar.tf()) == null) {
            return null;
        }
        return tf.kd();
    }

    public int getDynamicWidth() {
        return this.c;
    }

    public String getImageObjectFit() {
        return this.f10177pl.tu();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.hf
    public float getMarqueeValue() {
        return this.v;
    }

    public Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(xj(hf(this.f10177pl.a().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.hf
    public float getRippleValue() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.hf
    public float getShineValue() {
        return this.hf;
    }

    public float getStretchValue() {
        return this.jk;
    }

    public void hf(View view) {
        y kd;
        f fVar = this.g;
        if (fVar == null || (kd = fVar.tf().kd()) == null) {
            return;
        }
        view.setTag(2097610716, Boolean.valueOf(kd.ic()));
    }

    public void kd() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.c, this.f);
        layoutParams.topMargin = this.tf;
        int i = this.d;
        layoutParams.leftMargin = i;
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        y();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        hf();
        super.onDetachedFromWindow();
        if (this.pz != null) {
            DynamicRootView dynamicRootView = this.am;
            if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                this.pz.hf(0);
            } else {
                this.pz.hf(this.am.getRenderRequest().q());
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.yo.xj(canvas, this, this);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.sdk.component.adexpress.dynamic.animation.view.xj xjVar = this.yo;
        View view = this.qt;
        if (view == null) {
            view = this;
        }
        xjVar.xj(view, i, i2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.pz != null) {
            DynamicRootView dynamicRootView = this.am;
            if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                if (z) {
                    this.pz.xj(0);
                    return;
                } else {
                    this.pz.hf(0);
                    return;
                }
            }
            if (z) {
                this.pz.xj(this.am.getRenderRequest().q());
            } else {
                this.pz.hf(this.am.getRenderRequest().q());
            }
        }
    }

    public void setCanUseSensor(boolean z) {
        this.ht = z;
    }

    public void setMarqueeValue(float f) {
        this.v = f;
        postInvalidate();
    }

    public void setRippleValue(float f) {
        this.xj = f;
        postInvalidate();
    }

    public void setShineValue(float f) {
        this.hf = f;
        postInvalidate();
    }

    public void setShouldInvisible(boolean z) {
        this.zg = z;
    }

    public void setStretchValue(float f) {
        this.jk = f;
        this.yo.xj(this, f);
    }

    public boolean u() {
        c cVar = this.f10177pl;
        return (cVar == null || cVar.x() == 0) ? false : true;
    }

    public boolean w() {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.qt;
        if (view == null) {
            view = this;
        }
        if (u()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = ra;
            onClickListener = dk;
        }
        if (onTouchListener != null && onClickListener != null) {
            view.setOnTouchListener(onTouchListener);
            view.setOnClickListener(onClickListener);
            int xj = com.bytedance.sdk.component.adexpress.dynamic.hf.xj.xj(this.f10177pl);
            if (xj == 2 || xj == 3) {
                view.setOnClickListener(dk);
            } else {
                view.setOnClickListener(onClickListener);
            }
        }
        xj(view);
        hf(view);
        return true;
    }

    public void y() {
        if (c()) {
            return;
        }
        View view = this.qt;
        if (view == null) {
            view = this;
        }
        com.bytedance.sdk.component.adexpress.dynamic.animation.xj.hf hfVar = new com.bytedance.sdk.component.adexpress.dynamic.animation.xj.hf(view, this.g.tf().kd().cu());
        this.e = hfVar;
        hfVar.xj();
    }

    public boolean xj() {
        f();
        kd();
        w();
        return true;
    }

    private List<String> hf(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == '(') {
                i++;
                z = true;
            } else if (str.charAt(i3) == ')' && i - 1 == 0 && z) {
                int i4 = i3 + 1;
                arrayList.add(str.substring(i2, i4));
                i2 = i4;
                z = false;
            }
        }
        return arrayList;
    }

    public void xj(int i) {
        c cVar = this.f10177pl;
        if (cVar != null && cVar.xj(i)) {
            f();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && (getChildAt(i2) instanceof DynamicBaseWidget)) {
                    ((DynamicBaseWidget) childAt).xj(i);
                }
            }
        }
    }

    public void hf() {
        com.bytedance.sdk.component.adexpress.dynamic.animation.xj.hf hfVar = this.e;
        if (hfVar != null) {
            hfVar.hf();
        }
    }

    public void xj(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediaFormat.KEY_WIDTH, this.g.f());
            jSONObject.put(MediaFormat.KEY_HEIGHT, this.g.d());
            if (com.bytedance.sdk.component.adexpress.u.xj()) {
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.xj.jk, this.f10177pl.wo());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.xj.pz, this.g.tf().getType());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.xj.ht, this.g.w());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.xj.ra, jSONObject.toString());
                return;
            }
            view.setTag(2097610717, this.f10177pl.wo());
            view.setTag(2097610715, this.g.tf().getType());
            view.setTag(2097610714, this.g.w());
            view.setTag(2097610713, jSONObject.toString());
            int xj = com.bytedance.sdk.component.adexpress.dynamic.hf.xj.xj(this.f10177pl);
            if (xj == 1) {
                view.setTag(2097610707, new Pair(this.f10177pl.et(), Long.valueOf(this.f10177pl.io())));
                view.setTag(2097610708, Integer.valueOf(xj));
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
    }

    public Drawable xj(boolean z, String str) {
        String[] split;
        int[] iArr;
        int ai;
        if (!TextUtils.isEmpty(this.f10177pl.a())) {
            try {
                String a2 = this.f10177pl.a();
                String substring = a2.substring(a2.indexOf("(") + 1, a2.length() - 1);
                if (substring.contains("rgba") && substring.contains("%")) {
                    split = new String[]{substring.substring(0, substring.indexOf(",")).trim(), substring.substring(substring.indexOf(",") + 1, substring.indexOf("%") + 1).trim(), substring.substring(substring.indexOf("%") + 2).trim()};
                    iArr = new int[]{c.xj(split[1]), c.xj(split[2])};
                } else {
                    split = substring.split(", ");
                    iArr = new int[]{c.xj(split[1].substring(0, 7)), c.xj(split[2].substring(0, 7))};
                }
                try {
                    double parseDouble = Double.parseDouble(substring.substring(substring.indexOf("linear-gradient(") + 1, substring.indexOf("deg")));
                    if (parseDouble > 225.0d && parseDouble < 315.0d) {
                        int i = iArr[1];
                        iArr[1] = iArr[0];
                        iArr[0] = i;
                    }
                } catch (Exception unused) {
                }
                GradientDrawable xj = xj(xj(split[0]), iArr);
                xj.setShape(0);
                xj.setCornerRadius(com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.qt()));
                return xj;
            } catch (Exception unused2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float xj2 = com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.qt());
        drawable.setCornerRadius(xj2);
        if (xj2 < 1.0f) {
            float xj3 = com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.z());
            float xj4 = com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.j());
            float xj5 = com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.en());
            float xj6 = com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.l());
            float[] fArr = new float[8];
            if (xj3 > 0.0f) {
                fArr[0] = xj3;
                fArr[1] = xj3;
            }
            if (xj4 > 0.0f) {
                fArr[2] = xj4;
                fArr[3] = xj4;
            }
            if (xj5 > 0.0f) {
                fArr[4] = xj5;
                fArr[5] = xj5;
            }
            if (xj6 > 0.0f) {
                fArr[6] = xj6;
                fArr[7] = xj6;
            }
            drawable.setCornerRadii(fArr);
        }
        if (z) {
            ai = Color.parseColor(str);
        } else {
            ai = this.f10177pl.ai();
        }
        drawable.setColor(ai);
        if (this.f10177pl.e() > 0.0f) {
            drawable.setStroke((int) com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.e()), this.f10177pl.zg());
        } else if (this.f10177pl.yo() > 0) {
            drawable.setStroke(this.f10177pl.yo(), this.f10177pl.zg());
            drawable.setAlpha(50);
            if (A2egSU.BNL6CD(this.g, "video-vd")) {
                setLayerType(1, null);
                return new w((int) xj2, this.f10177pl.yo());
            }
        }
        return drawable;
    }

    public hf xj(Bitmap bitmap) {
        return new xj(bitmap, null);
    }

    private Drawable[] xj(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (str.contains("linear-gradient")) {
                String[] split = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = split.length - 1;
                int[] iArr = new int[length];
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2 + 1;
                    iArr[i2] = c.xj(split[i3].substring(0, 7));
                    i2 = i3;
                }
                GradientDrawable xj = xj(xj(split[0]), iArr);
                xj.setShape(0);
                xj.setCornerRadius(com.bytedance.sdk.component.adexpress.u.f.xj(this.p, this.f10177pl.qt()));
                drawableArr[(list.size() - 1) - i] = xj;
            }
        }
        return drawableArr;
    }

    public GradientDrawable xj(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            if (iArr.length == 1) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(iArr[0]);
                return gradientDrawable;
            }
            return new GradientDrawable(orientation, iArr);
        }
        return new GradientDrawable();
    }

    public GradientDrawable.Orientation xj(String str) {
        try {
            int parseFloat = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            if (parseFloat <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (parseFloat <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (parseFloat <= 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }
}
