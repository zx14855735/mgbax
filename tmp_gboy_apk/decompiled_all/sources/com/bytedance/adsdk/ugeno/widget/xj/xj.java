package com.bytedance.adsdk.ugeno.widget.xj;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.adsdk.ugeno.u;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;
import com.bytedance.adsdk.ugeno.widget.text.hf;
import com.bytedance.adsdk.ugeno.xj;
import com.bytedance.adsdk.ugeno.y.f;
import com.bytedance.adsdk.ugeno.y.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends hf {
    private String cu;
    private xj.C0035xj kc;
    private String lm;
    private boolean mg;
    private String no;
    private int qi;
    private boolean ut;
    private String vi;
    private int zd;

    public xj(Context context) {
        super(context);
        this.vi = "row";
    }

    private void f() {
        if (TextUtils.isEmpty(this.lm)) {
            return;
        }
        ((UGTextView) this.kd).setCompoundDrawables(null, null, null, null);
        if (!this.lm.startsWith("local://")) {
            u.xj().hf().xj(this.d, this.lm, new xj.InterfaceC0033xj() { // from class: com.bytedance.adsdk.ugeno.widget.xj.xj.1
                @Override // com.bytedance.adsdk.ugeno.xj.InterfaceC0033xj
                public void xj(final Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    f.xj(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.xj.xj.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            xj.this.hf(new BitmapDrawable(((w) xj.this).hf.getResources(), bitmap));
                        }
                    });
                }
            });
            return;
        }
        try {
            String replace = this.lm.replace("local://", "");
            Context context = this.hf;
            hf(f.xj(context, com.bytedance.adsdk.ugeno.y.u.hf(context, replace)));
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void eu() {
        super.eu();
        if (this.mg) {
            ((UGTextView) this.kd).setTextColor(((hf) this).my);
        }
        if (this.ut) {
            if (this.i) {
                xj(this.ua);
            } else {
                w(this.wo);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.hf, com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        f();
        ((UGTextView) this.kd).setGravity(17);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void ws() {
        super.ws();
        if (this.mg) {
            ((UGTextView) this.kd).setTextColor(this.zd);
        }
        if (this.ut) {
            if (this.i) {
                xj(this.kc);
            } else {
                w(this.qi);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.hf, com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        super.xj(str, str2);
        str.getClass();
        switch (str) {
            case "direction":
                this.vi = str2;
                break;
            case "highlightTextColor":
            case "highlightedTextColor":
                this.zd = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
                this.mg = true;
                break;
            case "image":
                this.lm = str2;
                break;
            case "highlightImage":
                this.cu = str2;
                break;
            case "highlightBackgroundColor":
                if (com.bytedance.adsdk.ugeno.y.xj.w(str2)) {
                    this.i = true;
                    this.kc = com.bytedance.adsdk.ugeno.y.xj.hf(str2);
                } else {
                    this.qi = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
                    this.i = false;
                }
                this.ut = true;
                break;
            case "highlightBackgroundImage":
                this.no = str2;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void hf(Drawable drawable) {
        char c;
        if (drawable == null) {
            return;
        }
        String str = this.vi;
        switch (str.hashCode()) {
            case -1781065991:
                if (str.equals("column_reverse")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1354837162:
                if (str.equals("column")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -207799939:
                if (str.equals("row_reverse")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 113114:
                if (str.equals("row")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            ((UGTextView) this.kd).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            return;
        }
        if (c == 1) {
            ((UGTextView) this.kd).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        } else if (c != 2) {
            ((UGTextView) this.kd).setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ((UGTextView) this.kd).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
        }
    }
}
