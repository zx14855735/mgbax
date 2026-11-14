package CikNvS;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz extends COJEAR.A4TApA {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ int f1809ADYaiT;

    public /* synthetic */ AYUAbz(int i) {
        this.f1809ADYaiT = i;
    }

    @Override // COJEAR.A4TApA
    public void A5SV6n(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.f1809ADYaiT) {
            case 0:
                super.A5SV6n(view, accessibilityEvent);
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                accessibilityEvent.setClassName(ScrollView.class.getName());
                accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
                accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
                accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
                accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
                accessibilityEvent.setMaxScrollY(nestedScrollView.getScrollRange());
                break;
            default:
                super.A5SV6n(view, accessibilityEvent);
                break;
        }
    }

    @Override // COJEAR.A4TApA
    public final void ADYaiT(View view, CQhlFr.AYUAbz aYUAbz) {
        int scrollRange;
        switch (this.f1809ADYaiT) {
            case 0:
                this.f1615A2egSU.onInitializeAccessibilityNodeInfo(view, aYUAbz.f1773A2egSU);
                NestedScrollView nestedScrollView = (NestedScrollView) view;
                aYUAbz.AZkASS(ScrollView.class.getName());
                if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                    aYUAbz.AlLFFp(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        aYUAbz.A4TApA(CQhlFr.A5SV6n.f1760AZOQYO);
                        aYUAbz.A4TApA(CQhlFr.A5SV6n.f1764AlLFFp);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        aYUAbz.A4TApA(CQhlFr.A5SV6n.f1759AYUAbz);
                        aYUAbz.A4TApA(CQhlFr.A5SV6n.f1765AmA8tU);
                        break;
                    }
                }
                break;
            case 1:
                View.AccessibilityDelegate accessibilityDelegate = this.f1615A2egSU;
                AccessibilityNodeInfo accessibilityNodeInfo = aYUAbz.f1773A2egSU;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                if (!DrawerLayout.AZkASS(view)) {
                    accessibilityNodeInfo.setParent(null);
                    break;
                }
                break;
            case 2:
                View.AccessibilityDelegate accessibilityDelegate2 = this.f1615A2egSU;
                AccessibilityNodeInfo accessibilityNodeInfo2 = aYUAbz.f1773A2egSU;
                accessibilityDelegate2.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                accessibilityNodeInfo2.setVisibleToUser(false);
                break;
            case 3:
                View.AccessibilityDelegate accessibilityDelegate3 = this.f1615A2egSU;
                AccessibilityNodeInfo accessibilityNodeInfo3 = aYUAbz.f1773A2egSU;
                accessibilityDelegate3.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo3);
                accessibilityNodeInfo3.setCollectionInfo(null);
                break;
            case 4:
                this.f1615A2egSU.onInitializeAccessibilityNodeInfo(view, aYUAbz.f1773A2egSU);
                aYUAbz.AlLFFp(false);
                break;
            default:
                View.AccessibilityDelegate accessibilityDelegate4 = this.f1615A2egSU;
                AccessibilityNodeInfo accessibilityNodeInfo4 = aYUAbz.f1773A2egSU;
                accessibilityDelegate4.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo4);
                accessibilityNodeInfo4.setCollectionInfo(null);
                break;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r6 != 16908346) goto L32;
     */
    @Override // COJEAR.A4TApA
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean ASJ6gh(android.view.View r5, int r6, android.os.Bundle r7) {
        /*
            r4 = this;
            int r0 = r4.f1809ADYaiT
            switch(r0) {
                case 0: goto La;
                default: goto L5;
            }
        L5:
            boolean r5 = super.ASJ6gh(r5, r6, r7)
            return r5
        La:
            boolean r7 = super.ASJ6gh(r5, r6, r7)
            r0 = 1
            if (r7 == 0) goto L13
            goto La1
        L13:
            androidx.core.widget.NestedScrollView r5 = (androidx.core.widget.NestedScrollView) r5
            boolean r7 = r5.isEnabled()
            r1 = 0
            if (r7 != 0) goto L1e
            goto La0
        L1e:
            int r7 = r5.getHeight()
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            android.graphics.Matrix r3 = r5.getMatrix()
            boolean r3 = r3.isIdentity()
            if (r3 == 0) goto L3b
            boolean r3 = r5.getGlobalVisibleRect(r2)
            if (r3 == 0) goto L3b
            int r7 = r2.height()
        L3b:
            r2 = 4096(0x1000, float:5.74E-42)
            if (r6 == r2) goto L75
            r2 = 8192(0x2000, float:1.14794E-41)
            if (r6 == r2) goto L4e
            r2 = 16908344(0x1020038, float:2.3877386E-38)
            if (r6 == r2) goto L4e
            r2 = 16908346(0x102003a, float:2.3877392E-38)
            if (r6 == r2) goto L75
            goto La0
        L4e:
            int r6 = r5.getPaddingBottom()
            int r7 = r7 - r6
            int r6 = r5.getPaddingTop()
            int r7 = r7 - r6
            int r6 = r5.getScrollY()
            int r6 = r6 - r7
            int r6 = java.lang.Math.max(r6, r1)
            int r7 = r5.getScrollY()
            if (r6 == r7) goto La0
            int r7 = r5.getScrollX()
            int r1 = r1 - r7
            int r7 = r5.getScrollY()
            int r6 = r6 - r7
            r5.B25kr6(r1, r6, r0)
            goto La1
        L75:
            int r6 = r5.getPaddingBottom()
            int r7 = r7 - r6
            int r6 = r5.getPaddingTop()
            int r7 = r7 - r6
            int r6 = r5.getScrollY()
            int r6 = r6 + r7
            int r7 = r5.getScrollRange()
            int r6 = java.lang.Math.min(r6, r7)
            int r7 = r5.getScrollY()
            if (r6 == r7) goto La0
            int r7 = r5.getScrollX()
            int r1 = r1 - r7
            int r7 = r5.getScrollY()
            int r6 = r6 - r7
            r5.B25kr6(r1, r6, r0)
            goto La1
        La0:
            r0 = 0
        La1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: CikNvS.AYUAbz.ASJ6gh(android.view.View, int, android.os.Bundle):boolean");
    }
}
