package MOpbMP;

import L2suez.ASJ6gh;
import android.widget.Toast;
import java.io.File;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BIYEnU implements LCJm5h.AMqCpz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ File f5047AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ BpkvW3 f5048AlLFFp;

    public BIYEnU(BpkvW3 bpkvW3, File file) {
        this.f5048AlLFFp = bpkvW3;
        this.f5047AcNBzu = file;
    }

    @Override // LCJm5h.AMqCpz
    public final void A4TApA(int i, String str) {
        int i2;
        BpkvW3 bpkvW3 = this.f5048AlLFFp;
        Toast.makeText(bpkvW3.getActivity(), 2131886235, 0).show();
        ArrayList arrayList = BpkvW3.f5062CNPG0E;
        if (arrayList == null || (i2 = bpkvW3.f5081BmvVmW) < 0 || i2 >= arrayList.size()) {
            bpkvW3.f5080BV3sI0 = null;
            bpkvW3.f5081BmvVmW = -1;
            return;
        }
        ASJ6gh.A2egSU a2egSU = (ASJ6gh.A2egSU) BpkvW3.f5062CNPG0E.get(bpkvW3.f5081BmvVmW);
        a2egSU.f4367A4TApA = this.f5047AcNBzu;
        LLiCI0.BJ7GGh bJ7GGh = bpkvW3.f5066AzWtSf;
        int i3 = bpkvW3.f5081BmvVmW;
        bJ7GGh.f4737AcNBzu.set(i3, a2egSU);
        bJ7GGh.notifyItemChanged(i3);
        bpkvW3.f5080BV3sI0 = null;
        bpkvW3.f5081BmvVmW = -1;
    }

    @Override // LCJm5h.AMqCpz
    public final void onError(String str) {
        Toast.makeText(this.f5048AlLFFp.getActivity(), "图片设置失败: " + str, 0).show();
    }
}
