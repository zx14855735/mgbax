package com.bytedance.adsdk.ugeno.hf;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.y.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj<E extends ViewGroup> extends w {
    protected List<w<View>> xj;

    public xj(Context context) {
        this(context, null);
    }

    public List<w<View>> c() {
        return this.xj;
    }

    public C0026xj f() {
        return new C0026xj(this);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public w w(String str) {
        w<View> y;
        if (!TextUtils.isEmpty(str) && tf(str) != null) {
            return this;
        }
        for (w<View> wVar : this.xj) {
            if (wVar != null && (y = wVar.y(str)) != null) {
                return y;
            }
        }
        return null;
    }

    public void xj(w wVar) {
        if (wVar == null) {
            return;
        }
        this.xj.add(wVar);
        View d = wVar.d();
        if (d != null) {
            ((ViewGroup) this.kd).addView(d);
        }
    }

    public xj(Context context, xj xjVar) {
        super(context, xjVar);
        this.xj = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public w hf(String str) {
        w<View> kd;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.f10070pl)) {
            return this;
        }
        for (w<View> wVar : this.xj) {
            if (wVar != null && (kd = wVar.kd(str)) != null) {
                return kd;
            }
        }
        return null;
    }

    public void xj(w wVar, ViewGroup.LayoutParams layoutParams) {
        if (wVar == null) {
            return;
        }
        this.xj.add(wVar);
        View d = wVar.d();
        if (d != null) {
            ((ViewGroup) this.kd).addView(d, layoutParams);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public w xj(String str) {
        w<View> u;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.p)) {
            return this;
        }
        for (w<View> wVar : this.xj) {
            if (wVar != null && (u = wVar.u(str)) != null) {
                return u;
            }
        }
        return null;
    }

    /* renamed from: com.bytedance.adsdk.ugeno.hf.xj$xj, reason: collision with other inner class name */
    public static class C0026xj {
        protected float am;
        protected float c;
        protected float d;
        protected ViewGroup.LayoutParams dk;
        protected boolean e;
        protected xj et;
        protected float f;
        protected float g;
        protected boolean ht;
        protected boolean jk;
        protected float kd;
        protected float p;

        /* renamed from: pl, reason: collision with root package name */
        protected float f10071pl;
        protected boolean pz;
        protected boolean qt;
        protected boolean ra;
        protected float tf;
        protected boolean v;
        protected float y;
        protected boolean yo;
        protected boolean zg;
        protected float xj = -2.0f;
        protected float hf = -2.0f;
        protected float w = 0.0f;
        protected float u = 0.0f;

        public C0026xj(xj xjVar) {
            this.et = xjVar;
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.xj + ", mHeight=" + this.hf + ", mMargin=" + this.kd + ", mMarginLeft=" + this.y + ", mMarginRight=" + this.c + ", mMarginTop=" + this.f + ", mMarginBottom=" + this.d + ", mParams=" + this.dk + '}';
        }

        public void xj(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            str.getClass();
            switch (str) {
                case "paddingLeft":
                    this.p = f.xj(context, str2);
                    this.zg = true;
                    break;
                case "minWidth":
                    this.w = f.xj(context, str2);
                    break;
                case "height":
                    if (!TextUtils.equals(str2, "match_parent")) {
                        if (!TextUtils.equals(str2, "wrap_content")) {
                            this.hf = f.xj(context, str2);
                            break;
                        } else {
                            this.hf = -2.0f;
                            break;
                        }
                    } else {
                        this.hf = -1.0f;
                        break;
                    }
                case "margin":
                    this.kd = f.xj(context, str2);
                    break;
                case "marginTop":
                    this.f = f.xj(context, str2);
                    this.ht = true;
                    break;
                case "padding":
                    this.tf = f.xj(context, str2);
                    this.qt = true;
                    break;
                case "marginBottom":
                    this.d = f.xj(context, str2);
                    this.ra = true;
                    break;
                case "minHeight":
                    this.u = f.xj(context, str2);
                    break;
                case "paddingTop":
                    this.f10071pl = f.xj(context, str2);
                    this.yo = true;
                    break;
                case "width":
                    if (!TextUtils.equals(str2, "match_parent")) {
                        if (!TextUtils.equals(str2, "wrap_content")) {
                            this.xj = f.xj(context, str2);
                            break;
                        } else {
                            this.xj = -2.0f;
                            break;
                        }
                    } else {
                        this.xj = -1.0f;
                        break;
                    }
                case "paddingBottom":
                    this.am = f.xj(context, str2);
                    this.v = true;
                    break;
                case "paddingRight":
                    this.g = f.xj(context, str2);
                    this.e = true;
                    break;
                case "marginRight":
                    this.c = f.xj(context, str2);
                    this.pz = true;
                    break;
                case "marginLeft":
                    this.y = f.xj(context, str2);
                    this.jk = true;
                    break;
            }
        }

        public ViewGroup.LayoutParams xj() {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) this.xj, (int) this.hf);
            marginLayoutParams.leftMargin = (int) (this.jk ? this.y : this.kd);
            marginLayoutParams.rightMargin = (int) (this.pz ? this.c : this.kd);
            marginLayoutParams.topMargin = (int) (this.ht ? this.f : this.kd);
            marginLayoutParams.bottomMargin = (int) (this.ra ? this.d : this.kd);
            return marginLayoutParams;
        }
    }
}
