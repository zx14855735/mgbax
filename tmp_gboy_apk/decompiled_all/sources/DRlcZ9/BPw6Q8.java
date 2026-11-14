package DRlcZ9;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BPw6Q8 extends COJEAR.A4TApA {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ BTvldC f2136ADYaiT;

    public BPw6Q8(BTvldC bTvldC) {
        this.f2136ADYaiT = bTvldC;
    }

    @Override // COJEAR.A4TApA
    public final void ADYaiT(View view, CQhlFr.AYUAbz aYUAbz) {
        BTvldC bTvldC = this.f2136ADYaiT;
        bTvldC.f2138ASJ6gh.ADYaiT(view, aYUAbz);
        RecyclerView recyclerView = bTvldC.f2137ARc23Z;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.A2egSU adapter = recyclerView.getAdapter();
        if (adapter instanceof BChYOn) {
            ((BChYOn) adapter).A5SV6n(childAdapterPosition);
        }
    }

    @Override // COJEAR.A4TApA
    public final boolean ASJ6gh(View view, int i, Bundle bundle) {
        return this.f2136ADYaiT.f2138ASJ6gh.ASJ6gh(view, i, bundle);
    }
}
