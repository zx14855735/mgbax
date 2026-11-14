package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.LineBackgroundSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.jk;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y extends c {
    private SpannableStringBuilder am;
    private final LinearLayout.LayoutParams d;
    private LinearLayout f;
    private xj g;
    private final List<TextView> p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10056pl;
    private SpannableStringBuilder qt;
    private final List<String> tf;

    public static class xj implements LineBackgroundSpan {
        private int hf;
        private float kd;
        private int u;
        private float w;
        private final Paint xj = new Paint();

        @Override // android.text.style.LineBackgroundSpan
        public void drawBackground(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, int i8) {
            if (this.w > 0.0f) {
                this.xj.setColor(this.hf);
                this.xj.setStrokeWidth(this.w);
                float f = i4 + this.w;
                canvas.drawLine(i, f, i2, f, this.xj);
            }
            if (this.kd > 0.0f) {
                this.xj.setColor(this.u);
                this.xj.setStrokeWidth(this.kd);
                float f2 = (i5 + i3) / 2.0f;
                canvas.drawLine(i, f2, i2, f2, this.xj);
            }
        }
    }

    public y(com.bytedance.adsdk.lottie.f fVar, f fVar2, Context context) {
        super(fVar, fVar2);
        List<d.hf> w;
        this.d = new LinearLayout.LayoutParams(-2, -2);
        this.tf = new ArrayList();
        this.p = new ArrayList();
        com.bytedance.adsdk.lottie.d dVar = ((c) this).c;
        if (dVar == null || (w = dVar.w()) == null || w.size() <= 0) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.f = linearLayout;
        linearLayout.setOrientation(0);
        hf(w.get(0).d);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(80);
        this.f.addView(linearLayout2);
        List<String> am = am();
        int i = 0;
        while (i < w.size()) {
            d.hf hfVar = w.get(i);
            TextView textView = new TextView(context);
            xj(textView, hfVar, (am == null || i >= am.size()) ? "" : am.get(i), i, w.size() - 1, w.get(0));
            int i2 = hfVar.f;
            if (i2 != 0) {
                this.d.bottomMargin = (int) (com.bytedance.adsdk.lottie.kd.d.xj() * i2);
                linearLayout2.addView(textView, this.d);
            } else {
                linearLayout2.addView(textView);
            }
            i++;
        }
        float xj2 = com.bytedance.adsdk.lottie.kd.d.xj();
        xj(this.f, (int) (((c) this).c.xj() * xj2), (int) (((c) this).c.hf() * xj2));
    }

    private List<String> am() {
        com.bytedance.adsdk.lottie.f fVar;
        jk et;
        List<d.hf> w;
        if (((c) this).c == null || (fVar = this.hf) == null || (et = fVar.et()) == null) {
            return null;
        }
        String u = ((c) this).c.u();
        if ((!TextUtils.isEmpty(u) || !TextUtils.isEmpty(this.f10056pl)) && (w = ((c) this).c.w()) != null) {
            String str = this.f10056pl;
            if (TextUtils.isEmpty(str)) {
                str = et.xj(u);
            }
            if (!TextUtils.isEmpty(str)) {
                int length = str.length();
                this.tf.clear();
                for (int i = 0; i < w.size(); i++) {
                    d.hf hfVar = w.get(i);
                    int i2 = hfVar.xj;
                    int i3 = hfVar.hf;
                    if (i2 < 0) {
                        i2 = Math.max(i2 + length, 0);
                    }
                    if (i3 < 0) {
                        i3 = Math.max(i3 + length, 0);
                    }
                    if (i2 + i3 > length) {
                        this.tf.add("");
                    } else {
                        if (w.size() == 1 && i2 == 0 && i3 == 0) {
                            i3 = length;
                        }
                        this.tf.add(str.substring(i2, i3 + i2));
                    }
                }
                return this.tf;
            }
        }
        return null;
    }

    private void hf(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f.setGravity(17);
            return;
        }
        str.getClass();
        if (str.equals("left")) {
            this.f.setGravity(19);
        } else if (str.equals("right")) {
            this.f.setGravity(21);
        } else {
            this.f.setGravity(17);
        }
    }

    private void w(float f) {
        List<d.hf> w;
        com.bytedance.adsdk.lottie.d dVar = ((c) this).c;
        if (dVar != null && (w = dVar.w()) != null && w.size() > 0) {
            this.f.setOrientation(0);
            hf(w.get(0).d);
            if (this.f.getChildCount() > 0) {
                LinearLayout linearLayout = (LinearLayout) this.f.getChildAt(0);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(80);
                this.f.removeAllViews();
                if (linearLayout.getChildCount() == w.size()) {
                    List<String> am = am();
                    this.p.clear();
                    int i = 0;
                    while (i < w.size()) {
                        d.hf hfVar = w.get(i);
                        TextView textView = (TextView) linearLayout.getChildAt(i);
                        this.p.add(textView);
                        xj(textView, hfVar, (am == null || i >= am.size()) ? "" : am.get(i), i, w.size() - 1, w.get(0));
                        i++;
                    }
                    linearLayout.removeAllViews();
                    for (int i2 = 0; i2 < w.size(); i2++) {
                        d.hf hfVar2 = w.get(i2);
                        TextView textView2 = this.p.get(i2);
                        textView2.setAlpha(f);
                        linearLayout.setAlpha(f);
                        int i3 = hfVar2.f;
                        if (i3 != 0) {
                            this.d.bottomMargin = (int) (com.bytedance.adsdk.lottie.kd.d.xj() * i3);
                            linearLayout.addView(textView2, this.d);
                        } else {
                            linearLayout.addView(textView2);
                        }
                    }
                    this.f.setAlpha(f);
                    this.f.addView(linearLayout);
                    float xj2 = com.bytedance.adsdk.lottie.kd.d.xj();
                    xj(this.f, (int) (((c) this).c.xj() * xj2), (int) (((c) this).c.hf() * xj2));
                }
            }
        }
    }

    private void xj(TextView textView, d.hf hfVar, String str, int i, int i2, d.hf hfVar2) {
        if (TextUtils.isEmpty(str)) {
            str = "";
            textView.setText("");
        } else {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(hfVar.w)) {
            textView.setTextColor(Color.parseColor(hfVar.w));
        } else if (!TextUtils.isEmpty(hfVar.u)) {
            textView.setTextColor(Color.parseColor(hfVar.u));
        }
        if (!TextUtils.isEmpty(hfVar.kd)) {
            textView.setBackgroundColor(Color.parseColor(hfVar.kd));
        }
        if (hfVar.c == 1) {
            textView.setTypeface(null, 1);
        } else {
            textView.setTypeface(null, 0);
        }
        textView.setGravity(17);
        textView.setTextSize(1, hfVar.y);
        d.hf.xj xjVar = hfVar.tf;
        if (xjVar != null && xjVar.xj > 0 && !TextUtils.isEmpty(xjVar.hf)) {
            if (this.am == null) {
                this.am = new SpannableStringBuilder(str);
            }
            if (this.g == null) {
                this.g = new xj();
            }
            this.g.hf = Color.parseColor(hfVar.tf.hf);
            this.g.w = com.bytedance.adsdk.lottie.kd.d.xj() * hfVar.tf.xj;
            this.am.clear();
            this.am.clearSpans();
            this.am.append((CharSequence) str);
            this.am.setSpan(this.g, 0, str.length(), 33);
            textView.setText(this.am);
        }
        d.hf.xj xjVar2 = hfVar.p;
        if (xjVar2 != null && xjVar2.xj > 0 && !TextUtils.isEmpty(xjVar2.hf)) {
            if (this.qt == null) {
                this.qt = new SpannableStringBuilder(str);
            }
            if (this.g == null) {
                this.g = new xj();
            }
            this.g.u = Color.parseColor(hfVar.p.hf);
            this.g.kd = com.bytedance.adsdk.lottie.kd.d.xj() * hfVar.p.xj;
            this.qt.clear();
            this.qt.clearSpans();
            this.qt.append((CharSequence) str);
            this.qt.setSpan(this.g, 0, str.length(), 33);
            textView.setText(this.qt);
        }
        int i3 = hfVar2.g;
        if (i3 > 0) {
            textView.setMaxLines(i3);
            if (hfVar2.f10038pl == 2 && i == 0) {
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            }
            if (hfVar2.f10038pl == 1 && i == 0) {
                textView.setEllipsize(TextUtils.TruncateAt.START);
            }
            if (hfVar2.f10038pl == 0 && i == i2) {
                textView.setEllipsize(TextUtils.TruncateAt.END);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.c, com.bytedance.adsdk.lottie.model.layer.w
    public void hf(Canvas canvas, Matrix matrix, int i) {
        if (this.f != null) {
            canvas.save();
            canvas.concat(matrix);
            xj(i);
            w(f());
            this.f.draw(canvas);
            canvas.restore();
            return;
        }
        super.hf(canvas, matrix, i);
    }

    private static void xj(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void xj(String str) {
        this.f10056pl = str;
    }
}
