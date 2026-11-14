package KBWg67;

import ADYaiT.D8MqeW;
import AZOQYO.ARc23Z;
import KLMZzS.A5SV6n;
import com.bytedance.sdk.component.tf.u.w;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends A5SV6n {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ String f4221AcNBzu;

    public A2egSU(String str) {
        this.f4221AcNBzu = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            KCVcbs.A5SV6n a5SV6n = new KCVcbs.A5SV6n();
            a5SV6n.A2egSU(PointParamKey.DATA, this.f4221AcNBzu);
            a5SV6n.A2egSU("userdefine", 1);
            if (ARc23Z.f362B4ZgIw == null) {
                throw new IllegalArgumentException("CrashContextAssembly not init");
            }
            KCVcbs.A5SV6n AlLFFp2 = ARc23Z.f362B4ZgIw.AlLFFp(JrXYwF.ARc23Z.CUSTOM_JAVA, a5SV6n);
            JtTqUo.A5SV6n A4TApA2 = JtTqUo.A5SV6n.A4TApA();
            JSONObject jSONObject = AlLFFp2.f4232A2egSU;
            A4TApA2.getClass();
            if (jSONObject != null && jSONObject.length() != 0) {
                new w(new D8MqeW(19, jSONObject), "hreadExecutor").start();
            }
        } catch (Throwable unused) {
        }
    }
}
