package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AcNBzu implements View.OnTouchListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ GestureDetector f11990AcNBzu;

    public AcNBzu(GestureDetector gestureDetector) {
        this.f11990AcNBzu = gestureDetector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.f11990AcNBzu.onTouchEvent(motionEvent);
        }
        return false;
    }
}
