package BmvVmW;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh extends AYUAbz {
    @Override // BmvVmW.AYUAbz
    public final void A2egSU(int i, int i2, int i3, Rect rect, Rect rect2) {
        Gravity.apply(i, i2, i3, rect, rect2, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        A4TApA();
        outline.setRoundRect(this.f1514AYUAbz, this.f1513ASJ6gh);
    }
}
