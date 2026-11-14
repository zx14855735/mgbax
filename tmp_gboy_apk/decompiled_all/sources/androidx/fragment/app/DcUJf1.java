package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DcUJf1 extends Transition.EpicenterCallback {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f8935A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Rect f8936A4TApA;

    public /* synthetic */ DcUJf1(int i, Rect rect) {
        this.f8935A2egSU = i;
        this.f8936A4TApA = rect;
    }

    @Override // android.transition.Transition.EpicenterCallback
    public final Rect onGetEpicenter(Transition transition) {
        switch (this.f8935A2egSU) {
            case 0:
                return this.f8936A4TApA;
            default:
                Rect rect = this.f8936A4TApA;
                if (rect == null || rect.isEmpty()) {
                    return null;
                }
                return rect;
        }
    }
}
