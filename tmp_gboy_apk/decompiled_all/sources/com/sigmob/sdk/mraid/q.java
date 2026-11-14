package com.sigmob.sdk.mraid;

import android.content.Context;
import android.graphics.Rect;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13487a;
    private final Rect b = new Rect();
    private final Rect c = new Rect();
    private final Rect d = new Rect();
    private final Rect e = new Rect();
    private final Rect f = new Rect();
    private final Rect g = new Rect();
    private final Rect h = new Rect();
    private final Rect i = new Rect();
    private final float j;

    public q(Context context, float f) {
        this.f13487a = context.getApplicationContext();
        this.j = f;
    }

    public float a() {
        return this.j;
    }

    public Rect b() {
        return this.b;
    }

    public Rect c() {
        return this.c;
    }

    public Rect d() {
        return this.d;
    }

    public Rect e() {
        return this.e;
    }

    public Rect f() {
        return this.f;
    }

    public Rect g() {
        return this.g;
    }

    public Rect h() {
        return this.h;
    }

    public Rect i() {
        return this.i;
    }

    public void a(int i, int i2) {
        this.b.set(0, 0, i, i2);
        a(this.b, this.c);
    }

    public void b(int i, int i2, int i3, int i4) {
        this.f.set(i, i2, i3 + i, i4 + i2);
        a(this.f, this.g);
    }

    public void c(int i, int i2, int i3, int i4) {
        this.h.set(i, i2, i3 + i, i4 + i2);
        a(this.h, this.i);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.d.set(i, i2, i3 + i, i4 + i2);
        a(this.d, this.e);
    }

    private void a(Rect rect, Rect rect2) {
        rect2.set(Dips.pixelsToIntDips(rect.left, this.f13487a), Dips.pixelsToIntDips(rect.top, this.f13487a), Dips.pixelsToIntDips(rect.right, this.f13487a), Dips.pixelsToIntDips(rect.bottom, this.f13487a));
    }
}
