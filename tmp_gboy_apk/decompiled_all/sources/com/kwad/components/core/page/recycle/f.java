package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.CTkVKb;
import androidx.recyclerview.widget.CcAIMM;
import androidx.recyclerview.widget.Cd8JRx;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.utils.ax;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class f {
    final RecyclerView WQ;
    final RecyclerView.ARc23Z WR;

    private f(RecyclerView recyclerView) {
        this.WQ = recyclerView;
        this.WR = recyclerView.getLayoutManager();
    }

    private View a(int i, int i2, boolean z, boolean z2) {
        Cd8JRx ccAIMM = this.WR.canScrollVertically() ? new CcAIMM(this.WR) : new CTkVKb(this.WR);
        int AaHO0E2 = ccAIMM.AaHO0E();
        int ASJ6gh2 = ccAIMM.ASJ6gh();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View childAt = this.WR.getChildAt(i);
            int AMqCpz = ccAIMM.AMqCpz(childAt);
            int A4TApA2 = ccAIMM.A4TApA(childAt);
            if (AMqCpz < ASJ6gh2 && A4TApA2 > AaHO0E2) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }

    public static f b(RecyclerView recyclerView) {
        ax.checkNotNull(recyclerView);
        return new f(recyclerView);
    }

    public final int findFirstVisibleItemPosition() {
        View a2 = a(0, this.WR.getChildCount(), false, true);
        if (a2 == null) {
            return -1;
        }
        return this.WQ.getChildAdapterPosition(a2);
    }

    public final int findLastVisibleItemPosition() {
        View a2 = a(this.WR.getChildCount() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return this.WQ.getChildAdapterPosition(a2);
    }
}
