package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private final int f13281a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private Button i;
    private Button j;
    private int k;
    private TextView l;
    private final com.sigmob.sdk.videoAd.c m;

    public interface a {
        void a();

        void b();
    }

    public d(Context context, com.sigmob.sdk.videoAd.c cVar) {
        super(context);
        this.m = cVar;
        this.f13281a = Dips.dipsToIntPixels(10.0f, context);
        int dipsToIntPixels = Dips.dipsToIntPixels(16.0f, context);
        this.b = dipsToIntPixels;
        this.c = Dips.dipsToIntPixels(227.0f, context);
        this.f = (int) ((r1 * 16.0f) / 9.0d);
        int dipsToIntPixels2 = Dips.dipsToIntPixels(25.0f, context);
        this.d = dipsToIntPixels2;
        this.h = Dips.dipsToIntPixels(25.0f, context);
        this.e = Dips.dipsToIntPixels(100.0f, context);
        this.g = dipsToIntPixels2 + dipsToIntPixels;
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        e(context);
    }

    private TextView a(Context context) {
        TextView textView = new TextView(context);
        textView.setText(this.m.a());
        textView.setTextColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        textView.setTextSize(2, 18.0f);
        textView.setGravity(17);
        return textView;
    }

    private TextView b(Context context) {
        TextView textView = new TextView(context);
        this.l = textView;
        textView.setTextColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        this.l.setTextSize(2, 14.0f);
        this.l.setGravity(17);
        return this.l;
    }

    private Button c(Context context) {
        Button button = new Button(context);
        button.setText(this.m.c());
        button.setTextColor(Color.parseColor("#ff999999"));
        button.setBackgroundColor(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, this.b / 2, 0, 0);
        button.setGravity(17);
        button.setTextSize(2, 14.0f);
        button.setLayoutParams(layoutParams);
        return button;
    }

    private Button d(Context context) {
        Button button = new Button(context);
        button.setText(this.m.d());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.g);
        int i = this.f13281a;
        layoutParams.setMargins(i * 5, i * 2, i * 5, 0);
        button.setLayoutParams(layoutParams);
        button.setTextColor(-1);
        button.setBackgroundColor(0);
        button.setTextSize(2, 16.0f);
        ab.a(button, r.f13321a, this.g / 2, Color.parseColor("#66000000"), 0, 0, 0);
        return button;
    }

    private void e(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.d);
        int i = this.b;
        layoutParams.setMargins(i, this.f13281a * 2, i, 0);
        linearLayout.addView(a(context), layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.h);
        int i2 = this.b;
        layoutParams2.setMargins(i2, this.f13281a, i2, 0);
        linearLayout.addView(b(context), layoutParams2);
        ab.a(linearLayout, Color.parseColor("#FFFFFF"), this.f13281a, Color.parseColor("#66000000"), 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.f, this.c);
        int i3 = this.b;
        layoutParams3.setMargins(i3, 0, i3, 0);
        layoutParams3.addRule(13);
        relativeLayout.setLayoutParams(layoutParams3);
        relativeLayout.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
        Button d = d(context);
        this.j = d;
        linearLayout.addView(d);
        Button c = c(context);
        this.i = c;
        linearLayout.addView(c);
        linearLayout.setGravity(17);
        addView(relativeLayout);
    }

    public void setDialogListener(final a aVar) {
        Button button = this.i;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.base.views.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    aVar.a();
                }
            });
        }
        Button button2 = this.j;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.base.views.d.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    aVar.b();
                }
            });
        }
    }

    public void setDuration(int i) {
        this.k = i;
        TextView textView = this.l;
        if (textView == null) {
            return;
        }
        textView.setText(this.m.b().replace("_SEC_", String.valueOf(this.k)));
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }
}
