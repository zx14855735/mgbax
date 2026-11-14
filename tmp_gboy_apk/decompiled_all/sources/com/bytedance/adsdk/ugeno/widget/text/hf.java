package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.adsdk.ugeno.y.f;
import com.sigmob.sdk.base.blurkit.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends w<UGTextView> {
    private float ci;
    private int cu;
    private boolean ey;
    private float he;

    @Deprecated
    private float ic;
    private int kc;
    private float lm;
    private TextUtils.TruncateAt mg;
    protected int my;
    private int no;

    @Deprecated
    private float nt;
    private float ol;
    private int qi;
    private float uf;
    private float ut;
    private int vi;
    private float vw;
    protected String xj;

    @Deprecated
    private TextUtils.TruncateAt zd;
    private int zm;

    public hf(Context context) {
        super(context);
        this.my = d.f13043a;
        this.lm = 12.0f;
        this.cu = Integer.MAX_VALUE;
        this.qi = 8388611;
        this.mg = TextUtils.TruncateAt.END;
        this.ut = -1.0f;
        this.he = 400.0f;
    }

    private int am(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -1178781136) {
            if (str.equals("italic")) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode != -1039745817) {
            if (hashCode == 3029637 && str.equals("bold")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals(PrerollVideoResponse.NORMAL)) {
                c = 2;
            }
            c = 65535;
        }
        if (c != 0) {
            return c != 1 ? 0 : 2;
        }
        return 1;
    }

    private void f() {
        ((UGTextView) this.kd).setLineSpacing(0.0f, this.ut);
    }

    private TextUtils.TruncateAt g(String str) {
        if (TextUtils.equals(str, "none")) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }

    private TextUtils.TruncateAt pl(String str) {
        str.getClass();
        switch (str) {
            case "center":
                this.zd = TextUtils.TruncateAt.MIDDLE;
                break;
            case "end":
                this.zd = TextUtils.TruncateAt.END;
                break;
            case "start":
                this.zd = TextUtils.TruncateAt.START;
                break;
            default:
                this.zd = null;
                break;
        }
        return this.zd;
    }

    private int qt(String str) {
        str.getClass();
        switch (str) {
            case "center":
                return 17;
            case "center_vertical":
                return 16;
            case "left":
                return 3;
            case "right":
                return 5;
            case "center_horizontal":
                return 1;
            default:
                return 3;
        }
    }

    private void tu() {
        float f = this.ut;
        if (f <= 3.0f) {
            ((UGTextView) this.kd).setLineSpacing(0.0f, f);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int round = Math.round(f.xj(this.hf, (f - (this.lm * 1.2f)) / 2.0f));
            int paddingTop = ((UGTextView) this.kd).getPaddingTop() + round;
            int paddingBottom = ((UGTextView) this.kd).getPaddingBottom() + round;
            UGTextView uGTextView = (UGTextView) this.kd;
            uGTextView.setPadding(uGTextView.getPaddingLeft(), paddingTop, ((UGTextView) this.kd).getPaddingRight(), paddingBottom);
            ((UGTextView) this.kd).setLineHeight(Math.round(f.xj(this.hf, this.ut)));
        }
    }

    private int zg(String str) {
        str.getClass();
        switch (str) {
            case "underline":
                return 8;
            case "strikethrough":
                return 16;
            case "none":
            default:
                return Integer.MAX_VALUE;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public UGTextView xj() {
        UGTextView uGTextView = new UGTextView(this.hf);
        uGTextView.xj(this);
        return uGTextView;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        Typeface create;
        super.hf();
        if (TextUtils.equals("null", this.xj)) {
            this.xj = "";
        }
        p(this.xj);
        ((UGTextView) this.kd).setTextSize(1, this.lm);
        ((UGTextView) this.kd).setTextColor(this.my);
        ((UGTextView) this.kd).setLines(this.no);
        ((UGTextView) this.kd).setMaxLines(this.cu);
        ((UGTextView) this.kd).setGravity(this.qi);
        ((UGTextView) this.kd).setIncludeFontPadding(false);
        y(this.kc);
        if (q()) {
            xj(this.mg);
        } else {
            xj(this.zd);
        }
        if (this.ut > 0.0f) {
            if (q()) {
                tu();
            } else {
                f();
            }
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            ((UGTextView) this.kd).setBreakStrategy(0);
        }
        if (!q()) {
            ((UGTextView) this.kd).setShadowLayer(this.uf, this.nt, this.ic, this.zm);
        } else if (this.ey) {
            if (this.uf <= 0.0f) {
                this.uf = 1.0E-5f;
            }
            ((UGTextView) this.kd).setShadowLayer(this.uf, this.ci, this.vw, this.zm);
        }
        int i2 = this.vi;
        if (i2 == 1) {
            ((UGTextView) this.kd).setTypeface(Typeface.DEFAULT, i2);
        } else if (i >= 28) {
            Typeface typeface = Typeface.DEFAULT;
            create = Typeface.create(Typeface.DEFAULT, (int) this.he, i2 == 2);
            ((UGTextView) this.kd).setTypeface(create);
        } else if (this.he >= 500.0f) {
            ((UGTextView) this.kd).setTypeface(Typeface.DEFAULT, 1);
        }
        if (f.xj(this.hf, this.lm) > 0.0f) {
            ((UGTextView) this.kd).setLetterSpacing(this.ol / f.xj(this.hf, this.lm));
        }
    }

    public void p(String str) {
        this.xj = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals("null", str)) {
            this.xj = "";
        }
        ((UGTextView) this.kd).setText(this.xj);
    }

    public void y(int i) {
        this.kc = i;
        if (i == Integer.MAX_VALUE) {
            return;
        }
        ((UGTextView) this.kd).setPaintFlags(i);
    }

    public void xj(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((UGTextView) this.kd).setEllipsize(truncateAt);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.xj(str, str2);
        str.getClass();
        switch (str) {
            case "shadowRadius":
            case "shadowBlur":
                this.uf = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case "shadowColor":
                this.zm = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
                this.ey = true;
                break;
            case "shadowOffsetX":
                this.ci = f.xj(this.hf, com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f));
                break;
            case "shadowOffsetY":
                this.vw = f.xj(this.hf, com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f));
                break;
            case "textAlign":
                this.qi = qt(str2);
                break;
            case "textColor":
                this.my = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
                break;
            case "textStyle":
                this.vi = am(str2);
                break;
            case "textSize":
                this.lm = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case "textDecoration":
                this.kc = zg(str2);
                break;
            case "shadowDx":
                this.nt = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case "shadowDy":
                this.ic = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case "fontWeight":
                float xj = com.bytedance.adsdk.ugeno.y.w.xj(str2, -1.0f);
                this.he = xj;
                if (xj < 1.0f || xj > 1000.0f) {
                    this.he = 400.0f;
                    break;
                }
                break;
            case "lineHeight":
                this.ut = com.bytedance.adsdk.ugeno.y.w.xj(str2, 1.0f);
                break;
            case "text":
                this.xj = str2;
                break;
            case "lines":
                this.no = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0);
                break;
            case "ellipsis":
                this.mg = g(str2);
                break;
            case "maxLines":
                int xj2 = com.bytedance.adsdk.ugeno.y.w.xj(str2, Integer.MAX_VALUE);
                this.cu = xj2 > 0 ? xj2 : Integer.MAX_VALUE;
                break;
            case "ellipsize":
                this.zd = pl(str2);
                break;
            case "letterSpacing":
                this.ol = f.xj(this.hf, com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f));
                break;
        }
    }
}
