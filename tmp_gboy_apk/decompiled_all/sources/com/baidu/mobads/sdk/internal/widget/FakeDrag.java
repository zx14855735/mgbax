package com.baidu.mobads.sdk.internal.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class FakeDrag {

    /* renamed from: a, reason: collision with root package name */
    private final ViewPager2 f9852a;
    private final ScrollEventAdapter b;
    private final RecyclerView c;
    private VelocityTracker d;
    private int e;
    private float f;
    private int g;
    private long h;

    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.f9852a = viewPager2;
        this.b = scrollEventAdapter;
        this.c = recyclerView;
    }

    private void d() {
        VelocityTracker velocityTracker = this.d;
        if (velocityTracker != null) {
            velocityTracker.clear();
        } else {
            this.d = VelocityTracker.obtain();
            this.e = ViewConfiguration.get(this.f9852a.getContext()).getScaledMaximumFlingVelocity();
        }
    }

    public boolean a() {
        return this.b.g();
    }

    public boolean b() {
        if (this.b.f()) {
            return false;
        }
        this.g = 0;
        this.f = 0;
        this.h = SystemClock.uptimeMillis();
        d();
        this.b.b();
        if (!this.b.e()) {
            this.c.stopScroll();
        }
        a(this.h, 0, 0.0f, 0.0f);
        return true;
    }

    public boolean c() {
        if (!this.b.g()) {
            return false;
        }
        this.b.c();
        VelocityTracker velocityTracker = this.d;
        velocityTracker.computeCurrentVelocity(1000, this.e);
        if (this.c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.f9852a.d();
        return true;
    }

    public boolean a(float f) {
        if (!this.b.g()) {
            return false;
        }
        float f2 = this.f - f;
        this.f = f2;
        int round = Math.round(f2 - this.g);
        this.g += round;
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z = this.f9852a.getOrientation() == 0;
        int i = z ? round : 0;
        int i2 = z ? 0 : round;
        float f3 = z ? this.f : 0.0f;
        float f4 = z ? 0.0f : this.f;
        this.c.scrollBy(i, i2);
        a(uptimeMillis, 2, f3, f4);
        return true;
    }

    private void a(long j, int i, float f, float f2) {
        MotionEvent obtain = MotionEvent.obtain(this.h, j, i, f, f2, 0);
        this.d.addMovement(obtain);
        obtain.recycle();
    }
}
