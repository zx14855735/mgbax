package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DuwtYk extends COJEAR.A4TApA {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final DvK7DB f9373ADYaiT;
    public final WeakHashMap AMqCpz = new WeakHashMap();

    public DuwtYk(DvK7DB dvK7DB) {
        this.f9373ADYaiT = dvK7DB;
    }

    @Override // COJEAR.A4TApA
    public final boolean A2egSU(View view, AccessibilityEvent accessibilityEvent) {
        COJEAR.A4TApA a4TApA = (COJEAR.A4TApA) this.AMqCpz.get(view);
        return a4TApA != null ? a4TApA.A2egSU(view, accessibilityEvent) : this.f1615A2egSU.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // COJEAR.A4TApA
    public final CQhlFr.AaHO0E A4TApA(View view) {
        COJEAR.A4TApA a4TApA = (COJEAR.A4TApA) this.AMqCpz.get(view);
        return a4TApA != null ? a4TApA.A4TApA(view) : super.A4TApA(view);
    }

    @Override // COJEAR.A4TApA
    public final void A5SV6n(View view, AccessibilityEvent accessibilityEvent) {
        COJEAR.A4TApA a4TApA = (COJEAR.A4TApA) this.AMqCpz.get(view);
        if (a4TApA != null) {
            a4TApA.A5SV6n(view, accessibilityEvent);
        } else {
            super.A5SV6n(view, accessibilityEvent);
        }
    }

    @Override // COJEAR.A4TApA
    public final void ADYaiT(View view, CQhlFr.AYUAbz aYUAbz) {
        DvK7DB dvK7DB = this.f9373ADYaiT;
        boolean hasPendingAdapterUpdates = dvK7DB.f9374ADYaiT.hasPendingAdapterUpdates();
        View.AccessibilityDelegate accessibilityDelegate = this.f1615A2egSU;
        AccessibilityNodeInfo accessibilityNodeInfo = aYUAbz.f1773A2egSU;
        if (!hasPendingAdapterUpdates) {
            RecyclerView recyclerView = dvK7DB.f9374ADYaiT;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, aYUAbz);
                COJEAR.A4TApA a4TApA = (COJEAR.A4TApA) this.AMqCpz.get(view);
                if (a4TApA != null) {
                    a4TApA.ADYaiT(view, aYUAbz);
                    return;
                } else {
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    return;
                }
            }
        }
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
    }

    @Override // COJEAR.A4TApA
    public final void AMqCpz(View view, AccessibilityEvent accessibilityEvent) {
        COJEAR.A4TApA a4TApA = (COJEAR.A4TApA) this.AMqCpz.get(view);
        if (a4TApA != null) {
            a4TApA.AMqCpz(view, accessibilityEvent);
        } else {
            super.AMqCpz(view, accessibilityEvent);
        }
    }

    @Override // COJEAR.A4TApA
    public final boolean ARc23Z(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        COJEAR.A4TApA a4TApA = (COJEAR.A4TApA) this.AMqCpz.get(viewGroup);
        return a4TApA != null ? a4TApA.ARc23Z(viewGroup, view, accessibilityEvent) : this.f1615A2egSU.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // COJEAR.A4TApA
    public final boolean ASJ6gh(View view, int i, Bundle bundle) {
        DvK7DB dvK7DB = this.f9373ADYaiT;
        if (!dvK7DB.f9374ADYaiT.hasPendingAdapterUpdates()) {
            RecyclerView recyclerView = dvK7DB.f9374ADYaiT;
            if (recyclerView.getLayoutManager() != null) {
                COJEAR.A4TApA a4TApA = (COJEAR.A4TApA) this.AMqCpz.get(view);
                if (a4TApA != null) {
                    if (a4TApA.ASJ6gh(view, i, bundle)) {
                        return true;
                    }
                } else if (super.ASJ6gh(view, i, bundle)) {
                    return true;
                }
                return recyclerView.getLayoutManager().performAccessibilityActionForItem(view, i, bundle);
            }
        }
        return super.ASJ6gh(view, i, bundle);
    }

    @Override // COJEAR.A4TApA
    public final void AYUAbz(View view, int i) {
        COJEAR.A4TApA a4TApA = (COJEAR.A4TApA) this.AMqCpz.get(view);
        if (a4TApA != null) {
            a4TApA.AYUAbz(view, i);
        } else {
            super.AYUAbz(view, i);
        }
    }

    @Override // COJEAR.A4TApA
    public final void AZOQYO(View view, AccessibilityEvent accessibilityEvent) {
        COJEAR.A4TApA a4TApA = (COJEAR.A4TApA) this.AMqCpz.get(view);
        if (a4TApA != null) {
            a4TApA.AZOQYO(view, accessibilityEvent);
        } else {
            super.AZOQYO(view, accessibilityEvent);
        }
    }
}
