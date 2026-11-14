package com.sigmob.sdk.base.common;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c extends GestureDetector.SimpleOnGestureListener {
    private static final int b = 4;
    private static final float c = 100.0f;
    private static final float d = 100.0f;

    /* renamed from: a, reason: collision with root package name */
    boolean f13122a;
    private final BaseAdUnit e;
    private float f;
    private float g;
    private boolean h;
    private boolean i;
    private int j;
    private float k;
    private a l = a.UNSET;
    private View m;

    /* renamed from: com.sigmob.sdk.base.common.c$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13123a;

        static {
            int[] iArr = new int[a.values().length];
            f13123a = iArr;
            try {
                iArr[a.UNSET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13123a[a.GOING_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13123a[a.GOING_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13123a[a.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum a {
        UNSET,
        GOING_RIGHT,
        GOING_LEFT,
        FINISHED,
        FAILED;

        static {
            svpXrV();
        }

        private static /* synthetic */ void svpXrV() {
            char[] charArray = "\u0081\u008d\u008fÌ\u0085\u0083\u008f\u0087Ì\u0080\u008d\u009bÌ\u0091\u008a\u0087\u008e\u008eÌ¨\u008c\u008b \u0090\u008b\u0086\u0085\u0087".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 226);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0081\u008e\u008b\u008c\u008b\u0096".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 226);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public c(View view, BaseAdUnit baseAdUnit) {
        this.f = 100.0f;
        if (view != null && view.getWidth() > 0) {
            this.f = Math.min(100.0f, view.getWidth() / 3.0f);
        }
        this.f13122a = false;
        this.m = view;
        this.e = baseAdUnit;
    }

    private void e() {
        int i = this.j + 1;
        this.j = i;
        if (i >= 4) {
            this.l = a.FINISHED;
        }
    }

    private boolean f(float f) {
        return f > this.g;
    }

    private boolean g(float f) {
        return f < this.g;
    }

    public void a() {
        a aVar = a.UNSET;
        b();
    }

    public void b() {
        this.j = 0;
        this.l = a.UNSET;
    }

    public void c() {
        this.f13122a = false;
    }

    public boolean d() {
        return this.f13122a;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        if (this.l == a.FINISHED) {
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
        if (a(motionEvent, motionEvent2)) {
            this.l = a.FAILED;
        } else {
            int i = AnonymousClass1.f13123a[this.l.ordinal()];
            if (i == 1) {
                this.k = motionEvent.getX();
                a(motionEvent2.getX());
            } else if (i == 2) {
                b(motionEvent2.getX());
            } else if (i == 3) {
                c(motionEvent2.getX());
            }
            this.g = motionEvent2.getX();
        }
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f13122a = true;
        return super.onSingleTapUp(motionEvent);
    }

    private void a(float f) {
        if (f > this.k) {
            this.l = a.GOING_RIGHT;
        }
    }

    private void b(float f) {
        if (d(f) && g(f)) {
            this.l = a.GOING_LEFT;
            this.k = f;
        }
    }

    private void c(float f) {
        if (e(f) && f(f)) {
            this.l = a.GOING_RIGHT;
            this.k = f;
        }
    }

    private boolean d(float f) {
        if (this.i) {
            return true;
        }
        if (f < this.k + this.f) {
            return false;
        }
        this.h = false;
        this.i = true;
        return true;
    }

    private boolean e(float f) {
        if (this.h) {
            return true;
        }
        if (f > this.k - this.f) {
            return false;
        }
        this.i = false;
        this.h = true;
        e();
        return true;
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent != null && motionEvent2 != null) {
            if (Math.abs(motionEvent2.getY() - motionEvent.getY()) > 100.0f) {
                return true;
            }
        }
        return false;
    }
}
