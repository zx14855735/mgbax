package androidx.viewpager.widget;

import android.os.Bundle;
import android.view.View;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.sigmob.sdk.downloader.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz extends COJEAR.A4TApA {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ AlLFFp f9537ADYaiT;

    public AMqCpz(AlLFFp alLFFp) {
        this.f9537ADYaiT = alLFFp;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
    
        if (r0.getCount() > 1) goto L8;
     */
    @Override // COJEAR.A4TApA
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A5SV6n(android.view.View r3, android.view.accessibility.AccessibilityEvent r4) {
        /*
            r2 = this;
            super.A5SV6n(r3, r4)
            java.lang.Class<androidx.viewpager.widget.AlLFFp> r3 = androidx.viewpager.widget.AlLFFp.class
            java.lang.String r3 = r3.getName()
            r4.setClassName(r3)
            androidx.viewpager.widget.AlLFFp r3 = r2.f9537ADYaiT
            androidx.viewpager.widget.A2egSU r0 = r3.mAdapter
            if (r0 == 0) goto L1a
            int r0 = r0.getCount()
            r1 = 1
            if (r0 <= r1) goto L1a
            goto L1b
        L1a:
            r1 = 0
        L1b:
            r4.setScrollable(r1)
            int r0 = r4.getEventType()
            r1 = 4096(0x1000, float:5.74E-42)
            if (r0 != r1) goto L3b
            androidx.viewpager.widget.A2egSU r0 = r3.mAdapter
            if (r0 == 0) goto L3b
            int r0 = r0.getCount()
            r4.setItemCount(r0)
            int r0 = r3.mCurItem
            r4.setFromIndex(r0)
            int r3 = r3.mCurItem
            r4.setToIndex(r3)
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.AMqCpz.A5SV6n(android.view.View, android.view.accessibility.AccessibilityEvent):void");
    }

    @Override // COJEAR.A4TApA
    public final void ADYaiT(View view, CQhlFr.AYUAbz aYUAbz) {
        this.f1615A2egSU.onInitializeAccessibilityNodeInfo(view, aYUAbz.f1773A2egSU);
        aYUAbz.AZkASS(AlLFFp.class.getName());
        AlLFFp alLFFp = this.f9537ADYaiT;
        A2egSU a2egSU = alLFFp.mAdapter;
        aYUAbz.AlLFFp(a2egSU != null && a2egSU.getCount() > 1);
        if (alLFFp.canScrollHorizontally(1)) {
            aYUAbz.A2egSU(f.a.c);
        }
        if (alLFFp.canScrollHorizontally(-1)) {
            aYUAbz.A2egSU(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
        }
    }

    @Override // COJEAR.A4TApA
    public final boolean ASJ6gh(View view, int i, Bundle bundle) {
        if (super.ASJ6gh(view, i, bundle)) {
            return true;
        }
        AlLFFp alLFFp = this.f9537ADYaiT;
        if (i == 4096) {
            if (!alLFFp.canScrollHorizontally(1)) {
                return false;
            }
            alLFFp.setCurrentItem(alLFFp.mCurItem + 1);
            return true;
        }
        if (i != 8192 || !alLFFp.canScrollHorizontally(-1)) {
            return false;
        }
        alLFFp.setCurrentItem(alLFFp.mCurItem - 1);
        return true;
    }
}
