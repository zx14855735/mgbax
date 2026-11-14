package COJEAR;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CkXcdM implements View.OnApplyWindowInsetsListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public FG7pZc f1672A2egSU = null;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ View f1673A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ BNL6CD f1674A5SV6n;

    public CkXcdM(View view, BNL6CD bnl6cd) {
        this.f1673A4TApA = view;
        this.f1674A5SV6n = bnl6cd;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        FG7pZc ASJ6gh2 = FG7pZc.ASJ6gh(view, windowInsets);
        int i = Build.VERSION.SDK_INT;
        BNL6CD bnl6cd = this.f1674A5SV6n;
        if (i < 30) {
            CmUvjW.A2egSU(windowInsets, this.f1673A4TApA);
            if (ASJ6gh2.equals(this.f1672A2egSU)) {
                return bnl6cd.B3GDIM(view, ASJ6gh2).ARc23Z();
            }
        }
        this.f1672A2egSU = ASJ6gh2;
        FG7pZc B3GDIM2 = bnl6cd.B3GDIM(view, ASJ6gh2);
        if (i >= 30) {
            return B3GDIM2.ARc23Z();
        }
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        CikNvS.A5SV6n(view);
        return B3GDIM2.ARc23Z();
    }
}
