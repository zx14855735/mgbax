package androidx.viewpager.widget;

import android.view.View;
import java.util.Comparator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AcNBzu implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        ADYaiT aDYaiT = (ADYaiT) ((View) obj).getLayoutParams();
        ADYaiT aDYaiT2 = (ADYaiT) ((View) obj2).getLayoutParams();
        boolean z = aDYaiT.f9532A2egSU;
        return z != aDYaiT2.f9532A2egSU ? z ? 1 : -1 : aDYaiT.AMqCpz - aDYaiT2.AMqCpz;
    }
}
