package MOpbMP;

import android.widget.Toast;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BJ7GGh implements LCJm5h.AMqCpz, androidx.swiperefreshlayout.widget.AZOQYO {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ BpkvW3 f5049AcNBzu;

    public /* synthetic */ BJ7GGh(BpkvW3 bpkvW3) {
        this.f5049AcNBzu = bpkvW3;
    }

    @Override // LCJm5h.AMqCpz
    public void A4TApA(int i, String str) {
        BpkvW3 bpkvW3 = this.f5049AcNBzu;
        bpkvW3.f5080BV3sI0 = null;
        bpkvW3.f5081BmvVmW = -1;
        Toast.makeText(bpkvW3.getActivity(), 2131886724, 0).show();
    }

    @Override // LCJm5h.AMqCpz
    public void onError(String str) {
        Toast.makeText(this.f5049AcNBzu.getActivity(), "存档导入失败: " + str, 0).show();
    }

    @Override // androidx.swiperefreshlayout.widget.AZOQYO
    public void onRefresh() {
        BpkvW3 bpkvW3 = this.f5049AcNBzu;
        bpkvW3.AzWtSf();
        bpkvW3.AZkASS(true);
    }
}
