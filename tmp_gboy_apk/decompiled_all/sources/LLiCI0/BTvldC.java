package LLiCI0;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BTvldC extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Activity f4748AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ArrayList f4749AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public AZkASS.ARc23Z f4750AmA8tU;

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f4749AlLFFp.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemViewType(int i) {
        return ((LHpdLt.BV3sI0) this.f4749AlLFFp.get(i)).f4602A5SV6n ? 1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00e1 A[LOOP:0: B:17:0x00db->B:19:0x00e1, LOOP_END] */
    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(androidx.recyclerview.widget.Dphsd2 r9, int r10) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: LLiCI0.BTvldC.onBindViewHolder(androidx.recyclerview.widget.Dphsd2, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new BPw6Q8(this, LayoutInflater.from(viewGroup.getContext()).inflate(i == 0 ? 2131492987 : 2131492988, viewGroup, false));
    }
}
