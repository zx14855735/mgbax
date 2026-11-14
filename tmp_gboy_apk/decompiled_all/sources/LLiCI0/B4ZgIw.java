package LLiCI0;

import L2suez.ASJ6gh;
import android.view.View;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B4ZgIw implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ MOpbMP.BpkvW3 f4719AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ASJ6gh.A2egSU f4720AlLFFp;

    public B4ZgIw(MOpbMP.BpkvW3 bpkvW3, ASJ6gh.A2egSU a2egSU) {
        this.f4719AcNBzu = bpkvW3;
        this.f4720AlLFFp = a2egSU;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        File file = this.f4720AlLFFp.f4366A2egSU;
        MOpbMP.BpkvW3 bpkvW3 = this.f4719AcNBzu;
        bpkvW3.getClass();
        bpkvW3.AcNBzu(file.getPath());
    }
}
