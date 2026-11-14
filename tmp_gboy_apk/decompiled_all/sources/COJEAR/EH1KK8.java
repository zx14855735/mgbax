package COJEAR;

import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EH1KK8 extends WindowInsetsAnimation.Callback {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ARc23Z f1708A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public List f1709A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public ArrayList f1710A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final HashMap f1711ADYaiT;

    public EH1KK8(ARc23Z aRc23Z) {
        super(0);
        this.f1711ADYaiT = new HashMap();
        this.f1708A2egSU = aRc23Z;
    }

    public final EUIRHA A2egSU(WindowInsetsAnimation windowInsetsAnimation) {
        EUIRHA euirha = (EUIRHA) this.f1711ADYaiT.get(windowInsetsAnimation);
        if (euirha == null) {
            euirha = new EUIRHA(0, null, 0L);
            if (Build.VERSION.SDK_INT >= 30) {
                euirha.f1716A2egSU = new EPdU4G(windowInsetsAnimation);
            }
            this.f1711ADYaiT.put(windowInsetsAnimation, euirha);
        }
        return euirha;
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        ARc23Z aRc23Z = this.f1708A2egSU;
        A2egSU(windowInsetsAnimation);
        ((View) aRc23Z.f1622B25kr6).setTranslationY(0.0f);
        this.f1711ADYaiT.remove(windowInsetsAnimation);
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        ARc23Z aRc23Z = this.f1708A2egSU;
        A2egSU(windowInsetsAnimation);
        View view = (View) aRc23Z.f1622B25kr6;
        int[] iArr = (int[]) aRc23Z.f1623B2KMhB;
        view.getLocationOnScreen(iArr);
        aRc23Z.f1620AmA8tU = iArr[1];
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        float fraction;
        ArrayList arrayList = this.f1710A5SV6n;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.f1710A5SV6n = arrayList2;
            this.f1709A4TApA = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation AaHO0E2 = C2rE4F.AaHO0E(list.get(size));
            EUIRHA A2egSU2 = A2egSU(AaHO0E2);
            fraction = AaHO0E2.getFraction();
            A2egSU2.f1716A2egSU.ADYaiT(fraction);
            this.f1710A5SV6n.add(A2egSU2);
        }
        ARc23Z aRc23Z = this.f1708A2egSU;
        FG7pZc ASJ6gh2 = FG7pZc.ASJ6gh(null, windowInsets);
        aRc23Z.A2egSU(ASJ6gh2, this.f1709A4TApA);
        return ASJ6gh2.ARc23Z();
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        Insets lowerBound;
        Insets upperBound;
        ARc23Z aRc23Z = this.f1708A2egSU;
        A2egSU(windowInsetsAnimation);
        lowerBound = bounds.getLowerBound();
        BV3sI0.A5SV6n A5SV6n2 = BV3sI0.A5SV6n.A5SV6n(lowerBound);
        upperBound = bounds.getUpperBound();
        BV3sI0.A5SV6n A5SV6n3 = BV3sI0.A5SV6n.A5SV6n(upperBound);
        View view = (View) aRc23Z.f1622B25kr6;
        int[] iArr = (int[]) aRc23Z.f1623B2KMhB;
        view.getLocationOnScreen(iArr);
        int i = aRc23Z.f1620AmA8tU - iArr[1];
        aRc23Z.f1621AzWtSf = i;
        view.setTranslationY(i);
        C2rE4F.AlLFFp();
        return C2rE4F.AZOQYO(A5SV6n2.ADYaiT(), A5SV6n3.ADYaiT());
    }
}
