package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTScrollView extends ScrollView {
    private boolean hf;
    private boolean u;
    private xj w;
    private int xj;

    public interface xj {
        void xj(boolean z);
    }

    public TTScrollView(Context context) {
        super(context);
        this.hf = false;
        this.u = false;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.hf) {
            return;
        }
        try {
            this.hf = true;
            View childAt = ((ViewGroup) getChildAt(0)).getChildAt(1);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = getHeight();
            childAt.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            pl.u("TTScrollView", "onLayout error" + th.toString());
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.xj = getChildAt(0).getMeasuredHeight();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.widget.TTScrollView.3
            @Override // java.lang.Runnable
            public void run() {
                TTScrollView tTScrollView = TTScrollView.this;
                tTScrollView.smoothScrollTo(0, tTScrollView.xj);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if (getScrollY() == 0) goto L15;
     */
    @Override // android.widget.ScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 1
            if (r0 != r1) goto L46
            int r0 = r4.getScrollY()
            int r2 = r4.xj
            if (r0 >= r2) goto L46
            int r0 = r4.getScrollY()
            int r2 = r4.xj
            int r2 = r2 / 2
            r3 = 0
            if (r0 <= r2) goto L24
            com.bytedance.sdk.openadsdk.widget.TTScrollView$1 r0 = new com.bytedance.sdk.openadsdk.widget.TTScrollView$1
            r0.<init>()
            r4.post(r0)
        L22:
            r1 = 0
            goto L39
        L24:
            int r0 = r4.getScrollY()
            if (r0 <= 0) goto L33
            com.bytedance.sdk.openadsdk.widget.TTScrollView$2 r0 = new com.bytedance.sdk.openadsdk.widget.TTScrollView$2
            r0.<init>()
            r4.post(r0)
            goto L39
        L33:
            int r0 = r4.getScrollY()
            if (r0 != 0) goto L22
        L39:
            com.bytedance.sdk.openadsdk.widget.TTScrollView$xj r0 = r4.w
            if (r0 == 0) goto L44
            boolean r2 = r4.u
            if (r1 == r2) goto L44
            r0.xj(r1)
        L44:
            r4.u = r1
        L46:
            boolean r5 = super.onTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.widget.TTScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setListener(xj xjVar) {
        this.w = xjVar;
    }

    public boolean xj() {
        return this.u;
    }
}
