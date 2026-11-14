package Oay4Bh;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.DvK7DB;
import com.google.android.material.internal.NavigationMenuView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B7CMnp extends DvK7DB {

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final /* synthetic */ BI9f7h f6545ARc23Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B7CMnp(BI9f7h bI9f7h, NavigationMenuView navigationMenuView) {
        super(navigationMenuView);
        this.f6545ARc23Z = bI9f7h;
    }

    @Override // androidx.recyclerview.widget.DvK7DB, COJEAR.A4TApA
    public final void ADYaiT(View view, CQhlFr.AYUAbz aYUAbz) {
        super.ADYaiT(view, aYUAbz);
        AzWtSf azWtSf = this.f6545ARc23Z.f6550B25kr6;
        int i = 0;
        int i2 = 0;
        while (true) {
            BI9f7h bI9f7h = azWtSf.f6540AzWtSf;
            if (i >= bI9f7h.f6550B25kr6.f6537AcNBzu.size()) {
                aYUAbz.f1773A2egSU.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(i2, 1, false));
                return;
            } else {
                int itemViewType = bI9f7h.f6550B25kr6.getItemViewType(i);
                if (itemViewType == 0 || itemViewType == 1) {
                    i2++;
                }
                i++;
            }
        }
    }
}
