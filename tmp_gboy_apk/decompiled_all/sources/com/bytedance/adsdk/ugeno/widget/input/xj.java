package com.bytedance.adsdk.ugeno.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import com.baidu.mobads.sdk.internal.a;
import com.bytedance.adsdk.ugeno.hf.w;
import com.sigmob.sdk.base.views.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends w<EditText> {
    private int cu;
    private int kc;
    private float lm;
    private String mg;
    private int my;
    private int no;
    private String qi;
    private String vi;
    private int xj;
    private String zd;

    public xj(Context context) {
        super(context);
        this.xj = 1;
        this.cu = Integer.MAX_VALUE;
        this.kc = 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int p(String str) {
        char c;
        switch (str.hashCode()) {
            case -1034364087:
                if (str.equals("number")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3556653:
                if (str.equals(a.b)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 96619420:
                if (str.equals("email")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 106642798:
                if (str.equals("phone")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1216985755:
                if (str.equals("password")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return r.b.d;
        }
        if (c == 1) {
            return 3;
        }
        if (c != 2) {
            return c != 3 ? 1 : 32;
        }
        return 2;
    }

    private int pl(String str) {
        str.getClass();
        switch (str) {
            case "center":
                return 17;
            case "left":
                return 3;
            case "right":
                return 5;
            default:
                return 2;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public EditText xj() {
        UGEditText uGEditText = new UGEditText(this.hf);
        uGEditText.xj(this);
        return uGEditText;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        ((EditText) this.kd).setInputType(this.xj);
        ((EditText) this.kd).setText(this.zd);
        ((EditText) this.kd).setTextSize(1, this.lm);
        ((EditText) this.kd).setTextColor(this.my);
        ((EditText) this.kd).setLines(this.no);
        ((EditText) this.kd).setMaxLines(this.cu);
        ((EditText) this.kd).setGravity(this.kc);
        ((EditText) this.kd).setHint(this.mg);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.xj(str, str2);
        str.getClass();
        switch (str) {
            case "textAlign":
                this.kc = pl(str2);
                break;
            case "textColor":
                this.my = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
                break;
            case "textStyle":
                this.vi = str2;
                break;
            case "textSize":
                this.lm = Float.parseFloat(str2);
                break;
            case "hint":
                this.mg = str2;
                break;
            case "text":
                this.zd = str2;
                break;
            case "lines":
                this.no = Integer.parseInt(str2);
                break;
            case "maxLines":
                this.cu = Integer.parseInt(str2);
                break;
            case "ellipsize":
                this.qi = str2;
                break;
            case "inputType":
                this.xj = p(str2);
                break;
        }
    }
}
