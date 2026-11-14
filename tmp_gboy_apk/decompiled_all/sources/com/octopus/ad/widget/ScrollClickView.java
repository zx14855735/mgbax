package com.octopus.ad.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.octopus.ad.R;
import com.octopus.ad.internal.utilities.ViewUtil;
import com.octopus.ad.utils.b.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ScrollClickView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    ImageView f12717a;
    ImageView b;
    TextView c;
    private boolean d;
    private String e;
    private int f;
    private String g;
    private int h;
    private int i;
    private ValueAnimator j;
    private Context k;
    private FrameLayout l;
    private FrameLayout m;
    private LinearLayout n;

    public ScrollClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = false;
        this.f = 12;
        this.g = "up";
        this.h = 45;
        this.i = 180;
        this.n = null;
        a(context);
    }

    private void e() {
        this.f12717a.post(new Runnable() { // from class: com.octopus.ad.widget.ScrollClickView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ScrollClickView.this.l == null || ScrollClickView.this.m == null) {
                    f.b("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
                    return;
                }
                if (ScrollClickView.this.f12717a.getLayoutParams() == null) {
                    return;
                }
                final int i = ScrollClickView.this.f12717a.getLayoutParams().height;
                ScrollClickView scrollClickView = ScrollClickView.this;
                scrollClickView.j = ValueAnimator.ofInt(i, scrollClickView.i);
                ViewGroup.LayoutParams layoutParams = ScrollClickView.this.b.getLayoutParams();
                f.b("ScrollClickUtil", "handHeight = " + i);
                if (layoutParams != null) {
                    layoutParams.height = ScrollClickView.this.i;
                }
                ScrollClickView.this.j.setDuration(1000L);
                ScrollClickView.this.j.setRepeatCount(-1);
                ScrollClickView.this.j.setRepeatMode(1);
                ScrollClickView.this.j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.octopus.ad.widget.ScrollClickView.2.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        ViewGroup.LayoutParams layoutParams2 = ScrollClickView.this.l.getLayoutParams();
                        if (layoutParams2 != null) {
                            layoutParams2.height = intValue;
                        }
                        ViewGroup.LayoutParams layoutParams3 = ScrollClickView.this.m.getLayoutParams();
                        if (layoutParams3 != null) {
                            layoutParams3.height = intValue - (i / 3);
                        }
                        ScrollClickView.this.l.requestLayout();
                    }
                });
            }
        });
    }

    public void setHandWidth(int i) {
        this.h = i;
    }

    public void setScrollDirection(String str) {
        this.g = str;
    }

    public void setScrollbarHeight(int i) {
        this.i = i;
    }

    public void setTitleFont(int i) {
        this.f = i;
    }

    public void setTitleText(String str) {
        this.e = str;
    }

    private void d() {
        this.f12717a.post(new Runnable() { // from class: com.octopus.ad.widget.ScrollClickView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ScrollClickView.this.l == null || ScrollClickView.this.m == null) {
                    f.b("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
                    return;
                }
                if (ScrollClickView.this.f12717a.getLayoutParams() == null) {
                    return;
                }
                final int i = ScrollClickView.this.f12717a.getLayoutParams().height;
                ScrollClickView scrollClickView = ScrollClickView.this;
                scrollClickView.j = ValueAnimator.ofInt(i, scrollClickView.i);
                f.b("ScrollClickUtil", "handHeight = " + i + ",scrollbarHeight = " + ScrollClickView.this.i);
                ViewGroup.LayoutParams layoutParams = ScrollClickView.this.b.getLayoutParams();
                StringBuilder sb = new StringBuilder("handHeight = ");
                sb.append(i);
                f.b("ScrollClickUtil", sb.toString());
                if (layoutParams != null) {
                    layoutParams.height = ScrollClickView.this.i;
                }
                ScrollClickView.this.j.setDuration(1000L);
                ScrollClickView.this.j.setRepeatCount(-1);
                ScrollClickView.this.j.setRepeatMode(1);
                ScrollClickView.this.j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.octopus.ad.widget.ScrollClickView.1.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        ViewGroup.LayoutParams layoutParams2 = ScrollClickView.this.f12717a.getLayoutParams();
                        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams2).topMargin = ScrollClickView.this.i - intValue;
                        }
                        ViewGroup.LayoutParams layoutParams3 = ScrollClickView.this.m.getLayoutParams();
                        if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                            layoutParams3.height = intValue - (i / 3);
                            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
                            layoutParams4.topMargin = ScrollClickView.this.i - layoutParams4.height;
                        }
                        ScrollClickView.this.l.requestLayout();
                    }
                });
            }
        });
    }

    public void b() {
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.j.cancel();
        }
    }

    public void c() {
        try {
            if ("up".equalsIgnoreCase(this.g)) {
                this.n = (LinearLayout) LayoutInflater.from(this.k).inflate(R.layout.oct_layout_scrollview_up, this);
            } else if ("down".equalsIgnoreCase(this.g)) {
                this.n = (LinearLayout) LayoutInflater.from(this.k).inflate(R.layout.oct_layout_scrollview_down, this);
            }
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
            if ("up".equalsIgnoreCase(this.g)) {
                this.n = (LinearLayout) LayoutInflater.from(this.k.getApplicationContext()).inflate(R.layout.oct_layout_scrollview_up, this);
            } else if ("down".equalsIgnoreCase(this.g)) {
                this.n = (LinearLayout) LayoutInflater.from(this.k.getApplicationContext()).inflate(R.layout.oct_layout_scrollview_down, this);
            }
        }
        LinearLayout linearLayout = this.n;
        if (linearLayout == null) {
            return;
        }
        this.f12717a = (ImageView) linearLayout.findViewById(R.id.hand);
        this.b = (ImageView) this.n.findViewById(R.id.scrollbar);
        this.c = (TextView) this.n.findViewById(R.id.title);
        this.l = (FrameLayout) this.n.findViewById(R.id.scroll_container);
        this.m = (FrameLayout) this.n.findViewById(R.id.scrollbar_container);
        this.h = ViewUtil.dip2px(this.k, this.h);
        this.i = ViewUtil.dip2px(this.k, this.i) + this.h;
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(this.e);
            this.c.setTextSize(2, this.f);
        }
        ImageView imageView = this.f12717a;
        if (imageView == null || this.b == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.b.getLayoutParams();
        if (layoutParams != null) {
            int i = this.h;
            layoutParams.width = i;
            layoutParams.height = i;
            if (layoutParams2 != null) {
                layoutParams2.height = this.i;
                layoutParams2.width = (int) (i * 0.55f);
            }
        }
        if ("down".equalsIgnoreCase(this.g)) {
            e();
        } else if ("up".equalsIgnoreCase(this.g)) {
            d();
        } else {
            if ("left".equalsIgnoreCase(this.g)) {
                return;
            }
            "right".equalsIgnoreCase(this.g);
        }
    }

    public void a() {
        StringBuilder sb = new StringBuilder("startAnim animator != null ? ");
        sb.append(this.j != null);
        f.b("ScrollClickUtil", sb.toString());
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void a(Context context) {
        if (this.d) {
            return;
        }
        this.k = context;
        this.d = true;
    }

    public ScrollClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = false;
        this.f = 12;
        this.g = "up";
        this.h = 45;
        this.i = 180;
        this.n = null;
        a(context);
    }

    public ScrollClickView(Context context) {
        super(context);
        this.d = false;
        this.f = 12;
        this.g = "up";
        this.h = 45;
        this.i = 180;
        this.n = null;
        a(context);
    }
}
