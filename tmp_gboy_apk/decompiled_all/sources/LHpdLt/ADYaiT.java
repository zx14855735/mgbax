package LHpdLt;

import android.app.Activity;
import com.google.android.material.tabs.TabLayout;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ Activity f4461AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ MTKlkd.AYUAbz f4462AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f4463AmA8tU;

    public ADYaiT(AZOQYO azoqyo, Activity activity, MTKlkd.AYUAbz aYUAbz) {
        this.f4463AmA8tU = azoqyo;
        this.f4461AcNBzu = activity;
        this.f4462AlLFFp = aYUAbz;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TabLayout.A2egSU AZOQYO2;
        if (this.f4461AcNBzu.isFinishing() || this.f4461AcNBzu.isDestroyed()) {
            return;
        }
        synchronized (this.f4463AmA8tU.f4506CQhlFr) {
            try {
                String A5SV6n2 = this.f4462AlLFFp.A5SV6n();
                boolean equals = "lobby".equals(this.f4462AlLFFp.AMqCpz());
                AZOQYO azoqyo = this.f4463AmA8tU;
                TabLayout tabLayout = azoqyo.f4488B4ZgIw;
                if (tabLayout != null && A5SV6n2 != null) {
                    if (equals) {
                        TabLayout.A2egSU AMqCpz = AZOQYO.AMqCpz(azoqyo);
                        if (AMqCpz != null) {
                            Locale locale = Locale.ROOT;
                            AMqCpz.A2egSU("大厅 (" + A5SV6n2 + ")");
                        }
                    } else if (azoqyo.f4497BTvldC && (AZOQYO2 = tabLayout.AZOQYO(0)) != null) {
                        Locale locale2 = Locale.ROOT;
                        AZOQYO2.A2egSU("房间 (" + A5SV6n2 + ")");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
