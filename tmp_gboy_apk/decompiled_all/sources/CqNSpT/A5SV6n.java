package CqNSpT;

import ADYaiT.BmvVmW;
import CQhlFr.AYUAbz;
import android.graphics.Rect;
import java.util.Comparator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n implements Comparator {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Rect f1831AcNBzu = new Rect();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Rect f1832AlLFFp = new Rect();

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final boolean f1833AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final BmvVmW f1834AzWtSf;

    public A5SV6n(boolean z, BmvVmW bmvVmW) {
        this.f1833AmA8tU = z;
        this.f1834AzWtSf = bmvVmW;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.f1834AzWtSf.getClass();
        Rect rect = this.f1831AcNBzu;
        ((AYUAbz) obj).ARc23Z(rect);
        Rect rect2 = this.f1832AlLFFp;
        ((AYUAbz) obj2).ARc23Z(rect2);
        int i = rect.top;
        int i2 = rect2.top;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i3 = rect.left;
        int i4 = rect2.left;
        boolean z = this.f1833AmA8tU;
        if (i3 < i4) {
            return z ? 1 : -1;
        }
        if (i3 > i4) {
            return z ? -1 : 1;
        }
        int i5 = rect.bottom;
        int i6 = rect2.bottom;
        if (i5 < i6) {
            return -1;
        }
        if (i5 > i6) {
            return 1;
        }
        int i7 = rect.right;
        int i8 = rect2.right;
        if (i7 < i8) {
            return z ? 1 : -1;
        }
        if (i7 > i8) {
            return z ? -1 : 1;
        }
        return 0;
    }
}
