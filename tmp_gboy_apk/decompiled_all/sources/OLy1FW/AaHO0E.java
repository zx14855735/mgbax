package OLy1FW;

import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E implements AcNBzu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public Long f6370A2egSU;

    @Override // OLy1FW.AcNBzu
    public final boolean isSupported() {
        if (this.f6370A2egSU == null) {
            try {
                Method declaredMethod = Build.class.getDeclaredMethod("getLong", String.class);
                declaredMethod.setAccessible(true);
                Long l = (Long) declaredMethod.invoke(null, "ro.build.version.oneui");
                l.longValue();
                this.f6370A2egSU = l;
            } catch (Exception unused) {
                this.f6370A2egSU = -1L;
            }
        }
        return this.f6370A2egSU.longValue() >= 40100;
    }
}
