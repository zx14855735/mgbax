package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.u.hf;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.widget.am;
import com.bytedance.sdk.openadsdk.core.widget.qt;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends y {
    private TextView aq;
    private View b;
    private boolean bl;
    private final Rect cy;
    private float da;
    private View dc;
    private final ai dq;
    private TextView eu;
    private boolean ft;
    private int gh;
    private float gj;
    private int gy;
    private int h;
    private ImageView hl;
    private float i;
    private ColorStateList k;
    private float le;
    private boolean lm;
    private int lw;
    private boolean my;
    private ImageView n;
    private final Rect nb;
    private int ne;
    private ColorStateList oa;
    private int op;
    private boolean qd;
    private ImageView r;
    private final View.OnTouchListener rg;
    private ImageView s;
    private am se;
    private final Rect si;
    private ColorStateList ss;
    private float t;
    private TextView tj;
    private TextView tu;
    private final Rect ua;
    private boolean vl;
    private TextView vm;
    private int wa;
    private SeekBar wn;
    private TextView wo;
    private TextView ws;
    private int xv;
    private View yy;
    private final Rect zb;

    public kd(Context context, View view, boolean z, EnumSet<hf.xj> enumSet, ws wsVar, com.bykv.vk.openvk.component.video.api.u.w wVar, boolean z2) {
        super(context, view, z, enumSet, wsVar, wVar, z2, null);
        this.dq = new ai(Looper.getMainLooper(), this);
        this.qd = false;
        this.bl = false;
        this.lw = 0;
        this.wa = 0;
        this.gh = 0;
        this.op = 0;
        this.gy = 0;
        this.nb = new Rect();
        this.cy = new Rect();
        this.xv = 0;
        this.h = 0;
        this.ne = 0;
        this.se = null;
        this.ft = false;
        this.rg = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.kd.7
            private float hf;

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                float x = motionEvent.getX();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked == 1) {
                        kd.this.ft = Math.abs(this.hf - motionEvent.getX()) < 10.0f;
                    } else if (actionMasked == 2) {
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (actionMasked == 3) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else {
                    this.hf = x;
                }
                return false;
            }
        };
        this.zb = new Rect();
        this.ua = new Rect();
        this.si = new Rect();
        this.f10450io = pz.getContext().getApplicationContext();
        u(z2);
        this.xj = view;
        this.pz = z;
        am amVar = new am(this);
        this.se = amVar;
        amVar.xj(this.pz);
        DisplayMetrics displayMetrics = this.f10450io.getResources().getDisplayMetrics();
        this.h = displayMetrics.widthPixels;
        this.ne = displayMetrics.heightPixels;
        this.dk = enumSet == null ? EnumSet.noneOf(hf.xj.class) : enumSet;
        this.j = wVar;
        this.et = wsVar;
        u(8);
        xj(context, this.xj, wsVar);
        u();
        zg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ShapeDrawable hf(int i, String str) {
        Context context = pz.getContext();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        int w = r.w(context, i);
        shapeDrawable.setIntrinsicWidth(w);
        shapeDrawable.setIntrinsicHeight(w);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(r.w(context, 1.0f));
        paint.setColor(Color.parseColor(str));
        return shapeDrawable;
    }

    private boolean j() {
        ws wsVar = this.et;
        if (wsVar == null) {
            return false;
        }
        int qd = wsVar.qd();
        return qd == 1 || qd == 2;
    }

    private void q() {
        DisplayMetrics displayMetrics = this.f10450io.getResources().getDisplayMetrics();
        TextView textView = this.tu;
        if (textView != null) {
            this.t = textView.getTextSize();
            this.tu.setTextSize(2, 14.0f);
            ColorStateList textColors = this.tu.getTextColors();
            this.k = textColors;
            if (textColors != null) {
                this.tu.setTextColor(jk.tf(this.f10450io, "tt_ssxinzi15"));
            }
            this.da = this.tu.getAlpha();
            this.tu.setAlpha(0.85f);
            this.tu.setShadowLayer(0.0f, r.w(this.f10450io, 0.5f), r.w(this.f10450io, 0.5f), jk.tf(this.f10450io, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams = this.tu.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.zb.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                r.hf(this.tu, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.zb.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.zb.bottom);
            }
        }
        TextView textView2 = this.aq;
        if (textView2 != null) {
            this.le = textView2.getTextSize();
            this.aq.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.aq.getTextColors();
            this.oa = textColors2;
            if (textColors2 != null) {
                this.aq.setTextColor(jk.tf(this.f10450io, "tt_ssxinzi15"));
            }
            this.i = this.aq.getAlpha();
            this.aq.setAlpha(0.85f);
            this.aq.setShadowLayer(0.0f, r.w(this.f10450io, 0.5f), r.w(this.f10450io, 0.5f), jk.tf(this.f10450io, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams2 = this.aq.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.ua.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                TextView textView3 = this.aq;
                int applyDimension = (int) TypedValue.applyDimension(1, 14.0f, displayMetrics);
                Rect rect = this.ua;
                r.hf(textView3, applyDimension, rect.top, rect.right, rect.bottom);
            }
        }
        ImageView imageView = this.s;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.si.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                ImageView imageView2 = this.s;
                Rect rect2 = this.si;
                r.hf(imageView2, rect2.left, rect2.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.si.bottom);
            }
        }
        ImageView imageView3 = this.s;
        if (imageView3 != null) {
            jk.xj(this.f10450io, "tt_shrink_fullscreen", imageView3);
        }
        TextView textView4 = this.eu;
        if (textView4 != null) {
            ColorStateList textColors3 = textView4.getTextColors();
            this.ss = textColors3;
            if (textColors3 != null) {
                this.eu.setTextColor(jk.tf(this.f10450io, "tt_ssxinzi15"));
            }
            this.gj = this.eu.getAlpha();
            this.eu.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.eu.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.cy.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                TextView textView5 = this.eu;
                int applyDimension2 = (int) TypedValue.applyDimension(1, 1.0f, displayMetrics);
                Rect rect3 = this.ua;
                r.hf(textView5, applyDimension2, rect3.top, rect3.right, rect3.bottom);
            }
        }
        View view = this.b;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.xv = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.b.setLayoutParams(layoutParams5);
            jk.xj(this.f10450io, "tt_shadow_fullscreen_top", this.b);
        }
        hf(this.vl, true);
    }

    private void z() {
        TextView textView = this.tu;
        if (textView != null) {
            textView.setTextSize(0, this.t);
            ColorStateList colorStateList = this.k;
            if (colorStateList != null) {
                this.tu.setTextColor(colorStateList);
            }
            this.tu.setAlpha(this.da);
            this.tu.setShadowLayer(r.w(this.f10450io, 1.0f), 0.0f, 0.0f, jk.tf(this.f10450io, "tt_video_shadow_color"));
            TextView textView2 = this.tu;
            Rect rect = this.zb;
            r.hf(textView2, rect.left, rect.top, rect.right, rect.bottom);
        }
        TextView textView3 = this.aq;
        if (textView3 != null) {
            textView3.setTextSize(0, this.le);
            ColorStateList colorStateList2 = this.oa;
            if (colorStateList2 != null) {
                this.aq.setTextColor(colorStateList2);
            }
            this.aq.setAlpha(this.i);
            this.aq.setShadowLayer(r.w(this.f10450io, 1.0f), 0.0f, 0.0f, jk.tf(this.f10450io, "tt_video_shadow_color"));
            TextView textView4 = this.aq;
            Rect rect2 = this.ua;
            r.hf(textView4, rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
        ImageView imageView = this.s;
        if (imageView != null) {
            Rect rect3 = this.si;
            r.hf(imageView, rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
        ImageView imageView2 = this.s;
        if (imageView2 != null) {
            jk.xj(this.f10450io, "tt_enlarge_video", imageView2);
        }
        TextView textView5 = this.eu;
        if (textView5 != null) {
            ColorStateList colorStateList3 = this.ss;
            if (colorStateList3 != null) {
                textView5.setTextColor(colorStateList3);
            }
            this.eu.setAlpha(this.gj);
            TextView textView6 = this.eu;
            Rect rect4 = this.ua;
            r.hf(textView6, rect4.left, rect4.top, rect4.right, rect4.bottom);
        }
        View view = this.b;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.xv;
            this.b.setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
            this.b.setBackground(gradientDrawable);
        }
        hf(this.vl, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y, com.bytedance.sdk.openadsdk.core.widget.am.xj
    public void am() {
        pl();
        w(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void c() {
        ws wsVar;
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.et)) {
            ht();
            return;
        }
        r.y(this.u);
        r.y(this.kd);
        r.kd(this.yy);
        if (this.y != null && (wsVar = this.et) != null && !TextUtils.isEmpty(h.hf(wsVar))) {
            r.y(this.y);
            com.bytedance.sdk.openadsdk.f.hf.xj(h.hf(this.et)).to(this.y);
            xj(this.y, h.hf(this.et));
        }
        if (this.w.getVisibility() == 0) {
            r.xj((View) this.w, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void d() {
        this.wn.setProgress(0);
        this.wn.setSecondaryProgress(0);
        this.qt.setProgress(0);
        this.qt.setSecondaryProgress(0);
        this.aq.setText(jk.xj(this.f10450io, "tt_00_00"));
        this.tu.setText(jk.xj(this.f10450io, "tt_00_00"));
        u(8);
        if (ai()) {
            this.hf.setVisibility(8);
        }
        ImageView imageView = this.y;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.y.setBackground(null);
        }
        u(8);
        r.xj(this.dc, 8);
        r.xj(this.f, 8);
        r.xj((View) this.d, 8);
        r.xj(this.tf, 8);
        r.xj((View) this.p, 8);
        r.xj((View) this.f10451pl, 8);
        r.xj((View) this.g, 8);
        qt qtVar = this.x;
        if (qtVar != null) {
            qtVar.xj(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void f() {
        r.kd(this.u);
        r.kd(this.yy);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public boolean g() {
        return this.ht;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void kd() {
        this.dq.removeMessages(1);
        this.dq.sendMessageDelayed(this.dq.obtainMessage(1), 2000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public boolean p() {
        return this.pz;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y, com.bytedance.sdk.openadsdk.core.widget.qt.hf
    public void pl() {
        xj(true, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y, com.bytedance.sdk.openadsdk.core.widget.am.xj
    public boolean qt() {
        qt qtVar = this.x;
        return qtVar != null && qtVar.xj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y, com.bytedance.sdk.openadsdk.core.widget.qt.hf
    public boolean tf() {
        return this.qd;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void u() {
        super.u();
        this.se.xj(this.xj);
        r.xj((View) this.r, (this.pz || this.dk.contains(hf.xj.hideCloseBtn)) ? 8 : 0);
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.kd.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (kd.this.pz()) {
                    kd kdVar = kd.this;
                    kdVar.ai.w(kdVar, view);
                }
            }
        });
        r.xj((View) this.wo, (!this.pz || this.dk.contains(hf.xj.alwayShowBackBtn)) ? 0 : 8);
        this.wo.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.kd.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (kd.this.pz()) {
                    kd kdVar = kd.this;
                    kdVar.ai.u(kdVar, view);
                }
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.kd.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (kd.this.pz()) {
                    kd kdVar = kd.this;
                    kdVar.ai.kd(kdVar, view);
                }
            }
        });
        this.hl.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.kd.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                kd.this.hf(false, true);
                kd.this.f();
                kd.this.c();
                kd.this.pz();
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.kd.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (kd.this.pz()) {
                    kd kdVar = kd.this;
                    kdVar.ai.hf(kdVar, view);
                }
            }
        });
        this.wn.setThumbOffset(0);
        this.wn.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.kd.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (kd.this.pz()) {
                    kd kdVar = kd.this;
                    kdVar.ai.xj(kdVar, i, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!kd.this.qd && kd.this.f10450io != null) {
                    seekBar.setThumb(kd.hf(22, "#1E000000"));
                }
                if (kd.this.pz()) {
                    seekBar.setThumbOffset(0);
                    kd kdVar = kd.this;
                    kdVar.ai.hf(kdVar, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!kd.this.qd && kd.this.f10450io != null) {
                    seekBar.setThumb(kd.hf(15, "#1E000000"));
                }
                if (kd.this.pz()) {
                    seekBar.setThumbOffset(0);
                    kd kdVar = kd.this;
                    kdVar.ai.xj(kdVar, seekBar.getProgress());
                }
            }
        });
        this.wn.setOnTouchListener(this.rg);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public boolean w(int i) {
        SeekBar seekBar = this.wn;
        return seekBar != null && i > seekBar.getSecondaryProgress();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void y() {
        this.dq.removeMessages(1);
    }

    private void y(boolean z) {
        if (z) {
            q();
        } else {
            z();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void w(boolean z) {
        TextView textView = this.ws;
        if (textView != null) {
            r.xj((View) textView, (!this.pz && z) ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y, com.bykv.vk.openvk.component.video.api.u.hf
    @SuppressLint({"ClickableViewAccessibility"})
    public /* bridge */ /* synthetic */ void xj(Object obj, WeakReference weakReference, boolean z) {
        xj((ws) obj, (WeakReference<Context>) weakReference, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void xj(Context context, View view, ws wsVar) {
        super.xj(context, view, wsVar);
        this.wo = (TextView) view.findViewById(2114387759);
        this.r = (ImageView) view.findViewById(2114387678);
        this.b = view.findViewById(2114387605);
        this.n = (ImageView) view.findViewById(2114387897);
        this.ws = (TextView) view.findViewById(2114387730);
        this.eu = (TextView) view.findViewById(2114387706);
        this.tj = (TextView) view.findViewById(2114387846);
        this.yy = view.findViewById(2114387823);
        this.hl = (ImageView) view.findViewById(2114387618);
        this.vm = (TextView) view.findViewById(2114387860);
        this.wn = (SeekBar) view.findViewById(2114387872);
        this.aq = (TextView) view.findViewById(2114387668);
        this.tu = (TextView) view.findViewById(2114387811);
        this.dc = view.findViewById(2114387628);
        this.s = (ImageView) view.findViewById(2114387661);
        this.c = (TTViewStub) view.findViewById(2114387744);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void hf(boolean z) {
        int i = tf() ? this.ne : this.e;
        int i2 = tf() ? this.h : this.yo;
        if (this.jk <= 0 || this.v <= 0 || i <= 0) {
            return;
        }
        if (!p() && !tf() && !this.dk.contains(hf.xj.fixedSize)) {
            i2 = this.f10450io.getResources().getDimensionPixelSize(jk.d(this.f10450io, "tt_video_container_maxheight"));
        }
        int i3 = this.v;
        int i4 = this.jk;
        int i5 = (int) (i4 * ((i * 1.0f) / i3));
        if (i5 > i2) {
            i = (int) (i3 * ((i2 * 1.0f) / i4));
        } else {
            i2 = i5;
        }
        if (!z && !tf()) {
            i = this.e;
            i2 = this.yo;
        }
        this.hf.xj(i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void u(int i) {
        this.ra = i;
        r.xj(this.xj, i);
        if (i != 0) {
            this.lm = false;
        } else if (this.my) {
            this.lm = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void hf(int i) {
        View view = this.dc;
        if (view != null && view.getVisibility() == 0) {
            r.xj((View) this.qt, 8);
            return;
        }
        r.xj((View) this.qt, 0);
        this.wn.setProgress(i);
        this.qt.setProgress(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void xj(String str) {
        TextView textView = this.ws;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.eu;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void xj(long j, long j2) {
        this.aq.setText(com.bykv.vk.openvk.component.video.xj.kd.xj.xj(j2));
        this.tu.setText(com.bykv.vk.openvk.component.video.xj.kd.xj.xj(j));
        this.wn.setProgress(com.bykv.vk.openvk.component.video.xj.kd.xj.xj(j, j2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void hf(ViewGroup viewGroup) {
        View view;
        pl.u("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup == null || (view = this.xj) == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.qd = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.xj.getLayoutParams();
        marginLayoutParams.width = this.gh;
        marginLayoutParams.height = this.op;
        marginLayoutParams.leftMargin = this.wa;
        marginLayoutParams.topMargin = this.lw;
        this.xj.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.gy);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            Rect rect = this.nb;
            r.hf(viewGroup, rect.left, rect.top, rect.right, rect.bottom);
        }
        hf(true);
        jk.xj(this.f10450io, "tt_enlarge_video", this.s);
        this.wn.setThumb(hf(15, "#1E000000"));
        this.wn.setThumbOffset(0);
        com.bykv.vk.openvk.component.video.xj.kd.xj.xj(this.xj, true);
        y(this.qd);
        r.xj(this.b, 8);
        if (this.dk.contains(hf.xj.alwayShowBackBtn)) {
            r.xj((View) this.wo, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y, com.bykv.vk.openvk.component.video.api.u.hf
    public void xj() {
        xj(false, this.pz);
        et();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void xj(long j) {
        this.tu.setText(com.bykv.vk.openvk.component.video.xj.kd.xj.xj(j));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    @SuppressLint({"ClickableViewAccessibility"})
    public void xj(ws wsVar, WeakReference<Context> weakReference, boolean z) {
        ws wsVar2;
        if (wsVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar)) {
            xj(pz.getContext(), this.xj);
            yo();
            return;
        }
        xj(this.xj, pz.getContext());
        xj(false, this.pz);
        r.xj(this.f, 0);
        r.xj((View) this.d, 0);
        r.xj(this.tf, 0);
        if (this.d != null && (wsVar2 = this.et) != null && !TextUtils.isEmpty(h.hf(wsVar2))) {
            com.bytedance.sdk.openadsdk.f.hf.xj(h.hf(this.et)).to(this.d);
            xj(this.d, h.hf(this.et));
        }
        r.xj((View) this.am, 0);
        r.xj((View) this.p, 8);
        r.xj((View) this.f10451pl, 8);
        r.xj((View) this.g, 8);
        r.xj(this.am, jk.xj(this.f10450io, "tt_video_dial_replay"));
        r.xj(this.am, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.kd.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hf hfVar = kd.this.ai;
                if (hfVar != null) {
                    hfVar.xj();
                }
            }
        }, "video_ad_button");
        r.xj(this.am, (View.OnTouchListener) null, "video_ad_button");
        if (j()) {
            r.xj(this.tf, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void xj(ViewGroup viewGroup) {
        if (viewGroup != null && (this.xj.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.qd = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.xj.getLayoutParams();
            this.wa = marginLayoutParams.leftMargin;
            this.lw = marginLayoutParams.topMargin;
            this.gh = marginLayoutParams.width;
            this.op = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.xj.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.gy = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.nb.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                r.hf(viewGroup, 0, 0, 0, 0);
            }
            hf(true);
            jk.xj(this.f10450io, "tt_shrink_video", this.s);
            this.wn.setThumb(hf(18, "#00000000"));
            this.wn.setThumbOffset(0);
            com.bykv.vk.openvk.component.video.xj.kd.xj.xj(this.xj, false);
            y(this.qd);
            r.xj(this.b, 8);
            if (!this.pz) {
                r.xj((View) this.r, 8);
                r.xj((View) this.wo, 8);
            } else if (this.dk.contains(hf.xj.hideCloseBtn)) {
                r.xj((View) this.r, 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y, com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        if (message.what != 1) {
            return;
        }
        pl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void xj(boolean z, boolean z2, boolean z3) {
        r.xj(this.dc, 0);
        r.xj((View) this.qt, 0);
        if (this.qd) {
            r.xj(this.b, 0);
            r.xj((View) this.eu, 0);
        } else if (z3) {
            r.xj(this.b, 8);
        }
        r.xj((View) this.w, (!z || this.u.getVisibility() == 0) ? 8 : 0);
        if (!this.pz && !this.qd) {
            if (!this.dk.contains(hf.xj.hideCloseBtn) && !z3) {
                r.xj((View) this.r, 0);
            }
            r.xj((View) this.wo, z3 ? 8 : 0);
        }
        r.xj((View) this.aq, 0);
        r.xj((View) this.tu, 0);
        if (j()) {
            r.xj((View) this.wn, 8);
        } else {
            r.xj((View) this.wn, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y
    public void xj(boolean z, boolean z2) {
        r.xj(this.dc, 8);
        r.xj(this.b, 8);
        r.xj((View) this.qt, z ? 0 : 8);
        r.xj((View) this.w, 8);
        if (!this.pz && !this.qd) {
            r.xj((View) this.r, 8);
            if (!this.dk.contains(hf.xj.alwayShowBackBtn)) {
                r.xj((View) this.wo, 8);
            }
        } else if (this.dk.contains(hf.xj.hideCloseBtn)) {
            r.xj((View) this.r, 8);
        }
        if (z2) {
            r.xj((View) this.r, 8);
            r.xj((View) this.wo, 8);
        }
        w(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.y, com.bytedance.sdk.openadsdk.core.widget.am.xj
    public void xj(View view, boolean z) {
        if (tf()) {
            String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            ws wsVar = this.et;
            if (wsVar != null && !TextUtils.isEmpty(wsVar.kr())) {
                xj(this.et.kr());
            }
            this.tj.setText(format);
        } else {
            xj("");
            this.tj.setText("");
        }
        if (this.q) {
            return;
        }
        w(this.pz && !this.qd);
        if (pz()) {
            this.ai.xj(this, view, true, this.u.getVisibility() != 0);
        }
    }
}
