package com.octopus.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.octopus.ad.internal.utilities.ViewUtil;
import com.octopus.ad.widget.ScrollClickView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    int f12709a;
    int b;
    private Context c;
    private int d;
    private int e;
    private a f = null;
    private boolean g = false;
    private int h = 200;
    private ScrollClickView i;

    public interface a {
        void a(com.octopus.ad.model.d dVar);
    }

    public k(Context context) {
        this.c = context;
    }

    public void a() {
        a(1000);
        b(0);
    }

    public void b(int i) {
        this.e = i;
    }

    public void b() {
        this.g = false;
        ScrollClickView scrollClickView = this.i;
        if (scrollClickView != null) {
            scrollClickView.b();
        }
        this.f = null;
        this.c = null;
        this.i = null;
        this.h = 200;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public View a(final int i, final int i2, String str) {
        com.octopus.ad.utils.b.f.a("ScrollClickUtil", "enter getScrollClick");
        if (this.c == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = "向上滑动跳转至\n第三方应用或详情页";
            }
            ScrollClickView scrollClickView = new ScrollClickView(this.c);
            this.i = scrollClickView;
            scrollClickView.setScrollDirection("up");
            this.i.setTitleText(str);
            int parseInt = Integer.parseInt("35");
            int parseInt2 = Integer.parseInt("56");
            float f = i / 360.0f;
            this.i.setTitleFont((int) (10.0f * f));
            this.i.setHandWidth((int) (parseInt * f));
            this.i.setScrollbarHeight((int) (parseInt2 * f));
            this.i.c();
            String str2 = "77%";
            TextUtils.isEmpty("50%");
            if (TextUtils.isEmpty("77%")) {
                str2 = "50%";
            }
            if ("50%".endsWith("%")) {
                this.f12709a = (Integer.parseInt("50%".substring(0, "50%".indexOf("%"))) * i) / 100;
            } else {
                this.f12709a = Integer.parseInt("50%");
            }
            if (str2.endsWith("%")) {
                this.b = (Integer.parseInt(str2.substring(0, str2.indexOf("%"))) * i2) / 100;
            } else {
                this.b = Integer.parseInt(str2);
            }
            this.f12709a = ViewUtil.dip2px(this.c, this.f12709a);
            this.b = ViewUtil.dip2px(this.c, this.b);
            final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            com.octopus.ad.utils.b.f.a("ScrollClickUtil", "topInt = " + this.b + ",centerXInt = " + this.f12709a + ",adWidthDp = " + i + ",adHeightDp = " + i2);
            this.i.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.octopus.ad.utils.k.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (k.this.i == null) {
                        return;
                    }
                    k.this.i.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = k.this.i.getMeasuredWidth();
                    int measuredHeight = k.this.i.getMeasuredHeight();
                    k kVar = k.this;
                    if (kVar.b == 0) {
                        kVar.b = ViewUtil.dip2px(kVar.c, i2) / 2;
                    }
                    k kVar2 = k.this;
                    if (kVar2.f12709a == 0) {
                        kVar2.f12709a = ViewUtil.dip2px(kVar2.c, i) / 2;
                    }
                    FrameLayout.LayoutParams layoutParams2 = layoutParams;
                    k kVar3 = k.this;
                    layoutParams2.topMargin = kVar3.b - (measuredHeight / 2);
                    layoutParams2.leftMargin = kVar3.f12709a - (measuredWidth / 2);
                    kVar3.i.setLayoutParams(layoutParams);
                    com.octopus.ad.utils.b.f.a("ScrollClickUtil", "topMargin = " + layoutParams.topMargin + ",leftMargin = " + layoutParams.leftMargin + ",scrollViewWidthInt = " + measuredWidth);
                }
            });
            this.i.setLayoutParams(layoutParams);
            this.i.postDelayed(new Runnable() { // from class: com.octopus.ad.utils.k.2
                @Override // java.lang.Runnable
                public void run() {
                    if (k.this.i != null) {
                        k.this.i.a();
                    }
                }
            }, 10L);
            return this.i;
        } catch (Throwable unused) {
            return null;
        }
    }
}
