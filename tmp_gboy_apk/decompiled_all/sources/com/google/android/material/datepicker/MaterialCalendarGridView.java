package com.google.android.material.datepicker;

import COJEAR.DG07BK;
import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class MaterialCalendarGridView extends GridView {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final boolean f11661AcNBzu;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        BTvldC.A5SV6n(null);
        if (AmA8tU.AmA8tU(getContext(), R.attr.windowFullscreen)) {
            setNextFocusLeftId(2131296461);
            setNextFocusRightId(2131296519);
        }
        this.f11661AcNBzu = AmA8tU.AmA8tU(getContext(), 2130969673);
        DG07BK.B4ZgIw(this, new CikNvS.AYUAbz(5));
    }

    public final B3GDIM A2egSU() {
        return (B3GDIM) super.getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (B3GDIM) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((B3GDIM) super.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        B3GDIM b3gdim = (B3GDIM) super.getAdapter();
        b3gdim.getClass();
        int max = Math.max(b3gdim.A2egSU(), getFirstVisiblePosition());
        int min = Math.min(b3gdim.A5SV6n(), getLastVisiblePosition());
        b3gdim.getItem(max);
        b3gdim.getItem(min);
        throw null;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        if (!z) {
            super.onFocusChanged(false, i, rect);
            return;
        }
        if (i == 33) {
            setSelection(((B3GDIM) super.getAdapter()).A5SV6n());
        } else if (i == 130) {
            setSelection(((B3GDIM) super.getAdapter()).A2egSU());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition == -1 || (selectedItemPosition >= ((B3GDIM) super.getAdapter()).A2egSU() && selectedItemPosition <= ((B3GDIM) super.getAdapter()).A5SV6n())) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(((B3GDIM) super.getAdapter()).A2egSU());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i, int i2) {
        if (!this.f11661AcNBzu) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i) {
        if (i < ((B3GDIM) super.getAdapter()).A2egSU()) {
            super.setSelection(((B3GDIM) super.getAdapter()).A2egSU());
        } else {
            super.setSelection(i);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: getAdapter, reason: avoid collision after fix types in other method */
    public final ListAdapter getAdapter2() {
        return (B3GDIM) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof B3GDIM)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), B3GDIM.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
