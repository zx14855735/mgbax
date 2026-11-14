package CQhlFr;

import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AccessibilityNodeInfo.CollectionItemInfo f1771A2egSU;

    public ASJ6gh(AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo) {
        this.f1771A2egSU = collectionItemInfo;
    }

    public static ASJ6gh A2egSU(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        return new ASJ6gh(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
    }
}
