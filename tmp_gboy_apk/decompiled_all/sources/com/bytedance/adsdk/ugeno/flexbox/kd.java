package com.bytedance.adsdk.ugeno.flexbox;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.flexbox.FlexboxLayout;
import com.bytedance.adsdk.ugeno.hf.xj;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends com.bytedance.adsdk.ugeno.hf.xj<FlexboxLayout> {
    private int cu;
    private int lm;
    private int my;
    private int no;
    private int vi;

    public static class xj extends xj.C0026xj {
        public float ai;
        public int en;
        public int ff;

        /* renamed from: io, reason: collision with root package name */
        public int f10066io;
        public int j;
        public int l;
        public int q;
        public float x;
        public float z;

        public xj(com.bytedance.adsdk.ugeno.hf.xj xjVar) {
            super(xjVar);
            this.f10066io = 1;
            this.x = 0.0f;
            this.ai = 0.0f;
            this.q = -1;
            this.z = -1.0f;
            this.j = -1;
            this.en = -1;
            this.l = 16777215;
            this.ff = 16777215;
        }

        private float hf(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                pl.xj(e);
                return 0.0f;
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private int kd(String str) {
            char c;
            str.getClass();
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1384876188:
                    if (str.equals("flex_start")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1744442261:
                    if (str.equals("flex_end")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return 4;
                case 1:
                    return 3;
                case 2:
                    return 2;
                case 3:
                    return 0;
                case 4:
                    return 1;
                default:
                    return -1;
            }
        }

        private float u(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                pl.xj(e);
                return -1.0f;
            }
        }

        private float w(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception e) {
                pl.xj(e);
                return 0.0f;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.hf.xj.C0026xj
        public String toString() {
            return "LayoutParams{mWidth=" + this.xj + ", mHeight=" + this.hf + ", mMargin=" + this.kd + ", mMarginLeft=" + this.y + ", mMarginRight=" + this.c + ", mMarginTop=" + this.f + ", mMarginBottom=" + this.d + ", mParams=" + this.dk + ", mOrder=" + this.f10066io + ", mFlexGrow=" + this.x + ", mFlexShrink=" + this.ai + ", mAlignSelf=" + this.q + ", mFlexBasisPercent=" + this.z + ", mMinWidth=" + this.j + ", mMinHeight=" + this.en + ", mMaxWidth=" + this.l + ", mMaxHeight=" + this.ff + "} " + super.toString();
        }

        @Override // com.bytedance.adsdk.ugeno.hf.xj.C0026xj
        public void xj(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.xj(context, str, str2);
            str.getClass();
            switch (str) {
                case "flexBasisPercent":
                    this.z = u(str2);
                    break;
                case "order":
                    this.f10066io = xj(str2);
                    break;
                case "flexShrink":
                    this.ai = w(str2);
                    break;
                case "flexGrow":
                    this.x = hf(str2);
                    break;
                case "alignSelf":
                    this.q = kd(str2);
                    break;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.hf.xj.C0026xj
        /* renamed from: hf, reason: merged with bridge method [inline-methods] */
        public FlexboxLayout.xj xj() {
            FlexboxLayout.xj xjVar = new FlexboxLayout.xj((int) this.xj, (int) this.hf);
            ((ViewGroup.MarginLayoutParams) xjVar).leftMargin = (int) this.y;
            ((ViewGroup.MarginLayoutParams) xjVar).rightMargin = (int) this.c;
            ((ViewGroup.MarginLayoutParams) xjVar).topMargin = (int) this.f;
            ((ViewGroup.MarginLayoutParams) xjVar).bottomMargin = (int) this.d;
            xjVar.w(this.f10066io);
            xjVar.u(this.q);
            xjVar.xj(this.x);
            xjVar.hf(this.ai);
            xjVar.w(this.z);
            return xjVar;
        }

        private int xj(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                pl.xj(e);
                return 1;
            }
        }
    }

    public kd(Context context) {
        super(context);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int am(String str) {
        char c;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1720785339:
                if (str.equals("baseline")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1384876188:
                if (str.equals("flex_start")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1744442261:
                if (str.equals("flex_end")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return 0;
        }
        if (c == 1) {
            return 1;
        }
        if (c != 2) {
            return c != 3 ? 4 : 3;
        }
        return 2;
    }

    private int g(String str) {
        str.getClass();
        switch (str) {
            case "center":
                return 2;
            case "space_around":
                return 4;
            case "space_between":
                return 3;
            case "flex_end":
                return 1;
            default:
                return 0;
        }
    }

    private int pl(String str) {
        str.getClass();
        return !str.equals("wrap") ? 0 : 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int qt(String str) {
        char c;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -932331738:
                if (str.equals("space_around")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1384876188:
                if (str.equals("flex_start")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1682480591:
                if (str.equals("space_between")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1744442261:
                if (str.equals("flex_end")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return 0;
        }
        if (c == 1) {
            return 1;
        }
        if (c == 2) {
            return 2;
        }
        if (c != 3) {
            return c != 4 ? 5 : 3;
        }
        return 4;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj
    public xj.C0026xj f() {
        return new xj(this);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj, com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        ((FlexboxLayout) this.kd).setFlexDirection(this.my);
        ((FlexboxLayout) this.kd).setFlexWrap(this.lm);
        ((FlexboxLayout) this.kd).setJustifyContent(this.vi);
        ((FlexboxLayout) this.kd).setAlignItems(this.cu);
        ((FlexboxLayout) this.kd).setAlignContent(this.no);
    }

    public int p(String str) {
        str.getClass();
        switch (str) {
            case "column_reverse":
                return 3;
            case "column":
                return 2;
            case "row_reverse":
                return 1;
            default:
                return 0;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: tu, reason: merged with bridge method [inline-methods] */
    public FlexboxLayout xj() {
        FlexboxLayout flexboxLayout = new FlexboxLayout(this.hf);
        flexboxLayout.xj(this);
        return flexboxLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.xj(str, str2);
        str.getClass();
        switch (str) {
            case "alignItems":
                this.cu = am(str2);
                break;
            case "flexDirection":
                this.my = p(str2);
                break;
            case "alignContent":
                this.no = qt(str2);
                break;
            case "flexWrap":
                this.lm = pl(str2);
                break;
            case "justifyContent":
                this.vi = g(str2);
                break;
        }
    }
}
