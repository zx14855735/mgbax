package Hdahpu;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z {
    public static final int AMqCpz;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f3691A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ActivityManager f3692A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ASJ6gh f3693A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final float f3694ADYaiT;

    static {
        AMqCpz = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        wsYnia();
    }

    public ARc23Z(Context context) {
        this.f3694ADYaiT = AMqCpz;
        this.f3691A2egSU = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        this.f3692A4TApA = activityManager;
        this.f3693A5SV6n = new ASJ6gh(context.getResources().getDisplayMetrics());
        if (Build.VERSION.SDK_INT < 26 || !activityManager.isLowRamDevice()) {
            return;
        }
        this.f3694ADYaiT = 0.0f;
    }

    private static /* synthetic */ void wsYnia() {
        char[] charArray = "\u009a\u0096\u0094×\u009e\u0098\u0094\u009c×\u009b\u0096\u0080×\u008a\u0091\u009c\u0095\u0095×³\u0097\u0090»\u008b\u0090\u009d\u009e\u009c".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 249);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009a\u0095\u0090\u0097\u0090\u008d".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 249);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
