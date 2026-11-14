package com.bytedance.sdk.openadsdk.core.widget;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.UgenLottieView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.text.DecimalFormat;
import java.util.Stack;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends AlertDialog {
    private float ai;
    private TextView am;
    private TextView c;
    private LinearLayout d;
    private String dk;
    private Button e;
    private String en;
    private String et;
    private LinearLayout f;
    private TextView g;
    Stack<View> hf;
    private String ht;

    /* renamed from: io, reason: collision with root package name */
    private String f10462io;
    private xj j;
    private String jk;
    private TextView kd;
    private TextView p;

    /* renamed from: pl, reason: collision with root package name */
    private TextView f10463pl;
    private String pz;
    private RelativeLayout q;
    private TextView qt;
    private String ra;
    private TTRatingBar2 tf;
    private TTRoundRectImageView u;
    private String v;
    private ImageView w;
    private JSONArray x;
    protected Context xj;
    private TextView y;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.hf yo;
    private View z;
    private TextView zg;

    public interface xj {
        void hf(Dialog dialog);

        void kd(Dialog dialog);

        void u(Dialog dialog);

        void w(Dialog dialog);

        void xj(Dialog dialog);

        void y(Dialog dialog);
    }

    public w(Context context) {
        super(context, jk.f(context, "tt_dialog_full"));
        this.hf = new Stack<>();
        this.xj = context;
    }

    private void c() {
        RelativeLayout relativeLayout;
        if (this.z == null || (relativeLayout = this.q) == null) {
            return;
        }
        final int childCount = relativeLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.q.getChildAt(i).setVisibility(4);
        }
        this.z.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.w.7
            @Override // java.lang.Runnable
            public void run() {
                w.this.w(childCount);
            }
        }, 10L);
    }

    private void f() {
        RelativeLayout.LayoutParams layoutParams;
        Button button = this.e;
        if (button != null) {
            ViewGroup.LayoutParams layoutParams2 = button.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                layoutParams3.bottomMargin = layoutParams3.topMargin;
                this.e.setLayoutParams(layoutParams3);
            } else if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams2;
                layoutParams4.bottomMargin = layoutParams4.topMargin;
                this.e.setLayoutParams(layoutParams4);
            }
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.hf hfVar = this.yo;
        if (hfVar != null) {
            UgenLottieView d = hfVar.d();
            if (d != null) {
                layoutParams = (RelativeLayout.LayoutParams) d.getLayoutParams();
            } else {
                int w = r.w(this.xj, 60.0f);
                layoutParams = new RelativeLayout.LayoutParams(w, w);
            }
            layoutParams.topMargin = -r.w(this.xj, 53.0f);
            this.yo.xj(layoutParams);
        }
    }

    private LinearLayout hf(int i, LinearLayout linearLayout, LinearLayout linearLayout2, int i2) {
        this.f = new LinearLayout(this.xj);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = r.w(this.xj, 10.0f);
        this.f.setLayoutParams(layoutParams);
        this.f.setOrientation(0);
        linearLayout2.addView(this.f);
        this.d = new LinearLayout(this.xj);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = r.w(this.xj, 10.0f);
        if (i == 0) {
            layoutParams2.topMargin = r.w(this.xj, 16.0f);
        } else {
            layoutParams2.topMargin = r.w(this.xj, 10.0f);
        }
        this.d.setLayoutParams(layoutParams2);
        this.d.setOrientation(0);
        this.tf = new TTRatingBar2(this.xj, null);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        this.tf.setLayoutParams(layoutParams3);
        this.d.addView(this.tf);
        this.p = new TextView(this.xj);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = r.w(this.xj, 3.0f);
        this.p.setTextSize(16.0f);
        this.p.setTextColor(Color.parseColor("#161823"));
        this.p.setLayoutParams(layoutParams4);
        this.d.addView(this.p);
        linearLayout2.addView(this.d);
        return xj(i, linearLayout, i2);
    }

    private ImageView kd() {
        ImageView imageView = new ImageView(this.xj);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r.w(this.xj, 0.5f), r.w(this.xj, 9.0f));
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i) {
        try {
            Rect rect = new Rect();
            if (this.xj.getResources().getConfiguration().orientation == 1) {
                this.f10463pl.getGlobalVisibleRect(rect);
            } else {
                this.e.getGlobalVisibleRect(rect);
            }
            while (!this.hf.isEmpty()) {
                Rect rect2 = new Rect();
                View pop = this.hf.pop();
                if (pop != null && pop.getVisibility() != 8) {
                    pop.getGlobalVisibleRect(rect2);
                    if (rect2.top != 0 && rect.top >= rect2.bottom) {
                        break;
                    }
                    if (pop == this.kd) {
                        View pop2 = this.hf.pop();
                        if (pop2 != null) {
                            pop2.setVisibility(8);
                        }
                    } else {
                        pop.setVisibility(8);
                    }
                }
            }
            if (this.hf.isEmpty()) {
                f();
            }
        } catch (Throwable unused) {
        }
        this.q.setVisibility(0);
        for (int i2 = 0; i2 < i; i2++) {
            this.q.getChildAt(i2).setVisibility(0);
        }
    }

    private LinearLayout xj(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view) {
        RelativeLayout.LayoutParams ASJ6gh2 = A2egSU.ASJ6gh(-2, -2, 14);
        ASJ6gh2.addRule(2, linearLayout2.getId());
        if (i == 1) {
            ASJ6gh2.leftMargin = i2;
            ASJ6gh2.rightMargin = i2;
        } else {
            int w = r.w(this.xj, 16.0f);
            ASJ6gh2.leftMargin = w;
            ASJ6gh2.rightMargin = w;
        }
        ASJ6gh2.topMargin = r.w(this.xj, 3.0f);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setGravity(17);
        this.g.setTextColor(Color.parseColor("#4D161823"));
        if (i == 0) {
            this.g.setTextSize(10.0f);
        } else {
            this.g.setTextSize(12.0f);
        }
        this.g.setLayoutParams(ASJ6gh2);
        this.q.addView(this.g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
        if (i == 1) {
            layoutParams.topMargin = r.w(this.xj, 9.0f);
        } else {
            layoutParams.topMargin = r.w(this.xj, 2.0f);
            layoutParams.bottomMargin = r.w(this.xj, 20.0f);
        }
        if (i == 1) {
            layoutParams.addRule(2, view.getId());
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(14);
        }
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setGravity(1);
        return hf(i, linearLayout, i2, linearLayout2, view);
    }

    private View y() {
        RelativeLayout relativeLayout = new RelativeLayout(this.xj);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.setId(View.generateViewId());
        ImageView imageView = new ImageView(this.xj);
        this.w = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int w = r.w(this.xj, 46.0f);
        this.w.setMaxHeight(w);
        this.w.setMaxWidth(w);
        this.w.setMinimumHeight(w);
        this.w.setMinimumWidth(w);
        com.bytedance.sdk.openadsdk.res.w wVar = new com.bytedance.sdk.openadsdk.res.w(r.w(this.xj, 14.0f));
        wVar.xj(com.sigmob.sdk.base.blurkit.d.f13043a);
        wVar.xj(r.w(this.xj, 2.0f));
        this.w.setImageDrawable(wVar);
        relativeLayout.addView(this.w);
        TextView textView = new TextView(this.xj);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("应用详情");
        textView.setLayoutParams(layoutParams);
        relativeLayout.addView(textView);
        this.q.addView(relativeLayout);
        return xj(relativeLayout);
    }

    public w d(String str) {
        this.en = str;
        return this;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        xj xjVar = this.j;
        if (xjVar != null) {
            xjVar.w(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xj();
        setCanceledOnTouchOutside(false);
        hf();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        w();
    }

    public w u(String str) {
        this.pz = str;
        return this;
    }

    public String u() {
        return this.en;
    }

    public w c(String str) {
        this.dk = str;
        return this;
    }

    public w kd(String str) {
        this.ht = str;
        return this;
    }

    public w f(String str) {
        this.et = str;
        return this;
    }

    public void w() {
        String str;
        int i;
        if (this.xj == null) {
            this.xj = pz.getContext();
        }
        int i2 = this.xj.getResources().getConfiguration().orientation;
        TextView textView = this.kd;
        if (textView != null) {
            textView.setText(this.v);
        } else {
            TTRoundRectImageView tTRoundRectImageView = this.u;
            if (tTRoundRectImageView != null) {
                tTRoundRectImageView.setVisibility(8);
            }
        }
        if (this.u != null && !TextUtils.isEmpty(this.jk)) {
            com.bytedance.sdk.openadsdk.f.hf.xj(this.jk).to(this.u);
        } else {
            TTRoundRectImageView tTRoundRectImageView2 = this.u;
            if (tTRoundRectImageView2 != null) {
                tTRoundRectImageView2.setVisibility(8);
            }
        }
        if (this.y != null) {
            if (TextUtils.isEmpty(this.pz)) {
                this.y.setVisibility(8);
            } else {
                this.y.setText(this.pz);
            }
        }
        if (this.f != null) {
            JSONArray jSONArray = this.x;
            if (jSONArray != null && jSONArray.length() > 0) {
                WindowManager windowManager = (WindowManager) this.xj.getSystemService("window");
                Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
                if (defaultDisplay != null) {
                    int width = defaultDisplay.getWidth();
                    if (width > defaultDisplay.getHeight()) {
                        double u = r.u(this.xj, width);
                        i = ((int) (u - (0.38d * u))) - 80;
                    } else {
                        i = r.u(this.xj, width) - 36;
                    }
                } else {
                    i = 0;
                }
                int length = this.x.length() <= 3 ? this.x.length() : 3;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    String optString = this.x.optString(i3);
                    if (!TextUtils.isEmpty(optString)) {
                        TextView textView2 = new TextView(this.xj);
                        textView2.setText(optString);
                        textView2.setTextSize(12.0f);
                        textView2.setTextColor(Color.parseColor("#161823"));
                        textView2.setAlpha(0.75f);
                        textView2.setBackgroundColor(Color.parseColor("#0F161823"));
                        int w = r.w(this.xj, 6.0f);
                        textView2.setPadding(w, 0, w, 0);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        int w2 = r.w(this.xj, 3.0f);
                        layoutParams.leftMargin = w2;
                        layoutParams.rightMargin = w2;
                        textView2.setLayoutParams(layoutParams);
                        textView2.getPaint().getTextBounds(optString, 0, optString.length(), new Rect());
                        i -= r.u(this.xj, r11.width()) + 20;
                        if (i >= 0) {
                            this.f.addView(textView2);
                        } else if (this.f.getChildCount() <= 0) {
                            this.f.setVisibility(8);
                        }
                    }
                    i3++;
                }
            } else {
                this.f.setVisibility(8);
            }
        }
        if (this.tf != null && this.p != null) {
            float f = this.ai;
            if (f <= 0.0f) {
                LinearLayout linearLayout = this.d;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                this.tf.setVisibility(8);
                this.p.setVisibility(8);
            } else {
                if (f > 5.0f) {
                    f = 5.0f;
                }
                this.ai = f;
                this.p.setText(new DecimalFormat(".0").format(this.ai));
                this.tf.setRating(this.ai);
                this.tf.xj(r.w(this.xj, 16.0f), r.w(this.xj, 15.0f));
                this.tf.xj(r.w(this.xj, 3.0f), 0, r.w(this.xj, 3.0f), 0);
                this.tf.xj();
            }
        }
        if (this.f10463pl != null) {
            str = TextUtils.isEmpty(this.ht) ? String.format("版本号：%1$s", "暂无") : String.format("版本号：%1$s", this.ht);
            if (i2 == 2) {
                TextPaint paint = this.f10463pl.getPaint();
                Rect rect = new Rect();
                paint.getTextBounds(str, 0, str.length(), rect);
                double tf = r.tf(this.xj);
                int width2 = (((int) (tf - (0.4d * tf))) - rect.width()) - r.w(this.xj, 106.0f);
                TextView textView3 = this.am;
                if (textView3 != null) {
                    TextPaint paint2 = textView3.getPaint();
                    String charSequence = this.am.getText().toString();
                    paint2.getTextBounds(charSequence, 0, charSequence.length(), rect);
                    width2 -= rect.width();
                }
                TextView textView4 = this.c;
                if (textView4 != null) {
                    TextPaint paint3 = textView4.getPaint();
                    String charSequence2 = this.c.getText().toString();
                    paint3.getTextBounds(charSequence2, 0, charSequence2.length(), rect);
                    width2 -= rect.width();
                }
                TextView textView5 = this.zg;
                if (textView5 != null) {
                    TextPaint paint4 = textView5.getPaint();
                    String charSequence3 = this.zg.getText().toString();
                    paint4.getTextBounds(charSequence3, 0, charSequence3.length(), rect);
                    width2 -= rect.width();
                }
                if (this.qt != null && !TextUtils.isEmpty(this.dk)) {
                    TextPaint paint5 = this.qt.getPaint();
                    String charSequence4 = this.qt.getText().toString();
                    paint5.getTextBounds(charSequence4, 0, TextUtils.isEmpty(charSequence4) ? 0 : charSequence4.length(), rect);
                    width2 -= rect.width();
                }
                if (width2 <= 0) {
                    ((LinearLayout.LayoutParams) this.f10463pl.getLayoutParams()).weight = 1.0f;
                }
            }
            if (i2 == 1) {
                this.f10463pl.setText(str);
            }
        } else {
            str = "";
        }
        TextView textView6 = this.g;
        if (textView6 != null) {
            textView6.setSelected(true);
            String format = TextUtils.isEmpty(this.et) ? String.format("开发者：%1$s", "补充中，可于应用官网查看") : String.format("开发者：%1$s", this.et);
            if (i2 == 2) {
                format = CtFAbx.AlLFFp(format, "  ", str);
            }
            this.g.setText(format);
        }
    }

    public w y(String str) {
        this.ra = str;
        return this;
    }

    private LinearLayout hf(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view) {
        if (i == 0) {
            xj(i, (ViewGroup) linearLayout2);
            if (!TextUtils.isEmpty(this.ra)) {
                View imageView = new ImageView(this.xj);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r.w(this.xj, 0.5f), r.w(this.xj, 9.0f));
                layoutParams.leftMargin = r.w(this.xj, 8.0f);
                layoutParams.gravity = 17;
                imageView.setLayoutParams(layoutParams);
                imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
                linearLayout2.addView(imageView);
            }
        }
        int w = r.w(this.xj, 8.0f);
        xj(linearLayout2, w);
        hf(linearLayout2, w);
        return xj(i, linearLayout, i2, linearLayout2, view, w);
    }

    public void xj() {
        if (this.xj == null) {
            this.xj = pz.getContext();
        }
        if (this.xj.getResources().getConfiguration().orientation == 1) {
            this.z = xj(1);
        } else {
            this.z = xj(0);
        }
        setContentView(this.z);
    }

    private View xj(int i) {
        int w;
        LinearLayout hf = hf(i);
        LinearLayout linearLayout = new LinearLayout(this.xj);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (i == 0) {
            w = r.w(this.xj, 40.0f);
        } else {
            layoutParams.addRule(3, y().getId());
            w = r.w(this.xj, 16.0f);
        }
        layoutParams.leftMargin = w;
        layoutParams.rightMargin = w;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        this.q.addView(linearLayout);
        this.u = new TTRoundRectImageView(this.xj);
        int w2 = r.w(this.xj, 64.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(w2, w2);
        layoutParams2.gravity = 1;
        if (i == 0) {
            layoutParams2.topMargin = r.w(this.xj, 40.0f);
        } else {
            layoutParams2.topMargin = r.w(this.xj, 36.0f);
        }
        this.u.setMaxHeight(w2);
        this.u.setMaxWidth(w2);
        this.u.setMinimumHeight(w2);
        this.u.setMinimumWidth(w2);
        this.u.setLayoutParams(layoutParams2);
        linearLayout.addView(this.u);
        return xj(i, hf, linearLayout, w);
    }

    private void hf(LinearLayout linearLayout, int i) {
        linearLayout.addView(kd());
        this.c = new TextView(this.xj);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.c.setLayoutParams(layoutParams);
        this.c.setAlpha(0.75f);
        this.c.setTextColor(Color.parseColor("#66161823"));
        if (this.xj.getResources().getConfiguration().orientation == 2) {
            this.c.setTextSize(10.0f);
        } else {
            this.c.setTextSize(12.0f);
        }
        this.c.setText("权限");
        linearLayout.addView(this.c);
    }

    private LinearLayout hf(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.xj);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(Color.parseColor("#99000000"));
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.xj);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        this.q = new RelativeLayout(this.xj);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(r.w(this.xj, 8.0f));
        this.q.setBackground(gradientDrawable);
        this.q.setLayoutParams(layoutParams2);
        linearLayout.addView(this.q);
        return xj(i, linearLayout);
    }

    private LinearLayout xj(int i, LinearLayout linearLayout, LinearLayout linearLayout2, int i2) {
        this.kd = new TextView(this.xj);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        if (i == 0) {
            layoutParams.topMargin = r.w(this.xj, 16.0f);
            int w = r.w(this.xj, 25.0f);
            layoutParams.leftMargin = w;
            layoutParams.rightMargin = w;
        } else {
            layoutParams.topMargin = r.w(this.xj, 14.0f);
        }
        this.kd.setLayoutParams(layoutParams);
        TextView textView = this.kd;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        this.kd.setTextColor(Color.parseColor("#161823"));
        this.kd.setTextSize(18.0f);
        this.kd.setGravity(17);
        this.kd.setTypeface(null, 1);
        linearLayout2.addView(this.kd);
        this.y = new TextView(this.xj);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = r.w(this.xj, 5.0f);
        this.y.setLayoutParams(layoutParams2);
        this.y.setEllipsize(truncateAt);
        this.y.setSingleLine(true);
        this.y.setAlpha(0.5f);
        this.y.setTextColor(Color.parseColor("#161823"));
        this.y.setTextSize(14.0f);
        this.y.setGravity(17);
        linearLayout2.addView(this.y);
        return hf(i, linearLayout, linearLayout2, i2);
    }

    public void hf() {
        if (this.xj == null) {
            this.xj = pz.getContext();
        }
        this.hf.clear();
        this.hf.push(this.u);
        this.hf.push(this.kd);
        this.hf.push(this.y);
        this.hf.push(this.f);
        this.hf.push(this.d);
        c();
        this.zg.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.w.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (w.this.j == null) {
                    return;
                }
                w.this.j.kd(w.this);
            }
        });
        if (this.qt != null && !TextUtils.isEmpty(this.dk)) {
            this.qt.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.w.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (w.this.j != null) {
                        w.this.j.y(w.this);
                    }
                }
            });
        }
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.w.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (w.this.j != null) {
                    w.this.j.hf(w.this);
                }
            }
        });
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.w.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (w.this.j != null) {
                    w.this.j.w(w.this);
                }
            }
        });
        this.am.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.w.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (w.this.j != null) {
                    w.this.j.u(w.this);
                }
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.w.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (w.this.j != null) {
                    w.this.j.xj(w.this);
                }
            }
        });
    }

    private LinearLayout xj(int i, LinearLayout linearLayout, int i2) {
        int i3 = pz.hf().i();
        boolean oa = pz.hf().oa();
        if (oa && i3 == 1) {
            this.e = new ShakeButton(this.xj);
        } else if (oa && i3 == 2) {
            this.e = new ShineButton(this.xj);
        } else {
            this.e = new Button(this.xj);
        }
        this.e.setId(View.generateViewId());
        LinearLayout linearLayout2 = new LinearLayout(this.xj);
        linearLayout2.setId(View.generateViewId());
        View view = new View(this.xj);
        view.setId(View.generateViewId());
        TextView textView = new TextView(this.xj);
        this.g = textView;
        textView.setId(View.generateViewId());
        if (i == 1) {
            xj(i, this.q);
        } else {
            xj(r.w(this.xj, 89.0f), i);
        }
        return xj(i, linearLayout, i2, linearLayout2, view);
    }

    public w hf(String str) {
        this.jk = str;
        return this;
    }

    private void xj(LinearLayout linearLayout, int i) {
        this.zg = new TextView(this.xj);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.zg.setLayoutParams(layoutParams);
        this.zg.setAlpha(0.75f);
        this.zg.setTextColor(Color.parseColor("#66161823"));
        if (this.xj.getResources().getConfiguration().orientation == 2) {
            this.zg.setTextSize(10.0f);
        } else {
            this.zg.setTextSize(12.0f);
        }
        this.zg.setText("功能");
        linearLayout.addView(this.zg);
    }

    private LinearLayout xj(int i, LinearLayout linearLayout, int i2, LinearLayout linearLayout2, View view, int i3) {
        linearLayout2.addView(kd());
        this.am = new TextView(this.xj);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i3;
        this.am.setLayoutParams(layoutParams);
        this.am.setAlpha(0.75f);
        this.am.setTextColor(Color.parseColor("#66161823"));
        if (this.xj.getResources().getConfiguration().orientation == 2) {
            this.am.setTextSize(10.0f);
        } else {
            this.am.setTextSize(12.0f);
        }
        this.am.setText("隐私");
        linearLayout2.addView(this.am);
        if (!TextUtils.isEmpty(this.dk)) {
            linearLayout2.addView(kd());
            this.qt = new TextView(this.xj);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = i3;
            layoutParams2.rightMargin = i3;
            this.qt.setLayoutParams(layoutParams2);
            this.qt.setAlpha(0.75f);
            this.qt.setTextColor(Color.parseColor("#66161823"));
            if (this.xj.getResources().getConfiguration().orientation == 2) {
                this.qt.setTextSize(10.0f);
            } else {
                this.qt.setTextSize(12.0f);
            }
            this.qt.setText("备案");
            linearLayout2.addView(this.qt);
        }
        this.q.addView(linearLayout2);
        if (i == 0) {
            return linearLayout;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, r.w(this.xj, 1.0f));
        layoutParams3.topMargin = r.w(this.xj, 12.0f);
        layoutParams3.addRule(2, this.e.getId());
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        this.q.addView(view);
        xj(i2, i);
        return linearLayout;
    }

    public w w(String str) {
        this.f10462io = str;
        return this;
    }

    private LinearLayout xj(int i, LinearLayout linearLayout) {
        if (i == 0) {
            this.w = new ImageView(this.xj);
            int w = r.w(this.xj, 28.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(w, w);
            int w2 = r.w(this.xj, 36.0f);
            layoutParams.topMargin = w2;
            layoutParams.rightMargin = w2;
            layoutParams.leftMargin = w2;
            layoutParams.bottomMargin = w2;
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            this.w.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.w.setLayoutParams(layoutParams);
            this.w.setMaxHeight(w);
            this.w.setMaxWidth(w);
            this.w.setMinimumHeight(w);
            this.w.setMinimumWidth(w);
            com.bytedance.sdk.openadsdk.res.hf hfVar = new com.bytedance.sdk.openadsdk.res.hf(r.w(this.xj, 28.0f));
            hfVar.xj(Color.parseColor("#66161823"));
            float w3 = r.w(this.xj, 2.0f);
            hfVar.xj(w3);
            com.bytedance.sdk.openadsdk.res.w wVar = new com.bytedance.sdk.openadsdk.res.w(r.w(this.xj, 12.0f));
            wVar.xj(-1);
            wVar.xj(w3);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{hfVar, wVar});
            layerDrawable.setLayerInset(0, 0, 0, 0, 0);
            int w4 = r.w(this.xj, 8.0f);
            layerDrawable.setLayerInset(1, w4, w4, w4, w4);
            this.w.setImageDrawable(layerDrawable);
            this.q.addView(this.w);
        }
        return linearLayout;
    }

    private void xj(int i, ViewGroup viewGroup) {
        this.f10463pl = new TextView(this.xj);
        if (i == 1) {
            RelativeLayout.LayoutParams ASJ6gh2 = A2egSU.ASJ6gh(-2, -2, 14);
            ASJ6gh2.addRule(2, this.g.getId());
            int w = r.w(this.xj, 16.0f);
            ASJ6gh2.leftMargin = w;
            ASJ6gh2.rightMargin = w;
            ASJ6gh2.topMargin = r.w(this.xj, 30.0f);
            this.f10463pl.setLayoutParams(ASJ6gh2);
            this.f10463pl.setGravity(17);
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388611;
            this.f10463pl.setLayoutParams(layoutParams);
        }
        this.f10463pl.setEllipsize(TextUtils.TruncateAt.END);
        this.f10463pl.setTextColor(Color.parseColor("#57161823"));
        if (i == 0) {
            this.f10463pl.setTextSize(10.0f);
        } else {
            this.f10463pl.setTextSize(12.0f);
        }
        viewGroup.addView(this.f10463pl);
    }

    private void xj(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        if (i2 == 1) {
            layoutParams.topMargin = r.w(this.xj, 14.0f);
            layoutParams.bottomMargin = r.w(this.xj, 46.0f);
            layoutParams.addRule(12);
        } else {
            layoutParams.topMargin = r.w(this.xj, 10.0f);
            layoutParams.bottomMargin = r.w(this.xj, 24.0f);
            layoutParams.addRule(2, this.g.getId());
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(r.w(this.xj, 3.0f));
        this.e.setBackground(gradientDrawable);
        this.e.setGravity(17);
        this.e.setText("立即下载");
        int w = r.w(this.xj, 13.0f);
        this.e.setPadding(0, w, 0, w);
        this.e.setTextColor(-1);
        this.e.setLayoutParams(layoutParams);
        this.e.setTextSize(15.0f);
        this.q.addView(this.e);
        if (i2 != 1 || TextUtils.isEmpty(this.f10462io)) {
            return;
        }
        int w2 = r.w(this.xj, 60.0f);
        com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.hf hfVar = new com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.hf(this.xj);
        this.yo = hfVar;
        hfVar.xj("src", this.f10462io);
        this.yo.xj("loop", "true");
        this.yo.xj("autoPlay", "true");
        this.yo.xj(MediaFormat.KEY_WIDTH, String.valueOf(w2));
        this.yo.xj(MediaFormat.KEY_HEIGHT, String.valueOf(w2));
        this.yo.xj("scaleType", "fitXY");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(w2, w2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, this.e.getId());
        layoutParams2.rightMargin = r.w(this.xj, 73.0f);
        layoutParams2.topMargin = -r.w(this.xj, 85.0f);
        this.yo.xj(layoutParams2);
        UgenLottieView d = this.yo.d();
        if (d == null) {
            return;
        }
        this.yo.hf();
        this.q.addView(d);
    }

    private View xj(RelativeLayout relativeLayout) {
        View view = new View(this.xj);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, r.w(this.xj, 1.0f));
        layoutParams.addRule(3, relativeLayout.getId());
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        view.setId(View.generateViewId());
        this.q.addView(view);
        return view;
    }

    public w xj(String str) {
        this.v = str;
        return this;
    }

    public w xj(JSONArray jSONArray) {
        this.x = jSONArray;
        return this;
    }

    public w xj(float f) {
        this.ai = f;
        return this;
    }

    public w xj(xj xjVar) {
        this.j = xjVar;
        return this;
    }
}
