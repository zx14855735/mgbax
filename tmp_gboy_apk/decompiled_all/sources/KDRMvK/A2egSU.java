package KDRMvK;

import JrXYwF.A5SV6n;
import JrXYwF.AMqCpz;
import android.os.Handler;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Handler f4242AcNBzu;

    @Override // java.lang.Runnable
    public final void run() {
        String hf = ((AMqCpz) A5SV6n.f4151A5SV6n.f240AmA8tU).hf();
        if (TextUtils.isEmpty(hf) || Constants.FAIL.equals(hf)) {
            this.f4242AcNBzu.postDelayed(this, 15000L);
            A5SV6n.f4152ADYaiT.getClass();
        } else {
            A5SV6n.A2egSU().f4181A2egSU.edit().putString("device_id", hf).apply();
            "[DeviceIdTask] did is ".concat(String.valueOf(hf));
            A5SV6n.f4152ADYaiT.getClass();
        }
    }
}
