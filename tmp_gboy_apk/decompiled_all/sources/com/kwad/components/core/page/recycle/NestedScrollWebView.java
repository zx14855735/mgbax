package com.kwad.components.core.page.recycle;

import COJEAR.B9tovu;
import COJEAR.BChYOn;
import COJEAR.CQhlFr;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.kwad.sdk.core.webview.KsAdWebView;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class NestedScrollWebView extends KsAdWebView implements B9tovu {
    private int WE;
    private int WF;
    private final int[] WG;
    private final int[] WH;
    private int WI;
    private boolean WJ;
    private int WK;
    private int WL;
    private BChYOn WM;
    private VelocityTracker WN;
    private int WO;

    public NestedScrollWebView(Context context) {
        super(context);
        this.WG = new int[2];
        this.WH = new int[2];
        sG();
    }

    private void sG() {
        this.WO = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.WM = new BChYOn(this);
        setNestedScrollingEnabled(true);
        this.WL = viewConfiguration.getScaledMaximumFlingVelocity();
        this.WK = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.WM.A2egSU(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.WM.A4TApA(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.WM.A5SV6n(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.WM.ADYaiT(i, i2, i3, i4, iArr, 0, null);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.WM.ARc23Z(0);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.WM.f1647ADYaiT;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.WO != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? com.kwad.sdk.c.a.a.k((Activity) getContext()) : com.kwad.sdk.c.a.a.getScreenHeight(getContext())) - (com.kwad.components.core.s.d.ux() ? com.kwad.sdk.c.a.a.getStatusBarHeight(getContext()) : 0)) - this.WO, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (hasFocus()) {
            return;
        }
        requestFocus();
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent;
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        boolean z = false;
        if (actionMasked == 0) {
            this.WI = 0;
        }
        if (this.WN == null) {
            this.WN = VelocityTracker.obtain();
        }
        int actionIndex = motionEvent.getActionIndex();
        int y = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, this.WI);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.WE - y;
                    if (dispatchNestedPreScroll(0, i, this.WH, this.WG)) {
                        i -= this.WH[1];
                        obtain.offsetLocation(0.0f, this.WG[1]);
                        this.WI += this.WG[1];
                    }
                    int scrollY = getScrollY();
                    this.WE = y - this.WG[1];
                    int max = Math.max(0, scrollY + i);
                    int i2 = i - (max - scrollY);
                    if (dispatchNestedScroll(0, max - i2, 0, i2, this.WG)) {
                        int i3 = this.WE;
                        int i4 = this.WG[1];
                        this.WE = i3 - i4;
                        obtain.offsetLocation(0.0f, i4);
                        this.WI += this.WG[1];
                    }
                    if (Math.abs(this.WH[1]) >= 5 || Math.abs(this.WG[1]) >= 5) {
                        if (!this.WJ) {
                            this.WJ = true;
                            super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                        }
                        onTouchEvent = false;
                    } else {
                        if (this.WJ) {
                            this.WJ = false;
                            onTouchEvent = false;
                        } else {
                            onTouchEvent = super.onTouchEvent(obtain);
                        }
                        obtain.recycle();
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        stopNestedScroll();
                        onTouchEvent = super.onTouchEvent(motionEvent);
                    }
                    onTouchEvent = false;
                }
            }
            this.WN.addMovement(motionEvent);
            this.WN.computeCurrentVelocity(1000, this.WL);
            int pointerId = motionEvent.getPointerId(actionIndex);
            VelocityTracker velocityTracker = this.WN;
            Map map = CQhlFr.f1662A2egSU;
            float f = -velocityTracker.getYVelocity(pointerId);
            if (Math.abs(f) > this.WK && !dispatchNestedPreFling(0.0f, f) && hasNestedScrollingParent()) {
                dispatchNestedFling(0.0f, f, true);
            }
            boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
            stopNestedScroll();
            if (Math.abs(motionEvent.getY() - this.WE) < 10.0f) {
                Math.abs(motionEvent.getX() - this.WF);
            }
            onTouchEvent = onTouchEvent2;
            z = true;
        } else {
            this.WE = y;
            this.WF = (int) motionEvent.getX();
            startNestedScroll(2);
            int[] iArr = this.WH;
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = this.WG;
            iArr2[0] = 0;
            iArr2[1] = 0;
            onTouchEvent = super.onTouchEvent(motionEvent);
            this.WJ = false;
        }
        if (!z) {
            this.WN.addMovement(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.WM.ASJ6gh(z);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.WM.AYUAbz(i, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.WM.AZOQYO(0);
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.WG = new int[2];
        this.WH = new int[2];
        sG();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.WG = new int[2];
        this.WH = new int[2];
        sG();
    }
}
