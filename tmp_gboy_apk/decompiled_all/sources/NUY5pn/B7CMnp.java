package NUY5pn;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class B7CMnp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final QkAq4X.AYUAbz f5972A2egSU = new QkAq4X.AYUAbz();

    static {
        HTRm();
    }

    public static String A2egSU(Context context) {
        String str = context.getApplicationInfo().name;
        if (TextUtils.isEmpty(str)) {
            str = context.getPackageName();
            try {
                EsrwYR.A4TApA A2egSU2 = NGepWW.B4ZgIw.A2egSU(context);
                String packageName = context.getPackageName();
                Context context2 = A2egSU2.f2550AlLFFp;
                return context2.getPackageManager().getApplicationLabel(context2.getPackageManager().getApplicationInfo(packageName, 0)).toString();
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return str;
    }

    public static String A4TApA(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(2131034117);
            case 2:
                return resources.getString(2131034123);
            case 3:
                return resources.getString(2131034114);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                return A5SV6n(context, "common_google_play_services_invalid_account_title");
            case 7:
                return A5SV6n(context, "common_google_play_services_network_error_title");
            case 8:
            case 9:
            case 10:
            case 11:
            case 16:
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                return null;
            case 17:
                return A5SV6n(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                return A5SV6n(context, "common_google_play_services_restricted_profile_title");
        }
    }

    public static String A5SV6n(Context context, String str) {
        Resources resources;
        QkAq4X.AYUAbz aYUAbz = f5972A2egSU;
        synchronized (aYUAbz) {
            try {
                String str2 = (String) aYUAbz.get(str);
                if (str2 != null) {
                    return str2;
                }
                int i = NOd7IU.AMqCpz.AMqCpz;
                try {
                    resources = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
                } catch (PackageManager.NameNotFoundException unused) {
                    resources = null;
                }
                if (resources != null) {
                    int identifier = resources.getIdentifier(str, "string", "com.google.android.gms");
                    if (identifier != 0) {
                        String string = resources.getString(identifier);
                        if (!TextUtils.isEmpty(string)) {
                            f5972A2egSU.put(str, string);
                            return string;
                        }
                        if (str.length() != 0) {
                            "Got empty resource: ".concat(str);
                        }
                    } else if (str.length() != 0) {
                        "Missing resource: ".concat(str);
                    }
                }
                return null;
            } finally {
            }
        }
    }

    public static String ADYaiT(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String A5SV6n2 = A5SV6n(context, str);
        if (A5SV6n2 == null) {
            A5SV6n2 = resources.getString(2131034119);
        }
        return String.format(resources.getConfiguration().locale, A5SV6n2, str2);
    }

    public static String AMqCpz(Context context, int i) {
        Resources resources = context.getResources();
        String A2egSU2 = A2egSU(context);
        if (i == 1) {
            return resources.getString(2131034116, A2egSU2);
        }
        if (i == 2) {
            return NOd7IU.AlLFFp.B2KMhB(context) ? resources.getString(2131034125) : resources.getString(2131034122, A2egSU2);
        }
        if (i == 3) {
            return resources.getString(2131034113, A2egSU2);
        }
        if (i == 5) {
            return ADYaiT(context, "common_google_play_services_invalid_account_text", A2egSU2);
        }
        if (i == 7) {
            return ADYaiT(context, "common_google_play_services_network_error_text", A2egSU2);
        }
        if (i == 9) {
            return resources.getString(2131034120, A2egSU2);
        }
        if (i == 20) {
            return ADYaiT(context, "common_google_play_services_restricted_profile_text", A2egSU2);
        }
        switch (i) {
            case 16:
                return ADYaiT(context, "common_google_play_services_api_unavailable_text", A2egSU2);
            case 17:
                return ADYaiT(context, "common_google_play_services_sign_in_failed_text", A2egSU2);
            case 18:
                return resources.getString(2131034124, A2egSU2);
            default:
                return resources.getString(2131034119, A2egSU2);
        }
    }

    private static /* synthetic */ void HTRm() {
        char[] charArray = "OCA\u0002KMAI\u0002NCU\u0002_DI@@\u0002fBEn^EHKI".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ',');
        }
        String str = new String(charArray);
        char[] charArray2 = "O@EBEX".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ',');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
