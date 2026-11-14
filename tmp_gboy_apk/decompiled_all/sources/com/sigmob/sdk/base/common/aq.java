package com.sigmob.sdk.base.common;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aq extends GestureDetector {

    /* renamed from: a, reason: collision with root package name */
    private final View f13121a;
    private final c b;

    private aq(Context context, View view, c cVar) {
        super(context, cVar);
        this.b = cVar;
        this.f13121a = view;
        setIsLongpressEnabled(false);
    }

    public void a() {
        this.b.b();
    }

    public void b() {
        this.b.c();
    }

    public boolean c() {
        return this.b.d();
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            this.b.a();
            return onTouchEvent;
        }
        if (action == 2 && !a(motionEvent, this.f13121a)) {
            a();
        }
        return onTouchEvent;
    }

    public aq(Context context, View view, BaseAdUnit baseAdUnit) {
        this(context, view, new c(view, baseAdUnit));
    }

    private boolean a(MotionEvent motionEvent, View view) {
        if (motionEvent != null && view != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x >= 0.0f && x <= view.getWidth() && y >= 0.0f && y <= view.getHeight()) {
                return true;
            }
        }
        return false;
    }
}
