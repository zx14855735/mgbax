package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DG07BK extends ViewGroup.MarginLayoutParams {

    /* renamed from: A2egSU, reason: collision with root package name */
    public Dphsd2 f9343A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Rect f9344A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f9345A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f9346ADYaiT;

    public DG07BK(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9344A4TApA = new Rect();
        this.f9345A5SV6n = true;
        this.f9346ADYaiT = false;
    }

    public DG07BK(int i, int i2) {
        super(i, i2);
        this.f9344A4TApA = new Rect();
        this.f9345A5SV6n = true;
        this.f9346ADYaiT = false;
    }

    public DG07BK(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f9344A4TApA = new Rect();
        this.f9345A5SV6n = true;
        this.f9346ADYaiT = false;
    }

    public DG07BK(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f9344A4TApA = new Rect();
        this.f9345A5SV6n = true;
        this.f9346ADYaiT = false;
    }

    public DG07BK(DG07BK dg07bk) {
        super((ViewGroup.LayoutParams) dg07bk);
        this.f9344A4TApA = new Rect();
        this.f9345A5SV6n = true;
        this.f9346ADYaiT = false;
    }
}
