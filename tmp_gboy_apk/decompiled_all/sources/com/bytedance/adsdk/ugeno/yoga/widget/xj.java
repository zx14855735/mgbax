package com.bytedance.adsdk.ugeno.yoga.widget;

import J3FDQU.A2egSU;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.hf.xj;
import com.bytedance.adsdk.ugeno.u;
import com.bytedance.adsdk.ugeno.w.c;
import com.bytedance.adsdk.ugeno.xj;
import com.bytedance.adsdk.ugeno.y.f;
import com.bytedance.adsdk.ugeno.y.w;
import com.bytedance.adsdk.ugeno.yoga.am;
import com.bytedance.adsdk.ugeno.yoga.g;
import com.bytedance.adsdk.ugeno.yoga.kd;
import com.bytedance.adsdk.ugeno.yoga.tf;
import com.bytedance.adsdk.ugeno.yoga.widget.YogaLayout;
import com.bytedance.adsdk.ugeno.yoga.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends com.bytedance.adsdk.ugeno.hf.xj<YogaLayout> {
    private com.bytedance.adsdk.ugeno.yoga.xj cu;
    private am lm;
    private kd my;
    private com.bytedance.adsdk.ugeno.yoga.xj no;
    private tf qi;
    private y vi;

    /* renamed from: com.bytedance.adsdk.ugeno.yoga.widget.xj$xj, reason: collision with other inner class name */
    public static class C0037xj extends xj.C0026xj {

        /* renamed from: a, reason: collision with root package name */
        public int f10093a;
        public float ai;
        private boolean b;
        public int en;
        private boolean eu;
        public int ff;

        /* renamed from: io, reason: collision with root package name */
        public int f10094io;
        public int j;
        public int l;
        private boolean n;
        public int q;
        private boolean r;
        private boolean tj;
        public float wo;
        private boolean ws;
        public float x;
        public float z;

        public C0037xj(com.bytedance.adsdk.ugeno.hf.xj xjVar) {
            super(xjVar);
            this.f10094io = 1;
            this.x = 0.0f;
            this.ai = 1.0f;
            this.q = com.bytedance.adsdk.ugeno.yoga.xj.AUTO.xj();
            this.z = -1.0f;
            this.j = g.RELATIVE.xj();
        }

        private void u() {
            com.bytedance.adsdk.ugeno.hf.xj xjVar = this.et;
            if (xjVar instanceof xj) {
                if (((xj) xjVar).dq() == kd.ROW && this.et.l() == -2 && this.xj == -1.0f && !this.et.n()) {
                    this.xj = -2.0f;
                    this.ai = 1.0f;
                    this.x = 1.0f;
                    this.r = true;
                    this.z = -1.0f;
                }
                if (((xj) this.et).dq() == kd.COLUMN && this.et.ff() == -2 && this.hf == -1.0f && !this.et.n()) {
                    this.hf = -2.0f;
                    this.ai = 1.0f;
                    this.x = 1.0f;
                    this.r = true;
                    this.z = -1.0f;
                }
            }
        }

        @Override // com.bytedance.adsdk.ugeno.hf.xj.C0026xj
        /* renamed from: hf, reason: merged with bridge method [inline-methods] */
        public YogaLayout.xj xj() {
            u();
            YogaLayout.xj xjVar = new YogaLayout.xj((int) this.xj, (int) this.hf);
            xjVar.pl((int) (this.jk ? this.y : this.kd));
            xjVar.am((int) (this.pz ? this.c : this.kd));
            xjVar.p((int) (this.ht ? this.f : this.kd));
            xjVar.g((int) (this.ra ? this.d : this.kd));
            xjVar.xj(this.f10094io);
            xjVar.kd(this.q);
            xjVar.hf(this.x);
            xjVar.w(this.ai);
            xjVar.zg(this.w);
            xjVar.e(this.u);
            if (this.r) {
                xjVar.u(this.z);
            }
            xjVar.y(this.j);
            if (this.b) {
                xjVar.c(this.en);
            }
            if (this.ws) {
                xjVar.d(this.l);
            }
            if (this.eu) {
                xjVar.f(this.ff);
            }
            if (this.tj) {
                xjVar.tf(this.f10093a);
            }
            if (this.n && w()) {
                float f = this.wo;
                if (f > 0.0f) {
                    xjVar.qt(f);
                    xjVar.w(0.0f);
                    xjVar.hf(0.0f);
                }
            }
            return xjVar;
        }

        @Override // com.bytedance.adsdk.ugeno.hf.xj.C0026xj
        public String toString() {
            StringBuilder sb = new StringBuilder("LayoutParams{mOrder=");
            sb.append(this.f10094io);
            sb.append(", mFlexGrow=");
            sb.append(this.x);
            sb.append(", mFlexShrink=");
            sb.append(this.ai);
            sb.append(", mAlignSelf=");
            sb.append(this.q);
            sb.append(", mFlexBasis=");
            sb.append(this.z);
            sb.append(", mPosition=");
            sb.append(this.j);
            sb.append(", mTop=");
            sb.append(this.en);
            sb.append(", mBottom=");
            sb.append(this.l);
            sb.append(", mLeft=");
            sb.append(this.ff);
            sb.append(", mRight=");
            return A2egSU.B2KMhB(sb, this.f10093a, '}');
        }

        public boolean w() {
            float f = this.xj;
            if (f == -1.0f && this.hf == -1.0f) {
                return false;
            }
            return f == -2.0f || this.hf == -2.0f;
        }

        @Override // com.bytedance.adsdk.ugeno.hf.xj.C0026xj
        public void xj(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.xj(context, str, str2);
            str.getClass();
            switch (str) {
                case "flexBasis":
                    this.r = true;
                    float xj = w.xj(str2, -1.0f);
                    this.z = xj;
                    this.z = f.xj(context, xj);
                    break;
                case "bottom":
                    this.ws = true;
                    this.l = (int) f.xj(context, w.xj(str2, 0));
                    break;
                case "top":
                    this.b = true;
                    this.en = (int) f.xj(context, w.xj(str2, 0));
                    break;
                case "left":
                    this.eu = true;
                    this.ff = (int) f.xj(context, w.xj(str2, 0));
                    break;
                case "order":
                    this.f10094io = w.xj(str2, 1);
                    break;
                case "ratio":
                    this.n = true;
                    this.wo = w.xj(str2, 0.0f);
                    break;
                case "right":
                    this.tj = true;
                    this.f10093a = (int) f.xj(context, w.xj(str2, 0));
                    break;
                case "position":
                    this.j = g.xj(str2).xj();
                    break;
                case "flexShrink":
                    this.ai = w.xj(str2, 1.0f);
                    break;
                case "flexGrow":
                    this.x = w.xj(str2, 0.0f);
                    break;
                case "alignSelf":
                    this.q = com.bytedance.adsdk.ugeno.yoga.xj.xj(str2).xj();
                    break;
            }
        }
    }

    public xj(Context context) {
        super(context);
        this.my = kd.ROW;
        this.lm = am.NO_WRAP;
        this.vi = y.FLEX_START;
        com.bytedance.adsdk.ugeno.yoga.xj xjVar = com.bytedance.adsdk.ugeno.yoga.xj.STRETCH;
        this.cu = xjVar;
        this.no = xjVar;
    }

    public kd dq() {
        return this.my;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void io() {
        ImageView.ScaleType scaleType;
        if (this.eu) {
            c cVar = this.le;
            if (cVar != null) {
                cVar.xj();
            }
            u.xj().hf().xj(this.d, this.r, new xj.InterfaceC0033xj() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.xj.1
                @Override // com.bytedance.adsdk.ugeno.xj.InterfaceC0033xj
                public void xj(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (((com.bytedance.adsdk.ugeno.hf.w) xj.this).le != null) {
                            c cVar2 = ((com.bytedance.adsdk.ugeno.hf.w) xj.this).le;
                            xj xjVar = xj.this;
                            cVar2.hf(xjVar, ((com.bytedance.adsdk.ugeno.hf.w) xjVar).r);
                            return;
                        }
                        return;
                    }
                    if (((com.bytedance.adsdk.ugeno.hf.w) xj.this).le != null) {
                        c cVar3 = ((com.bytedance.adsdk.ugeno.hf.w) xj.this).le;
                        xj xjVar2 = xj.this;
                        cVar3.xj(xjVar2, ((com.bytedance.adsdk.ugeno.hf.w) xjVar2).r);
                    }
                    final Bitmap xj = f.xj(((com.bytedance.adsdk.ugeno.hf.w) xj.this).hf, bitmap, (int) ((com.bytedance.adsdk.ugeno.hf.w) xj.this).ws);
                    if (xj != null) {
                        f.xj(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.xj.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                xj.this.xj(new BitmapDrawable(xj));
                            }
                        });
                    }
                }
            });
            return;
        }
        c cVar2 = this.le;
        if (cVar2 != null) {
            cVar2.xj();
        }
        ImageView imageView = new ImageView(this.hf);
        u.xj().hf().xj(this.d, this.r, imageView, this.kd.getWidth(), this.kd.getHeight(), new xj.InterfaceC0033xj() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.xj.2
            @Override // com.bytedance.adsdk.ugeno.xj.InterfaceC0033xj
            public void xj(Bitmap bitmap) {
                if (bitmap == null) {
                    if (((com.bytedance.adsdk.ugeno.hf.w) xj.this).le != null) {
                        c cVar3 = ((com.bytedance.adsdk.ugeno.hf.w) xj.this).le;
                        xj xjVar = xj.this;
                        cVar3.hf(xjVar, ((com.bytedance.adsdk.ugeno.hf.w) xjVar).r);
                        return;
                    }
                    return;
                }
                if (((com.bytedance.adsdk.ugeno.hf.w) xj.this).le != null) {
                    c cVar4 = ((com.bytedance.adsdk.ugeno.hf.w) xj.this).le;
                    xj xjVar2 = xj.this;
                    cVar4.xj(xjVar2, ((com.bytedance.adsdk.ugeno.hf.w) xjVar2).r);
                }
            }
        });
        if (!this.tj || (scaleType = this.b) == ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView.setScaleType(scaleType);
        }
        YogaLayout.xj xjVar = new YogaLayout.xj(-1, -1);
        xjVar.y(g.ABSOLUTE.xj());
        T t = this.kd;
        if (t instanceof YogaLayout) {
            ((YogaLayout) t).addView(imageView, 0, xjVar);
            xj(imageView);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public C0037xj f() {
        return new C0037xj(this);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: tu, reason: merged with bridge method [inline-methods] */
    public YogaLayout xj() {
        YogaLayout yogaLayout = new YogaLayout(this.hf);
        yogaLayout.xj(this);
        this.qi = yogaLayout.getYogaNode();
        return yogaLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj, com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        this.qi.xj(this.my);
        this.qi.xj(this.lm);
        this.qi.xj(this.vi);
        this.qi.xj(this.cu);
        this.qi.w(this.no);
        this.qi.xj(true);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void pl() {
        if (this.j) {
            this.qi.hf(com.bytedance.adsdk.ugeno.yoga.u.ALL, this.f10069io);
        }
        if (this.en) {
            this.qi.hf(com.bytedance.adsdk.ugeno.yoga.u.LEFT, this.x);
        }
        if (this.l) {
            this.qi.hf(com.bytedance.adsdk.ugeno.yoga.u.RIGHT, this.ai);
        }
        if (this.ff) {
            this.qi.hf(com.bytedance.adsdk.ugeno.yoga.u.TOP, this.q);
        }
        if (this.f10068a) {
            this.qi.hf(com.bytedance.adsdk.ugeno.yoga.u.BOTTOM, this.z);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(Drawable drawable) {
        ImageView.ScaleType scaleType;
        ImageView imageView = new ImageView(this.hf);
        imageView.setImageDrawable(drawable);
        if (this.tj && (scaleType = this.b) != ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(scaleType);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        YogaLayout.xj xjVar = new YogaLayout.xj(-1, -1);
        xjVar.y(g.ABSOLUTE.xj());
        T t = this.kd;
        if (t instanceof YogaLayout) {
            ((YogaLayout) t).addView(imageView, 0, xjVar);
            xj(imageView);
        }
    }

    private void xj(final ImageView imageView) {
        this.kd.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.widget.xj.3
            @Override // java.lang.Runnable
            public void run() {
                tf xj;
                if (((com.bytedance.adsdk.ugeno.hf.w) xj.this).kd == null || (xj = ((YogaLayout) ((com.bytedance.adsdk.ugeno.hf.w) xj.this).kd).xj(imageView)) == null) {
                    return;
                }
                xj.u(((com.bytedance.adsdk.ugeno.hf.w) xj.this).kd.getWidth());
                xj.y(((com.bytedance.adsdk.ugeno.hf.w) xj.this).kd.getHeight());
                ((com.bytedance.adsdk.ugeno.hf.w) xj.this).kd.requestLayout();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar) {
        super.xj(wVar);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, ViewGroup.LayoutParams layoutParams) {
        if (wVar == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.hf.xj) this).xj.add(wVar);
        View d = wVar.d();
        if (d != null) {
            ((YogaLayout) this.kd).addView(d, layoutParams);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        super.xj(str, str2);
        str.getClass();
        switch (str) {
            case "alignItems":
                this.cu = com.bytedance.adsdk.ugeno.yoga.xj.xj(str2);
                break;
            case "flexDirection":
                this.my = kd.xj(str2);
                break;
            case "alignContent":
                this.no = com.bytedance.adsdk.ugeno.yoga.xj.xj(str2);
                break;
            case "flexWrap":
                this.lm = am.xj(str2);
                break;
            case "justifyContent":
                this.vi = y.xj(str2);
                break;
        }
    }
}
