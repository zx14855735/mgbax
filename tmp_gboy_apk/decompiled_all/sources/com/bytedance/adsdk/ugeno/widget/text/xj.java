package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.hf.w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends w<RichTextView> {
    private int cu;
    private int kc;
    private float lm;
    private int my;
    private int no;
    private String qi;
    private String vi;
    private String xj;

    public xj(Context context) {
        super(context);
        this.cu = Integer.MAX_VALUE;
        this.kc = 2;
    }

    private int p(String str) {
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
    public RichTextView xj() {
        RichTextView richTextView = new RichTextView(this.hf);
        richTextView.xj(this);
        return richTextView;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        ((RichTextView) this.kd).setRichText(this.xj);
        ((RichTextView) this.kd).setTextSize(1, this.lm);
        ((RichTextView) this.kd).setTextColor(this.my);
        ((RichTextView) this.kd).setLines(this.no);
        ((RichTextView) this.kd).setMaxLines(this.cu);
        ((RichTextView) this.kd).setGravity(this.kc);
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
                this.kc = p(str2);
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
            case "text":
                this.xj = str2;
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
        }
    }
}
