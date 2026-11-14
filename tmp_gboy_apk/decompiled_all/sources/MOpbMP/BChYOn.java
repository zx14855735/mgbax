package MOpbMP;

import androidx.recyclerview.widget.GridLayoutManager;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BChYOn extends GridLayoutManager.A4TApA {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ int f5041A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ BpkvW3 f5042ADYaiT;

    public BChYOn(BpkvW3 bpkvW3, int i) {
        this.f5042ADYaiT = bpkvW3;
        this.f5041A5SV6n = i;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.A4TApA
    public final int A5SV6n(int i) {
        LLiCI0.ARc23Z aRc23Z;
        if (i != 0 || (aRc23Z = this.f5042ADYaiT.f5074BI9f7h) == null) {
            return 1;
        }
        ArrayList arrayList = aRc23Z.f4682AcNBzu;
        if ((arrayList == null ? 0 : arrayList.size()) > 0) {
            return this.f5041A5SV6n;
        }
        return 1;
    }
}
