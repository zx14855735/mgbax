package LCJm5h;

import com.google.android.material.button.MaterialButton;
import java.io.File;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4422AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ long f4423AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Runnable f4424AmA8tU;

    public /* synthetic */ A5SV6n(int i, Runnable runnable, long j) {
        this.f4422AcNBzu = i;
        this.f4424AmA8tU = runnable;
        this.f4423AlLFFp = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4422AcNBzu) {
            case 0:
                ARc23Z.f4431A5SV6n.set(false);
                AZkASS.AMqCpz aMqCpz = (AZkASS.AMqCpz) this.f4424AmA8tU;
                int AZOQYO2 = ARc23Z.AZOQYO(((File) aMqCpz.f448AzWtSf).getName());
                String A2egSU2 = ARc23Z.A2egSU(this.f4423AlLFFp);
                AMqCpz aMqCpz2 = (AMqCpz) aMqCpz.f449B25kr6;
                Locale locale = Locale.ROOT;
                aMqCpz2.A4TApA(AZOQYO2, "文件保存成功 (" + A2egSU2 + ")");
                break;
            default:
                MOpbMP.ADYaiT aDYaiT = (MOpbMP.ADYaiT) this.f4424AmA8tU;
                MaterialButton materialButton = aDYaiT.f4993AlLFFp.f4999B3GDIM;
                if (materialButton != null) {
                    materialButton.setEnabled(false);
                    aDYaiT.f4993AlLFFp.f4999B3GDIM.setText(this.f4423AlLFFp + "秒后重新获取");
                    break;
                }
                break;
        }
    }
}
