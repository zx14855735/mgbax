package NOd7IU;

import android.content.Context;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import com.fl.saas.videocache.ProxyCacheUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static boolean f5862A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static boolean f5863A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final AtomicBoolean f5864A5SV6n = new AtomicBoolean();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final AtomicBoolean f5865ADYaiT = new AtomicBoolean();
    public static final /* synthetic */ int AMqCpz = 0;

    static {
        wYUZULQ();
    }

    public static boolean A2egSU(Context context) {
        Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
        while (it.hasNext()) {
            if ("com.google.android.gms".equals(it.next().getAppPackageName())) {
                return true;
            }
        }
        try {
            return context.getPackageManager().getApplicationInfo("com.google.android.gms", ProxyCacheUtils.DEFAULT_BUFFER_SIZE).enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static /* synthetic */ void wYUZULQ() {
        char[] charArray = "\n\u0006\u0004G\u000e\b\u0004\fG\u000b\u0006\u0010G\u001a\u0001\f\u0005\u0005G#\u0007\u0000+\u001b\u0000\r\u000e\f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'i');
        }
        String str = new String(charArray);
        char[] charArray2 = "\n\u0005\u0000\u0007\u0000\u001d".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'i');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
