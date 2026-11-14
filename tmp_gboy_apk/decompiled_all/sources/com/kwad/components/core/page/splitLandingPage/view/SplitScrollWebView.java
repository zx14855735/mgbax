package com.kwad.components.core.page.splitLandingPage.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.components.core.s.d;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SplitScrollWebView extends KsAdWebView {
    private int WO;
    private boolean Xm;
    private a Xn;
    private float Xo;
    private boolean Xp;

    public interface a {
        void e(float f);

        boolean sM();
    }

    public SplitScrollWebView(Context context) {
        super(context);
        this.Xm = false;
        sG();
    }

    private void sG() {
        this.WO = 0;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.WO != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? com.kwad.sdk.c.a.a.k((Activity) getContext()) : com.kwad.sdk.c.a.a.getScreenHeight(getContext())) - (d.ux() ? com.kwad.sdk.c.a.a.getStatusBarHeight(getContext()) : 0)) - this.WO, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        if (r1 != 3) goto L31;
     */
    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r6)
            boolean r1 = r5.Xm
            if (r1 == 0) goto Ld
            boolean r6 = super.onTouchEvent(r0)
            return r6
        Ld:
            int r1 = r6.getActionMasked()
            float r2 = r6.getY()
            r3 = 0
            if (r1 == 0) goto L51
            r6 = 1
            if (r1 == r6) goto L38
            r4 = 2
            if (r1 == r4) goto L22
            r0 = 3
            if (r1 == r0) goto L38
            goto L50
        L22:
            float r1 = r5.Xo
            float r3 = r1 - r2
            com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView$a r4 = r5.Xn
            if (r4 == 0) goto L33
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 > 0) goto L33
            r5.Xp = r6
            r4.e(r3)
        L33:
            boolean r6 = super.onTouchEvent(r0)
            return r6
        L38:
            com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView$a r0 = r5.Xn
            if (r0 == 0) goto L50
            float r1 = r5.Xo
            float r1 = r1 - r2
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L48
            boolean r1 = r5.Xp
            if (r1 == 0) goto L50
        L48:
            boolean r0 = r0.sM()
            if (r0 == 0) goto L50
            r5.Xm = r6
        L50:
            return r3
        L51:
            r5.Xo = r2
            r5.Xp = r3
            boolean r6 = super.onTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setDisableAnimation(boolean z) {
        this.Xm = z;
    }

    public void setSplitScrollWebViewListener(a aVar) {
        this.Xn = aVar;
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Xm = false;
        sG();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Xm = false;
        sG();
    }
}
